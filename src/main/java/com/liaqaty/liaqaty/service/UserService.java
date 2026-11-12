package com.liaqaty.liaqaty.service;

import com.liaqaty.liaqaty.entity.User;
import com.liaqaty.liaqaty.entity.Role;
import com.liaqaty.liaqaty.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        List<String> errors = new ArrayList<>();

        if (user.getAge() == null || user.getAge() < 10) {
            errors.add("Age cannot be less than 10!");
        }

        if (user.getWeight() == null || user.getWeight().compareTo(BigDecimal.ZERO) <= 0) {
            errors.add("Weight must be greater than zero!");
        }

        if (user.getHeight() == null || user.getHeight().doubleValue() <= 0) {
            errors.add("Height must be greater than zero!");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            errors.add("Email is already registered!");
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(" | ", errors));
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role("ROLE_USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}