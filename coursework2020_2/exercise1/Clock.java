package CSC8002AdvancedProgrammingCoursework2.exercise1;

public class Clock extends Thread {
    private BinarySemaphore tick;

    public Clock(BinarySemaphore s)
    {
        tick = s;
    }

    public void run()
    {
        while (true)
        {
            try {sleep(1000);}
            catch (InterruptedException e){}
            tick.V();
        }
    }
}
