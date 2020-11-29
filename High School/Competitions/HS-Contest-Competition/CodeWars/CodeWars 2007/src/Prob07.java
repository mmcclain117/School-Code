
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class Prob07 {

    static final int DRIVE_COSTS[] = {75, 110, 140, 250};

    static final int DRIVE_SIZES[] = {250, 400, 500, 750};

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob07.txt"));
        int cap = scan.nextInt(); // Memory
        int rl = scan.nextInt(); // Raidlevel
        switch (rl) {
            case 0:
                calculateRaidZero(cap);
                break;
            case 1:
                calculateRaidOne(cap);
                break;
            case 5:
                calculateRaidFive(cap);
                break;
        }
    }

    private static void calculateRaidZero(int capacity) {
        float arrayCost = 0;
        int diskPrice = 0;
        int driveCount = 0;
        int arrayCapacity = 0;
        String diskType = "";
        for (int i = 0; i < DRIVE_SIZES.length; i++) {
            int curCount = getNumDrivesNeeded(capacity, DRIVE_SIZES[i]);
            float curCost = (curCount * DRIVE_COSTS[i]);
            if (curCount > 8) {
                continue;
            }
            if ((arrayCost == 0) || curCost < arrayCost) {
                arrayCost = (curCount * DRIVE_COSTS[i]);
                arrayCapacity = (curCount * DRIVE_SIZES[i]);
                diskType = "" + DRIVE_SIZES[i] + "GB";
                diskPrice = DRIVE_COSTS[i];
                driveCount = curCount;
            }
        }
        System.out.println("Qty: " + driveCount + " Disk: " + diskType + " Price: $" + diskPrice);
        System.out.println("Total price of this " + arrayCapacity + "GB array: $" + (driveCount * diskPrice));
    }

    private static void calculateRaidOne(int capacity) {
        float arrayCost = 0;
        int diskPrice = 0;
        int driveCount = 0;
        int arrayCapacity = 0;
        String diskType = "";
        for (int i = 0; i < DRIVE_SIZES.length; i++) {
            int curCount = getNumDrivesNeeded(capacity, DRIVE_SIZES[i]);
            float curCost = (curCount * DRIVE_COSTS[i]);
            if (curCount > 4) {
                continue;
            }
            if ((arrayCost == 0) || curCost < arrayCost) {
                arrayCost = (curCount * DRIVE_COSTS[i]);
                arrayCapacity = (curCount * DRIVE_SIZES[i]);
                diskType = "" + DRIVE_SIZES[i] + "GB";
                diskPrice = DRIVE_COSTS[i];
                driveCount = curCount;
            }
        }
        driveCount *= 2;
        System.out.println("Qty: " + driveCount + " Disk: " + diskType + " Price: $" + diskPrice);
        System.out.println("Total price of this " + arrayCapacity + "GB array: $" + (driveCount * diskPrice));
    }

    private static void calculateRaidFive(int capacity) {
        float arrayCost = 0;
        int diskPrice = 0;
        int driveCount = 0;
        int arrayCapacity = 0;
        String diskType = "";
        for (int i = 0; i < DRIVE_SIZES.length; i++) {
            int curCount = getNumDrivesNeeded(capacity, DRIVE_SIZES[i]) + 1;
            float curCost = (curCount * DRIVE_COSTS[i]);
            if (curCount > 8) {
                continue;
            }
            if ((arrayCost == 0) || curCost < arrayCost) {
                arrayCost = (curCount * DRIVE_COSTS[i]);
                arrayCapacity = ((curCount - 1) * DRIVE_SIZES[i]);
                diskType = "" + DRIVE_SIZES[i] + "GB";
                diskPrice = DRIVE_COSTS[i];
                driveCount = curCount;
            }
        }
        System.out.println("Qty: " + driveCount + " Disk: " + diskType + " Price: $" + diskPrice);
        System.out.println("Total price of this " + arrayCapacity + "GB array: $" + (driveCount * diskPrice));
    }

    private static int getNumDrivesNeeded(int capacity, int driveSize) {
        return (int) Math.round(Math.ceil((float) capacity / (float) driveSize));
    }
}
