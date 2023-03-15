package com.ganjatec.ticketmaster.dataclasses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findByUserID(long userID);
    List<Ticket> findByUserIDAndStatus(long userID, int status);

    List<Ticket> findByStatus(int status);
}
