/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import parser.LenguajeQBaseVisitor;
import parser.LenguajeQParser;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.LenguajeQLexer;
import parser.LenguajeQParser.*;
import ts.*;

/**
 *
 * @author juanluis
 */
public class InterpreteVisitor extends LenguajeQBaseVisitor<TreeParserNode> {

    //Manejo de los símbolos y sus ámbitos de ejecución, podemos declarar variables locales dentro de las sentencias
    private Stack<SymbolTable> environment;

    public InterpreteVisitor() {
        environment = new Stack<>();
    }

    public void interpret(File source) {
        FileReader reader;
        try {
            reader = new FileReader(source);
            ANTLRInputStream input = new ANTLRInputStream(reader);
            LenguajeQLexer lexer = new LenguajeQLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LenguajeQParser parser = new LenguajeQParser(tokens);
            ParseTree tree = parser.start();
            InterpreteVisitor int_visitor = new InterpreteVisitor();
            int_visitor.visit(tree);
        } catch (IOException ex) {
            throw new RuntimeException("Verifique que el fichero de entrada sea correcto.");
        }

    }

    @Override
    public TreeParserNode visitStart(StartContext ctx) {
        System.out.println("Iniciando Intérprete...");
        //Creo una tabla de simbolos para las variables globales
        SymbolTable table = new SymbolTable();
        //La coloco en el fondo de la pila
        environment.push(table);
        for (DclContext dcl : ctx.dcl()) {
            visit(dcl);
        }
        //Creo la tabla para el contexto de las sentencias
        table = new SymbolTable();
        //La coloco en la pila
        environment.push(table);
        //Visito las sentencias
        for (SentContext sent : ctx.sent()) {
            visit(sent);
        }
        //Quito la TS de las sentencias de la pila
        environment.pop();
        //Quito la TS de la pila
        environment.pop();
        System.out.println("Finalizando Intérprete...");
        return null;
    }

    @Override
    public TreeParserNode visitDcl(LenguajeQParser.DclContext ctx) {
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
        TreeParserNode var = visit(ctx.tipo());
        boolean initialized = false;
        if (ctx.constante() != null) {
            initialized = true;
            TreeParserNode aux = visit(ctx.constante());
            //Chequeo de Tipos: Que el tipo de la constante sea compatible con el tipo de la variable
            boolean check = EnumType.checkCompAsig(var.getType(), aux.getType());
            if (!check) {
                throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Asignación de tipos incompatibles.");
            }
            switch (var.getType()) {
                case INT:
                    //Se le pone a var el tipo INT, aunque se puede omitir este paso debido a que ya lo tiene
                    //var.setType(EnumType.INT);
                    switch (aux.getType()) {
                        case INT:
                            //Actualización del valor en el símbolo
                            var.setValue((int) aux.getValue());
                            break;
                        //No es necesario pq ya se chequearon los tipos incompatibles
                        //case FLOAT:  
                        //case STRING:
                    }
                    break;
                case FLOAT:
                    //Se le pone a var el tipo FLOAT, aunque se puede omitir este paso debido a que ya lo tiene
                    //var.setType(EnumType.FLOAT);
                    switch (aux.getType()) {
                        case INT:
                            //Actualización del valor en el símbolo
                            var.setValue(Float.parseFloat("" + (int) aux.getValue()));
                            break;
                        case FLOAT:
                            //Actualización del valor en el símbolo
                            var.setValue((float) aux.getValue());
                            break;
                        //No es necesario pq ya se chequearon los tipos incompatibles
                        //case STRING:
                    }
                    break;
                case STRING:
                    //Se le pone a var el tipo STRING, aunque se puede omitir este paso debido a que ya lo tiene
                    //var.setType(EnumType.STRING);
                    switch (aux.getType()) {
                        case STRING:
                            var.setValue("" + aux.getValue());
                            break;
                        //No es necesario pq ya se chequearon los tipos incompatibles
                        //case INT
                        //case FLOAT:
                    }
                    break;
            }
        }
        GlobalVarSymbol global = new GlobalVarSymbol(var.getType(), initialized, var.getValue(), id, ctx.TK_ID().getSymbol().getLine());
        //Coloco la variable global en la TS que esta en el tope que coincide con las de global
        environment.peek().insert(global);
        return null;
    }

