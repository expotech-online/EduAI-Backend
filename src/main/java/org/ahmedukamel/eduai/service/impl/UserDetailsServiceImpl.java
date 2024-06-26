package org.ahmedukamel.eduai.service.impl;

import lombok.RequiredArgsConstructor;
import org.ahmedukamel.eduai.handler.UserNotFoundException;
import org.ahmedukamel.eduai.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.loadByUsernameOrEmailOrNid(username.strip())
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with username or email or nid %s not found."
                                .formatted(username)
                ));
    }
    public UserDetails getUserById(Integer userId) throws UsernameNotFoundException {
        return repository.findById(Long.valueOf(userId)).orElseThrow(()-> new UserNotFoundException("User Not Found with that id :"+ userId));
    }
}