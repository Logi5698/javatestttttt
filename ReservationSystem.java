/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moonrailsystem;


public class ReservationSystem {
    private Train[] trains;

    public ReservationSystem() {
    this.trains = new Train[3];

    // Create price objects for each seat type
    Price regularPrice = new Price(10.0, "Regular", 1.0);
    Price firstClassPrice = new Price(20.0, "First Class", 1.5);

    // Create trains with corresponding prices
    this.trains[0] = new Train("Train 1", 20, regularPrice);
    this.trains[1] = new Train("Train 2", 20, regularPrice);
    this.trains[2] = new Train("Train 3", 20, firstClassPrice);
}


    public Train[] getTrains() {
        return trains;
    }

     public boolean reserveSeat(int trainNum, int seatNum, String passengerName) {
        Train train = trains[trainNum - 1];
        Seat seat = train.getSeats()[seatNum - 1];
        if (seat.isAvailable()) {
            seat.reserve(passengerName);
            double price = seat.getPrice();
            System.out.println("Seat reserved successfully! Price: " + price);
            return true;
        } else {
            System.out.println("Seat is already reserved or invalid selection.");
            return false;
        }
    }
}
