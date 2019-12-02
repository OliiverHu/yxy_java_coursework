package coursework3;

import java.io.FileReader;
import java.util.*;

public class Event implements Comparable<Event> {
    private String eventName;
    private int unsoldTickets;

    Event(String name, int numberOfTickets) {
        eventName = name;
        unsoldTickets = numberOfTickets;
    }

    Event(String name) {
        eventName = name;
        //unsoldTickets = numberOfTickets;
    }

    String getEventName() {
        return eventName;
    }

    int getEventUnsoldTicketsNumber() {
        return unsoldTickets;
    }

    void updateEventUnsoldTicketsNumber(int num) {
        unsoldTickets = num;
    }

    public void returnTicket() {
        unsoldTickets += 1;
    }

    public boolean buyTicket() {
        if (unsoldTickets == 0) {
            return false;
        }
        else {
            unsoldTickets -= 1;
            return true;
        }
    }

    @Override
    public int compareTo(Event o) {
        String tempName = o.getEventName();
        return -tempName.compareTo(eventName);
    }

    public static void main(String[] args) {
        SortedArrayList<Event> eventList = new SortedArrayList<Event>();

        try {
            Scanner inFile = new Scanner(new FileReader("/Users/huyf/Desktop/java/src/coursework3/file.txt"));
            String temp = inFile.nextLine();
            //System.out.println(temp);
            int eventLength = Integer.parseInt(temp);
            String key = "0";
            int n = 0;
            String t = "0";
//            while (eventLength > 0) {
//                if (eventLength % 2 == 0) {
//                    key = inFile.nextLine();
//                }
//                else {
//                    n = inFile.nextInt();
//                }
//                Event event = new Event(key, );
//                eventLength--;
//            }
            while(eventLength > 0){
                key = inFile.nextLine();
                //System.out.println(key);
                t = inFile.nextLine();
                //System.out.println(t);
                Event event = new Event(key, Integer.parseInt(t));
                eventList.insert(event);
                eventLength--;
            }
            for (int i = 0; i < eventList.size(); i++) {
                System.out.println(eventList.get(i).getEventName());
                System.out.println(eventList.get(i).getEventUnsoldTicketsNumber());
            }

            inFile.close();
        }
        catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
