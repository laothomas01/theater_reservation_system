package driver;

import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

// The operating system of this application
public class main {
    public static void main(String args[]) throws IOException {
//        String filename = "helloworld.txt";
//        File file = new File(filename);

        //make sure to update global database of shows and their respective available seats

        //initialize database of shows with show times and available seats
        //populate when loading text files

        //this list of seats should be a hashmap to make access to specific seats easier
        HashMap<String, ArrayList<seat>> DataBase_Of_Shows = new HashMap<>();
        ArrayList<seat> seats = new ArrayList<>();
        //======================= TEST DATA =======================
        seats.add(new seat(1, "m", 35, true));
        seats.add(new seat(2, "m", 35, true));
        seats.add(new seat(3, "m", 35, true));
        seats.add(new seat(4, "m", 35, true));
        seats.add(new seat(101, "m", 45, true));
        //==========================================================
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, Month.DECEMBER, 23, 18, 30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTimeString = localDateTime1.format(formatter);
        DataBase_Of_Shows.put(formattedDateTimeString, seats);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a date and time: (date time format example: 2010-01-23 10:30)");
        String line = input.readLine();
        if (line.equals(formattedDateTimeString)) {
            for (int i = 0; i < DataBase_Of_Shows.get(line).size(); i++) {
                System.out.println(DataBase_Of_Shows.get(line).get(i));
            }
        }


        HashMap<String, customer> DataBase_Of_Users = new HashMap<>();
//        DataBase_Of_Users.put("a", 1);
//        if (DataBase_Of_Users.containsKey("a")) {
//            System.out.println("Duplicate key adding");
//        } else {
//            DataBase_Of_Users.put("a", 2);
//        }
//        System.out.println(DataBase_Of_Users);

        boolean run = true;
        while (run) {
            System.out.println("Sign [U]p\n" + "Sign [I]n\n" + "E[X]it");
            line = input.readLine();
            switch (line) {
                case "u":
                case "U":
                    System.out.println("=======================SIGN UP=======================");
                    System.out.println("[C]reate User");
                    System.out.println("[B]ack");
                    line = input.readLine();
                    switch (line) {
                        case "c":
                        case "C":
                            //when user signs up, populate an internal database of signed up users
                            //key = username, value = hashtable of reservations
                            //hashtable of reservations:
                            // key = date_and_time, value = list of reserved seats
                            System.out.println("Enter User Id:");
                            String username;
                            line = input.readLine();
                            username = line;
                            System.out.println("Enter password:");
                            String password;
                            line = input.readLine();
                            password = line;

                            if (DataBase_Of_Users.containsKey(username)) {
                                System.out.println("Username has already been taken!");
                            } else {
                                DataBase_Of_Users.put(username, new customer(username, password));
                            }

                        default:
                            break;
                    }
                case "i":
                case "I":
                    System.out.println("[S]ign In");
                    System.out.println("[B]ack");
                    switch (line) {
                        case "s":
                        case "S":
                            System.out.println("Login Id:");
                            String username;
                            line = input.readLine();
                            username = line;
                            System.out.println("Login Password:");
                            String password;
                            line = input.readLine();
                            password = line;
                            if (DataBase_Of_Users.get(username).getUserId().equals(username) && DataBase_Of_Users.get(username).getPassword().equals(password)) {
                                //access signed up user account
                                customer c = DataBase_Of_Users.get(username);

                                //when user makes and finishes a reservation, we also update the global internal database
                                //when another user signs up and want to add an already reserved seat for a specific show time, other users should NOT be able to reserve that seat`
                            }
                            //if login successful


                    }
                    break;

            }
        }
    }

    public void runApp() throws IOException {
        boolean run = true;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (run) {
            System.out.println("Sign [U]p\n" + "Sign [I]n\n" + "E[X]it");
            line = input.readLine();
            switch (line) {
                case "u":
                case "U":
                    System.out.println("=======================SIGN UP=======================");
                    System.out.println("[C]reate User");
                    System.out.println("[B]ack");
                    line = input.readLine();
                    switch (line) {
                        case "c":
                        case "C":
                            //when user signs up, populate an internal database of signed up users
                            //key = username, value = hashtable of reservations
                            //hashtable of reservations:
                            // key = date_and_time, value = list of reserved seats
                            System.out.println("Enter User Id:");
                            line = input.readLine();
                            System.out.println("Enter password:");
                            line = input.readLine();
                            break;
                        case "b":
                        case "B":

                            break;
                        default:
                            break;
                    }


                case "i":
                case "I":
                    System.out.println("=======================SIGN IN=======================");
                    //when user signs in,
                    //when user successfully signs in, begin transaction mode
                    /*
                     *
                     * [R] eserve
                     * [V] iew
                     * [C] ancel
                     * [O] ut: display receipt for transaction. prompt initial menu again when user signs out
                     *
                     *
                     * */
                    break;
                case "x":
                case "X":
                    System.out.println("=======================EXIT!=======================");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }


    }
}


