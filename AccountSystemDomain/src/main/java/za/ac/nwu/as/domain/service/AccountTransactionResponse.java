package za.ac.nwu.as.domain.service;

import za.ac.nwu.as.domain.dto.AccountTypeDTO;

public class AccountTransactionResponse extends GeneralResponse<AccountTypeDTO> {

    public AccountTransactionResponse(boolean successful, AccountTypeDTO payload) {
        super(successful, payload);
    }
}
