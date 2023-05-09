/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moonrailsystem;


public class Seat {
    private int number;
    private boolean available;
    private String passengerName;
    private Price price;

    public Seat(int number, Price price) {
        this.number = number;
        this.available = true;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void reserve(String passengerName) {
        this.passengerName = passengerName;
        this.available = false;
    }

    public void cancelReservation() {
        this.passengerName = null;
        this.available = true;
    }
    
     public double getPrice() {
        return price.calculatePrice();
    }

    public String getSeatType() {
        return price.getSeatType();
    }
}


