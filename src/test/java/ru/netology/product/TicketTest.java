package ru.netology.product;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketTest {

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

    @Test
    void sortingByPrice() {
        Ticket[] expected = new Ticket[]{fourth, second, third, first, fifth};
        Ticket[] actual = new Ticket[]{fourth, second, third, first, fifth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortingByTime() {
        Ticket[] expected = new Ticket[]{fourth, second, third, first, fifth};
        Ticket[] actual = new Ticket[]{fourth, second, third, first, fifth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
