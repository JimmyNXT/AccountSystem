package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTypeDTO;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDTO> getAllAccountTypes();
}
