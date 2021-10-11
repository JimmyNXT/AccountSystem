package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Balance", description = "A Data Transfer Object that represents the Member's balance of an account type.")
public class AccountBalanceDTO implements Serializable {

    private static final long serialVersionUID = -7970875337531858827L;

    private Integer accountTypeID;
    private Long balance;

    public AccountBalanceDTO() {
    }

    public AccountBalanceDTO(Integer accountTypeID, Long balance) {
        this.accountTypeID = accountTypeID;
        this.balance = balance;
    }

    @ApiModelProperty(
            position = 1,
            value = "AccountTypeID",
            name = "Account Type ID",
            dataType = "java.lang.String",
            example = "1",
            required = true
    )
    public Integer getAccountTypeID() {
        return accountTypeID;
    }

    @ApiModelProperty(
            position = 2,
            value = "AccountBalance",
            name = "Account Balance",
            dataType = "java.lang.String",
            example = "100",
            required = true
    )
    public Long getBalance() {
        return balance;
    }

    public void setAccountTypeID(Integer accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void addToBalance(Long transactionAmount)
    {
        this.setBalance(this.getBalance()+ transactionAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountBalanceDTO)) return false;
        AccountBalanceDTO that = (AccountBalanceDTO) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, balance);
    }

    @Override
    public String toString() {
        return "AccountBalanceDTO{" +
                "accountTypeID=" + accountTypeID +
                ", balance=" + balance +
                '}';
    }
}
