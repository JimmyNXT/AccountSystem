package za.ac.nwu.as.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
    @Query(value =
            "SELECT " +
            "at " +
            "FROM " +
            "AccountType " +
            "at " +
            "WHERE at.mnemonic = :accountTypeMnemonic ")
    AccountType getByMnemonic(String accountTypeMnemonic);
}
