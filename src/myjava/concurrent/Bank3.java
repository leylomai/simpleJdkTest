package myjava.concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank3 {
    private ReentrantReadWriteLock rwl;
    private ReentrantReadWriteLock.ReadLock readLock;
    private ReentrantReadWriteLock.WriteLock writeLock;

    //账户数
    private final double[] accounts;
    private Condition sufficientFunds;

    public Bank3(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        rwl = new ReentrantReadWriteLock();
        readLock = rwl.readLock();
        writeLock = rwl.writeLock();
        sufficientFunds = writeLock.newCondition();
    }

    public int size() {
        return accounts.length;
    }

    public double getTotalBalance() {
        readLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }

            return sum;
        } finally {
            readLock.unlock();
        }
    }

    public void transfer(int from, int to, double amount) {
        writeLock.lock();
        try {
//            if (accounts[from] < amount)
//                return;
            try {
                while (accounts[from] < amount)
                    sufficientFunds.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            writeLock.unlock();
        }

    }
}
