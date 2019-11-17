package cl.cehd.ocr.algorithm.entity.data;

import cl.cehd.ocr.algorithm.entity.AccountDigit;
import cl.cehd.ocr.io.AccountNumberInput;
import cl.cehd.ocr.io.MalFormattedOCRInput;
import org.junit.Test;

import java.util.List;

import static cl.cehd.ocr.kata.TestHelper.*;
import static cl.cehd.ocr.kata.TestHelper.digitDataForTestPurpose;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountNumberInputTest {


    private static final String SKIP_LINE = "\n";

    @Test(expected = MalFormattedOCRInput.class)
    public void isClassThere() {
        AccountNumberInput accountNumberInput = new AccountNumberInput("line 1", "lin2 2", "line 3");
        assertNotNull(accountNumberInput);
    }

    @Test
    public void checkDataIsRight() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        String x = accountNumberInput.recreateAccountNumber();
        String expected = LINE_1_123456789_EXAMPLE + SKIP_LINE + LINE_2_123456789_EXAMPLE + SKIP_LINE + LINE_3_123456789_EXAMPLE;
        assertEquals(expected, x);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexZero() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(0).recreateNumber();
        assertEquals("   \n" +
                "  |\n" +
                "  |", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexOne() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(1).recreateNumber();
        assertEquals(" _ \n" +
                " _|\n" +
                "|_ ", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexTwo() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(2).recreateNumber();
        assertEquals(" _ \n" +
                " _|\n" +
                " _|", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexThree() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(3).recreateNumber();
        assertEquals("   \n" +
                "|_|\n" +
                "  |", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexFour() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(4).recreateNumber();
        assertEquals(" _ \n" +
                "|_ \n" +
                " _|", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexFive() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(5).recreateNumber();
        assertEquals(" _ \n" +
                "|_ \n" +
                "|_|", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexSix() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(6).recreateNumber();
        assertEquals(" _ \n" +
                "  |\n" +
                "  |", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexSeven() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(7).recreateNumber();
        assertEquals(" _ \n" +
                "|_|\n" +
                "|_|", s);
    }

    @Test
    public void checkGenerateIndividualDigitCheckIndexEight() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> one = accountNumberInput.generateDigits();
        String s = one.get(8).recreateNumber();
        assertEquals(" _ \n" +
                "|_|\n" +
                " _|", s);
    }

    @Test
    public void checkListIndividualDigitSize() {
        AccountNumberInput accountNumberInput =digitDataForTestPurpose();
        List<AccountDigit> individualDigits = accountNumberInput.generateDigits();
        assertEquals(9, individualDigits.size());
    }
}
