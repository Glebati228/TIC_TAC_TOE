package com.example.exampler.service;

import com.example.exampler.domain.Role;
import com.example.exampler.domain.User;
import com.example.exampler.repositories.UserRepo;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService
{
    @Value("${ex-link}")
    private String eLink;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailService mailService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        return userRepo.findByUsername(s);
    }

    public boolean AddUser(User user)
    {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb != null)
        {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);

        if(!StringUtils.isEmpty(user.getEmail()))
        {
            String emailTo = user.getEmail();
            String subject = "Activation code";
            String message = "Hello, " + user.getUsername() + "\n Your activation link:" + eLink + user.getActivationCode();
            mailService.send(emailTo, subject, message);
        }

        return true;
    }

    public boolean isActiveUser(String code)
    {
        User user = userRepo.findByActivationCode(code);
        if(user == null)
        {
           return false;
        }

        user.setActivationCode(null);
        userRepo.save(user);
        return true;
    }

    public boolean isUnicalMail(String email)
    {
        User user = userRepo.findByEmail(email);
        if(user != null)
        {
            return false;
        }

        return true;
    }
}
