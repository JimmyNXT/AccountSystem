package za.ac.nwu.as.translator.impl;

import javafx.util.converter.LocalDateStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTypeDTO;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.repository.persistence.AccountTypeRepository;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Component
public class AccountTypeTranslationImpl implements AccountTypeTranslator {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    public AccountTypeTranslationImpl() {
    }

    public AccountTypeTranslationImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public AccountTypeRepository getAccountTypeRepository() {
        return accountTypeRepository;
    }

    public void setAccountTypeRepository(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes(){
        List<AccountTypeDTO> accountTypeDTOs = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDTOs.add(new AccountTypeDTO(accountType));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from Database",e);
        }
        return accountTypeDTOs;
    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountTypeDTO){
        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDTO.getAccountType());
            return new AccountTypeDTO(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
