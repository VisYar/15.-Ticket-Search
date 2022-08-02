package ru.netology.manager;

import ru.netology.product.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll(String airportFrom, String airportTo) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (matches(ticket, airportFrom, airportTo)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String airportFrom, String airportTo) {

        if (ticket.getAirportFrom().contains(airportFrom)) {
            return ticket.getAirportTo().contains(airportTo);
        }

        return false;
    }

    public Ticket[] findAllOffers() {
        Ticket[] result = repository.getAll();
        Arrays.sort(result);
        return result;
    }
}