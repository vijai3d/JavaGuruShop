package lv.javaguru.java2.utils;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public interface DecimalFormatUtil {
    BigDecimal format(String price);
}

@Component
class DecimalFormatUtilImpl implements DecimalFormatUtil{

    @Override
    public BigDecimal format(String price) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
        BigDecimal priceFormatted = null;
        try {
            priceFormatted = (BigDecimal) decimalFormat.parse(price);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return priceFormatted;
    }
}


