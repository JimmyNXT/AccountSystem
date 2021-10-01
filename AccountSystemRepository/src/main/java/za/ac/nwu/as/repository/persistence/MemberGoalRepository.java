package za.ac.nwu.as.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistence.MemberGoal;

public interface MemberGoalRepository extends JpaRepository<MemberGoal, Long> {
}
