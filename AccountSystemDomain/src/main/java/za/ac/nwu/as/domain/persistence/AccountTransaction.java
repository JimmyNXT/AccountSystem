package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "account_transaction")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = -3644932884292748523L;

    private Integer ID;
    private AccountType accountType;
    private Member member;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Integer ID, AccountType accountType, Member member, Long amount, LocalDate transactionDate) {
        this.ID = ID;
        this.accountType = accountType;
        this.member = member;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTransaction)) return false;
        AccountTransaction that = (AccountTransaction) o;
        return ID.equals(that.ID) && accountType.equals(that.accountType) && member.equals(that.member) && amount.equals(that.amount) && transactionDate.equals(that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, accountType, member, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "ID=" + ID +
                ", accountType=" + accountType +
                ", member=" + member +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
