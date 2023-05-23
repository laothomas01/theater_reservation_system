package driver;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 *
 *
 * MONOLITHIC DOGSHIT
 *
 * */
// The operating system of this application

/*
 *
 *
 * bugs:
 * [] checking double digit user inputs
 *
 *  Monolithic Architecture
 * */
public class Driver1 {

    //temporarily commented out
//    public static void main(String args[]) throws IOException {
//
//        HashMap<String, ArrayList<seat>> Database_Of_Shows = new HashMap<>();
//        HashMap<String, customer> Database_Of_Signups = new HashMap<>();
//        HashMap<String, HashMap<String, ArrayList<seat>>> transactionHistory = new HashMap<>();
//        ArrayList<seat> seats = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //======================= TEST DATA =======================
//
////        seats.add(new seat(1, "m", 35, true));
////        seats.add(new seat(2, "m", 35, true));
////        seats.add(new seat(2, "m", 35, true));
////        seats.add(new seat(2, "m", 35, true));
////        seats.add(new seat(2, "m", 35, true));
////        seats.add(new seat(3, "m", 35, true));
////        seats.add(new seat(3, "m", 35, true));
////        seats.add(new seat(3, "m", 35, true));
////        seats.add(new seat(3, "m", 35, true));
////        seats.add(new seat(3, "m", 35, true));
////        seats.add(new seat(4, "m", 35, true));
////        seats.add(new seat(101, "m", 45, true));
////        seats.add(new seat(101, "m", 45, true));
////        seats.add(new seat(101, "m", 45, true));
////        seats.add(new seat(101, "m", 45, true));
////        seats.add(new seat(101, "m", 45, true));
////        seats.add(new seat(101, "m", 45, true));
////        seats.add(new seat(101, "m", 45, true));
//        //==========================================================
//
//        //======================= DATE TIME HANDLING ==============================================================
//        LocalDateTime localDateTime1 = LocalDateTime.of(2020, Month.DECEMBER, 23, 18, 30);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String formattedDateTimeString = localDateTime1.format(formatter);
//        Database_Of_Shows.put(formattedDateTimeString, seats); // datetime, list of seats
//
//        //=============================================================================================================
//
//
//        boolean run = true;
//        String input;
//
//        while (run) {
//            // ========================== MAIN MENU PROMPT ===========================
//            System.out.println("Sign [U]p\n" + "Sign [I]n\n" + "E[X]it");
//            input = br.readLine();
//            switch (input) {
//                case "u":
//                case "U":
//
//                    // =================== SIGN UP ====================================
//                    boolean signingUp = true;
//                    do {
//                        System.out.println("[C]reate User Account");
//                        System.out.println("[B]ack");
//                        input = br.readLine();
//                        if (!input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c")) {
//                            System.out.println("Invalid Input");
//                        } else if (input.equalsIgnoreCase("b")) {
//                            signingUp = false;
//                        } else {
//                            System.out.println("Enter a valid username:");
//                            String username = br.readLine();
//                            if (Database_Of_Signups.containsKey(username)) {
//                                System.out.println("Username has been taken!");
//                            } else {
//                                System.out.println("Enter a password");
//                                String password = br.readLine();
//                                Database_Of_Signups.put(username, new customer(username, password));
//                                System.out.println(Database_Of_Signups);
//                                signingUp = false; // return back to menu
//                            }
//
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
//                        input = br.readLine();
//
//                        // ========================= SIGNING IN  =====================================
//                        if (!input.equalsIgnoreCase("e") && !input.equalsIgnoreCase("b")) {
//                            System.out.println("Invalid Input");
//                        } else if (input.equalsIgnoreCase("b")) {
//                            signingIn = false;
//                        } else {
//                            System.out.println("Enter login username:");
//                            String username = br.readLine();
//                            if (!Database_Of_Signups.containsKey(username)) {
//                                System.out.println("Username does not exist!");
//                            } else {
//                                //================ VALIDATE USERNAME ============================================
//                                System.out.println("Enter login password:");
//                                String password = br.readLine();
//                                // transition to transaction mode
//
//
//                                //================= SIGN IN SUCCESSFUL ===========================================
//                                if (Database_Of_Signups.get(username).getPassword().equals(password)) {
//                                    System.out.println("Sign in successful");
//
//                                    //create a reference variable to the customer object stored inside signed up user database
//
//                                    //data will persist inside data structure until end of program
//                                    customer user = Database_Of_Signups.get(username);
//
//                                    // prompt reservation menu
//                                    boolean transactionMode = true;
//
//                                    //=========================== TRANSACTION MODE ==========================
//                                    //start transaction mode
//                                    do {
//
//                                        //reference variable to seat database
//
//                                        //updates to reference variable also updates the variable being referenced
//
//                                        //c++ notation: &seatList = Database_Of_Shows.get(dateTime) => &seatList = ArrayList<seat>
//
//
//                                        //====================== TRANSACTION SELECTION =========================
//                                        System.out.println("[R]eserve\n" + "[V]iew\n" + "[C]ancel\n" + "[O]ut");
//                                        input = br.readLine();
//                                        switch (input) {
//                                            case "R":
//                                            case "r":
//                                                boolean reservingShowTime = true;
//
//                                                ArrayList<seat> reservedSeats = new ArrayList<>();
//                                                String dateTime = "";
//
//                                                //================= SEAT RESERVATION ===========================
//                                                do {
//
//
//                                                    //@TODO show available show times to make date entering easier
//
//                                                    System.out.println("Enter a date : (input must follow the date format: `2020-01-23`) or press quit (q)");
//                                                    String date = br.readLine();
//                                                    if (date.equalsIgnoreCase("q")) {
//                                                        break;
//                                                    }
//                                                    System.out.println("Enter a time  : (input must follow the time format examples: `18:30`\t`01:15`) or press quit (q) ");
//                                                    String time = br.readLine();
//                                                    if (time.equalsIgnoreCase("q")) {
//                                                        break;
//                                                    }
//                                                    dateTime = date + " " + time;
//
//                                                    //reference variable to database of shows
//                                                    ArrayList<seat> seatDB = Database_Of_Shows.get(dateTime);
//
//                                                    if (Database_Of_Shows.containsKey(dateTime)) {
//
//                                                        boolean reservingSeats = true;
//                                                        do {
//                                                            System.out.print("Seat Listings\n=====================================================");
//                                                            //display list of seats for current date time
//                                                            for (int i = 0; i < seatDB.size(); i++) {
//                                                                if (i % 6 == 0) {
//                                                                    System.out.println('\n');
//                                                                }
//                                                                System.out.print("[" + i + "] " + seatDB.get(i) + "   ");
//                                                            }
//                                                            System.out.print("======================================================");
//
//
//                                                            System.out.println("\n\nCurrent Reservations:" + reservedSeats);
//
//                                                            System.out.println("Reserve a seat or press quit(-1 or q)");
//                                                            input = br.readLine();
//                                                            if (input.equalsIgnoreCase("q") || input.equals("-1")) {
//                                                                reservingSeats = false;
//                                                                //if entering "asdas", invalid input
//                                                            } else if (onlyDigits(input)) //if input string is a number, it is considered valid
//                                                            {
//                                                                int seatNum = Integer.parseInt(input);
//                                                                if (seatNum < -1 || seatNum > seatDB.size()) {
//                                                                    System.out.println("Seat does not exist!");
//                                                                    continue;
//                                                                }
//                                                                if (seatDB.get(seatNum).isAvailable()) {
//                                                                    seatDB.get(seatNum).setAvailable(false);
//                                                                    reservedSeats.add(seatDB.get(seatNum));
//                                                                } else {
//                                                                    System.out.println("seat unavailable!\n");
//                                                                }
//                                                            }
//                                                            //if input not a number and is a character that's not q or -1,  print invalid statement
//                                                            else {
//                                                                System.out.println("Invalid input");
//                                                                continue;
//                                                            }
//                                                        } while (reservingSeats);
//
//                                                    }
//
//
//                                                } while (reservingShowTime);
//
//                                                if (!reservedSeats.isEmpty()) {
//                                                    user.getReservations().put(dateTime, reservedSeats);
//                                                }
//                                                break;
//
//
//                                            case "V":
//                                            case "v":
//
//                                                //======================== VIEWING RESERVATIONS ================================
//
//                                                //@TODO should be able to view reservations in order by date and then time
//
//                                                //we would need to find a way to organize the keyset of date times
//                                                for (String key : user.getReservations().keySet()) {
//                                                    for (seat s : user.getReservations().get(key)) {
//                                                        System.out.println(key + " | " + s);
//                                                    }
//                                                    System.out.println();
//                                                }
//                                                break;
//                                            case "C":
//                                            case "c":
//                                                // ====================== CANCELLING RESERVATIONS ================================
//                                                boolean cancelingReservations = true;
//                                                do {
//                                                    System.out.println("Enter a date : (input must follow the date format: `2020-01-23`) or press quit (q)");
//                                                    String date = br.readLine();
//                                                    if (date.equalsIgnoreCase("q")) {
//                                                        break;
//                                                    }
//                                                    System.out.println("Enter a time  : (input must follow the time format examples: `18:30`\t`01:15`) or press quit (q) ");
//                                                    String time = br.readLine();
//                                                    if (time.equalsIgnoreCase("q")) {
//                                                        break;
//                                                    }
//                                                    dateTime = date + " " + time;
//                                                    System.out.println(dateTime);
//                                                    if (Database_Of_Shows.containsKey(dateTime) && user.getReservations().containsKey(dateTime)) {
//                                                        //forgetting to check if user even has a reservation
//                                                        boolean selectingToCancel = true;
//                                                        List<seat> reservations = user.getReservations().get(dateTime);
//                                                        do {
//                                                            System.out.println("Enter a number to cancel a seat or press quit(-1 or q)");
//
//                                                            for (int i = 0; i < reservations.size(); i++) {
//                                                                System.out.println("[" + i + "]" + dateTime + "|" + reservations.get(i).getSeatNumber());
//                                                            }
//                                                            input = br.readLine();
//
//                                                            if (input.equalsIgnoreCase("q") || input.equals("-1")) {
//                                                                selectingToCancel = false;
//                                                                //if entering "asdas", invalid input
//                                                            } else if (onlyDigits(input)) {
//                                                                if (!reservations.isEmpty()) {
//                                                                    int seatNum = Integer.parseInt(input);
//                                                                    reservations.remove(seatNum);
//                                                                } else {
//                                                                    System.out.println("You have no reservations!");
//                                                                }
//
//                                                            }
//                                                            //if input not a number and is a character that's not q or -1,  print invalid statement
//                                                            else {
//                                                                System.out.println("Invalid input");
//                                                                continue;
//                                                            }
//
////                                                            reservations.remove(Integer.parseInt(input));
//                                                        } while (selectingToCancel);
//                                                    } else {
//                                                        System.out.println("User reservation does not exist");
//                                                    }
//
//
//                                                } while (cancelingReservations);
//                                                break;
//                                            // ============================== SIGN OUT ===========================================================
//                                            case "O":
//                                            case "o":
//                                                //@TODO: display all reserved shows and organize by date and then time
//                                                //check user's reservations by looking at key sets and mapping those keys to their values
//                                                if (!user.getReservations().isEmpty()) {
//                                                    for (String key : user.getReservations().keySet()) {
//                                                        double totalPrice = 0;
//                                                        System.out.println(key);
//                                                        System.out.println("Confirmation Number " + createRandNums());
//
//                                                        for (seat s : user.getReservations().get(key)) {
//                                                            System.out.println(s.getSeatLocation() + s.getSeatNumber() + "  \t$" + s.getSeatPrice());
//                                                            totalPrice += s.getSeatPrice();
//                                                        }
//                                                        System.out.println("Total \t$" + totalPrice);
//                                                    }
//
//                                                } else {
//                                                    System.out.println("You have no reservations");
//                                                }
//                                                System.out.println("================== Successfully Logged Out ==================");
//                                                transactionMode = false;
//
//                                                break;
//                                            default:
//                                                System.out.println("Invalid input!");
//                                                break;
//                                        }
//
//
//                                    } while (transactionMode);
//
//                                }
//
//                            }
//
//                        }
//                    } while (signingIn);
//                    // ============================= USER HAS LOGGED OUT ====================================
//
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
////                    With this option, the system
////                    copies the valid reservations of all registered users from the in-memory data structure to a
////                    file called 'reservations.txt'.
//                    if (!Database_Of_Signups.isEmpty()) {
//                        for (String username : Database_Of_Signups.keySet()) {
//                            System.out.println(username + ":");
//                            if (!Database_Of_Signups.get(username).getReservations().isEmpty()) {
//                                for (String showTimeReservation : Database_Of_Signups.get(username).getReservations().keySet()) {
//                                    System.out.println(showTimeReservation + ":");
//                                    for (seat s : Database_Of_Signups.get(username).getReservations().get(showTimeReservation)) {
//                                        System.out.println(s.getSeatLocation() + s.getSeatNumber() + " $" + s.getSeatPrice());
//                                    }
//                                }
//                            }
//                        }
//                    }
//
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
//    }

