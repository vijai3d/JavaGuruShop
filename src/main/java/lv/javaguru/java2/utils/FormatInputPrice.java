package lv.javaguru.java2.utils;

import java.text.DecimalFormat;

/**
 * Created by Vijai3D on 26.03.2017.
 */
public class FormatInputPrice {

    public static String format(String userInput) {
        //String result;
        userInput = userInput.replaceAll(",",".");
        if(isDouble(userInput)) {
            DecimalFormat twoPlaces = new DecimalFormat("0.00");
            String result = twoPlaces.format(Double.valueOf(userInput));
            System.out.println(result);
            return result;
        }
        System.out.println(userInput + " it is not valid input");
        return null;
    }

    private static Boolean isDouble(String tempString) {
        try {
            Double.parseDouble(tempString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
