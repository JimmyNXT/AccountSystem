package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A Data Transfer Object that represents the Account transaction.")
public class AccountTransactionDTO implements Serializable {

    private static final long serialVersionUID = -9166740859129560710L;
    
    private AccountTypeDTO accountType;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDTO() {
    }

    public AccountTransactionDTO(AccountTypeDTO accountType, Long amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDTO(AccountTransaction accountTransaction) {
        this.accountType = new AccountTypeDTO(accountTransaction.getAccountType());
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @ApiModelProperty(
            position = 1,
            value = "Transaction AccountType",
            name = "Account Type",
            dataType = "za.ac.nwu.as.domain.dto.AccountTypeDTO",
//            example = "Miles",
            required = true
    )

    public AccountTypeDTO getAccountType() {
        return accountType;
    }

    @ApiModelProperty(
            position = 2,
            value = "Transaction Amount",
            name = "amount",
            dataType = "java.lang.Long",
            example = "-100",
            required = true
    )
    public Long getAmount() {
        return amount;
    }

    @ApiModelProperty(
            position = 3,
            value = "Transaction Date",
            name = "Date",
            dataType = "java.time.LocalDat",
            example = "2021/10/01",
            required = true
    )
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setAccountType(AccountTypeDTO accountType) {
        this.accountType = accountType;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTransactionDTO)) return false;
        AccountTransactionDTO that = (AccountTransactionDTO) o;
        return Objects.equals(accountType, that.accountType) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDTO{" +
                "accountType=" + accountType +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
