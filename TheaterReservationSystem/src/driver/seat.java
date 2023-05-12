package driver;

public class seat {

    int seatNumber;
    String seatLocation;
    double seatPrice;
    boolean isAvailable;

    public seat(int num, String name, double price, boolean availability) {
        seatNumber = num;
        seatLocation = name;
        seatPrice = price;
        isAvailable = availability;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return seatLocation + seatNumber + ",$" + seatPrice;
    }


}
