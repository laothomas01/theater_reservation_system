package driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class customer {


    String userId;
    String password;

    //list of reservations

    // key: show datetime, value = list of seats

    //@TODO turn into a hashmap of <hashmap<time,date>, <list<seat>>
    HashMap<String, ArrayList<seat>> reservations;

    public customer(String id, String password) {
        reservations = new HashMap<>();
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


    public HashMap<String, ArrayList<seat>> getReservations() {
        return reservations;
    }

    public void addReservation(String dateTime, ArrayList<seat> seats) {
        getReservations().put(dateTime, seats);
    }

    public String toString() {
        return getUserId() + " " + getPassword() + " ";
    }
}
