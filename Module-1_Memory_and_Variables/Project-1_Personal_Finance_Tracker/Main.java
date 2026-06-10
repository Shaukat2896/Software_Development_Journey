import java.util.*;

public class Main {

    public double addExpense(int expenses, Scanner sc) {
        double totalExpense = 0;

        for (int i = 1; i <= expenses; i++) {
            System.out.print("Enter name of the expense: ");
            String expenseName = sc.nextLine();

            System.out.printf("Enter the expense of %s: ", expenseName);
            double expenseAmount = sc.nextDouble();
            sc.nextLine(); // consume leftover newline

            totalExpense += expenseAmount;
        }

        return totalExpense;
    }

    public double savingsPercentage(double monthlySalary, double expense) {
        double savings = monthlySalary - expense;
        return (savings / monthlySalary) * 100;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        System.out.println("==== Welcome to the HiddenCrafts Application ====");

        while (true) {

            System.out.println("\nSelect any one option:");
            System.out.println("1. Expense Tracker");
            System.out.println("2. Exit");
            System.out.print("Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter your monthly income: ");
                    double salary = sc.nextDouble();

                    System.out.print("Enter how many expenses you have this month: ");
                    int expenses = sc.nextInt();

                    sc.nextLine(); // consume newline before entering expense names

                    double totalExpenses = m.addExpense(expenses, sc);

                    double savingsPercent =
                            m.savingsPercentage(salary, totalExpenses);

                    double remainingBalance =
                            salary - totalExpenses;

                    System.out.println("\n===== MONTHLY FINANCE REPORT =====");

                    System.out.printf("Monthly Income      : %.2f%n", salary);
                    System.out.printf("Total Expenses      : %.2f%n", totalExpenses);
                    System.out.printf("Remaining Balance   : %.2f%n", remainingBalance);
                    System.out.printf("Savings Percentage  : %.2f%%%n", savingsPercent);

                    break;

                case 2:

                    System.out.println("Thank you for using the application.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice !!!");
            }
        }
    }
}