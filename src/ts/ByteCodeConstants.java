/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import ts.EnumType;

/**
 *
 * @author juanluis
 */
public class ByteCodeConstants {

    public static final String INT_TYPE_NEM = "i";
    public static final String INT_TYPE_DESC = "I";
    public static final String FLOAT_TYPE_NEM = "f";
    public static final String FLOAT_TYPE_DESC = "F";
    public static final String VOID_TYPE_DESC = "V";
    public static final String STRING_TYPE_NEM = "a";
    public static final String STRING_TYPE_DESC = "Ljava/lang/String;";
    public static final String ARRAY_TYPE_DESC = "[";

    public static String getDescriptor(EnumType type) {
        switch (type) {
            case INT:
                return INT_TYPE_DESC;
            case FLOAT:
                return FLOAT_TYPE_DESC;
            case STRING:
                return STRING_TYPE_DESC;
            /* case VOID:
             return VOID_TYPE_DESC;*/

        }
        return "";
    }

    public static String getMnemonic(EnumType type) {
        switch (type) {
            case INT:
                return INT_TYPE_NEM;
            case FLOAT:
                return FLOAT_TYPE_NEM;
            case STRING:
                return STRING_TYPE_NEM;

        }
        return "";
    }

    public static String generateMethodName(String className, String name, String argDesc) {
        return name + "_" + className.length() + "_" + className + "_" + argDesc;
    }
}
