/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import java.util.HashMap;

/**
 *
 * @author juanluis
 */
public class SymbolTable {

    private HashMap<String, Symbol> tabla;

    public SymbolTable() {
        tabla = new HashMap();
    }
    //Aquí pueden realizar la búsqueda antes de insertar y lanzar un error si ya se encuentra
    public void insert(Symbol symbol) /*throws DuplicateSymbolException */{
        String name = symbol.getName();
        /*if (exists(name)) {
            throw new DuplicateSymbolException();
        } else {*/
            tabla.put(name, symbol);
        /*}*/
    }

    public Symbol search(String name) {
        return tabla.get(name);
    }

    public boolean exists(String name) {
        return tabla.containsKey(name);
    }

    public void remove(Symbol symbol) {
        tabla.remove(symbol.getName());
    }
    
    public int symbolsQuantity(){
        return tabla.size();
    }

}
