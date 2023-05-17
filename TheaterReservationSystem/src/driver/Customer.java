package driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Customer {


    String userId;
    String password;

    //list of reservations

    // key: show datetime, value = list of seats

    //@TODO turn into a hashmap of <hashmap<time,date>, <list<seat>>
    LinkedHashMap<String, ArrayList<Seat>> showReservations;

    public Customer(String id, String password) {
        showReservations = new LinkedHashMap<>();
        this.userId = id;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public HashMap<String, ArrayList<Seat>> getShowReservations() {
        return showReservations;
    }

    public void addReservation(String dateTime, ArrayList<Seat> seats) {
        getShowReservations().put(dateTime, seats);
    }

    public String toString() {
        return getUserId() + " " + getPassword() + " ";
    }
}
