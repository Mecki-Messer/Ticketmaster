package com.ganjatec.ticketmaster.controller;

import com.ganjatec.ticketmaster.dataclasses.Session;
import com.ganjatec.ticketmaster.dataclasses.User;
import com.ganjatec.ticketmaster.dataclasses.TicketRepository;
import com.ganjatec.ticketmaster.dataclasses.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class AdminController{
        @Autowired
        TicketRepository ticketRepository;
        @Autowired
        UserRepository userRepository;

        @GetMapping("/admin")
        public String status(Model model, HttpSession session) {
            Session sessionData = (Session) session.getAttribute("data");
            User user = userRepository.findByID(sessionData.getLinkedUser());
            if (!sessionData.isValidated()) {
                return "error";
            } else if(user.getPrivLevel() != 0){
                return "error";
            } else {
                return "admin";
            }
        }
    }


