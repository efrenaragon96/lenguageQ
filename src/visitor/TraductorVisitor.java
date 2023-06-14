/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import parser.LenguajeQBaseVisitor;
import parser.LenguajeQParser;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;
import ts.*;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import parser.LenguajeQLexer;

/**
 *
 * @author juanluis
 */
public class TraductorVisitor extends LenguajeQBaseVisitor<TreeParserNode<ST>> {

    private final STGroup bytecode;
    //Manejo de los símbolos y sus ámbitos de ejecución, podemos declarar variables locales dentro de las sentencias
    private Stack<SymbolTable> environment;
    private int locals;
    private int labels;
    public static final String className = "LenguajeQ";

    public TraductorVisitor() {
        environment = new Stack<>();
        bytecode = new STGroupFile("src/templates/ByteCode.stg");
        locals = 2;
        labels = 1;
    }

    public void compile(File source) {
        FileReader reader;
        try {
            reader = new FileReader(source);
            ANTLRInputStream input = new ANTLRInputStream(reader);
            LenguajeQLexer lexer = new LenguajeQLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LenguajeQParser parser = new LenguajeQParser(tokens);
            ParseTree tree = parser.start();
            TraductorVisitor traductor = new TraductorVisitor();
            ST tag = traductor.visit(tree).getValue();
            System.out.println("" + tag.render());
            try {
                FileWriter writer = new FileWriter(className + ".j");
                writer.write(tag.render());
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error en la aplicación!", "Error", JOptionPane.DEFAULT_OPTION);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Verifique que el fichero de entrada sea correcto.");
        }

    }

    @Override
    public TreeParserNode<ST> visitStart(LenguajeQParser.StartContext ctx) {
        ST tag = bytecode.getInstanceOf("class");
        System.out.println("Iniciando Traductor...");
        //Creo una tabla de simbolos para las variables globales
        SymbolTable table = new SymbolTable();
        //Las coloco en el fondo de la pila
        environment.push(table);
        List<LenguajeQParser.DclContext> listaDcl = ctx.dcl();
        for (LenguajeQParser.DclContext dcl : listaDcl) {
            ST value = visit(dcl).getValue();
            if (value != null) {
                tag.add("instructions", value);
            }
        }
        //Creo la tabla para el contexto de las sentencias
        table = new SymbolTable();
        //La coloco en la pila
        environment.push(table);
        //Visito las sentencias
        List<LenguajeQParser.SentContext> listaSent = ctx.sent();
        for (LenguajeQParser.SentContext sent : listaSent) {
            ST value = visit(sent).getValue();
            if (value != null) {
                tag.add("instructions", value);
            }
        }
        tag.add("maxStackDepth", 5); //Este tamaño debe calcularse en dependencia de los tipos de datos
        tag.add("maxLocals", locals); //La cantidad de variables locales
        tag.add("className", className);
        //Quito la TS de las sentencias de la pila
        environment.pop();
        //Quito la TS de la pila
        environment.pop();
        System.out.println("Finalizando Traductor...");
        return new TreeParserNode<>(tag);
    }

