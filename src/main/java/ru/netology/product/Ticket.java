package ru.netology.product;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String airportFrom;
    protected String airportTo;
    protected int time;

    public Ticket(int id, int price, String airportFrom, String airportTo, int travelTime) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.time = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public int getPrice() {
        return price;
    }

    public int getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && time == ticket.time && Objects.equals(airportFrom, ticket.airportFrom) && Objects.equals(airportTo, ticket.airportTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, airportFrom, airportTo, time);
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
