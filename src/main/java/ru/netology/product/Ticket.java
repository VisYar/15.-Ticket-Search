package ru.netology.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    private int id;
    private double price;
    private String airportFrom;
    private String airportTo;
    private int time;

    public int getId() {
        return id;
    }

    public String getFrom() {
        return airportFrom;
    }

    public String getTo() {
        return airportTo;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
