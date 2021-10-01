package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTypeDTO;

public interface CreateAccountTypeFlow {
    AccountTypeDTO create(AccountTypeDTO accountType);
}
