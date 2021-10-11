package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.logic.flow.CreateMemberFlow;
import za.ac.nwu.as.translator.MemberTranslator;

import javax.transaction.Transactional;


@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.as.translator")
public class CreateMemberFlowImpl implements CreateMemberFlow {

    MemberTranslator memberTranslator;

    @Autowired
    public CreateMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDTO create(MemberDTO member) {

        return memberTranslator.create(member);
    }
}
