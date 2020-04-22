package CSC8002AdvancedProgrammingCoursework2.exercise1;

public class Task extends Thread {
    private int id;
    private BinarySemaphore myStart;

    public Task(int id, BinarySemaphore s)
    {
        myStart = s;
        this.id = id;
    }

    public void run()
    {
        int count = 0;
        while (true)
        {
            try {
                myStart.P();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println("Task no. " + id +
                    " has been performed (" + count + ")");
        }
    }
}
