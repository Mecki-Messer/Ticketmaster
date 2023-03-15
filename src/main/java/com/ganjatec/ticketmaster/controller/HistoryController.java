package com.ganjatec.ticketmaster.controller;

import com.ganjatec.ticketmaster.dataclasses.Session;
import com.ganjatec.ticketmaster.dataclasses.TicketRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {
    @Autowired
    TicketRepository ticketRepository;
    @GetMapping("/history")
    public String history(Model model, HttpSession session) {
        Session sessionData = (Session) session.getAttribute("data");
        if (!sessionData.isValidated()) {
            return "error";
        } else {
            model.addAttribute("tickets", ticketRepository.findByUserID(sessionData.getLinkedUser()));
            return "history";
        }
    }

}
