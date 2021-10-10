package za.ac.nwu.as.domain.service;

import za.ac.nwu.as.domain.dto.MemberGoalDTO;

public class GoalResponse extends GeneralResponse<MemberGoalDTO> {

    public GoalResponse(MemberGoalDTO memberGoal) {
        super(true, memberGoal);
    }
}
