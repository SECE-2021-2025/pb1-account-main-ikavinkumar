
public class Account {

    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return balance;
        }
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return balance;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Transaction failed.");
            return balance;
        }
        balance -= amount;
        return balance;
    }

    public int transferTo(Account other, int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return balance;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Transaction failed.");
            return balance;
        }
        debit(amount);
        other.credit(amount);
        return balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}
