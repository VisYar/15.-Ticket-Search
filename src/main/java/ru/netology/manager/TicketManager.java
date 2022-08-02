package ru.netology.manager;

import ru.netology.product.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAllOffers() {
        Ticket[] result = repository.getAll();
        Arrays.sort(result);
        return result;
    }

    Comparator<Ticket> ticketComparator = Comparator.comparingInt(Ticket::getTime);

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];
            if (ticket.getAirportFrom().equals(from) && ticket.getAirportTo().equals(to)) {
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, ticketComparator);
        return result;
    }
}
