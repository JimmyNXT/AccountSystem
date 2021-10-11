package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "account_type")
public class AccountType  implements Serializable {

    private static final long serialVersionUID = 3681456844239263069L;

    private Integer id;
    private String mnemonic;
    private String name;
    private LocalDate creationDate;
    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Integer id, String mnemonic, String name, LocalDate creationDate) {
        this.id = id;
        this.mnemonic = mnemonic;
        this.name = name;
        this.creationDate = creationDate;
    }

    public AccountType(String mnemonic, String name, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.name = name;
        this.creationDate = creationDate;
    }

    public AccountType(String mnemonic, String name) {
        this.mnemonic = mnemonic;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getId() {
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


    public void setId(Integer id) {
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
        return Objects.equals(id, that.id) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate) && Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mnemonic, name, creationDate, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "id=" + id +
                ", mnemonic='" + mnemonic + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}

