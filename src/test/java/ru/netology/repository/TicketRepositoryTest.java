package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.product.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {
    static TicketRepository repository = new TicketRepository();

    private static final String DME = "Домодедово";
    private static final String EGO = "Белгород";
    private static final String LED = "Пулково";
    private static final String VKO = "Внуково";
    private static final String ACP = "Астрахань";

    private static Ticket first = new Ticket(1, 6543, DME, EGO, 115);
    private static Ticket second = new Ticket(2, 2345, LED, ACP, 100);
    private static Ticket third = new Ticket(3, 3210, VKO, EGO, 110);
    private static Ticket fourth = new Ticket(4, 1234, DME, ACP, 95);
    private static Ticket fifth = new Ticket(5, 9890, VKO, ACP, 150);

    @BeforeAll
    static void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    public void findAll() {
        Ticket[] expected = {first, second, third, fourth};
        assertArrayEquals(expected, repository.getAll());
    }

    @Test
    public void shouldSave() {
        repository.save(fifth);
        Ticket[] expected = {first, second, third, fourth, fifth};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeOfferById() {
        repository.removeById(2);
        Ticket[] expected = {first, third, fourth, fifth};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}