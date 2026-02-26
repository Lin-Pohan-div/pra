package tw.spring09.pra.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.spring09.pra.entity.Member;

public interface MemberRepo extends JpaRepository<Member,Integer> {
    Optional<Member> findByEmail(String email);
}
