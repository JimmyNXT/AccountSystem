package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.domain.persistence.MemberGoal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ApiModel(value = "Member", description = "A Data Transfer Object that represents the Member.")
public class MemberDTO implements Serializable {

    private static final long serialVersionUID = 2190561030787378422L;

    private Integer ID = null;
    private String firstName;
    private String lastName;
    private Set<MemberGoalDTO> memberGoals;
    private Set<AccountTransactionDTO>  accountTransactions;


    public MemberDTO() {
    }

    public MemberDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MemberDTO(String firstName, String lastName, Set<MemberGoalDTO> memberGoals, Set<AccountTransactionDTO> accountTransactions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberGoals = memberGoals;
        this.accountTransactions = accountTransactions;
    }

    public MemberDTO(Member member) {
        this.ID = member.getID();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.memberGoals = new HashSet<>();
        this.accountTransactions = new HashSet<>();

        for(MemberGoal memberGoal : member.getMemberGoals()){
            this.memberGoals.add(new MemberGoalDTO(memberGoal));
        }

        for(AccountTransaction accountTransaction : member.getAccountTransactions()){
            this.accountTransactions.add(new AccountTransactionDTO(accountTransaction));
        }
    }

    @ApiModelProperty(
            position = 1,
            value = "Member's Unique ID'",
            name = "ID",
            dataType = "java.lang.Integer",
            example = "1",
            required = false
    )
    public Integer getID() {
        return ID;
    }

    @ApiModelProperty(
            position = 2,
            value = "Member First Name",
            name = "First Name",
            dataType = "java.lang.String",
            example = "Pieter",
            required = true
    )
    public String getFirstName() {
        return firstName;
    }

    @ApiModelProperty(
            position = 3,
            value = "Member Last Name",
            name = "Last Name",
            dataType = "java.lang.String",
            example = "Davidson",
            required = true
    )
    public String getLastName() {
        return lastName;
    }

    @ApiModelProperty(
            position = 4,
            value = "Member's goals",
            name = "Goals",
            dataType = "za.ac.nwu.as.domain.dto.MemberGoalDTO",
//            example = "Miles",
            required = false
    )
    public Set<MemberGoalDTO> getMemberGoals() {
        return memberGoals;
    }

    @ApiModelProperty(
            position = 5,
            value = "Member's Transactions",
            name = "Transactions",
            dataType = "za.ac.nwu.as.domain.dto.AccountTransactionDTO",
//            example = "Miles",
            required = false
    )
    public Set<AccountTransactionDTO> getAccountTransactions() {
        return accountTransactions;
    }

    @JsonIgnore
    public Member getMember()
    {
        return new Member(this.firstName, this.lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMemberGoals(Set<MemberGoalDTO> memberGoals) {
        this.memberGoals = memberGoals;
    }

    public void setAccountTransactions(Set<AccountTransactionDTO> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberDTO)) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(firstName, memberDTO.firstName) && Objects.equals(lastName, memberDTO.lastName) /*&& Objects.equals(memberGoals, memberDTO.memberGoals) && Objects.equals(accountTransactions, memberDTO.accountTransactions)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName/*, memberGoals, accountTransactions*/);
    }

    @Override
    public String toString() {
        return "MemberTDO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", memberGoals=" + memberGoals +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
