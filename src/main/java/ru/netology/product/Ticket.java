package ru.netology.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected double price;
    protected String airportFrom;
    protected String airportTo;
    protected int time;

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
