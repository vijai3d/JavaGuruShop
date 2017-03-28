package lv.javaguru.java2.utils;

import java.text.DecimalFormat;

/**
 * Created by Vijai3D on 26.03.2017.
 */
public class ValidateAndFormatInputDouble {

    public static String validate(String userInput) {
        String result = null;
        try {
            Double isDouble = Double.parseDouble(userInput);
            DecimalFormat twoPlaces = new DecimalFormat("0.00");
            result = twoPlaces.format(isDouble);
        } catch (NumberFormatException e) {
            System.out.println(userInput + " is not valid input!");
        }
        return result;
    }
}
