package Aparts;

/**
 *
 * @author Master
 */
public enum key {

    INTEGER, STRING, LONG, DOUBLE, CHAR;

    String calculate(String a) {
        switch (this) {
            case INTEGER:
                return "int";
            case STRING:
                return "String";
            case LONG:
                return "long";
            case DOUBLE:
                return "double";
            case CHAR:
                return "char";
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }
}
