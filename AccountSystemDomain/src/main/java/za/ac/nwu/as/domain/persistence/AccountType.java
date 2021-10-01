package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "")
public class AccountType  implements Serializable {

    private static final long serialVersionUID = 3681456844239263069L;

    private long id;
    private String mnemonic;
    private String name;
    private LocalDate creationDate;
    private Set<AccountTransaction> accountTransactions;
    private Set<MemberGoal> memberGoals;

    public AccountType() {
    }

    public AccountType(long id, String mnemonic, String name, LocalDate creationDate) {
        this.id = id;
        this.mnemonic = mnemonic;
        this.name = name;
        this.creationDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "", sequenceName = "", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    @OneToMany(targetEntity = MemberGoal.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<MemberGoal> getMemberGoals() {
        return memberGoals;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountType)) return false;
        AccountType that = (AccountType) o;
        return id == that.id && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mnemonic, name, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "id=" + id +
                ", mnemonic='" + mnemonic + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

