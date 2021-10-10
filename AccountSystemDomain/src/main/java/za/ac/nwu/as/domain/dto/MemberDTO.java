package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.domain.persistence.MemberGoal;

import java.io.Serializable;
import java.util.*;

@ApiModel(value = "Member", description = "A Data Transfer Object that represents the Member.")
public class MemberDTO implements Serializable {

    private static final long serialVersionUID = 2190561030787378422L;

    private Integer ID = null;
    private String firstName;
    private String lastName;
    private Set<MemberGoalDTO> memberGoals;
    private List<AccountBalanceDTO> accountBalances;


    public MemberDTO() {
    }

    public MemberDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberGoals = new HashSet<>();
        this.accountBalances = new ArrayList<>();
    }

    public MemberDTO(Member member) {
        this.ID = member.getID();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.memberGoals = new HashSet<>();
        this.accountBalances = new ArrayList<>();

        for(MemberGoal memberGoal : member.getMemberGoals()){
            this.memberGoals.add(new MemberGoalDTO(memberGoal));
        }

        for(AccountTransaction accountTransaction : member.getAccountTransactions()){
            boolean hasType = false;

            for (int i = 0; i < accountBalances.size(); i++) {
                AccountBalanceDTO tempAccountBalanceDTO = accountBalances.get(i);
                if(tempAccountBalanceDTO.getAccountType().equals(accountTransaction.getAccountType()))
                {
                    hasType = true;
                    tempAccountBalanceDTO.addToBalance(accountTransaction.getAmount());
                    accountBalances.set(i, tempAccountBalanceDTO);
                }
            }

            if(!hasType)
            {
                this.accountBalances.add(new AccountBalanceDTO(new AccountTypeDTO(accountTransaction.getAccountType()), accountTransaction.getAmount()));
            }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberDTO)) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(ID, memberDTO.ID) && Objects.equals(firstName, memberDTO.firstName) && Objects.equals(lastName, memberDTO.lastName) && Objects.equals(memberGoals, memberDTO.memberGoals) && Objects.equals(accountBalances, memberDTO.accountBalances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, memberGoals, accountBalances);
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", memberGoals=" + memberGoals +
                ", accountBalances=" + accountBalances +
                '}';
    }
}
