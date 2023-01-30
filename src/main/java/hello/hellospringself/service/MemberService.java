package hello.hellospringself.service;

import hello.hellospringself.domain.Member;
import hello.hellospringself.repository.MemberRepository;
import hello.hellospringself.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름의 중복 회원 X
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });

        memberRepository.save(member);
        return member.getId();

    }

}
