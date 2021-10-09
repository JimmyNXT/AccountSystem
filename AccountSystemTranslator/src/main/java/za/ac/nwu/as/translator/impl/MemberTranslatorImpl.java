package za.ac.nwu.as.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDTO;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.repository.persistence.MemberRepository;
import za.ac.nwu.as.translator.MemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {

    @Autowired
    private MemberRepository memberRepository;

    public MemberTranslatorImpl() {
    }

    public MemberTranslatorImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        try {
            Member member = memberRepository.save(memberDTO.getMember());
            return new MemberDTO(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> memberDTOS = new ArrayList<>();
        try {
            for (Member memberTDO : memberRepository.findAll()) {
                memberDTOS.add(new MemberDTO(memberTDO));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from Database",e);
        }
        return memberDTOS;
    }
}
