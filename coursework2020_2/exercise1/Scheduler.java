package CSC8002AdvancedProgrammingCoursework2.exercise1;

public class Scheduler extends Thread {
    private int[] interval;
    private int[] next;
    private BinarySemaphore[] start;
    private BinarySemaphore tick;

    public Scheduler(BinarySemaphore t, BinarySemaphore[] s, int[] interval)
    {
        tick = t;
        start = s;
        this.interval = interval;
        next = new int[interval.length];
        for (int i=0; i<interval.length; i++) next[i] = interval[i];
    }



    public void run()
    {
        while (true)
        {
            try {
                tick.P();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0; i<next.length; i++)
            {
                next[i]--;
                if (next[i] == 0)
                {
                    next[i] = interval[i];
                    start[i].V();
                }
            }
        }
    }
}
