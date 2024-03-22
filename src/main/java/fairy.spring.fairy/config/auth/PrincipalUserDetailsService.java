package fairy.spring.fairy.config.auth;


import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PrincipalUserDetailsService implements UserDetailsService {

//    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//        Optional<User> optionalUser = userRepository.findByEmail(userid);
        Optional<User> optionalUser = Optional.empty();

        if (optionalUser.isEmpty()) {
            return null;
        }
        User user = optionalUser.get();
        return new PrincipalUserDetails(user);

    }

}
