package za.ac.nwu.as.translator.impl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountBalanceDTO;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.domain.exception.DatabaseReadException;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.repository.persistence.AccountTransactionRepository;
import za.ac.nwu.as.repository.persistence.AccountTypeRepository;
import za.ac.nwu.as.repository.persistence.MemberRepository;
import za.ac.nwu.as.translator.MemberTranslator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemberTranslatorImpl implements MemberTranslator {


    private final MemberRepository memberRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final AccountTransactionRepository accountTransactionRepository;


    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository, AccountTypeRepository accountTypeRepository, AccountTransactionRepository accountTransactionRepository) {
        this.memberRepository = memberRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        try {
            Member member = memberRepository.save(memberDTO.getMember());
            return new MemberDTO(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> memberDTOS = new ArrayList<>();
        try {
            for (Member memberTDO : memberRepository.findAll()) {
                memberDTOS.add(new MemberDTO(memberTDO));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from Database",e);
        }
        return memberDTOS;
    }

    @Override
    public List<AccountBalanceDTO> getMemberBalances(Integer memberID) {
        try{
            List<AccountBalanceDTO> accountBalances = new ArrayList<>();

            Member member = memberRepository.getOne(memberID);
            List<AccountTransaction> accountTransactions = accountTransactionRepository.getBalancesByMemberID(member);
            System.out.println("Got them");

            for(AccountTransaction accountTransaction : accountTransactions){
                boolean hasBalance = false;
                System.out.println(accountBalances.size());
                for (int i = 0; i < accountBalances.size(); i++) {
                    AccountBalanceDTO tempAccountBalanceDTO = accountBalances.get(i);
                    if(tempAccountBalanceDTO.getAccountTypeID() == accountTransaction.getAccountType().getId()) {
                        hasBalance = true;
                        tempAccountBalanceDTO.setBalance(tempAccountBalanceDTO.getBalance() + accountTransaction.getAmount());
                        accountBalances.set(i, tempAccountBalanceDTO);
                    }
                }
                if(!hasBalance)
                {
                    accountBalances.add(new AccountBalanceDTO(accountTransaction.getAccountType().getId(), accountTransaction.getAmount()));
                }
            }
            return accountBalances;
        }catch (Exception e)
        {
            throw new DatabaseReadException("Could not read from database");
        }



    }
}
