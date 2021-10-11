package za.ac.nwu.as.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTransactionDTO;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.repository.persistence.AccountTransactionRepository;
import za.ac.nwu.as.repository.persistence.AccountTypeRepository;
import za.ac.nwu.as.repository.persistence.MemberRepository;
import za.ac.nwu.as.translator.AccountTransactionTranslator;

import java.time.LocalDate;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;
    private final MemberRepository memberRepository;
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository, MemberRepository memberRepository, AccountTypeRepository accountTypeRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.memberRepository = memberRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTransaction) {
        try {
            Member member = memberRepository.getOne(accountTransaction.getMemberID());
            AccountType accountType = accountTypeRepository.getByMnemonic(accountTransaction.getAccountTypeMnemonic());
            return new AccountTransactionDTO(
                    accountTransactionRepository.save(
                            new AccountTransaction(accountType,
                                    member,
                                    accountTransaction.getAmount(),
                                    LocalDate.now()
                            )
                    )
            );
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
