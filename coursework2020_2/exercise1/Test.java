package CSC8002AdvancedProgrammingCoursework2.exercise1;

public class Test {
    public static void main(String[] args) throws InterruptedException
    {
        final int N = 3;
        final int[] interval = {2,5,10};
        BinarySemaphore tick = new BinarySemaphore(0);
        BinarySemaphore[] start = new BinarySemaphore[N];
        for (int i=0; i<start.length; i++)
            start[i] = new BinarySemaphore(0);

        Clock clock = new Clock(tick);
        Scheduler scheduler = new Scheduler(tick, start, interval);
        Task[] task = new Task[N];
        for (int i=0; i<task.length; i++)
            task[i] = new Task(i,start[i]);

        clock.start();
        scheduler.start();
        for (int i=0; i<task.length; i++)
            task[i].start();

        Thread.sleep(20000);

        System.exit(0);
    }
}
