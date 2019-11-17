package cl.cehd.ocr.algorithm.entity;

import java.util.Map;
import java.util.Optional;

public class IndividualDigitIdentifier {

    private final DigitRepresentationDictionary digitRepresentationDictionary;

    public IndividualDigitIdentifier(DigitRepresentationDictionary accountDigitRepresentationDictionary) {
        this.digitRepresentationDictionary = accountDigitRepresentationDictionary;
    }

    public String readDigitValue(AccountDigit accountDigit) {
        Map<AccountDigit, String> accountDigitToDigitMap = digitRepresentationDictionary.createNumberFactory();
        return Optional.ofNullable(accountDigitToDigitMap.get(accountDigit)).orElse("?");

    }
}
