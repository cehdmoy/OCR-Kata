package cl.cehd.ocr.algorithm.processor;

import cl.cehd.ocr.algorithm.entity.AccountDigit;
import cl.cehd.ocr.algorithm.entity.DigitRepresentationDictionary;
import cl.cehd.ocr.algorithm.entity.IndividualDigitIdentifier;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static cl.cehd.ocr.kata.TestHelper.digitDataForTestPurpose;
import static org.junit.Assert.assertEquals;

public class IndividualDigitIdentifierTest {

    private IndividualDigitIdentifier individualDigitIdentifier;
    private List<AccountDigit> individualDigitData;

    @Before
    public void setUp() {

        individualDigitData = digitDataForTestPurpose().generateDigits();
        DigitRepresentationDictionary digitRepresentationDictionary = new DigitRepresentationDictionary();
        individualDigitIdentifier = new IndividualDigitIdentifier(digitRepresentationDictionary);
    }

    @Test
    public void givenAZeroRepresentationMustReturnValueZero() {
        AccountDigit zero = new AccountDigit(" _ ", "| |", "|_|");
        String digitValue = individualDigitIdentifier.readDigitValue(zero);
        assertEquals("0", digitValue);
    }

    @Test
    public void givenAOneRepresentationMustReturnValueOne() {
        AccountDigit zeroRepresentation = individualDigitData.get(0);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("1", digitValue);
    }

    @Test
    public void givenATwoRepresentationMustReturnValueTwo() {
        AccountDigit zeroRepresentation = individualDigitData.get(1);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("2", digitValue);
    }

    @Test
    public void givenATwoRepresentationMustReturnValueThree() {
        AccountDigit zeroRepresentation = individualDigitData.get(2);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("3", digitValue);
    }

    @Test
    public void givenAFourRepresentationMustReturnValueFour() {
        AccountDigit zeroRepresentation = individualDigitData.get(3);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("4", digitValue);
    }


    @Test
    public void givenAFiveRepresentationMustReturnValueFive() {
        AccountDigit zeroRepresentation = individualDigitData.get(4);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("5", digitValue);
    }


    @Test
    public void givenASixRepresentationMustReturnValueSix() {
        AccountDigit zeroRepresentation = individualDigitData.get(5);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("6", digitValue);
    }

    @Test
    public void givenASixRepresentationMustReturnValueSeven() {
        AccountDigit zeroRepresentation = individualDigitData.get(6);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("7", digitValue);
    }

    @Test
    public void givenASixRepresentationMustReturnValueEight() {
        AccountDigit zeroRepresentation = individualDigitData.get(7);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("8", digitValue);
    }

    @Test
    public void givenASixRepresentationMustReturnValueNine() {
        AccountDigit zeroRepresentation = individualDigitData.get(8);
        String digitValue = individualDigitIdentifier.readDigitValue(zeroRepresentation);
        assertEquals("9", digitValue);
    }

    /*@Test(expected = UnsupportedOperationException.class)
    public void givenAnInvalidRepresentationMustReturnValueQuestion() {
        IndividualDigitData zeroRepresentation = new IndividualDigitData("", "", "");
        String digitValue = individualDigitProcessor.readDigitValue(zeroRepresentation);
        assertEquals("?", digitValue);
    }*/
}
