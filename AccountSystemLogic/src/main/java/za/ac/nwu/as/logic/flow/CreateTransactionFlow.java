package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTransactionDTO;

public interface CreateTransactionFlow {
    AccountTransactionDTO create(Integer memberID, String AccountTypeMnemonic, Long amount);
}
