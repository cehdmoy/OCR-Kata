package cl.cehd.ocr.algorithm.usecase;

import cl.cehd.ocr.algorithm.entity.DigitRepresentationDictionary;
import cl.cehd.ocr.algorithm.entity.IndividualDigitIdentifier;

public class AccountNumberIdentifierCreator {
    public AccountNumberIdentifier create() {
        DigitRepresentationDictionary digitRepresentationDictionary = new DigitRepresentationDictionary();
        IndividualDigitIdentifier individualDigitIdentifier = new IndividualDigitIdentifier(digitRepresentationDictionary);
        return new AccountNumberIdentifier(individualDigitIdentifier);
    }
}
