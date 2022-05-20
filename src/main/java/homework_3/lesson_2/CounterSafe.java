package homework_3.lesson_2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterSafe {
    private static volatile int count = 0;
    private static volatile int numberOfIncrements = 0;
    private static volatile int numberOfDecrements = 0;
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void increment(){
        lock.writeLock().lock();
        count ++;
        numberOfIncrements ++;
        lock.writeLock().unlock();
    }

    public static void decrement(){
        lock.writeLock().lock();
        count --;
        numberOfDecrements ++;
        lock.writeLock().unlock();
    }

    public static void getCount(){
        lock.readLock().lock();
        System.out.println("After " + numberOfIncrements + " increments," +
                " and "+ numberOfDecrements + " decrements: " + count);
        lock.readLock().unlock();
    }
}
