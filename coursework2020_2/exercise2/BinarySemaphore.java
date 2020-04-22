package CSC8002AdvancedProgrammingCoursework2.exercise2;

public class BinarySemaphore extends Semaphore {

    public BinarySemaphore() {
        super();
    }

    public BinarySemaphore(int initial) {
        super((initial>0) ? 1 : 0);
    }
}
