package com.staxoverflow.demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServices implements UserDetailsService {


    @Autowired
    private final UserAccountRepo repo;

    public UserAccountServices(UserAccountRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {
        return repo.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("Username does not exist."));
    }
}
