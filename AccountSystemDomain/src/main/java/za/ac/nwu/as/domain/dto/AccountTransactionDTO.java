package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A Data Transfer Object that represents the Account transaction.")
public class AccountTransactionDTO implements Serializable {

    private static final long serialVersionUID = -9166740859129560710L;

    private Integer memberID;
    private String accountTypeMnemonic;
    private Long amount;

    public AccountTransactionDTO() {
    }

    public AccountTransactionDTO(Integer memberID, String accountTypeMnemonic, Long amount) {
        this.memberID = memberID;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.amount = amount;
    }

    public AccountTransactionDTO(AccountTransaction accountTransaction) {
        this.memberID = accountTransaction.getMember().getID();
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.amount = accountTransaction.getAmount();
    }

    @ApiModelProperty(
            position = 1,
            value = "Transaction Member ID",
            name = "MemberID",
            dataType = "java.lang.Long",
            example = "1",
            required = true
    )

    public Integer getMemberID() {
        return memberID;
    }

    @ApiModelProperty(
            position = 3,
            value = "Transaction AccountType",
            name = "Account Type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true
    )
    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    @ApiModelProperty(
            position = 4,
            value = "Transaction Amount",
            name = "amount",
            dataType = "java.lang.Long",
            example = "-100",
            required = true
    )
    public Long getAmount() {
        return amount;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    //    @JsonIgnore
//    public AccountTransaction getAccountTransaction()
//    {
//        return new AccountTransaction(
//                new AccountType(this.accountType.getMnemonic(), this.accountType.getName()),
//                new Member(this.member.getFirstName(), this.member.getLastName()),
//                this.getAmount(),
//                LocalDate.now()
//        );
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTransactionDTO)) return false;
        AccountTransactionDTO that = (AccountTransactionDTO) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, accountTypeMnemonic, amount);
    }

    @Override
    public String toString() {
        return "AccountTransactionDTO{" +
                "memberID=" + memberID +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", amount=" + amount +
                '}';
    }
}
