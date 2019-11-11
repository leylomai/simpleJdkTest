package myjava.concurrent;

import java.util.Arrays;

public class Bank2 {
    private double[] accounts;

    public Bank2(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 转账
     *
     * @param from   转出账户
     * @param to     转入账户
     * @param amount 转移金额
     * @throws Exception 描述抛出异常原因
     * @author zhanlele
     * @date 20191111 22:17:31
     * @modify 20191111 zhanlele 创建
     */
    public synchronized void transfer(int from, int to, int amount) throws Exception {
        while (accounts[from] < amount)
            wait();
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
