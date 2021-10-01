package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER", schema = "")
public class Member implements Serializable {

    private static final long serialVersionUID = -4651200715713084503L;

    private Long ID;
    private String firstName;
    private String lastName;
    private Set<MemberGoal> memberGoals;
    private Set<AccountTransaction>  accountTransactions;

    public Member() {
    }

    public Member(Long ID, String firstName, String lastName, Set<MemberGoal> memberGoals, Set<AccountTransaction> accountTransactions) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberGoals = memberGoals;
        this.accountTransactions = accountTransactions;
    }

    @Id
    @SequenceGenerator(name = "", sequenceName = "", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
    @Column(name = "ID")
    public Long getID() {
        return ID;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @OneToMany(targetEntity = MemberGoal.class, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<MemberGoal> getMemberGoals() {
        return memberGoals;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMemberGoals(Set<MemberGoal> memberGoals) {
        this.memberGoals = memberGoals;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(ID, member.ID) && Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(memberGoals, member.memberGoals) && Objects.equals(accountTransactions, member.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, memberGoals, accountTransactions);
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", memberGoals=" + memberGoals +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
