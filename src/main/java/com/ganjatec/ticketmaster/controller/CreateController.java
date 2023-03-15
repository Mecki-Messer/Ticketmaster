package com.ganjatec.ticketmaster.controller;

import com.ganjatec.ticketmaster.dataclasses.Session;
import com.ganjatec.ticketmaster.dataclasses.TicketRepository;
import com.ganjatec.ticketmaster.formsubmission.Create;
import com.ganjatec.ticketmaster.dataclasses.Ticket;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateController {
    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/create")
    public String create(Model model, HttpSession session) {
        Session sessionData = (Session) session.getAttribute("data");
        if (!sessionData.isValidated()) {
            return "error";
        } else {

            model.addAttribute("create", new Create());
            return "create";
        }
    }

    @PostMapping("/create")
    public String createSubmit(@ModelAttribute Create create, HttpSession session, Model model) {
        Session sessionData = (Session) session.getAttribute("data");
        if (!sessionData.isValidated()) {
            return "error";
        } else {
            Ticket ticket = new Ticket();
            ticket.setUserID(sessionData.getLinkedUser());
            ticket.setHead(create.getHead());
            ticket.setBody(create.getBody());
            ticket.setStatus(0);
            ticketRepository.save(ticket);
            return "create_confirm";
        }
    }
}
