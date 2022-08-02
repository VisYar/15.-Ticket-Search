package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.product.Ticket;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    static TicketRepository repository = new TicketRepository();
    static TicketManager manager = new TicketManager(repository);

    private static final String DME = "Домодедово";
    private static final String EGO = "Белгород";
    private static final String LED = "Пулково";
    private static final String VKO = "Внуково";
    private static final String ACP = "Астрахань";
    private static final String SIP = "Симферополь";
    private static final String BKA = "Быково";

    private static Ticket first = new Ticket(1, 6543, DME, SIP, 115);
    private static Ticket second = new Ticket(2, 2345, LED, ACP, 100);
    private static Ticket third = new Ticket(3, 3210, VKO, EGO, 110);
    private static Ticket fourth = new Ticket(4, 1234, DME, LED, 95);
    private static Ticket fifth = new Ticket(5, 9890, BKA, ACP, 150);
    private static Ticket sixth = new Ticket(6, 4890, EGO, LED, 130);
    private static Ticket seventh = new Ticket(7, 2340, LED, ACP, 100);

    @BeforeAll
    static void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    public void findOffer() {
        Ticket[] expected = new Ticket[]{second, seventh};
        assertArrayEquals(expected, manager.findAll("Пулково", "Астрахань", Ticket::compareTo));
    }

    @Test
    public void showAllOffers() {
        Ticket[] expected = new Ticket[]{fourth, second, third, sixth, first, fifth};
        assertArrayEquals(expected, manager.findAllOffers());
    }

    @Test
    void searchBy() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("", "", Ticket::compareTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addNotExistingTicket() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(7);
        });
    }

    @Test
    public void addExistingTicket() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.save(first);
        });
    }

    @Test
    void searchByFrom() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("Пулково", "", Ticket::compareTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByFromOf() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("<Быково>", "Симферополь", Ticket::compareTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByOf() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("", "Симферополь", Ticket::compareTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByOfFrom() {
        Ticket[] expected = new Ticket[]{fifth};
        Ticket[] actual = manager.findAll("Быково", "Астрахань", Ticket::compareTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNot() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("Быково", "Пулково", Ticket::compareTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAll() {
        repository.save(seventh);
        Ticket[] expected = new Ticket[]{second, seventh};
        Ticket[] actual = manager.findAll("Пулково", "Астрахань", Ticket::compareTo);
        assertArrayEquals(expected, actual);
    }

}