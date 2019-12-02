package coursework3;

import java.io.FileReader;
import java.util.Scanner;

public class Menu {
    private SortedArrayList<Client> clientList = new SortedArrayList<>();
    private SortedArrayList<Event> eventList = new SortedArrayList<>();

    private void fileReader() {
        try {
            Scanner inFile = new Scanner(new FileReader("/Users/huyf/Desktop/java/src/coursework3/file.txt"));
            String temp = inFile.nextLine();
            //System.out.println(temp);
            int eventLength = Integer.parseInt(temp);
            String key;
            String t;
            while(eventLength > 0){
                key = inFile.nextLine();
                //System.out.println(key);
                t = inFile.nextLine();
                //System.out.println(t);
                Event event = new Event(key, Integer.parseInt(t));
                eventList.insert(event);
                eventLength--;
            }
            //int registeredClientCount = Integer.parseInt(inFile.nextLine());
            inFile.nextLine();
            while (inFile.hasNextLine()) {
                String tempName = inFile.nextLine();
                String[] stringList;
                stringList = tempName.split(" ");
                Client c = new Client(stringList[0], stringList[1]);
                clientList.insert(c);
            }
            //eventList.show(eventTicketMap);

            inFile.close();
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    private void startMenu() {
        Scanner startMenuScanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("f: finish running the program");
        System.out.println("e: display events information");
        System.out.println("c: display clients information");
        System.out.println("b: buy tickets");
        System.out.println("r: returns tickets");
        System.out.println("-------------------------------------");
        System.out.println("\n");
        char choice = startMenuScanner.next().charAt(0);
        while (true) {
            try {
                //System.out.println("");
                //System.out.println("");
                if (choice == 'e') {
                    displayEventsInfo();
                } else if (choice == 'c') {
                    displayClientsInfo();
                } else if (choice == 'b') {
                    buyTickets();
                } else if (choice == 'r') {
                    returnTickets();
                } else if (choice == 'f') {
                    return;
                } else {
                    warning();
                }
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println("f: finish running the program");
                System.out.println("e: display events information");
                System.out.println("c: display clients information");
                System.out.println("b: buy tickets");
                System.out.println("r: returns tickets");
                System.out.println("-------------------------------------");
                System.out.println("\n");
                choice = startMenuScanner.next().charAt(0);
            }
            catch (Exception e) {
                //System.out.println("?");
                warning();
                //e.printStackTrace();
            }
        }

    }

    private void returnTickets() {
        Scanner returnTicketsScanner = new Scanner(System.in);
        System.out.println("Please type in the name of client");
        String clientName = returnTicketsScanner.nextLine();
        String[] stringList;
        stringList = clientName.split(" ");
        Client tempClient = new Client(stringList[0], stringList[1]);
        for (Client client : clientList) {
            if (client.compareTo(tempClient) == 0) {
                System.out.println("Please type in the name of event");
                String eventName = returnTicketsScanner.nextLine();
                //
                Event tempEvent = new Event(eventName, 0);
                for (Event event : eventList) {
                    if (event.compareTo(tempEvent) == 0) {
                        System.out.println("Please type in the number of tickets you wanna return");
                        int numberOfTicketsClientWannaReturn = returnTicketsScanner.nextInt();
                        boolean returnTag = client.returnTicket(eventName, numberOfTicketsClientWannaReturn);
                        if (!returnTag) {
                            System.out.println("sorry");
                            System.out.println("you have not bought tickets for this event ");
                            System.out.println("or you do not have enough tickets to return");
                            System.out.println();
                            System.out.println();
                            return;
                        }
                        System.out.println("congrats");
                        System.out.println("you are all set!");
                        event.updateEventUnsoldTicketsNumber(event.getEventUnsoldTicketsNumber() + numberOfTicketsClientWannaReturn);
                        System.out.println();
                        System.out.println();
                        return;
                    }
                }
                System.out.println("this event is not in the list");
                System.out.println("please double check it");
                System.out.println();
                System.out.println();
                return;
            }
        }
        System.out.println("this client is not in the list");
        System.out.println("please double check it");
        System.out.println();
        System.out.println();
    }

    private void buyTickets() {
        Scanner buyTicketsScanner = new Scanner(System.in);
        System.out.println("Please type in the name of client");
        String clientName = buyTicketsScanner.nextLine();
        String[] stringList;
        stringList = clientName.split(" ");
        Client tempClient = new Client(stringList[0], stringList[1]);
        for (Client client : clientList) {
            if (client.compareTo(tempClient) == 0) {
                System.out.println("Please type in the name of event");
                String eventName = buyTicketsScanner.nextLine();
                Event tempEvent = new Event(eventName, 0);
                for (Event event : eventList) {
                    if (event.compareTo(tempEvent) == 0) {
                        System.out.println("Please type in the number of tickets you wanna buy");
                        int numberOfTicketsToBuy = buyTicketsScanner.nextInt();
                        int currentUnsoldTicketsNumber = event.getEventUnsoldTicketsNumber();
                        if (currentUnsoldTicketsNumber >= numberOfTicketsToBuy) {
                            boolean buyTag = client.buyTicket(eventName, numberOfTicketsToBuy);
                            if (!buyTag) {
                                System.out.println("sorry");
                                System.out.println("you have already ordered 3 kinds of events");
                                System.out.println();
                                System.out.println();
                                return;
                            }
                            System.out.println("congrats");
                            System.out.println("you are all set!");
                            event.updateEventUnsoldTicketsNumber(currentUnsoldTicketsNumber - numberOfTicketsToBuy);
                            System.out.println();
                            System.out.println();
                            return;
                        } else {
                            System.out.println("sorry");
                            System.out.println("we do not have enough tickets");
                            System.out.println();
                            System.out.println();
                            return;
                        }
                    }
                }
                System.out.println("this event is not in the list");
                System.out.println("please double check it");
                System.out.println();
                System.out.println();
                return;
            }
        }
        System.out.println("this client is not in the list");
        System.out.println("please double check it");
        System.out.println();
        System.out.println();
    }

    private void displayClientsInfo() {
        Scanner displayClientsInfoScanner = new Scanner(System.in);
        for (Client client : clientList) {
            System.out.println(client.getClientFirstName() + " " + client.getClientLastName());
            for (String key : client.getBoughtEvent().keySet()) {
                System.out.println(key + "=" + client.getBoughtEvent().get(key));
            }
        }

        System.out.println("what ya gonna do next?");
        System.out.println("press 1 to continue");
        System.out.println("press 2 then back to the start menu");
        int displayClientsInfoChoice = displayClientsInfoScanner.nextInt();
        if (displayClientsInfoChoice == 1) {
            displayClientsInfo();
        }
    }

    private void displayEventsInfo() {
        Scanner displayEventsInfoScanner = new Scanner(System.in);
        for (Event event : eventList) {
            System.out.println(event.getEventUnsoldTicketsNumber() + " " + event.getEventName());
        }

        System.out.println("what ya gonna do next?");
        System.out.println("press 1 to continue");
        System.out.println("press 2 then back to the start menu");
        int displayEventsInfoChoice = displayEventsInfoScanner.nextInt();
        if (displayEventsInfoChoice == 1) {
            displayEventsInfo();
        }
    }

    private void warning() {
        Scanner warningScanner = new Scanner(System.in);
        System.out.println("Warning !!!");
        System.out.println("please follow the UI instructions");
        System.out.println("\n");
        System.out.println("Press any key to proceed...");
        String waitKey = warningScanner.nextLine();
    }

    public static void main(String[] args) {
        //sc.useDelimiter("/n");
        Menu menu = new Menu();
        menu.fileReader();
        menu.startMenu();
    }
}
