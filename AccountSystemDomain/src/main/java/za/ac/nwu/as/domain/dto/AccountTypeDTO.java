package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A Data Transfer Object that represents the Account Type.")
public class AccountTypeDTO implements Serializable {

    private static final long serialVersionUID = -7266955643970667441L;

    private String mnemonic;
    private String name;
    private LocalDate creationDate;

    public AccountTypeDTO() {
    }

    public AccountTypeDTO(String mnemonic, String name, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.name = name;
        this.creationDate = creationDate;
    }

    public AccountTypeDTO(AccountType accountType) {
        this.mnemonic = accountType.getMnemonic();
        this.name = accountType.getName();
        this.creationDate = accountType.getCreationDate();
    }

    @ApiModelProperty(
            position = 1,
            value = "Account type Mnemonic",
            name = "Mnemonic",
            dataType = "java.lang.String",
            example = "Miles",
            required = true
    )
    public String getMnemonic() {
        return mnemonic;
    }

    @ApiModelProperty(
            position = 2,
            value = "Account type Name",
            name = "Name",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true
    )
    public String getName() {
        return name;
    }

    @ApiModelProperty(
            position = 3,
            value = "Account type Creation Date",
            name = "CreationDate",
            notes = "The date on which the Account type was created",
            dataType = "java.time.LocalDate",
            example = "2020/01/01",
            allowEmptyValue = true,
            required = false
    )
    public LocalDate getCreationDate() {
        return creationDate;
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

    @JsonIgnore
    public AccountType getAccountType()
    {
        return new AccountType(this.getMnemonic(), this.getName(), this.getCreationDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTypeDTO)) return false;
        AccountTypeDTO that = (AccountTypeDTO) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, name, creationDate);
    }



    @Override
    public String toString() {
        return "AccountTypeDTO{" +
                "mnemonic=" + mnemonic +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
