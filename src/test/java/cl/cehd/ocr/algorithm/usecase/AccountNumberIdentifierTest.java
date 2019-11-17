package cl.cehd.ocr.algorithm.usecase;

import cl.cehd.ocr.algorithm.entity.AccountDigit;
import cl.cehd.ocr.algorithm.entity.DigitRepresentationDictionary;
import cl.cehd.ocr.algorithm.entity.IndividualDigitIdentifier;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountNumberIdentifierTest {

    private AccountNumberIdentifier accountNumberIdentifier;
    private DigitRepresentationDictionary digitRepresentationDictionary;

    @Before
    public void setUp() {
        digitRepresentationDictionary = new DigitRepresentationDictionary();
        IndividualDigitIdentifier individualDigitIdentifier = new IndividualDigitIdentifier(digitRepresentationDictionary);
        accountNumberIdentifier= new AccountNumberIdentifier(individualDigitIdentifier);

    }

    @Test
    public void checkAccount0000000() {
        List<AccountDigit> l = new ArrayList<>();
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        l.add(digitRepresentationDictionary.retrieveAccountDigitFromNumberRepresentation("0"));
        String response = accountNumberIdentifier.identifyAccountNumber(l);
        assertEquals("000000000",response);
    }
}