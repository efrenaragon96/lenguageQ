/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

/**
 *
 * @author juanluis
 */
public class LocalVarSymbol extends VarSymbol {

    protected int num;  //Dirección en memoria, no es más que el número q se le asigna a la variable

    public LocalVarSymbol(int num, EnumType type, boolean initialized, String name, int line) {
        super(type, initialized, name, line);
        this.num = num;
    }
    
    public LocalVarSymbol(int num,EnumType type, boolean initialized, Object value, String name, int line) {
        super(type, initialized, value, name, line);
        this.num=num;
    }
    
 
    @Override
    public int getSymbolType() {
        return Symbol.LOCAL_VAR;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

}