    public static void main(String args[]) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime startDate_6_30 = LocalDateTime.of(2020, Month.DECEMBER, 23, 18, 30);
        LocalDateTime endDate_6_30 = LocalDateTime.of(2021, Month.JANUARY, 2, 18, 30);
        //2020-12-23 => 2021-01-02 , 18:30
        for (int i = 0; i <= startDate_6_30.until(endDate_6_30, ChronoUnit.DAYS); i++) {
            if (startDate_6_30.plusDays(i).getDayOfMonth() == 26 || startDate_6_30.plusDays(i).getDayOfMonth() == 27) {
                String formattedDateTimeString = startDate_6_30.plusDays(i).format(formatter);
                System.out.println(formattedDateTimeString);
                System.out.println("Discount Night: $20");
            } else {
                String formattedDateTimeString = startDate_6_30.plusDays(i).format(formatter);
                System.out.println(formattedDateTimeString);
            }
        }
        //2020-12-23 => 2021-01-02 , 20:30
        LocalDateTime startDate_8_30 = LocalDateTime.of(2020, Month.DECEMBER, 23, 20, 30);
        LocalDateTime endDate_8_30 = LocalDateTime.of(2021, Month.JANUARY, 2, 20, 30);
        System.out.println();
        for (int i = 0; i <= startDate_8_30.until(endDate_8_30, ChronoUnit.DAYS); i++) {
            if (startDate_6_30.plusDays(i).getDayOfMonth() == 26 || startDate_6_30.plusDays(i).getDayOfMonth() == 27) {
                String formattedDateTimeString = startDate_6_30.plusDays(i).format(formatter);
                System.out.println(formattedDateTimeString);
                System.out.println("Discount Night: $20");
            } else {
                String formattedDateTimeString = startDate_6_30.plusDays(i).format(formatter);
                System.out.println(formattedDateTimeString);
            }
        }

    }

    public static boolean onlyDigits(String str) {
        // Regex to check string
        // contains only digits
        String regex = "[0-9]+";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }
        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    public static String createRandNums() {
        final Random rnd = new Random();
        final int N = 100;
        final int K = 5;
        final ArrayList<Integer> S = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            S.add(i + 1);
        }
        Collections.shuffle(S, rnd);
        String result = "";
        for (int i = 0; i < K; i++) {
            result += S.get(i).toString();
        }
        return result;
    }


}


