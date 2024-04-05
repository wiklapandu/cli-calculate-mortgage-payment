import jdk.jfr.Percentage;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        calculateMortgagePayment();

//        int income = 120_000;
//        highIncomeLowIncome(income);
        // loopCase();
    }

    public static void loopCase()
    {
        for (int i = 0; i < 5; i++) {
            System.out.println("loop index: "+i);
        }

        String[] items = {"one", "two", "three"};

        // ? Foreach in java
        // ! Limitation
        /*
         * - Can't replace the value of item if use foreach
         * - Can't get index of each item
         * */
        for (String item : items) {
            System.out.println("item: " + item);
        }
    }

    public static void highIncomeLowIncome(int income)
    {
        roleWelcome("admin");
        final int MIN_HIGH_INCOME = 100_000;
        String className = (income > MIN_HIGH_INCOME) ? "High Income" : "Lower Income";
        System.out.println("You are " + className + " class");
    }

    public static void roleWelcome(String role)
    {

        // Full Switch Case
        // String message = "Welcome my guest!";

//        switch (role) {
//            case "admin":
//                message = "Welcome my admin!";
//                break;
//            case "subscriber":
//                message = "Welcome my Subscriber!";
//                break;
//            default:
//                message = "Welcome my guest!";
//                break;
//        }

        /* Inline Switch Case */
        String message = switch (role) {
            case "admin" -> "Welcome my admin!";
            case "subscriber" -> "Welcome my Subscriber!";
            default -> "Welcome my guest!";
        };

        System.out.println(message);
    }

    public static void calculateMortgagePayment()
    {
        final byte MONTHS_IN_YEAR = 12; // Constant months in year
        final byte PERCENT = 100;
        final int MIN_LIMIT_PRINCIPAL = 1000;
        final int MAX_LIMIT_PRINCIPAL = 1000000;

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        int principal = 0;

        boolean validationPrincipal = true;
        while (validationPrincipal) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();

            if (!(principal >= MIN_LIMIT_PRINCIPAL && principal <= MAX_LIMIT_PRINCIPAL)) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
                continue;
            }
            validationPrincipal = false;
        }

        float percentageAnnualInterestRate = 0f;
        boolean validationPercentageAnnualInterestRate = true;
        while (validationPercentageAnnualInterestRate) {
            System.out.print("Annual Interest Rate: ");
            percentageAnnualInterestRate = scanner.nextFloat();

            if (!(percentageAnnualInterestRate > 0)) {
                System.out.println("Enter a value greater than 0 and less than or equal 1");
                continue;
            }
            validationPercentageAnnualInterestRate = false;
        }


        int periodYears = 0;
        boolean validationPeriod = true;
        while (validationPeriod) {
            System.out.print("Period (Years): ");
            periodYears = scanner.nextInt();

            if (!(periodYears >= 1 && periodYears <= 30)) {
                System.out.println("Enter a value between 1 and 30");
                continue;
            }

            validationPeriod = false;
        }

            int periodMonthly = periodYears * MONTHS_IN_YEAR;

            float monthlyInterest = (percentageAnnualInterestRate / PERCENT) / MONTHS_IN_YEAR;

            double monthlyInterestTimesPeriod = (monthlyInterest * Math.pow(1 + monthlyInterest, periodMonthly));
            double monthlyInterestTimesPeriodSecond = (Math.pow(1 + monthlyInterest, periodMonthly) - 1);

            double mortgage = principal * (monthlyInterestTimesPeriod / (monthlyInterestTimesPeriodSecond));
            double annuallyPayment = mortgage * MONTHS_IN_YEAR;

            System.out.println("Monthly Payment: " + currency.format(mortgage));
            System.out.println("Annually Payment: " + currency.format(annuallyPayment));
    }
}