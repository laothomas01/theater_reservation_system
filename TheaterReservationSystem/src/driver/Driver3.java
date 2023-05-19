package driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver3 {
    private static LinkedHashMap<String, ArrayList<Seat>> Database_Of_Shows = new LinkedHashMap<>();
    private static HashMap<String, Customer> Database_Of_Signups = new HashMap<>();

    public static void initializeDatabase() {
        LocalDateTime startDate_6_30 = LocalDateTime.of(2020, Month.DECEMBER, 23, 18, 30);
        LocalDateTime endDate_6_30 = LocalDateTime.of(2021, Month.JANUARY, 2, 18, 30);

        LocalDateTime startDate_8_30 = LocalDateTime.of(2020, Month.DECEMBER, 23, 20, 30);
        LocalDateTime endDate_8_30 = LocalDateTime.of(2021, Month.JANUARY, 2, 20, 30);

        generateShows(startDate_6_30, endDate_6_30);
        generateShows(startDate_8_30, endDate_8_30);
    }

    private static void generateShows(LocalDateTime startDate, LocalDateTime endDate) {


        DateTimeFormatter formattedDateTimeString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (int i = 0; i <= startDate.until(endDate, ChronoUnit.DAYS); i++) {
            String DateTimeString = startDate.plusDays(i).format(formattedDateTimeString);
            ArrayList<Seat> seats = new ArrayList<>();
            String[] seatNames = new String[]{"m", "sb", "wb", "eb"};

            for (String n : seatNames) {
                for (int j = 1; j <= 150; j++) {
                    double price = 0;
                    if ((startDate.plusDays(i).getDayOfMonth() == 26 && startDate.getMonth().equals(Month.DECEMBER)) || (startDate.plusDays(i).getDayOfMonth() == 27 && startDate.getMonth().equals(Month.DECEMBER))) {
                        price = 20;

                        if (n.equals("m")) {
//                            System.out.println(n + j + " : $20");
                            seats.add(new Seat(j, n, price, true));
                            if (j == 150) {
                                seats.add(new Seat(j, n, price, true));

//                                System.out.println(n + j + " : $20");

                                break;
                            }
                        } else if (n.equals("sb")) {
//                            System.out.println(n + j + " : $20");
                            seats.add(new Seat(j, n, price, true));

                            if (j == 50) {
//                                System.out.println(n + j + " : $20");
                                seats.add(new Seat(j, n, price, true));

                                break;
                            }
                        } else if (n.equals("wb")) {
//                            System.out.println(n + j + " : $20");
                            seats.add(new Seat(j, n, price, true));

                            if (j == 100) {
//                                System.out.println(n + j + " : $20");
                                seats.add(new Seat(j, n, price, true));

                                break;
                            }
                        } else if (n.equals("eb")) {
//                            System.out.println(n + j + " : $20");
                            seats.add(new Seat(j, n, price, true));

                            if (j == 100) {
//                                System.out.println(n + j + " : $20");
                                seats.add(new Seat(j, n, price, true));

                                break;
                            }
                        }
                    } else {

                        if (n.equals("m")) {
                            if (j <= 100) {
                                price = 35;
                            } else {
                                price = 45;
                            }
                            seats.add(new Seat(j, n, price, true));

//                            System.out.println(n + j + " : " + price);

                            if (j == 150) {
//                                System.out.println(n + j + " : " + price);

                                seats.add(new Seat(j, n, price, true));

                                break;
                            }
                        } else if (n.equals("sb")) {
                            if (j <= 25) {
                                price = 50;

                            } else {
                                price = 55;
                            }
//                            System.out.println(n + j + " : " + price);

                            seats.add(new Seat(j, n, price, true));

                            if (j == 50) {
//                                System.out.println(n + j + " : " + price);
                                seats.add(new Seat(j, n, price, true));
                                break;
                            }
                        } else if (n.equals("wb")) {
                            price = 40;

//                            System.out.println(n + j + " : " + price);

                            seats.add(new Seat(j, n, price, true));

                            if (j == 100) {
//                                System.out.println(n + j + " : " + price);

                                seats.add(new Seat(j, n, price, true));

                                break;
                            }
                        } else if (n.equals("eb")) {
                            price = 40;

//                            System.out.println(n + j + " : " + price);

                            seats.add(new Seat(j, n, price, true));

                            if (j == 100) {
//                                System.out.println(n + j + " : " + price);

                                seats.add(new Seat(j, n, price, true));

                                break;
                            }
                        }
                    }
                }

            }

            Database_Of_Shows.put(DateTimeString, seats);


/*
o Main Floor: $35 (left side: m1-m50, right side:m51-m100), $45 (m101-m150)
o South Balcony: $50 (sb1-sb25), $55(sb26-sb50)
o West Balconies: $40 (wb1-wb100)
o East Balconies: $40 (eb1-wb100)
* */

        }

//        for (Seat s : Database_Of_Shows.get("2020-12-23 18:30")) {
//            System.out.println(s.toString() + "\n");
//        }

    }

    private static boolean onlyDigits(String str) {
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

    private static String createRandNums() {
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

    private static void printNiceMessage(String message) {
        int messageLength = message.length();
        int borderLength = messageLength + 4;

        // Print the top border
        printBorder(borderLength);

        // Print the message
        System.out.println("| " + message + " |");

        // Print the bottom border
        printBorder(borderLength);
    }

    private static void printBorder(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        initializeDatabase();
        printNiceMessage("Miracle on 34th Street");
        mainMenu();

    }


    private static void mainMenu() throws IOException {
        printNiceMessage("Main Menu");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            System.out.println("Sign [U]p\n" + "Sign [I]n\n" + "E[X]it");
            input = br.readLine();
            if (input.equalsIgnoreCase("u")) {
                signUp(br);
            } else if (input.equalsIgnoreCase("i")) {
                signIn(br);
            } else if (input.equalsIgnoreCase("x")) {
                //write all internal database data to a .txt file called "reservations.txt"
                System.out.println("Good bye");
                break;
            } else {
                System.out.println("Invalid Input!");
            }

        } while (!input.equalsIgnoreCase("x"));
    }

    private static void signUp(BufferedReader br) throws IOException {
        String input;
        do {
            System.out.println("[C]reate User Account\n[B]ack");
            input = br.readLine();
            if (input.equalsIgnoreCase("c")) {
                System.out.println("Enter a valid username:");
                String username = br.readLine();
                if (!Database_Of_Signups.containsKey(username)) {
                    System.out.println("Enter a password:");
                    String password = br.readLine();
                    Database_Of_Signups.put(username, new Customer(username, password));
                    break;
                } else {
                    System.out.println("Username has already been taken!");
                }
            } else if (input.equalsIgnoreCase("b")) {
                break;
            } else {
                System.out.println("Invalid Input");
            }

        } while (!input.equalsIgnoreCase("b"));
    }

    private static void signIn(BufferedReader br) throws IOException {
        String input;
        do {
            printNiceMessage("Sign In");

            System.out.println("[E]nter Login\n[B]ack");
            input = br.readLine();
            if (input.equalsIgnoreCase("b")) {
                break;
            } else if (input.equalsIgnoreCase("e")) {
                System.out.println("Enter a username:");
                String username = br.readLine();
                if (!Database_Of_Signups.containsKey(username)) {
                    System.out.println("username not found!");
                } else {
                    System.out.println("Enter a password");

                    //reference variable to signed in user
                    Customer c = Database_Of_Signups.get(username);
                    String password = br.readLine();
                    //enter transaction session
                    if (password.equals(c.getPassword())) {
                        transactionSession(br, c);
                    }
                    //display customer's receipt
                }
            }
        } while (true);

    }

    private static void transactionSession(BufferedReader br, Customer c) throws IOException {
        String input;
        ArrayList<Seat> reservations = new ArrayList<>();
        do {
            printNiceMessage("Transaction Mode");

            System.out.println("[R]eserve\n" + "[V]iew\n" + "[C]ancel\n" + "[O]ut");
            input = br.readLine();
            if (input.equalsIgnoreCase("r")) {
                //begin reservation session
                reservationSession(br, reservations, c);

            } else if (input.equalsIgnoreCase("v")) {

                //list user reservations
            } else if (input.equalsIgnoreCase("c")) {
                //begin cancellation session
            } else if (input.equalsIgnoreCase("o")) {
                ArrayList<Double> listOfTotalPrices = new ArrayList<>();

                for (String key : c.getShowReservations().keySet()) {
//                    System.out.println(key);
                    DateTimeFormatter formattedDateTimeString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime dateTime = LocalDateTime.parse(key, formattedDateTimeString);
                    if ((dateTime.getMonth() == Month.DECEMBER && dateTime.getDayOfMonth() == 27) || (dateTime.getMonth() == Month.DECEMBER && dateTime.getDayOfMonth() == 26)) {
                        // do not apply group discounts
                    }
//                    System.out.println(dateTime.getMonth());
//                    System.out.println(dateTime.getDayOfMonth());
//                    System.out.println(dateTime.getMonth() + " " + dateTime.getDayOfMonth());

                }

                break;
            } else {
                System.out.println("Invalid Input!");
            }
        } while (true);
    }

    private static void reservationSession(BufferedReader br, ArrayList<Seat> reservations, Customer c) throws IOException {
        String dateTime = null;
        String input;
        printNiceMessage("Reservation Session");

        do {

            System.out.println("==================");
            for (String key : Database_Of_Shows.keySet()) {
                System.out.println("|" + key + "|");
            }
            System.out.println("==================");
            System.out.println("Enter a date and time : (input must follow the date format: `2020-01-23 18:30`) or press quit (q)");
            input = br.readLine();
            if (input.equalsIgnoreCase("q") && dateTime == null) {
                break;
            } else if (input.equalsIgnoreCase("q") && dateTime != null) {
                c.addReservation(dateTime, reservations);
                break;
            } else {
                dateTime = input;
            }
            if (Database_Of_Shows.containsKey(dateTime)) {
                ArrayList<Seat> seatListReference = Database_Of_Shows.get(dateTime);
                do {
                    printNiceMessage("Seat Selection");
                    int i = 0;
                    for (Seat s : seatListReference) {
                        System.out.println(" [ " + i + " ] " + s.toString());
                        i += 1;
                    }
                    printNiceMessage("User Reservations");
                    for (Seat s : reservations) {
                        System.out.println(s.toString());
                    }
                    System.out.println("Select a seat or press quit(q)");
                    input = br.readLine();
                    if (input.equalsIgnoreCase("q")) {
                        break;
                    }
                    if (onlyDigits(input)) {
                        int seatNum = Integer.parseInt(input);
                        if (seatNum < 0 || seatNum >= seatListReference.size()) {
                            System.out.println("Does not exist");
                        } else {
                            Seat s = seatListReference.get(seatNum);
                            s.setAvailable(false);
                            reservations.add(s);
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                } while (true);
            } else {
                System.out.println("Does not exist!");
            }
        } while (true);
    }

}




