package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;
import ru.netology.product.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();

    String DME = "Домодедово";
    String EGO = "Белгород";
    String LED = "Пулково";
    String VKO = "Внуково";
    String ACP = "Астрахань";

    Ticket first = new Ticket(1, 6543, DME, EGO, 115);
    Ticket second = new Ticket(22, 2345, LED, ACP, 100);
    Ticket third = new Ticket(333, 3210, VKO, EGO, 110);
    Ticket fourth = new Ticket(44, 1234, DME, ACP, 95);
    Ticket fifth = new Ticket(55, 9890, VKO, ACP, 150);

    @Test
    public void findEmpty() {
        Ticket[] expected = {};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        Ticket[] expected = {first, second, third, fourth};
        assertArrayEquals(expected, repository.getAll());
    }

    @Test
    public void removeExistingTicketFromArray() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(2);
        });
    }

    @Test
    public void shouldSave() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        Ticket[] expected = {first, second, third, fourth, fifth};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTicketById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.removeById(22);
        Ticket[] expected = {first, third, fourth};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}