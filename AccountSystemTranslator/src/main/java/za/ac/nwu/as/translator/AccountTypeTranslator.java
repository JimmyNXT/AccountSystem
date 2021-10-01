package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountTypeDTO;

import java.util.List;

public interface AccountTypeTranslator {
    AccountTypeDTO create(AccountTypeDTO accountType);

    List<AccountTypeDTO> getAllAccountTypes();
}
