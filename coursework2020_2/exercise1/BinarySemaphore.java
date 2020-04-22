package CSC8002AdvancedProgrammingCoursework2.exercise1;

public class BinarySemaphore extends Semaphore {

    public BinarySemaphore() {
        super();
    }

    public BinarySemaphore(int initial) {
        super((initial>0) ? 1 : 0);
    }

    @Override
    public synchronized void V() {
//        super.V();
        super.value = 1;
        notify();
    }
}
