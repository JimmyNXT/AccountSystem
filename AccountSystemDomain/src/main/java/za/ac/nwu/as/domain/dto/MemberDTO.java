package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.Member;

import java.io.Serializable;
import java.util.*;

@ApiModel(value = "Member", description = "A Data Transfer Object that represents the Member.")
public class MemberDTO implements Serializable {

    private static final long serialVersionUID = 2190561030787378422L;

    private Integer ID = null;
    private String firstName;
    private String lastName;

    public MemberDTO() {
    }

    public MemberDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MemberDTO(Member member) {
        this.ID = member.getID();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
    }

    @ApiModelProperty(
            position = 1,
            value = "Member's Unique ID'",
            name = "ID",
            dataType = "java.lang.Integer",
            example = "1",
            required = true
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

    @JsonIgnore
    public Member getMember()
    {
        return new Member(this.firstName, this.lastName);
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberDTO)) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(ID, memberDTO.ID) && Objects.equals(firstName, memberDTO.firstName) && Objects.equals(lastName, memberDTO.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName);
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
