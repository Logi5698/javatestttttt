/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moonrailsystem;


public class Price {
    private double basePrice;
    private String seatType;
    private double priceMultiplier;

    public Price(double basePrice, String seatType, double priceMultiplier) {
        this.basePrice = basePrice;
        this.seatType = seatType;
        this.priceMultiplier = priceMultiplier;
    }

    public double calculatePrice() {
        return basePrice * priceMultiplier;
    }

    public String getSeatType() {
        return seatType;
    }
}

