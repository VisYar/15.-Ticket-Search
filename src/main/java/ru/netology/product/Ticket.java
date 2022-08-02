package ru.netology.product;

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
