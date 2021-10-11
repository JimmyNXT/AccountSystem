package za.ac.nwu.as.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.domain.persistence.Member;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Integer> {
    @Query(value =
            "SELECT " +
                    "at " +
                    "FROM " +
                    "AccountTransaction " +
                    "at " +
                    "WHERE "+
                    "at.member = :member ")
    List<AccountTransaction> getBalancesByMemberID(Member member);
}
