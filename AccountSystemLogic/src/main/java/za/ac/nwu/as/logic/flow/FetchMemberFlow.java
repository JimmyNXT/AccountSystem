package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountBalanceDTO;
import za.ac.nwu.as.domain.dto.MemberDTO;

import java.util.List;

public interface FetchMemberFlow {
    List<MemberDTO> getAllMembers();

    List<AccountBalanceDTO> getMemberBalances(Integer memberID);
}
