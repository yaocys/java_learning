import lombok.AllArgsConstructor;

/**
 * 以转账
 *
 * @author yaosunique@gmail.com
 * 2024/7/21 20:59
 */
public class TransferMoney implements Runnable {

    static class Account {
        int balance;

        public Account(int balance) {
            this.balance = balance;
        }
    }

    public int flag;
    static Account account1 = new Account(1000);
    static Account account2 = new Account(500);

    @Override
    public void run() {
        // 这里其实是两笔互相转账的操作导致的死锁
        if (flag == 1) transferMoney(account1, account2, 500);
        if (flag == 2) transferMoney(account2, account1, 500);
    }

    private void transferMoney(Account from, Account to, int amount) {
        synchronized (from) {
            System.out.println(Thread.currentThread().getName() + "获取到第一把锁");
            // 确保两把锁分别被不同的线程先拿到，发生死锁
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + "获取到第二把锁");
            }
            if (from.balance - amount < 0) {
                System.out.println("余额不足，转账失败。");
                return;
            }
            from.balance -= amount;
            to.balance += amount;
            System.out.println("成功转账" + amount + "元");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 2;
        Thread t1 = new Thread(r1, "第一笔转账");
        Thread t2 = new Thread(r2, "第二笔转账");
        t1.start();
        t2.start();
        // 这里的两个join操作是为了保证下面打印余额前两笔转账完成
        t1.join();
        t2.join();
        System.out.println("账户1的余额为：" + account1.balance);
        System.out.println("账户2的余额为：" + account2.balance);
    }
}