    @Override
    public TreeParserNode<ST> visitDcl(LenguajeQParser.DclContext ctx) {
        //Visitando una Declaracion
        String id = ctx.TK_ID().getText();
        //Chequeo Semántico
        //Que no se haya declarado una variable global con ese nombre previamente. Pueden definirse otras variable locales con ese nombre.
        //Para ello obtengo la TS que esta en el tope de la pila. En este punto se garantiza
        //que esta en el tope la de las variblaes globales
        SymbolTable tmp = environment.peek();
        if (tmp.exists(id)) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Variable Global declarada previamente");
        }
        TreeParserNode<ST> var = visit(ctx.tipo());
        //Si esta presente la constante genero la pantilla
        // Obtener el valor de la constante, si existe
        boolean initialized = false;
        ST tag = null;
        if (ctx.constante() != null) {
            TreeParserNode<ST> cte = visit(ctx.constante());
            initialized = true;
            //Chequeo de Tipos: Que el tipo de la constante sea compatible con el tipo de la variable
            boolean check = EnumType.checkCompAsig(var.getType(), cte.getType());
            if (!check) {
                throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Asignación de tipos incompatibles.");
            }
            tag = bytecode.getInstanceOf("assign");
            tag.add("varNum", locals);
            tag.add("value", cte.getValue()); //Contiene la plantilla de la constante
            tag.add("id", id);
            String nemotec = ByteCodeConstants.getMnemonic(var.getType());
            tag.add("nemotec", nemotec);
            tag.add("comment", "Asignando un valor Var Global: -> Line " + ctx.TK_ID().getSymbol().getLine());
        }
        //Trabajo todas las variables como locales porque todas van a estar dentro del método main
        //OJO el atributo value de VarSymbol en el traductor no se utiliza
        LocalVarSymbol local = new LocalVarSymbol(locals++, var.getType(), initialized, id, ctx.TK_ID().getSymbol().getLine());
        //locals lo incremento aquí para que coincidan los valores
        //Coloco la variable global en la TS que esta en el tope que coincide con las de global
        environment.peek().insert(local);
        return new TreeParserNode(tag);
    }

    @Override
    public TreeParserNode<ST> visitSentVarLocalDec(LenguajeQParser.SentVarLocalDecContext ctx) {
        //Visitando una Declaracion
        String id = ctx.TK_ID().getText();
        //Chequeo Semántico
        //Que no se haya declarado una variable global con ese nombre previamente. Pueden definirse otras variable locales con ese nombre.
        //Para ello obtengo la TS que esta en el tope de la pila. En este punto se garantiza
        //que esta en el tope la de las variblaes globales
        SymbolTable tmp = environment.peek();
        if (tmp.exists(id)) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Variable Global declarada previamente");
        }
        TreeParserNode<ST> var = visit(ctx.tipo());
        //Si esta presente la constante genero la pantilla
        // Obtener el valor de la constante, si existe
        boolean initialized = false;
        ST tag = null;
        TreeParserNode exp = visit(ctx.exp());
        if (exp != null) {
            initialized = true;
            //Chequeo de Tipos: Que el tipo de la constante sea compatible con el tipo de la variable
            boolean check = EnumType.checkCompAsig(var.getType(), exp.getType());
            if (!check) {
                throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Asignación de tipos incompatibles.");
            }
            tag = bytecode.getInstanceOf("assign");
            tag.add("varNum", locals);
            tag.add("value", exp.getValue()); //Contiene la plantilla de la constante
            tag.add("id", id);
            String nemotec = ByteCodeConstants.getMnemonic(var.getType());
            tag.add("nemotec", nemotec);
            tag.add("comment", "Asignando un valor Var Local: -> Line " + ctx.TK_ID().getSymbol().getLine());
        }
        //Trabajo todas las variables como locales porque todas van a estar dentro del método main
        //OJO el atributo value de VarSymbol en el traductor no se utiliza
        LocalVarSymbol local = new LocalVarSymbol(locals++, var.getType(), initialized, id, ctx.TK_ID().getSymbol().getLine());
        //locals lo incremento aquí para que coincidan los valores
        //Coloco la variable global en la TS que esta en el tope que coincide con las de global
        environment.peek().insert(local);
        return new TreeParserNode(tag);
    }

    @Override
    public TreeParserNode<ST> visitSentEntrada(LenguajeQParser.SentEntradaContext ctx) {
        String id = ctx.TK_ID().getText();
        Symbol symbol = searchSymbol(id);
        //Chequeos semánticos
        if (symbol == null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador de variable no declarado previamente.");
        } else if (symbol.getSymbolType() != Symbol.LOCAL_VAR && symbol.getSymbolType() != Symbol.GLOBAL_VAR) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] El identificador debe ser una variable.");
        }
        EnumType type = ((VarSymbol) symbol).getType();
        ST tag = null;
        switch (type) {
            case INT:
                tag = bytecode.getInstanceOf("iread");
                break;
            case FLOAT:
                tag = bytecode.getInstanceOf("fread");
                break;
            case STRING:
                tag = bytecode.getInstanceOf("sread");
                break;
        }
        //Pongo la variable como inicializada
        ((LocalVarSymbol) symbol).setInitialized(true);
        //Coloco los valores en la plantilla
        tag.add("varNum", ((LocalVarSymbol) symbol).getNum());
        tag.add("id", id);
        tag.add("comment", "Leyendo un valor");
        return new TreeParserNode(tag);
    }

    @Override
    public TreeParserNode<ST> visitSentIf(LenguajeQParser.SentIfContext ctx) {
        //Primero se debe generar la comparación
        //La compración debe ser exp con 0
        TreeParserNode<ST> expNode = visit(ctx.exp());
        if (expNode.getType() != EnumType.INT) {
            throw new RuntimeException("Error [" + ctx.TK_IF().getSymbol().getLine() + "] La expresión debe ser de tipo entera.");
        }
        //cmp recibe la plantilla que tiene exp, recuerden que con los enteros se puede preguntar directamente.
        ST exp = expNode.getValue();
        //Se comienza a llenar la plantilla del if
        ST _if = bytecode.getInstanceOf("if");
        //Añadir la expresión de comparación
        _if.add("exp", exp);
        //Añadir la etiqueta 1
        _if.add("label1", labels++);
        //Visitar la sent del IF
        TreeParserNode<ST> sent1 = visit(ctx.sent(0));
        //Añadir la plantilla de la sent a la platilla del IF
        _if.add("sent1", sent1.getValue());
        //Verificar si existe la sentencia del else
        if (ctx.TK_ELSE() != null) {
            TreeParserNode<ST> sent2 = visit(ctx.sent(1));
            //Añadir la etiqueta 2
            _if.add("label2", labels++);
            //Añadir la sentencia del else
            _if.add("sent2", sent2.getValue());
        }
        return new TreeParserNode<ST>(_if);
    }

    @Override
    public TreeParserNode<ST> visitSentSalida(LenguajeQParser.SentSalidaContext ctx) {
        List<LenguajeQParser.ExpContext> lista = ctx.exp();
        String ln = (ctx.TK_PRINTLN() != null) ? "ln" : "";
        ST block = bytecode.getInstanceOf("block");
        for (LenguajeQParser.ExpContext exp : lista) {
            TreeParserNode<ST> nodo = visit(exp);
            String descr = ByteCodeConstants.getDescriptor(nodo.getType());
            ST tag = bytecode.getInstanceOf("write");
            tag.add("value", nodo.getValue());
            tag.add("comment", "Imprimiendo un valor");
            tag.add("ln", ln);
            tag.add("descr", descr);
            block.add("instructions", tag);
        }
        return new TreeParserNode(block);
    }

    @Override
    public TreeParserNode<ST> visitBloque(LenguajeQParser.BloqueContext ctx) {
        //Se crea una tabla para el contexto del bloque
        SymbolTable table = new SymbolTable();
        //Coloco la TS en la pila
        environment.push(table);
        //En un bloque se visitan todas las sentencias
        List<LenguajeQParser.SentContext> lista = ctx.sent();
        ST tag = bytecode.getInstanceOf("block");
        for (LenguajeQParser.SentContext sent : lista) {
            ST value = visit(sent).getValue();
            tag.add("instructions", value);
        }
        //Quito la TS asociada al bloque
        environment.pop();
        return new TreeParserNode(tag);
    }

    @Override
    public TreeParserNode<ST> visitSentAsig(LenguajeQParser.SentAsigContext ctx) {
        //Se obtiene el nombre de la variable
        String id = ctx.TK_ID().getText();
        //Chequeo semántico: Que exista una variable con ese nombre
        //Se busca en la pila si ya se ha declarado un símbolo con este identificador
        //Además el símbolo debe ser de tipo LOCAL_VAR o GLOBAL_VAR
        Symbol symbol = searchSymbol(id);
        if (symbol == null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador de variable no declarado previamente.");
        } else if (symbol.getSymbolType() != Symbol.LOCAL_VAR && symbol.getSymbolType() != Symbol.GLOBAL_VAR) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] El identificador debe ser una variable.");
        }
        //Se visita la expresión
        TreeParserNode expNode = visit(ctx.exp());
        //Tipo del s'imbolo
        EnumType type = ((VarSymbol) symbol).getType();
        //Se chequean que los tipos sean compatibles
        boolean check = EnumType.checkCompAsig(type, expNode.getType());
        if (!check) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Asignación de tipos incompatibles.");
        }
        //Se pone la variable como inicializada
        ((LocalVarSymbol) symbol).setInitialized(true);
        ST tag = bytecode.getInstanceOf("assign");
        String convTipo = "";
        //Si son de diferentes tipos entro al switch por si es necesaria una conversion de tipos
        if (type != expNode.getType()) {
            //Solo chequeo diferentes tipos
            switch (type) {
                case INT:
                    switch (expNode.getType()) {
                        case FLOAT:
                            convTipo = "f2i";
                            break;
                    }
                    break;
                case FLOAT:
                    switch (expNode.getType()) {
                        case INT:
                            convTipo = "i2f";
                            break;
                    }
                    break;
                //El caso de STRING es solo con String, no es necesario ponerlo
            }
        }
        tag.add("varNum", ((LocalVarSymbol) symbol).getNum());
        tag.add("value", expNode.getValue());
        //Si los tipos son diferentes y es necesaria una conversión
        if (!convTipo.equals("")) {
            tag.add("value", convTipo);
        }
        tag.add("id", id);
        tag.add("nemotec", ByteCodeConstants.getMnemonic(type));
        tag.add("comment", "Asignando un valor: -> Line " + ctx.TK_ID().getSymbol().getLine());
        return new TreeParserNode(tag);
    }

    @Override
    public TreeParserNode<ST> visitExpSigno(LenguajeQParser.ExpSignoContext ctx) {
        TreeParserNode<ST> exp = visit(ctx.exp());
        EnumType type = exp.getType();
        if (type == EnumType.STRING) {
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación no soportada por el tipo de datos STRING.");
        }
        if (ctx.op.getText().equals("-") && type != EnumType.STRING) {
            ST tag = bytecode.getInstanceOf("neg");
            tag.add("a", exp.getValue());
            tag.add("nemotec", ByteCodeConstants.getMnemonic(exp.getType()));
            return new TreeParserNode<>(type, tag);
        } else {
            return exp;
        }
    }

    @Override
    public TreeParserNode<ST> visitExpNeg(LenguajeQParser.ExpNegContext ctx) {
        TreeParserNode<ST> exp = visit(ctx.exp());
        EnumType type = exp.getType();
        if (type == EnumType.STRING) {
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación no soportada por el tipo de datos STRING.");
        }
        ST tag = bytecode.getInstanceOf("negLogica");
        tag.add("a", exp.getValue());
        tag.add("label1", labels++);
        tag.add("label2", labels++);
       // tag.add("nemotec", ByteCodeConstants.getMnemonic(type));
        return new TreeParserNode<>(type, tag);
    }

    @Override
    public TreeParserNode<ST> visitExpMulDiv(LenguajeQParser.ExpMulDivContext ctx) {
        TreeParserNode<ST> nLeft = visit(ctx.exp(0));  // Obtener tipo exp izq
        TreeParserNode<ST> nRight = visit(ctx.exp(1)); // Obtener tipo exp derecha
        TreeParserNode<ST> rpta = new TreeParserNode(null);
        String op = (ctx.op.getText().equals("*")) ? "mul" : "div";
        ST tag = bytecode.getInstanceOf(op);
        String nemotec = "";
        if (nLeft.getType() == EnumType.STRING || nRight.getType() == EnumType.STRING) {
            //Se chequea a STRING porque en Operaciones compatibles si es posible la +, es decir, la concatenación
            //Como ni * ni / son válidos
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación de tipos incompatibles.");
        }
        //Añado la expresión izquierda
        tag.add("a", nLeft.getValue());
        switch (nLeft.getType()) {
            case INT:
                switch (nRight.getType()) {
                    case INT:
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.INT);
                        tag.add("b", nRight.getValue());
                        rpta.setType(EnumType.INT);
                        break;
                    case FLOAT:
                        //Convierto el entero a float
                        tag.add("a", "i2f");
                        tag.add("b", nRight.getValue());
                        //El tipo de la expresion es float
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.FLOAT);
                        rpta.setType(EnumType.FLOAT);
                        break;
                }

                break;
            case FLOAT:
                switch (nRight.getType()) {
                    case INT:
                        //Cargo expresion derecha
                        tag.add("b", nRight.getValue());
                        //Convierto el entero a float
                        tag.add("b", "i2f");
                        //El tipo de la expresion es float
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.FLOAT);
                        rpta.setType(EnumType.FLOAT);
                        break;
                    case FLOAT:
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.FLOAT);
                        tag.add("b", nRight.getValue());
                        rpta.setType(EnumType.FLOAT);
                        break;
                }
                break;
        }
        tag.add("nemotec", nemotec);
        rpta.setValue(tag);
        return rpta;
    }

    @Override
    public TreeParserNode<ST> visitExpAddSub(LenguajeQParser.ExpAddSubContext ctx) {
        TreeParserNode<ST> nLeft = visit(ctx.exp(0));  // Obtener tipo exp izq
        TreeParserNode<ST> nRight = visit(ctx.exp(1)); // Obtener tipo exp derecha
        TreeParserNode<ST> rpta = new TreeParserNode(null);
        String op = (ctx.op.getText().equals("+")) ? "add" : "sub";
        if (op.equals("sub") && (nLeft.getType() == EnumType.STRING || nRight.getType() == EnumType.STRING)) {
            //Se chequea a STRING porque en Operaciones compatibles si es posible la +, es decir, la concatenación
            //La - no es válida
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación de tipos incompatibles.");
        }
        ST tag = bytecode.getInstanceOf(op);
        String nemotec = "";
        //Añado la expresión izquierda
        tag.add("a", nLeft.getValue());
        switch (nLeft.getType()) {
            case INT:
                switch (nRight.getType()) {
                    case INT:
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.INT);
                        tag.add("b", nRight.getValue());
                        rpta.setType(EnumType.INT);
                        break;
                    case FLOAT:
                        //Convierto el entero a float
                        tag.add("a", "i2f");
                        tag.add("b", nRight.getValue());
                        //El tipo de la expresion es float
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.FLOAT);
                        rpta.setType(EnumType.FLOAT);
                        break;
                    case STRING:
                        //Caso particular
                        //Instancia plantilla cocatenar de entero cadena
                        ST aux = bytecode.getInstanceOf("concatExpString");
                        aux.add("a", nLeft.getValue());
                        aux.add("b", nRight.getValue());
                        aux.add("descrA", ByteCodeConstants.getDescriptor(nLeft.getType()));
                        aux.add("descrB", ByteCodeConstants.getDescriptor(nRight.getType()));
                        rpta.setType(EnumType.STRING);
                        rpta.setValue(aux);
                        return rpta;
                }

                break;
            case FLOAT:
                switch (nRight.getType()) {
                    case INT:
                        //Cargo expresion derecha
                        tag.add("b", nRight.getValue());
                        //Convierto el entero a float
                        tag.add("b", "i2f");
                        //El tipo de la expresion es float
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.FLOAT);
                        rpta.setType(EnumType.FLOAT);
                        break;
                    case FLOAT:
                        nemotec = ByteCodeConstants.getMnemonic(EnumType.FLOAT);
                        tag.add("b", nRight.getValue());
                        rpta.setType(EnumType.FLOAT);
                        break;
                    case STRING:
                        //Caso particular
                        //Instancia plantilla cocatenar de entero cadena
                        ST aux = bytecode.getInstanceOf("concatExpString");
                        aux.add("a", nLeft.getValue());
                        aux.add("b", nRight.getValue());
                        aux.add("descrA", ByteCodeConstants.getDescriptor(nLeft.getType()));
                        aux.add("descrB", ByteCodeConstants.getDescriptor(nRight.getType()));
                        rpta.setType(EnumType.STRING);
                        rpta.setValue(aux);
                        return rpta;
                }
                break;
            case STRING:
                switch (nRight.getType()) {
                    case INT:
                    case FLOAT:
                        //Caso particular
                        //Instancia plantilla cocatenar de entero cadena
                        ST aux = bytecode.getInstanceOf("concatExpString");
                        aux.add("a", nLeft.getValue());
                        aux.add("b", nRight.getValue());
                        aux.add("descrA", ByteCodeConstants.getDescriptor(nLeft.getType()));
                        aux.add("descrB", ByteCodeConstants.getDescriptor(nRight.getType()));
                        rpta.setType(EnumType.STRING);
                        rpta.setValue(aux);
                        return rpta;
                    case STRING:
                        aux = bytecode.getInstanceOf("concatStringString");
                        aux.add("a", nLeft.getValue());
                        aux.add("b", nRight.getValue());
                        rpta.setType(EnumType.STRING);
                        rpta.setValue(aux);
                        return rpta;
                }
                break;
        }
        tag.add("nemotec", nemotec);
        rpta.setValue(tag);
        return rpta;
    }

    @Override
    public TreeParserNode<ST> visitExpID(LenguajeQParser.ExpIDContext ctx) {
        String id = ctx.TK_ID().getText();
        Symbol symbol = searchSymbol(id);
        //Chequeos semánticos
        if (symbol == null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador de variable no declarado previamente.");
        } else if (symbol.getSymbolType() != Symbol.LOCAL_VAR && symbol.getSymbolType() != Symbol.GLOBAL_VAR) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] El identificador debe ser una variable.");
        } else if (!((VarSymbol) symbol).isInitialized()) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] La variable no se ha inicializado.");
        }
        EnumType type = ((VarSymbol) symbol).getType();
        ST tag = bytecode.getInstanceOf("load");
        tag.add("id", id);
        tag.add("varNum", ((LocalVarSymbol) symbol).getNum());
        tag.add("nemotec", ByteCodeConstants.getMnemonic(type));
        return new TreeParserNode(type, tag);
    }

    @Override
    public TreeParserNode<ST> visitExpCte(LenguajeQParser.ExpCteContext ctx) {
        return visit(ctx.constante());
    }

    @Override
    public TreeParserNode<ST> visitExpParent(LenguajeQParser.ExpParentContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public TreeParserNode<ST> visitCteHex(LenguajeQParser.CteHexContext ctx) {
        String hex = ctx.TK_CTE_HEX().getText();
        Integer obj = Integer.valueOf(hex.substring(hex.indexOf('x') + 1, hex.length()), 16);
        ST tag = bytecode.getInstanceOf("const");
        tag.add("value", obj);
        return new TreeParserNode(EnumType.INT, tag);
    }

    @Override
    public TreeParserNode<ST> visitCteInt(LenguajeQParser.CteIntContext ctx) {
        Integer obj = Integer.valueOf(ctx.TK_CTE_INT().getText());
        ST tag = bytecode.getInstanceOf("const");
        tag.add("value", obj);
        return new TreeParserNode(EnumType.INT, tag);
    }

    @Override
    public TreeParserNode<ST> visitCteFloat(LenguajeQParser.CteFloatContext ctx) {
        Float obj = Float.valueOf(ctx.TK_CTE_FLOAT().getText());
        ST tag = bytecode.getInstanceOf("const");
        tag.add("value", obj);
        return new TreeParserNode(EnumType.FLOAT, tag);
    }

    @Override
    public TreeParserNode<ST> visitCteString(LenguajeQParser.CteStringContext ctx) {
        String obj = ctx.TK_CTE_STRING().getText();
        ST tag = bytecode.getInstanceOf("const");
        tag.add("value", obj);
        return new TreeParserNode(EnumType.STRING, tag);
    }

    @Override
    public TreeParserNode<ST> visitSentTimes(LenguajeQParser.SentTimesContext ctx) {
       //Primero se debe generar la comparación
        //La compración debe ser exp con 0
        TreeParserNode<ST> expNode = visit(ctx.exp());
        if (expNode.getType() != EnumType.INT) {
            throw new RuntimeException("Error [" + ctx.TK_TIMES().getSymbol().getLine() + "] La expresión debe ser de tipo entera.");
        }
        //cmp recibe la plantilla que tiene exp, recuerden que con los enteros se puede preguntar directamente.
        ST exp = expNode.getValue();
        //Se comienza a llenar la plantilla del time
        ST _times = bytecode.getInstanceOf("times");
        //Añadir la expresión de comparación
        _times.add("exp", exp);
        //Añadir la etiqueta 1
        _times.add("label1", labels++);
        _times.add("label2", labels++);
        //Visitar la sent del time
        TreeParserNode<ST> sent = visit(ctx.sent());
        //Añadir la plantilla de la sent a la platilla del times
        _times.add("sent", sent.getValue());
        
        return new TreeParserNode<ST>(_times);
    }

    @Override
    public TreeParserNode<ST> visitSentMean(LenguajeQParser.SentMeanContext ctx) {
        List<LenguajeQParser.ExpContext> listaExp=ctx.exp();
        ST mean=bytecode.getInstanceOf("mean");
        for (LenguajeQParser.ExpContext expx : listaExp) {            
            TreeParserNode exp=visit(expx);            
            ST add=bytecode.getInstanceOf("add");
            
            add.add("b", exp.getValue());
            if (exp.getType()==EnumType.INT) {
                add.add("b", "i2f");
            }
            add.add("nemotec", "f");
            mean.add("exp", add);
        }
        mean.add("cant", listaExp.size());
        return new TreeParserNode<>(EnumType.FLOAT,mean);
        
    }
    
    

    @Override
    public TreeParserNode<ST> visitTipoInt(LenguajeQParser.TipoIntContext ctx) {
        return new TreeParserNode(EnumType.INT, null);
    }

    @Override
    public TreeParserNode<ST> visitTipoFloat(LenguajeQParser.TipoFloatContext ctx) {
        return new TreeParserNode(EnumType.FLOAT, null);
    }

    @Override
    public TreeParserNode<ST> visitTipoString(LenguajeQParser.TipoStringContext ctx) {
        return new TreeParserNode(EnumType.STRING, null);
    }

    private Symbol searchSymbol(String name) {
        int size = environment.size();
        for (int i = size - 1; i >= 0; i--) {
            SymbolTable table = environment.get(i);
            Symbol symbol = table.search(name);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

}
