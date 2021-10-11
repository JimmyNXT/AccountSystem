package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountTransactionDTO;

public interface AccountTransactionTranslator {
    AccountTransactionDTO create(AccountTransactionDTO accountTransaction);
}
