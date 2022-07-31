package ru.netology.repository;

import ru.netology.product.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void removeById(int id) {
        Ticket draft_1 = findById(id);
        if (draft_1 == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Ticket[] tmp = new Ticket[items.length - 1];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void save(Ticket addTicket) {
        Ticket draft_2 = findById(addTicket.getId());
        if (draft_2 != null) {
            throw new AlreadyExistsException("Element with id: " + addTicket.getId() + " already exists");
        }
        Ticket[] tmp = new Ticket[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = addTicket;
        items = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Ticket[] getAll() {
        return items;
    }

}