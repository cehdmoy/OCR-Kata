package cl.cehd.ocr.facade;

import cl.cehd.ocr.algorithm.usecase.AccountNumberIdentifierCreator;
import cl.cehd.ocr.io.AccountInputReaderTestImp;
import cl.cehd.ocr.io.AccountNumberOut;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountNumberIdentifierFacadeTest {

    private AccountNumberIdentifierFacade accountNumberIdentifierFacade;

    @Before
    public void setUp() {
        AccountInputReaderTestImp accountInputReaderTestImp = new AccountInputReaderTestImp();
        AccountNumberIdentifierCreator accountNumberIdentifierCreator = new AccountNumberIdentifierCreator();
        accountNumberIdentifierFacade = new AccountNumberIdentifierFacade(accountInputReaderTestImp, accountNumberIdentifierCreator.create());
    }

    @Test
    public void integrationCataUseCase1() {
        final List<AccountNumberOut> accountNumberOuts = accountNumberIdentifierFacade.processORCAccounts();
        assertNotNull(accountNumberOuts);
        assertEquals("000000000",accountNumberOuts.get(0).getAccountNumber());
        assertEquals("345882865",accountNumberOuts.get(1).getAccountNumber());
        assertEquals("49006771?",accountNumberOuts.get(2).getAccountNumber());
        assertEquals("664371495",accountNumberOuts.get(3).getAccountNumber());
    }
}