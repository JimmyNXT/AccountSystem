package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountBalanceDTO;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.logic.flow.FetchMemberFlow;
import za.ac.nwu.as.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.as.translator")
public class FetchMemberFlowImpl implements FetchMemberFlow {

    MemberTranslator memberTranslator;

    @Autowired
    public FetchMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        return memberTranslator.getAllMembers();
    }

    @Override
    public List<AccountBalanceDTO> getMemberBalances(Integer memberID) {
        return memberTranslator.getMemberBalances(memberID);
    }
}
