package br.univille.projetoperformance.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import br.univille.projetoperformance.model.UserModel;
import br.univille.projetoperformance.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public User loadUserByUsername(String email) {
        UserModel user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        Collection<SimpleGrantedAuthority> listGrants = new ArrayList<>();
        listGrants.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(user.getEmail(), user.getPassword(), listGrants);
    }
}