package ts;

public enum EnumType {

    STRING("st"), INT("i"), FLOAT("f"), NULL("n");
    private final String value;

    private EnumType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
/**
 * Tenga en cuenta que este método se puede realizar para cada operación o eliminarse e incluirse dentro del compilador
 * @param type1
 * @param type2
 * @return 
 */
    public static boolean checkCompAsig(EnumType type1, EnumType type2) {
        switch (type1) {
            case INT:
                switch (type2) {
                    case INT:
                        return true;
                    case STRING:
                        return false;
                    case FLOAT:
                        return false;
                }
            case FLOAT:
                switch (type2) {
                    case INT:
                        return true;
                    case STRING:
                        return false;
                    case FLOAT:
                        return true;
                }
            case STRING:
                switch (type2) {
                    case INT:
                        return false;
                    case STRING:
                        return true;
                    case FLOAT:
                        return false;
                }
            default:
                return false;
        }
    }

};
