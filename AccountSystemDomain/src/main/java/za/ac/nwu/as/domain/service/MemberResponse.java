package za.ac.nwu.as.domain.service;

import za.ac.nwu.as.domain.dto.MemberDTO;

import java.util.List;

public class MemberResponse extends GeneralResponse<List<MemberDTO>>{

    public MemberResponse(List<MemberDTO> members) {
        super(true, members);
    }
}
