package id.ac.polban.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class FormatUtil {
    private static final DecimalFormat RUPIAH_FORMAT;
    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        RUPIAH_FORMAT = new DecimalFormat("#,##0", symbols);
    }

    private FormatUtil() {}

    public static String rupiah(long nilai) {
        return "Rp" + RUPIAH_FORMAT.format(nilai);
    }
}
