package za.ac.nwu.as.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.domain.persistence.MemberGoal;

import java.io.Serializable;

public class MemberGoalDTO implements Serializable {

    private static final long serialVersionUID = 5762831065901000768L;

    private Long goal;
    private AccountTypeDTO accountType;

    public MemberGoalDTO() {
    }

    public MemberGoalDTO(Long goal, AccountTypeDTO accountType) {
        this.goal = goal;
        this.accountType = accountType;
    }

    public MemberGoalDTO(MemberGoal memberGoal) {
        this.goal = memberGoal.getGoal();
        this.accountType = new AccountTypeDTO(memberGoal.getAccountType());
    }

    @ApiModelProperty(
            position = 1,
            value = "Member's Goal Value",
            name = "Value",
            dataType = "java.lang.Long",
            example = "1000",
            required = true
    )
    public Long getGoal() {
        return goal;
    }

    @ApiModelProperty(
            position = 2,
            value = "Account type of goal",
            name = "AccountType",
            dataType = "za.ac.nwu.as.domain.persistence.AccountTypeDTO",
//            example = "Pieter",
            required = true
    )
    public AccountTypeDTO getAccountType() {
        return accountType;
    }


}
