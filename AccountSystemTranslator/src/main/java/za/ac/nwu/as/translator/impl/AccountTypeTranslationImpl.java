package za.ac.nwu.as.translator.impl;

import javafx.util.converter.LocalDateStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTypeDTO;
import za.ac.nwu.as.domain.exception.DatabaseReadException;
import za.ac.nwu.as.domain.exception.DatabaseWriteException;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.repository.persistence.AccountTypeRepository;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Component
public class AccountTypeTranslationImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslationImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public AccountTypeRepository getAccountTypeRepository() {
        return accountTypeRepository;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes(){
        List<AccountTypeDTO> accountTypeDTOs = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDTOs.add(new AccountTypeDTO(accountType));
            }
        }catch (Exception e){
            throw new DatabaseReadException("Unable to read from Database");
        }
        return accountTypeDTOs;
    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountTypeDTO){
        try {
            AccountType tempAccountType = accountTypeDTO.getAccountType();
            tempAccountType.setCreationDate(LocalDate.now());
            AccountType accountType = accountTypeRepository.save(tempAccountType);
            return new AccountTypeDTO(accountType);
        }catch (Exception e){
            throw new DatabaseWriteException("Unable to save to the DB");
        }
    }
}