    @Override
    public TreeParserNode visitSentVarLocalDec(SentVarLocalDecContext ctx) {
        //Visitando una Declaracion de Variable Local
        String id = ctx.TK_ID().getText();
        //Chequeo Semántico
        //Que no se haya declarado una variable local con ese nombre dentro de ese ambito, puede existir una global
        // con el mismo nombre pero se utiliza la del ambito de mas arriba
        SymbolTable tmp = environment.peek();
        if (tmp.exists(id)) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Variable Local declarada previamente");
        }
        TreeParserNode var = visit(ctx.tipo());
        boolean initialized = false;
        if (ctx.exp() != null) {
            initialized = true;
            TreeParserNode aux = visit(ctx.exp());
            //Chequeo de Tipos: Que el tipo de la expresión sea compatible con el tipo de la variable
            boolean check = EnumType.checkCompAsig(var.getType(), aux.getType());
            if (!check) {
                throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Asignación de tipos incompatibles.");
            }
            switch (var.getType()) {
                case INT:
                    //Se le pone a var el tipo INT, aunque se puede omitir este paso debido a que ya lo tiene
                    //var.setType(EnumType.INT);
                    switch (aux.getType()) {
                        case INT:
                            //Actualización del valor en el símbolo
                            var.setValue((int) aux.getValue());
                            break;
                        //No es necesario pq ya se chequearon los tipos incompatibles
                        //case FLOAT:  
                        //case STRING:
                    }
                    break;
                case FLOAT:
                    //Se le pone a var el tipo FLOAT, aunque se puede omitir este paso debido a que ya lo tiene
                    //var.setType(EnumType.FLOAT);
                    switch (aux.getType()) {
                        case INT:
                            //Actualización del valor en el símbolo
                            var.setValue(Float.parseFloat("" + (int) aux.getValue()));
                            break;
                        case FLOAT:
                            //Actualización del valor en el símbolo
                            var.setValue(Float.parseFloat("" + aux.getValue()));
                            break;
                        //No es necesario pq ya se chequearon los tipos incompatibles
                        //case STRING:
                    }
                    break;
                case STRING:
                    //Se le pone a var el tipo STRING, aunque se puede omitir este paso debido a que ya lo tiene
                    //var.setType(EnumType.STRING);
                    switch (aux.getType()) {
                        case STRING:
                            var.setValue("" + aux.getValue());
                            break;
                        //No es necesario pq ya se chequearon los tipos incompatibles
                        //case INT
                        //case FLOAT:
                    }
                    break;
            }
        }
        LocalVarSymbol global = new LocalVarSymbol(0, var.getType(), initialized, var.getValue(), id, ctx.TK_ID().getSymbol().getLine());
        //Coloco la variable local en la TS que esta en el tope
        environment.peek().insert(global);
        return null;
    }

    @Override
    public TreeParserNode visitSentTimes(SentTimesContext ctx) {
        //Se visita la expresión
        TreeParserNode exp = visit(ctx.exp());
        //Chequeo semántico
        //Que la expresión sea de tipo entera
        if (exp.getType() != EnumType.INT) {
            throw new RuntimeException("Error [" + ctx.TK_TIMES().getSymbol().getLine() + "] La expresión debe ser de tipo INT.");
        }
        //Se crea una tabla para el contexto del if
        SymbolTable table = new SymbolTable();
        //Coloco la TS en la pila
        environment.push(table);
        int value = (int) exp.getValue();
        while (value > 0) {
            visit(ctx.sent());
            value--;
        }
        //Quito la TS asociada al if de la pila
        environment.pop();
        return null;
    }
    @Override
    public TreeParserNode visitSentMean(SentMeanContext ctx) {
        List<ExpContext> expList = ctx.exp();
        double res = 0;
        boolean isInteger = true;

        for(ExpContext exp: expList) {
            TreeParserNode val = visit(exp);

            if(val.getType() == EnumType.STRING) {
                throw new RuntimeException("Error [" + ctx.TK_MEAN().getSymbol().getLine() + "] Los parámetros debes ser numéricos");
            }

            if(val.getType() == EnumType.FLOAT) isInteger = false;
            res += Double.parseDouble(val.getValue().toString());
        }

        if(isInteger) return new TreeParserNode(EnumType.INT, (int)( res / expList.size()));

        return new TreeParserNode(EnumType.FLOAT, res / expList.size());
    }

    @Override
    public TreeParserNode visitSentIf(LenguajeQParser.SentIfContext ctx) {
        //Se visita la expresión
        TreeParserNode exp = visit(ctx.exp());
        //Chequeo semántico
        //Que la expresión sea de tipo entera
        if (exp.getType() != EnumType.INT) {
            throw new RuntimeException("Error [" + ctx.TK_IF().getSymbol().getLine() + "] La expresión debe ser de tipo INT.");
        }
        //Se crea una tabla para el contexto del if
        SymbolTable table = new SymbolTable();
        //Coloco la TS en la pila
        environment.push(table);
        int value = (int) exp.getValue();
        if (value != 0) {
            visit(ctx.sent(0));
        } else if (ctx.TK_ELSE() != null) {
            visit(ctx.sent(1));
        }
        //Quito la TS asociada al if de la pila
        environment.pop();
        return null;
    }

    @Override
    public TreeParserNode visitSentAsig(LenguajeQParser.SentAsigContext ctx) {
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
        switch (type) {
            case INT:
                switch (expNode.getType()) {
                    case INT:
                        ((VarSymbol) symbol).setValue((int) expNode.getValue());
                        break;
                    //No es necesario pq ya se chequearon los tipos incompatibles
                    //case FLOAT:
                    //case STRING:
                }
                break;
            case FLOAT:
                switch (expNode.getType()) {
                    case INT:
                        ((VarSymbol) symbol).setValue(Float.parseFloat("" + (int) expNode.getValue()));
                        break;
                    case FLOAT:
                        ((VarSymbol) symbol).setValue((float) expNode.getValue());
                        break;
                    //No es necesario pq ya se chequearon los tipos incompatibles
                    //case STRING:
                }
                break;
            case STRING:
                switch (expNode.getType()) {
                    case STRING:
                        ((VarSymbol) symbol).setValue("" + expNode.getValue());
                        break;
                    //No es necesario pq ya se chequearon los tipos incompatibles
                    //case INT
                    //case FLOAT:
                }
                break;
        }
        return new TreeParserNode(null);
    }

    @Override
    public TreeParserNode visitBloque(LenguajeQParser.BloqueContext ctx) {
        //Se crea una tabla para el contexto del bloque
        SymbolTable table = new SymbolTable();
        //Coloco la TS en la pila
        environment.push(table);
        //En un bloque se visitan todas las expresiones
        List<SentContext> lista = ctx.sent();
        for (SentContext sent : lista) {
            visit(sent);
        }
        //Quito la TS asociada al bloque
        environment.pop();
        return null;
    }

