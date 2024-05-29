package com.sebastien.jobboard.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sebastien.jobboard.roleName;
import com.sebastien.jobboard.entity.Role;
import com.sebastien.jobboard.entity.User;
import com.sebastien.jobboard.repository.UserRepository;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public void register(User user) {
        if(user.getEmail().indexOf("@") == -1) {
            throw new RuntimeException("Email invalide");
        }
        if(!user.getEmail().contains(".")) {
            throw new RuntimeException("Email invalide");
        }
        String CryptedPwd = this.passwordEncoder.encode(user.getPassword());

        user.setPassword(CryptedPwd);

        Role  roleUser = new Role();
        roleUser.setNom_du_role(roleName.USER);
        user.setRole(roleUser);


        user = this.userRepo.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
