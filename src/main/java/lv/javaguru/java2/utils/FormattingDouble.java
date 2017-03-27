package lv.javaguru.java2.utils;

import java.text.DecimalFormat;

/**
 * Created by Vijai3D on 26.03.2017.
 */
public class FormattingDouble {
    public static Double convert(Double p) {
        DecimalFormat df = new DecimalFormat("0.##");
        return Double.valueOf(df.format(p));
    }
}
