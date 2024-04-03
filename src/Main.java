import jdk.jfr.Percentage;

import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12; // Constant months in year
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();


        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float percentageAnnualInterestRate = scanner.nextFloat();

        System.out.print("Period (Years): ");
        int periodYears = scanner.nextInt();
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