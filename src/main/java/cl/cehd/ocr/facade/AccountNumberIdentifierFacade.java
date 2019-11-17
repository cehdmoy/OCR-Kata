package cl.cehd.ocr.facade;

import cl.cehd.ocr.algorithm.usecase.AccountNumberIdentifier;
import cl.cehd.ocr.io.AccountInputReader;
import cl.cehd.ocr.io.AccountNumberInput;
import cl.cehd.ocr.io.AccountNumberOut;

import java.util.List;
import java.util.stream.Collectors;

public class AccountNumberIdentifierFacade {

    private final AccountInputReader accountInputReader;
    private final AccountNumberIdentifier accountNumberIdentifier;

    public AccountNumberIdentifierFacade(AccountInputReader accountInputReader, AccountNumberIdentifier accountNumberIdentifier) {
        this.accountInputReader = accountInputReader;
        this.accountNumberIdentifier = accountNumberIdentifier;
    }

    public List<AccountNumberOut> processORCAccounts() {
        List<AccountNumberInput> accountNumberInputs = accountInputReader.readInputData();
        List<String> rawAccountsNumbers = getRawAccountNumbers(accountNumberInputs);
        return rawAccountsNumbers
                .stream()
                .map(AccountNumberOut::new)
                .collect(Collectors.toList());
    }

    private List<String> getRawAccountNumbers(List<AccountNumberInput> accountNumberInputs) {
        return accountNumberInputs
                .stream()
                .map(accountInput -> accountNumberIdentifier.identifyAccountNumber(accountInput.generateDigits()))
                .collect(Collectors.toList());
    }
}
