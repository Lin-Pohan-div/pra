package tw.spring09.pra.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tw.spring09.pra.Repo.MemberRepo;
import tw.spring09.pra.entity.Member;

public class MemberService implements UserDetailsService {
    @Autowired
    private MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException{
        Member member = memberRepo.findByEmail(username).orElse(null);
        if (member == null) throw new UsernameNotFoundException("Email NOT FOUND");

        return User.builder().username(member.getEmail())
        .password(member.getPassword()).roles(member.getRole()).build();

    }
}
