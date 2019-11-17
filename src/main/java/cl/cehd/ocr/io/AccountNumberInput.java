package cl.cehd.ocr.io;

import cl.cehd.ocr.algorithm.entity.AccountDigit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountNumberInput {
    private final String line1;
    private final String line2;
    private final String line3;

    public AccountNumberInput(String line1, String line2, String line3) {
        int limit = 27;
        int length = line1.length();
        int length1 = line2.length();
        int length2 = line3.length();
        if (length != limit || length1 != limit || length2 != limit)
            throw new MalFormattedOCRInput();
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    public String recreateAccountNumber() {
        return line1 + "\n" + line2 + "\n" + line3;
    }

    public List<AccountDigit> generateDigits() {
        return IntStream
                .range(0, 9)
                .mapToObj(i -> getAccountDigit(i * 3))
                .collect(Collectors.toList());

    }

    private AccountDigit getAccountDigit(int beginIndex) {
        String currentLine1 = line1.substring(beginIndex, beginIndex+3);
        String currentLine2 = line2.substring(beginIndex, beginIndex+3);
        String currentLine3 = line3.substring(beginIndex, beginIndex+3);
        return new AccountDigit(currentLine1, currentLine2, currentLine3);
    }
}
