package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_GOAL", schema = "HR")
public class MemberGoal implements Serializable {

    private Long ID;
    private Long ggoal;
    private Member member;
    private AccountType accountType;

    public MemberGoal() {
    }

    public MemberGoal(Long ID, Long ggoal, Member member, AccountType accountType) {
        this.ID = ID;
        this.ggoal = ggoal;
        this.member = member;
        this.accountType = accountType;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_GOAL_SEQ", sequenceName = "HR.MEMBER_GOAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
    @Column(name = "ID")
    public Long getID() {
        return ID;
    }

    @Column(name = "GOAL")
    public Long getGgoal() {
        return ggoal;
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

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setGgoal(Long ggoal) {
        this.ggoal = ggoal;
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
        return Objects.equals(ID, that.ID) && Objects.equals(ggoal, that.ggoal) && Objects.equals(member, that.member) && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, ggoal, member, accountType);
    }

    @Override
    public String toString() {
        return "MemberGoal{" +
                "ID=" + ID +
                ", ggoal=" + ggoal +
                ", member=" + member +
                ", accountType=" + accountType +
                '}';
    }
}