//    @Override
//    public TreeParserNode visitExpPotencia(LenguajeQParser.ExpPotenciaContext ctx) {
//        TreeParserNode nLeft = visit(ctx.exp(0));
//        TreeParserNode nRight = visit(ctx.exp(1));
//        TreeParserNode result = null;
//        Object lValue, rValue = null;
//        switch (nLeft.getType()) {
//            case INT:
//                lValue = (int) nLeft.getValue();
//                switch (nRight.getType()) {
//                    case INT:
//                        rValue = (int) nRight.getValue();
//                        int r = (int) Math.pow((double) lValue, (double) rValue);
//                        result = new TreeParserNode(EnumType.INT, r);
//                        break;
//                    //No es necesario pq ya se chequearon los tipos incompatibles
//                    //case STRING:
//                }
//                break;
//            case STRING:
//                throw new RuntimeException("Error: El operador potencia no opera con cadenas.");
//        }
//        return result;
//    }
    @Override
    public TreeParserNode visitExpSigno(ExpSignoContext ctx) {
        TreeParserNode exp = visit(ctx.exp());
        EnumType type = exp.getType();
        if (type == EnumType.STRING) {
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación no soportada por el tipo de datos STRING.");
        }
        if (ctx.op.getText().equals("-")) {
            TreeParserNode result = null;
            switch (exp.getType()) {
                case INT:
                    result = new TreeParserNode(type, (Integer) exp.getValue() * -1);
                    break;
                case FLOAT:
                    result = new TreeParserNode(type, (Float) exp.getValue() * -1);
                    break;
                default:
                    throw new RuntimeException("Error: Tipo Incorrecto.");
            }
            return result;
        } else {
            return exp;
        }
    }

    @Override
    public TreeParserNode visitExpNeg(LenguajeQParser.ExpNegContext ctx) {
        TreeParserNode exp = visit(ctx.exp());
        EnumType type = exp.getType();
        if (type == EnumType.STRING) {
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación no soportada por el tipo de datos STRING.");
        }
        TreeParserNode result = null;
        switch (type) {
            case INT:
                result = new TreeParserNode(type, (Integer) exp.getValue() * -1);
                break;
            case FLOAT:
                result = new TreeParserNode(type, (Float) exp.getValue() * -1);
                break;
            default:
                throw new RuntimeException("Error: Tipo Incorrecto.");
        }
        return result;
    }

    @Override
    public TreeParserNode visitExpMulDiv(LenguajeQParser.ExpMulDivContext ctx) {
        TreeParserNode nLeft = visit(ctx.exp(0));
        TreeParserNode nRight = visit(ctx.exp(1));
        TreeParserNode result = null;
        if (nLeft.getType() == EnumType.STRING || nRight.getType() == EnumType.STRING) {
            //Se chequea a STRING porque en Operaciones compatibles si es posible la +, es decir, la concatenación
            //Como ni * ni / son válidos
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación de tipos incompatibles.");
        }
        Object lValue, rValue, r = null;
        switch (nLeft.getType()) {
            case INT:
                lValue = (int) nLeft.getValue();
                switch (nRight.getType()) {
                    case INT:
                        rValue = (int) nRight.getValue();
                        r = (ctx.op.getText().equals("*")) ? ((int) lValue * (int) rValue) : ((int) lValue / (int) rValue);
                        result = new TreeParserNode(EnumType.INT, (int) r);
                        break;
                    case FLOAT:
                        rValue = (float) nRight.getValue();
                        r = (ctx.op.getText().equals("*")) ? ((int) lValue * (float) rValue) : ((int) lValue / (float) rValue);
                        result = new TreeParserNode(EnumType.FLOAT, (float) r);
                        break;
                    //No es necesario pq ya se chequearon los tipos incompatibles
                    //case STRING:
                }
                break;
            case FLOAT:
                lValue = (float) nLeft.getValue();
                switch (nRight.getType()) {
                    case INT:
                        rValue = (int) nRight.getValue();
                        r = (ctx.op.getText().equals("*")) ? ((float) lValue * (int) rValue) : ((float) lValue / (int) rValue);
                        result = new TreeParserNode(EnumType.FLOAT, (float) r);
                        break;
                    case FLOAT:
                        rValue = (float) nRight.getValue();
                        r = (ctx.op.getText().equals("*")) ? ((float) lValue * (float) rValue) : ((float) lValue / (float) rValue);
                        result = new TreeParserNode(EnumType.FLOAT, (float) r);
                        break;
                    //No es necesario pq ya se chequearon los tipos incompatibles
                    //case STRING:
                }
                break;
        }
        return result;
    }

    @Override
    public TreeParserNode visitExpAddSub(LenguajeQParser.ExpAddSubContext ctx) {
        TreeParserNode nLeft = visit(ctx.exp(0));
        TreeParserNode nRight = visit(ctx.exp(1));
        TreeParserNode result = null;
        Object lValue, rValue, r = null;
        if (ctx.op.getText().equals("-") && (nLeft.getType() == EnumType.STRING || nRight.getType() == EnumType.STRING)) {
            //Se chequea a STRING porque en Operaciones compatibles si es posible la +, es decir, la concatenación
            //La - no es válida
            throw new RuntimeException("Error [" + ctx.getStart().getLine() + "] Operación de tipos incompatibles.");
        }
        switch (nLeft.getType()) {
            case INT:
                lValue = (int) nLeft.getValue();
                switch (nRight.getType()) {
                    case INT:
                        rValue = (int) nRight.getValue();
                        r = (ctx.op.getText().equals("+")) ? ((int) lValue + (int) rValue) : ((int) lValue - (int) rValue);
                        result = new TreeParserNode(EnumType.INT, (int) r);
                        break;
                    case FLOAT:
                        rValue = (float) nRight.getValue();
                        r = (ctx.op.getText().equals("+")) ? ((int) lValue + (float) rValue) : ((int) lValue - (float) rValue);
                        result = new TreeParserNode(EnumType.FLOAT, (float) r);
                        break;
                    case STRING:
                        rValue = nRight.getValue().toString();
                        r = lValue.toString() + rValue.toString();
                        result = new TreeParserNode(EnumType.STRING, r);
                        break;
                }
                break;
            case FLOAT:
                lValue = (float) nLeft.getValue();
                switch (nRight.getType()) {
                    case INT:
                        rValue = (int) nRight.getValue();
                        r = (ctx.op.getText().equals("+")) ? ((float) lValue + (int) rValue) : ((float) lValue - (int) rValue);
                        result = new TreeParserNode(EnumType.INT, (int) r);
                        break;
                    case FLOAT:
                        rValue = (float) nRight.getValue();
                        r = (ctx.op.getText().equals("+")) ? ((float) lValue + (float) rValue) : ((float) lValue - (float) rValue);
                        result = new TreeParserNode(EnumType.FLOAT, (float) r);
                        break;
                    case STRING:
                        rValue = nRight.getValue().toString();
                        r = lValue.toString() + rValue.toString();
                        result = new TreeParserNode(EnumType.STRING, r);
                        break;
                }
                break;
            case STRING:
                lValue = nLeft.getValue().toString();
                rValue = nRight.getValue().toString();
                r = lValue.toString() + rValue.toString();
                result = new TreeParserNode(EnumType.STRING, r);
                break;
        }
        return result;
    }

    @Override
    public TreeParserNode visitExpCte(ExpCteContext ctx) {
        return visit(ctx.constante());
    }

    @Override
    public TreeParserNode visitExpID(LenguajeQParser.ExpIDContext ctx) {
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
        return new TreeParserNode(((VarSymbol) symbol).getType(), ((VarSymbol) symbol).getValue());
    }

    @Override
    public TreeParserNode visitExpParent(ExpParentContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public TreeParserNode visitSentSalida(LenguajeQParser.SentSalidaContext ctx) {
        List<ExpContext> lista = ctx.exp();
        if (ctx.TK_PRINT() != null) {
            for (ExpContext exp : lista) {
                TreeParserNode nodo = visit(exp);
                if (nodo.getType() == EnumType.STRING) {
                    System.out.print((String) nodo.getValue());
                } else {
                    System.out.print(nodo.getValue());
                }

            }
        } else {
            for (ExpContext exp : lista) {
                TreeParserNode nodo = visit(exp);
                if (nodo.getType() == EnumType.STRING) {
                    System.out.println((String) nodo.getValue());
                } else {
                    System.out.println(nodo.getValue());
                }
            }
        }
        return null;
    }

    @Override
    public TreeParserNode visitSentEntrada(LenguajeQParser.SentEntradaContext ctx) {
        String id = ctx.TK_ID().getText();
        Symbol symbol = searchSymbol(id);
        if (symbol == null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador de variable no declarado previamente.");
        } else if (symbol.getSymbolType() != Symbol.LOCAL_VAR && symbol.getSymbolType() != Symbol.GLOBAL_VAR) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] El identificador debe ser una variable.");
        }
        EnumType type = ((VarSymbol) symbol).getType();
        Scanner in = new Scanner(System.in);
        TreeParserNode nodo = null;
        Object value;
        switch (type) {
            case INT:
                value = in.nextInt();
                nodo = new TreeParserNode(type, value);
                break;
            case FLOAT:
                value = in.nextFloat();
                nodo = new TreeParserNode(type, value);
                break;
            case STRING:
                value = in.nextLine().trim();
                nodo = new TreeParserNode(type, value);
                break;
        }
        ((VarSymbol) symbol).setValue(nodo.getValue());
        ((VarSymbol) symbol).setInitialized(true);
        return null;
    }

    @Override
    public TreeParserNode visitTipoInt(TipoIntContext ctx) {
        return new TreeParserNode(EnumType.INT, null);
    }

    @Override
    public TreeParserNode visitCteInt(LenguajeQParser.CteIntContext ctx) {
        Integer obj = Integer.valueOf(ctx.TK_CTE_INT().getText());
        return new TreeParserNode(EnumType.INT, obj);
    }

    @Override
    public TreeParserNode visitCteFloat(LenguajeQParser.CteFloatContext ctx) {
        Float obj = Float.valueOf(ctx.TK_CTE_FLOAT().getText());
        return new TreeParserNode(EnumType.FLOAT, obj);
    }

    @Override
    public TreeParserNode visitCteHex(LenguajeQParser.CteHexContext ctx) {
        String hex = ctx.TK_CTE_HEX().getText();
        Integer obj = Integer.valueOf(hex.substring(hex.indexOf('x') + 1, hex.length()), 16);
        return new TreeParserNode(EnumType.INT, obj);
    }

    @Override
    public TreeParserNode visitTipoString(TipoStringContext ctx) {
        return new TreeParserNode(EnumType.STRING, null);
    }

    @Override
    public TreeParserNode visitTipoFloat(TipoFloatContext ctx) {
        return new TreeParserNode(EnumType.FLOAT, null);
    }

    @Override
    public TreeParserNode visitCteString(CteStringContext ctx) {
        String obj = ctx.TK_CTE_STRING().getText();
        return new TreeParserNode(EnumType.STRING, obj);
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
