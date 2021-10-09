package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.MemberDTO;

import java.util.List;

public interface MemberTranslator {
    MemberDTO create(MemberDTO member);

    List<MemberDTO> getAllMembers();
}
