package Producer_Consumer;
import Valuables.*;
import Deposit.Deposit;

import java.util.Random;

public class Miner implements Runnable {
    private final Deposit<Valuables> deposit;

    public Miner(Deposit<Valuables> deposit) {
        this.deposit = deposit;
    }

    private void Mine() throws InterruptedException {
        Random randomNumbers = new Random();
        int number = randomNumbers.nextInt(1, 7);
        switch (number) {
            case 0:
                deposit.put(Valuables.getInstance(ValuablesType.WOODENCOIN));
                break;
            case 1:
                deposit.put(Valuables.getInstance(ValuablesType.GOLDNUGGET));
                break;
            case 2:
                deposit.put(Valuables.getInstance(ValuablesType.RUBY));
                break;
            case 3:
                deposit.put(Valuables.getInstance(ValuablesType.JEWEL));
                break;
            case 4:
                deposit.put(Valuables.getInstance(ValuablesType.SAPPHIRE));
                break;
            case 5:
                deposit.put(Valuables.getInstance(ValuablesType.EMERALD));
                break;
            case 6:
                deposit.put(Valuables.getInstance(ValuablesType.DIAMOND));
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Mine();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}