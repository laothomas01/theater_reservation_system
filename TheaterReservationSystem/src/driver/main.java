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
            // ========================== MAIN MENU PROMPT ===========================
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

                        // ========================= SIGNING IN EDGE CASES =====================================
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
                                //================ VALID USERNAME ============================================
                                System.out.println("Enter login password:");
                                String password = br.readLine();
                                // transition to transaction mode


                                //================= SIGN IN SUCCESSFUL ===========================================
                                if (Database_Of_Signups.get(username).getPassword().equals(password)) {
                                    System.out.println("Sign in successful");

                                    //create a reference variable to the customer object stored inside signed up user database

                                    //data will persist inside data structure until end of program
                                    customer user = Database_Of_Signups.get(username);

                                    // prompt reservation menu
                                    boolean transactionMode = true;
                                    //=========================== TRANSACTION MODE ==========================
                                    //start transaction mode
                                    do {


                                        //reference variable to seat database

                                        //updates to reference variable also updates the variable being referenced

                                        //c++ notation: &seatList = Database_Of_Shows.get(dateTime) => &seatList = ArrayList<seat>


                                        //====================== TRANSACTION SELECTION =========================
                                        System.out.println("[R]eserve\n" + "[V]iew\n" + "[C]ancel\n" + "[O]ut");
                                        input = br.readLine();
                                        switch (input) {
                                            case "R":
                                            case "r":
                                                boolean pickingShowTime = true;
                                                ArrayList<seat> reservedSeats = new ArrayList<>();

                                                //create list of seat reservations
//                                                ArrayList<seat> reservedSeats = new ArrayList<>();
                                                //while user
                                                String dateTime = "";

                                                //================= SEAT REVERSATION ===========================
                                                do {


                                                    //@TODO show available show times to make date entering easier

                                                    System.out.println("Enter a date : (input must follow the date format: `2020-01-23`) or press quit (q)");
                                                    String date = br.readLine();
                                                    if (date.equalsIgnoreCase("q")) {
                                                        break;
                                                    }
                                                    System.out.println("Enter a time  : (input must follow the time format examples: `18:30`\t`01:15`) or press quit (q) ");
                                                    String time = br.readLine();
                                                    if (time.equalsIgnoreCase("q")) {
                                                        break;
                                                    }
                                                    dateTime = date + " " + time;
                                                    ArrayList<seat> seatSelection = Database_Of_Shows.get(dateTime);

                                                    if (Database_Of_Shows.containsKey(dateTime)) {

                                                        boolean reservingSeats = true;
                                                        do {
                                                            //print current state of list of seats
                                                            System.out.print("Seat Listings\n=====================================================");
                                                            for (int i = 0; i < seatSelection.size(); i++) {
                                                                if (i % 6 == 0) {
                                                                    System.out.println('\n');
                                                                }
                                                                System.out.print("[" + i + "] " + seatSelection.get(i) + "   ");

                                                            }
                                                            System.out.println("\n=====================================================");

                                                            System.out.println("Reserved Seats\n" + reservedSeats + "\n");
                                                            System.out.println("=====================================================");
                                                            System.out.println("Reserve a seat or press quit(-1 or q)");

                                                            input = br.readLine();
                                                            //if input q or -1, quit
                                                            if (input.equalsIgnoreCase("q") || input.equals("-1")) {
                                                                reservingSeats = false;
                                                                //if entering "asdas", invalid input
                                                            } else if (input.length() > 1) {
                                                                System.out.println("Invalid Input");
                                                                continue;

                                                            } else if (input.matches("^[0-9]*$") && !input.equals("")) //if input string is a number, it is considered valid
                                                            {
                                                                int seatNum = Integer.parseInt(input);
                                                                seat s = seatSelection.get(seatNum);
                                                                s.setAvailable(false);
                                                                reservedSeats.add(s);
                                                            }
                                                            //if input not a number and is a character that's not q or -1,  print invalid statement
                                                            else {
                                                                System.out.println("Invalid input");
                                                                continue;
                                                            }
                                                        } while (reservingSeats);

                                                    }


                                                } while (pickingShowTime);
//                                                System.out.println(user.getReservations());
                                                user.getReservations().put(dateTime, reservedSeats);
//                                                System.out.println(user.getReservations());
                                                break;


                                            case "V":
                                            case "v":

                                                //======================== RESERVATION VIEWING ================================
                                                boolean viewingReservations = true;
                                                for (String key : user.getReservations().keySet()) {
                                                    for (seat s : user.getReservations().get(key)) {
                                                        System.out.println(key + " | " + s);
                                                    }
                                                    System.out.println();
                                                }
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
                    // ============================= USER HAS LOGGED OUT ====================================

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


