package ua.com.reactive.reactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Role;
import ua.com.reactive.reactive.entity.RolesHasUsers;
import ua.com.reactive.reactive.entity.User;
import ua.com.reactive.reactive.repository.RoleRepository;
import ua.com.reactive.reactive.repository.RolesHasUsersRepository;
import ua.com.reactive.reactive.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RolesHasUsersRepository rolesHasUsersRepository;
    private final PasswordEncoder passwordEncoder;

    public Mono<User> register(String username, String rawPassword) {
        return roleRepository.findByName("ROLE_User")
                .switchIfEmpty(Mono.error(new IllegalStateException("ROLE_User not found")))
                .flatMap(role -> userRepository.findByUsername(username)
                        .flatMap(existing -> Mono.error(new IllegalArgumentException("Username already exists")))
                        .switchIfEmpty(Mono.defer(() -> {
                            User user = new User();
                            user.setUsername(username);
                            user.setPassword(passwordEncoder.encode(rawPassword));
                            return userRepository.save(user)
                                    .flatMap(saved -> linkRole(saved, role).thenReturn(saved));
                        }))
                        .cast(User.class)
                );
    }

    private Mono<Void> linkRole(User user, Role role) {
        RolesHasUsers link = new RolesHasUsers();
        link.setUser_id(user.getId());
        link.setRole_id(role.getId());
        return rolesHasUsersRepository.save(link).then();
    }
}


