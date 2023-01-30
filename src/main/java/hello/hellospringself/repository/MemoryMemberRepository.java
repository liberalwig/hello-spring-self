package hello.hellospringself.repository;

import hello.hellospringself.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{

    public static Map<Long, Member> store = new HashMap<>(); //save 할 시
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // store.get(id) 하려다가 null 처리 위해 Optional 로 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) {
        store.values().stream()
                .filter(member -> member.getName().equals(name));
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

}
