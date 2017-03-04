package utils;

/**
 * Created by Vijai3D on 04.03.2017.
 */
public class DoubleInputValidate {
    public static boolean isDoubleInput(String input) {
        if( input == null ) return false;
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
