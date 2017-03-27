package lv.javaguru.java2.utils;

import java.text.DecimalFormat;

/**
 * Created by Vijai3D on 26.03.2017.
 */
public class ValidateAndFormattInputDouble {
    public static Double convert(String s) {
String inputValue = "1.2";
        try {
            Double isDouble = Double.parseDouble(inputValue);

            DecimalFormat twoPlaces = new DecimalFormat("0.00");
            Double result = Double.valueOf(twoPlaces.format(isDouble));
            System.out.println(result);
            return result;
        } catch (NumberFormatException e) {
            System.out.println(inputValue + " is not a number");
            return null;
        }
// TODO its not working
    }
}
