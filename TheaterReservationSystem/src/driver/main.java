package driver;

import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
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

        Hashtable<String, ArrayList<seat>> DataBase_Of_Shows = new Hashtable<>();
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


//        String dateTimeString = localDateTime1;
        //        DataBase_Of_Shows.put(, seats);
        //        DataBase_Of_Shows.put(localDateTime1,)
        //populate when loading signed up users
        Hashtable<String, customer> DataBase_Of_Users = new Hashtable<>();

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
//                    System.out.println("Enter User Id:");
//                    System.out.println("Enter password:");
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


