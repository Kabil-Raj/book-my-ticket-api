package com.ticket.my.book.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.my.book.model.TicketBooked;

public interface TicketBookedRepository extends JpaRepository<TicketBooked, Integer>{

}
