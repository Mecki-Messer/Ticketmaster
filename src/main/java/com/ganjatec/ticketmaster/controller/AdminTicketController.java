package com.ganjatec.ticketmaster.controller;

import com.ganjatec.ticketmaster.dataclasses.Session;
import com.ganjatec.ticketmaster.dataclasses.TicketRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminTicketController {
    @Autowired
    TicketRepository ticketRepository;
    @GetMapping("/admin_tickets")
    public String status(Model model, HttpSession session) {
        Session sessionData = (Session) session.getAttribute("data");
        if (!sessionData.isValidated()) {
            return "error";
        } else {
            model.addAttribute("tickets", ticketRepository.findByStatus(0));
            return "admin_tickets";
        }
    }
}
