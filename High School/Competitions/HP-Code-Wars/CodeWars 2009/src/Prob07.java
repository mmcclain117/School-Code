
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: Ponzi Calculator
//        Points: 5
        Scanner scan = new Scanner(new File("prob07.txt"));
        int aPI = scan.nextInt(); // AmountPerInvester
        int iPM = scan.nextInt(); // IncestorsPerMonth
        int iPY = scan.nextInt(); // Interst Per Year
        System.out.println("Investment Cost (per person) $: " + aPI + "\n"
                + "New Investors (per month): " + iPM + "\n"
                + "Guaranteed Annual Interest Rate (%): " + iPY + "");
        System.out.println();

        PonziCalculator calculator = new PonziCalculator(aPI, iPM, iPY);
        System.out.println("Month Investors Begin Balance  Interest Paid  End Balance");
        System.out.println("----- --------- -------------- -------------- ---------------");
        while (!calculator.isDone()) {
            calculator.nextMonth();
            calculator.printMonthsResults();
        }
        calculator.printResults();

    }

}

class PonziCalculator {

    private static int targetProfit = 10000000;

    private int investorsPerMonth;
    private int amountPerInvestor;
    private float interestPerMonth;

    private int month;
    private int investorCount;
    private int startBalance;
    private int endBalance;
    private int interestPaid;

    /**
     * Constructs a new ponzi calculator that can run one simulation of the
     * scam.
     *
     * @param amountPerInvestor The amount of money each investor invests.
     * @param investorsPerMonth The number of new investors each month.
     * @param interestPerYear The amount of interest the investors will earn
     * over a year. This is in percentage form.
     */
    public PonziCalculator(int amountPerInvestor, int investorsPerMonth, int interestPerYear) {
        this.amountPerInvestor = amountPerInvestor;
        this.investorsPerMonth = investorsPerMonth;
        this.interestPerMonth = interestPerYear / 12.0f / 100;

        month = 0;
        investorCount = 0;
        startBalance = 0;
        endBalance = 0;
        interestPaid = 0;
    }

    /**
     * Calculates the results for the next month.
     */
    public void nextMonth() {
        ++month;
        investorCount += investorsPerMonth;
        startBalance = endBalance + (investorsPerMonth * amountPerInvestor);
        interestPaid = (int) (investorCount * amountPerInvestor * interestPerMonth);
        endBalance = startBalance - interestPaid;
    }

    /**
     * Returns true when the ponzi experiment has either failed or succeeded.
     * This returns false when the experiment should continue.
     */
    public boolean isDone() {
        return endBalance < 0 || startBalance >= targetProfit;
    }

    /**
     * Prints the header for the table.
     */
    public void printHeader() {
        System.out.println("Month Investors Begin Balance  Interest Paid  End Balance");
        System.out.println("----- --------- -------------- -------------- ---------------");
    }

    /**
     * Prints the results for the current month.
     */
    public void printMonthsResults() {
        System.out.printf("%-6d %-10d $%-13d $%-13d $%-13d\n", month, investorCount, startBalance, interestPaid, endBalance);
    }

    /**
     * Prints the final results of the ponzi experiment. The method isDone()
     * should return true before calling this method.
     */
    public void printResults() {
        System.out.println();
        if (endBalance < 0) {
            System.out.println("Abort Project Emu Farms!");
        } else if (startBalance >= targetProfit) {
            System.out.println("Total Balance at beginning of Month " + month + " is $" + startBalance);
            System.out.println("Purple Horseshow loves Emu Farms!");
        }
        System.out.println();
    }
}
