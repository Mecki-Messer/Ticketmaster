package com.ganjatec.ticketmaster.controller;

import com.ganjatec.ticketmaster.dataclasses.Hash;
import com.ganjatec.ticketmaster.dataclasses.HashRepository;
import com.ganjatec.ticketmaster.dataclasses.User;
import com.ganjatec.ticketmaster.dataclasses.UserRepository;
import com.ganjatec.ticketmaster.formsubmission.Register;
import com.ganjatec.ticketmaster.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HashRepository hashRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("register", new Register());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Register register, Model model) {
        Utilities ut = new Utilities();
        Hash hash = ut.hashPassword(register.getPass1());
        boolean validated = ut.validatePassword(register.getPass2(), hash);

        if (!validated) {
            return "failed";
        } else {

            hashRepository.save(hash);
            Hash insertedHash = hashRepository.findByHash(hash.getHash());
            Long hashID = insertedHash.getID();

            User user = new User();
            user.setUsername(register.getUsername());
            user.setDepartment(register.getDepartment());
            user.setMatrikelnr(register.getMatrikel());
            user.setPrivLevel(2); //Hardcoded to be standard user privs, priv elevation is handled by Admins on the DB itself. I know, ugly as hell, but gets the job done
            user.setHashID(hashID);

            userRepository.save(user);
        }

        return "redirect:login";
    }
}
