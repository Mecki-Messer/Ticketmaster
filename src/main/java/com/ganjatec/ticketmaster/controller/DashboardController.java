package com.ganjatec.ticketmaster.controller;

import com.ganjatec.ticketmaster.dataclasses.Session;
import com.ganjatec.ticketmaster.dataclasses.Ticket;
import com.ganjatec.ticketmaster.dataclasses.TicketRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){

        Session sessionData = (Session) session.getAttribute("data");
        if(!sessionData.isValidated())  {
            return "error";

        } else {
            List<Ticket> tickets = ticketRepository.findByUserID(sessionData.getLinkedUser());
            model.addAttribute("tickets", tickets);
            return "dashboard";
        }
    }
}
