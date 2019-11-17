package cl.cehd.ocr.kata;

import cl.cehd.ocr.io.AccountNumberInput;

public class TestHelper {

    public static final String LINE_1_123456789_EXAMPLE = "    _  _     _  _  _  _  _ ";
    public static final String LINE_2_123456789_EXAMPLE = "  | _| _||_||_ |_   ||_||_|";
    public static final String LINE_3_123456789_EXAMPLE = "  ||_  _|  | _||_|  ||_| _|";

    public static AccountNumberInput digitDataForTestPurpose(){
        return new AccountNumberInput(LINE_1_123456789_EXAMPLE, LINE_2_123456789_EXAMPLE, LINE_3_123456789_EXAMPLE);
    }
}
