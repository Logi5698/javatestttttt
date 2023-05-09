/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moonrailsystem;

        
import java.util.Scanner;

public class MoonRailSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        boolean continueReserving = true;

        while (continueReserving) {
            // Print available trains
            Train[] trains = reservationSystem.getTrains();
            System.out.println("Available Trains:");
            for (int i = 0; i < trains.length; i++) {
                System.out.println((i + 1) + ". " + trains[i].getName());
            }

            // Prompt for train selection
            System.out.print("Select a train (1-" + trains.length + "): ");
            int selectedTrain = scanner.nextInt();

            if (selectedTrain < 1 || selectedTrain > trains.length) {
                System.out.println("Invalid train selection.");
                continue;
            }

            // Print seat availability and prices for the selected train
            Train selectedTrainObj = trains[selectedTrain - 1];
            System.out.println("Seat Availability and Prices for " + selectedTrainObj.getName());
            Seat[] seats = selectedTrainObj.getSeats();
            for (Seat seat : seats) {
                System.out.println("Seat " + seat.getNumber() + ": " + (seat.isAvailable() ? "Available" : "Reserved") +
                        " - " + seat.getSeatType() + " - Price: " + seat.getPrice());
            }

            // Prompt for seat selection or return to train selection
            System.out.println("Enter the seat number to reserve or 0 to return to train selection:");
            int selectedSeat = scanner.nextInt();

            if (selectedSeat == 0) {
                continue;
            }

            if (selectedSeat < 1 || selectedSeat > seats.length || !seats[selectedSeat - 1].isAvailable()) {
                System.out.println("Invalid seat selection or seat already reserved.");
                continue;
            }

            // Prompt for passenger name
            System.out.print("Enter passenger name: ");
            scanner.nextLine(); // Consume the newline character
            String passengerName = scanner.nextLine();

            // Reserve the seat
            boolean reservationSuccessful = reservationSystem.reserveSeat(selectedTrain, selectedSeat, passengerName);

            if (reservationSuccessful) {
                System.out.println("Seat reserved successfully!");
            } else {
                System.out.println("Seat reservation failed.");
            }

            // Prompt to continue reserving
            System.out.print("Do you want to continue reserving? (yes/no): ");
            String continueReservingInput = scanner.next().trim().toLowerCase();
            continueReserving = continueReservingInput.equals("yes") || continueReservingInput.equals("y");

            scanner.nextLine(); // Consume the newline character after reading the input
        }
    }
}
