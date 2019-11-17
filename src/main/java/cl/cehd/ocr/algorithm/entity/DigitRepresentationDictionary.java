package cl.cehd.ocr.algorithm.entity;


import java.util.HashMap;
import java.util.Map;

public class DigitRepresentationDictionary {

    private   HashMap<AccountDigit, String> accountDigitsToStringMap = new HashMap<>();

    public Map<AccountDigit, String> createNumberFactory() {
        insertHarcodedData(accountDigitsToStringMap);
        return accountDigitsToStringMap;

    }

    public AccountDigit retrieveAccountDigitFromNumberRepresentation(String number)
    {
        insertHarcodedData(accountDigitsToStringMap);
        return accountDigitsToStringMap.entrySet().stream()
                .filter(e -> e.getValue().equals(number))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private void insertHarcodedData(HashMap<AccountDigit, String> accountDigitsToStringMap) {
        AccountDigit zero = new AccountDigit(" _ ", "| |", "|_|");
        accountDigitsToStringMap.put(zero, "0");
        AccountDigit one = new AccountDigit("   ", "  |", "  |");
        accountDigitsToStringMap.put(one, "1");
        AccountDigit two = new AccountDigit(" _ ", " _|", "|_ ");
        accountDigitsToStringMap.put(two, "2");
        AccountDigit three = new AccountDigit(" _ ", " _|", " _|");
        accountDigitsToStringMap.put(three, "3");
        AccountDigit four = new AccountDigit("   ", "|_|", "  |");
        accountDigitsToStringMap.put(four, "4");
        AccountDigit five = new AccountDigit(" _ ", "|_ ", " _|");
        accountDigitsToStringMap.put(five, "5");
        AccountDigit six = new AccountDigit(" _ ", "|_ ", "|_|");
        accountDigitsToStringMap.put(six, "6");
        AccountDigit seven = new AccountDigit(" _ ", "  |", "  |");
        accountDigitsToStringMap.put(seven, "7");
        AccountDigit eighth = new AccountDigit(" _ ", "|_|", "|_|");
        accountDigitsToStringMap.put(eighth, "8");
        AccountDigit nine = new AccountDigit(" _ ", "|_|", " _|");
        accountDigitsToStringMap.put(nine, "9");
    }

}
