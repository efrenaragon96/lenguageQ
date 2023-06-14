/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

/**
 *
 * @author juanluis
 * @param <T>
 */
public class TreeParserNode<T> implements Comparable<T> {

    private EnumType type;
    private T value;

    public TreeParserNode(T value) {
        this.value = value;
    }

    public TreeParserNode(EnumType type, T value) {
        this.type = type;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    @Override
    public int compareTo(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
