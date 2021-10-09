package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "member_goal")
public class MemberGoal implements Serializable {

    private Integer ID;
    private Long goal;
    private Member member;
    private AccountType accountType;

    public MemberGoal() {
    }

    public MemberGoal(Integer ID, Long goal, Member member, AccountType accountType) {
        this.ID = ID;
        this.goal = goal;
        this.member = member;
        this.accountType = accountType;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    public Integer getID() {
        return ID;
    }

    @Column(name = "GOAL")
    public Long getGoal() {
        return goal;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member_ID")
    public Member getMember() {
        return member;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setGoal(Long goal) {
        this.goal = goal;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberGoal)) return false;
        MemberGoal that = (MemberGoal) o;
        return Objects.equals(ID, that.ID) && Objects.equals(goal, that.goal) && Objects.equals(member, that.member) && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, goal, member, accountType);
    }

    @Override
    public String toString() {
        return "MemberGoal{" +
                "ID=" + ID +
                ", ggoal=" + goal +
                ", member=" + member +
                ", accountType=" + accountType +
                '}';
    }
}
