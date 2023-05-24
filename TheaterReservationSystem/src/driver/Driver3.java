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


    //populate global database of shows user can access
    public static void initializeShowDatabase() {
        LocalDateTime startDate_6_30 = LocalDateTime.of(2020, Month.DECEMBER, 23, 18, 30);
        LocalDateTime endDate_6_30 = LocalDateTime.of(2021, Month.JANUARY, 2, 18, 30);
        LocalDateTime startDate_8_30 = LocalDateTime.of(2020, Month.DECEMBER, 23, 20, 30);
        LocalDateTime endDate_8_30 = LocalDateTime.of(2021, Month.JANUARY, 2, 20, 30);
        generateShows(startDate_6_30, endDate_6_30);
        generateShows(startDate_8_30, endDate_8_30);
    }


    //generate a list of seats and a date time to represent a show
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


        }


    }

    //miscellaneous function used to check if string inputs are composed of digits
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

    //function used to generate unique confirmation numbers
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

    //miscellaneous function used to print nice display messages
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
        initializeShowDatabase();
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
                        //print receipt data

                        //handle receipt data if we want to "charge" customer
                    }
                    //display customer's receipt
                }
            }
        } while (true);

    }

    private static void transactionSession(BufferedReader br, Customer c) throws IOException {
        String input;
        //list of seat reservations made during transaction session

        //when user clicks "O", end transaction session and terminate temporary list of seats
        ArrayList<Seat> reservations;
        do {
            printNiceMessage("Transaction Mode");
            System.out.println("[R]eserve\n" + "[V]iew\n" + "[C]ancel\n" + "[O]ut");
            input = br.readLine();
            if (input.equalsIgnoreCase("r")) {
                //begin reservation session
                reservationSession(br, c);
            } else if (input.equalsIgnoreCase("v")) {
                //list user reservations
            } else if (input.equalsIgnoreCase("c")) {
                //begin cancellation session
            } else if (input.equalsIgnoreCase("o")) {
                DateTimeFormatter formattedDateTimeString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                for (String key : c.getShowReservations().keySet()) {
                    double totalPrice = 0;
                    System.out.println("DateTime: " + key);
                    printNiceMessage("Prices");
                    LocalDateTime dateTime = LocalDateTime.parse(key, formattedDateTimeString);
                    if ((dateTime.getMonth() == Month.DECEMBER && dateTime.getDayOfMonth() == 27) || (dateTime.getMonth() == Month.DECEMBER && dateTime.getDayOfMonth() == 26)) {
                        //no group discount during discount night
                        for (Seat s : c.getShowReservations().get(key)) {
                            System.out.println(" $" + s.getSeatPrice());
                            totalPrice += s.getSeatPrice();
                        }
                    } else {
                        int personCount = 0;
                        for (Seat s : c.getShowReservations().get(key)) {
                            System.out.println(" $" + s.getSeatPrice());
                            totalPrice += s.getSeatPrice();
                            personCount += 1;
                        }
                        if (personCount >= 5 && personCount <= 10) {
                            totalPrice -= 2 * personCount;
                        } else if (personCount >= 11 && personCount <= 20) {
                            totalPrice -= 5 * personCount;
                        }
                    }
                    printNiceMessage("Total Price:");
                    System.out.println("$" + totalPrice);
                }

                break;
            } else {
                System.out.println("Invalid Input!");
            }
        } while (true);
    }

    public static void reservationSession(BufferedReader br, Customer c) throws IOException {
        String seatStr;
        String dateTime;
        printNiceMessage("Reservation Session");
        do {
            System.out.println("==================");
            for (String key : Database_Of_Shows.keySet()) {
                System.out.println("|" + key + "|");
            }
            System.out.println("==================");
            System.out.println("Enter a date and time : (input must follow the date format: `2020-01-23 18:30`) or press quit (q)");
            dateTime = br.readLine();
            if (dateTime.equalsIgnoreCase("q")) {
                break;
            } else if (Database_Of_Shows.containsKey(dateTime)) {
                ArrayList<Seat> userReservations = new ArrayList<>();
                ArrayList<Seat> showSeats = Database_Of_Shows.get(dateTime);
                do {

                    printNiceMessage("Seat Selection");
                    int i = 0;
                    for (Seat s : showSeats) {
                        System.out.println(" [ " + i + " ] " + s.toString());
                        i += 1;
                    }

                    printNiceMessage("User Reservations");
                    for (Seat s : userReservations) {
                        System.out.println(s.toString());
                    }
                    System.out.println("Enter a seat number or press quit (q)");
                    seatStr = br.readLine();
                    if (seatStr.equalsIgnoreCase("q")) {
                        c.addReservation(dateTime, userReservations);
                        break;
                    }
                    if (onlyDigits(seatStr)) {
                        int seatNum = Integer.parseInt(seatStr);
                        if (seatNum < 0 || seatNum >= showSeats.size()) {
                            System.out.println("Seat does not exist!");
                        } else {
                            Seat s = showSeats.get(seatNum);
                            if (s.isAvailable()) {
                                s.setAvailable(false);
                                userReservations.add(s);
                            } else {
                                System.out.println("Seat not available");
                            }

                        }

                    } else {
                        System.out.println("Invalid Input!");
                    }


                } while (true);
            }
        } while (true);
    }

}




