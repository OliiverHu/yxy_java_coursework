package coursework3;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client implements Comparable<Client> {
    private String clientFirstName;
    private String clientLastName;
    private int maxBoughtEventSize = 3;
    private Map<String, Integer> boughtEvent = new HashMap<>();

    Client(String fname, String lname) {
        clientFirstName = fname;
        clientLastName = lname;
    }

//    boolean setBoughtEvent(String event, int number) {
//        if (boughtEvent.size() <= 2) {
//            boughtEvent.put(event, number);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    String getClientFirstName() {
        return clientFirstName;
    }

    String getClientLastName() {
        return clientLastName;
    }

    Map<String, Integer> getBoughtEvent() {
        return boughtEvent;
    }

    public boolean returnTicket(String eventName, int returnTicketsNumber) {
        if (boughtEvent.containsKey(eventName)) {
            int currentTickets = boughtEvent.get(eventName);
            if (currentTickets < returnTicketsNumber) {
                return false; // the client does not have enough tickets to return
            }
            else if (currentTickets > returnTicketsNumber) {
                boughtEvent.replace(eventName, currentTickets - returnTicketsNumber);
                return true;
            }
            else {
                boughtEvent.remove(eventName);
                return true;
            }
        }
        else {
            return false; // the client does not order tickets for this event
        }
    }

    boolean buyTicket(String eventName, int ticketsNumber) {
        if (boughtEvent.size() <= maxBoughtEventSize) {
            if (boughtEvent.containsKey(eventName)) {
                int currentTickets = boughtEvent.get(eventName);
                boughtEvent.replace(eventName, currentTickets + ticketsNumber);
                return true;
            }
            else {
                boughtEvent.put(eventName, ticketsNumber);
                return true;
            }
        }
        else {
            return false; // each client can only buy at most tickets for 3 events
        }
    }

    @Override
    public int compareTo(Client o) {
        String tempFirstName = o.getClientFirstName();
        String tempLastName = o.getClientLastName();
        if (-tempLastName.compareTo(clientLastName) == 0) {
            return  -tempFirstName.compareTo(clientFirstName);
        }
        else {
            return -tempLastName.compareTo(clientLastName);
        }
    }

    public static void main(String[] args) {
        SortedArrayList<Client> clientList = new SortedArrayList<>();
        try {
            Scanner inFile = new Scanner(new FileReader("/Users/huyf/Desktop/java/src/coursework3/file.txt"));
            String temp = inFile.nextLine();
            //System.out.println(temp);
            int eventLength = 2 * Integer.parseInt(temp);
            //String key = "0";
            while (eventLength > 0) {
                inFile.nextLine();
                eventLength--;
            }
            //int registeredClientCount = Integer.parseInt(inFile.nextLine());
            while (inFile.hasNextLine()) {
                String tempName = inFile.nextLine();
                String[] stringList;
                stringList = tempName.split(" ");
                Client c = new Client(stringList[0], stringList[1]);
                clientList.insert(c);
            }
            for (Client client : clientList) {
                System.out.println(client.getClientFirstName() + " " + client.getClientLastName());
            }
            inFile.close();
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
