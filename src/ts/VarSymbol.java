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
public abstract class VarSymbol<T> extends Symbol {
    
    protected EnumType type;            //Tipo de la variable
    protected boolean initialized;      //Inicializada
    protected T value;                  //Valor OJO Solo se utiliza en el intéprete.
    

    public VarSymbol(EnumType type, boolean initialized, T value, String name, int line) {
        super(name, line);
        this.type = type;
        this.initialized = initialized;
        this.value = value;
    }
    
      public VarSymbol(EnumType type, boolean initialized, String name, int line) {
        super(name, line);
        this.type = type;
        this.initialized = initialized;
    }


    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    public T getValue() {
        return value;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setValue(T value) {
        initialized=true;
        this.value = value;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
    
   
}
