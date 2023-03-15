package com.ganjatec.ticketmaster.controller;

import com.ganjatec.ticketmaster.formsubmission.Login;
import com.ganjatec.ticketmaster.dataclasses.HashRepository;
import com.ganjatec.ticketmaster.dataclasses.UserRepository;
import com.ganjatec.ticketmaster.dataclasses.User;
import com.ganjatec.ticketmaster.dataclasses.Session;
import com.ganjatec.ticketmaster.utils.Utilities;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    HashRepository hashRepository;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin(@ModelAttribute Login login, HttpSession session, Model model) {
        Utilities ut = new Utilities();
        User user = userRepository.findByUsername(login.getUsername());

        boolean validated = ut.validatePassword(login.getPassword(), hashRepository.findByID(user.getHashID()));
        if(validated){

            Session sess = new Session();
            sess.setUuid(session.getId());
            sess.setValidated(true);
            sess.setLinkedUser(user.getID());
            sess.setTimeout(0);

            session.setAttribute("data", sess);
            return "redirect:dashboard";
        }
        else {
            Session sess = new Session();
            sess.setValidated(false);
            session.invalidate();
        }
        return "redirect:error";

    }
}
