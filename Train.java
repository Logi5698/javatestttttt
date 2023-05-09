/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moonrailsystem;


public class Train {
    private String name;
    private int numSeats;
    private Seat[] seats;

    public Train(String name, int numSeats, Price price) {
        this.name = name;
        this.numSeats = numSeats;
        this.seats = new Seat[numSeats];
        for (int i = 0; i < numSeats; i++) {
            this.seats[i] = new Seat(i+1, price);
        }
    }

    public String getName() {
        return name;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public boolean reserveSeat(int seatNum, String passengerName) {
        Seat seat = seats[seatNum - 1];
        if (seat.isAvailable()) {
            seat.reserve(passengerName);
            return true;
        } else {
            return false;
        }
    }
}
