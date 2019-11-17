package cl.cehd.ocr.algorithm.usecase;

import cl.cehd.ocr.algorithm.entity.AccountDigit;
import cl.cehd.ocr.algorithm.entity.IndividualDigitIdentifier;

import java.util.List;
import java.util.stream.Collectors;

public class AccountNumberIdentifier {

    private final IndividualDigitIdentifier individualDigitIdentifier;

    public AccountNumberIdentifier(IndividualDigitIdentifier individualDigitIdentifier) {
        this.individualDigitIdentifier = individualDigitIdentifier;
    }

    public String identifyAccountNumber(List<AccountDigit> accountDigits) {
        return accountDigits
                .stream()
                .map(individualDigitIdentifier::readDigitValue)
                .collect(Collectors.joining());
    }

}
