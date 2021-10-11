package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTransactionDTO;
import za.ac.nwu.as.logic.flow.CreateTransactionFlow;
import za.ac.nwu.as.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.as.translator")
public class CreateTransactionFlowImpl implements CreateTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public CreateTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTransaction) {

        return accountTransactionTranslator.create(accountTransaction);
    }
}
