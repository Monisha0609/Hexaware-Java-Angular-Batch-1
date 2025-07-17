package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Authority must be "ROLE_EMPLOYER" or "ROLE_JOBSEEKER"
        String role = "ROLE_" + user.getRole();

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(role)));
    }

    @RequiredArgsConstructor
    private static class AppUserDetails implements UserDetails {
        private final User user;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
        }

        @Override public String getPassword() { return user.getPassword(); }

        @Override public String getUsername() { return user.getUsername(); }

        @Override public boolean isAccountNonExpired() { return true; }

        @Override public boolean isAccountNonLocked() { return true; }

        @Override public boolean isCredentialsNonExpired() { return true; }

        @Override public boolean isEnabled() { return true; }
    }
}
