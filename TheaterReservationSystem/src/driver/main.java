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
        HashMap<String, ArrayList<seat>> Database_Of_Shows = new HashMap<>();
        HashMap<String, customer> Database_Of_Signups = new HashMap<>();
        ArrayList<seat> seats = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //======================= TEST DATA =======================

        seats.add(new seat(1, "m", 35, true));
        seats.add(new seat(2, "m", 35, true));
        seats.add(new seat(2, "m", 35, true));
        seats.add(new seat(2, "m", 35, true));
        seats.add(new seat(2, "m", 35, true));
        seats.add(new seat(3, "m", 35, true));
        seats.add(new seat(3, "m", 35, true));
        seats.add(new seat(3, "m", 35, true));
        seats.add(new seat(3, "m", 35, true));
        seats.add(new seat(3, "m", 35, true));
        seats.add(new seat(4, "m", 35, true));
        seats.add(new seat(101, "m", 45, true));
        seats.add(new seat(101, "m", 45, true));
        seats.add(new seat(101, "m", 45, true));
        seats.add(new seat(101, "m", 45, true));
        seats.add(new seat(101, "m", 45, true));
        seats.add(new seat(101, "m", 45, true));
        seats.add(new seat(101, "m", 45, true));
        //==========================================================

        //======================= DATE TIME HANDLING ==============================================================
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, Month.DECEMBER, 23, 18, 30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTimeString = localDateTime1.format(formatter);
        Database_Of_Shows.put(formattedDateTimeString, seats); // datetime, list of seats

        //=============================================================================================================


        boolean run = true;
        String input;

        while (run) {
            System.out.println("Sign [U]p\n" + "Sign [I]n\n" + "E[X]it");
            input = br.readLine();
            switch (input) {
                case "u":
                case "U":
                    boolean signingUp = true;
                    do {
                        System.out.println("[C]reate User Account");
                        System.out.println("[B]ack");
                        input = br.readLine();
                        if (!input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c")) {
                            System.out.println("Invalid Input");
                        } else if (input.equalsIgnoreCase("b")) {
                            signingUp = false;
                        } else {
                            System.out.println("Enter a valid username:");
                            String username = br.readLine();
                            if (Database_Of_Signups.containsKey(username)) {
                                System.out.println("Username has been taken!");
                            } else {
                                System.out.println("Enter a password");
                                String password = br.readLine();
                                Database_Of_Signups.put(username, new customer(username, password));
                                System.out.println(Database_Of_Signups);
                                signingUp = false; // return back to menu
                            }


                        }
                    } while (signingUp);
                    break;
                case "i":
                case "I":
                    boolean signingIn = true;
                    do {
                        System.out.println("[E]nter Login");
                        System.out.println("[B]ack");
                        input = br.readLine();
                        if (!input.equalsIgnoreCase("e") && !input.equalsIgnoreCase("b")) {
                            System.out.println("Invalid Input");
                        } else if (input.equalsIgnoreCase("b")) {
                            signingIn = false;
                        } else {
                            System.out.println("Enter login username:");
                            String username = br.readLine();
                            if (!Database_Of_Signups.containsKey(username)) {
                                System.out.println("Username does not exist!");
                            } else {
                                System.out.println("Enter login password:");
                                String password = br.readLine();
                                // transition to transaction mode
                                if (Database_Of_Signups.get(username).getPassword().equals(password)) {
                                    System.out.println("Sign in successful");
                                    //create a reference to the customer account to persist made reservations
                                    customer user = Database_Of_Signups.get(input);
                                    // prompt reservation menu
                                    boolean transactionMode = true;

                                    do {
                                        System.out.println("[R]eserve\n" + "[V]iew\n" + "[C]ancel\n" + "[O]ut");
                                        input = br.readLine();
                                        switch (input) {
                                            case "R":
                                            case "r":
                                                boolean reserving = true;
                                                //enter date and time of desired show
//                                                System.out.println("Enter a date and time: (input must follow date time format: 2010-01-23 10:30 )");
                                                System.out.println("Enter a date : (input must follow the date format: `2020-01-23`) ");
                                                String date = br.readLine();
                                                System.out.println("Enter a time  : (input must follow the time format examples: `18:30`\t`01:15`) ");
                                                String time = br.readLine();
                                                String dateTime = date + " " + time;
                                                if (Database_Of_Shows.containsKey(dateTime)) {
                                                    ArrayList<seat> listOfSeats = Database_Of_Shows.get(dateTime);
                                                    for (int i = 0; i < listOfSeats.size(); i++) {
                                                        //ever 6 seats, print a new line
                                                        if (i % 6 == 0) {
                                                            System.out.println('\n');
                                                        }

                                                        System.out.print("[" + i + "] " + listOfSeats.get(i) + "    ");
                                                    }
                                                    System.out.println("\n\n" + "Select one or more seats : (input for multiple seats should follow the following format: `0,1,2,3,4,5,[....],100`) \n");

                                                    boolean reservingSeats = true;
                                                    ArrayList<seat> reservedSeats = new ArrayList<>();

                                                    while (reservingSeats) {
                                                        System.out.println("Enter in a number to select a seat or [Q] to quit");
                                                        System.out.println(reservedSeats);
                                                        input = br.readLine();
                                                        if (input.equalsIgnoreCase("q")) {
                                                            reservingSeats = false;
                                                        } else {
                                                            if (Integer.parseInt(input) > listOfSeats.size() || Integer.parseInt(input) < 0) {
                                                                System.out.println("Invalid Input");
                                                                continue;
                                                            }


                                                            if (reservedSeats.contains(listOfSeats.get(Integer.parseInt(input)))) {
                                                                continue;
                                                            } else {
                                                                reservedSeats.add(listOfSeats.get(Integer.parseInt(input)));
                                                            }

                                                        }


                                                    }
                                                    //pick choice

                                                    //update show database
//                                                    ArrayList<seat> reservedSeats = new ArrayList<>();
//                                                    reservedSeats.add(listOfSeats.get(seatChoiceInt));


                                                }
                                                break;
                                            case "V":
                                            case "v":
                                                break;
                                            case "C":
                                            case "c":
                                                break;
                                            case "O":
                                            case "o":
                                                transactionMode = false;
                                                signingIn = false;
                                                break;
                                            default:
                                                System.out.println("Invalid input!");
                                                break;
                                        }
                                    } while (transactionMode);
                                }
                            }
                        }
                    } while (signingIn);
                    break;


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

    public static void runApp() throws IOException {
//        boolean run = true;
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//
//        while (run) {
//            System.out.println("Sign [U]p\n" + "Sign [I]n\n" + "E[X]it");
//            line = input.readLine();
//            switch (line) {
//                case "u":
//                case "U":
//                    boolean signingUp = true;
//                    do {
//                        System.out.println("[C]reate User Account");
//                        System.out.println("[B]ack");
//                        line = input.readLine();
//                        if (!line.equalsIgnoreCase("b") && !line.equalsIgnoreCase("c")) {
//                            System.out.println("Invalid Input");
//                        } else if (line.equalsIgnoreCase("b")) {
//                            signingUp = false;
//                        } else {
//                            System.out.println("Enter a valid username:");
//                            String username = input.readLine();
//                            System.out.println("Enter a password");
//                            String password = input.readLine();
//
//                        }
//                    } while (signingUp);
//                    break;
//                case "i":
//                case "I":
//                    boolean signingIn = true;
//                    do {
//                        System.out.println("[E]nter Login");
//                        System.out.println("[B]ack");
//                        line = input.readLine();
//                        if (!line.equalsIgnoreCase("e") && !line.equalsIgnoreCase("b")) {
//                            System.out.println("Invalid Input");
//                        } else if (line.equalsIgnoreCase("b")) {
//                            signingIn = false;
//                        } else {
//                            System.out.println("Enter login username:");
//                            String username = input.readLine();
//                            System.out.println("Enter login password:");
//                            String password = input.readLine();
//                            if()
//                            break;
//                        }
//                    }
//                    while (signingIn);
//                    break;
//
//
//                //when user signs in,
//                //when user successfully signs in, begin transaction mode
//                /*
//                 *
//                 * [R] eserve
//                 * [V] iew
//                 * [C] ancel
//                 * [O] ut: display receipt for transaction. prompt initial menu again when user signs out
//                 *
//                 *
//                 * */
//                case "x":
//                case "X":
//                    System.out.println("=======================EXIT!=======================");
//                    run = false;
//                    break;
//                default:
//                    System.out.println("Invalid Input!");
//                    break;
//            }
//        }
//
//
    }
}


