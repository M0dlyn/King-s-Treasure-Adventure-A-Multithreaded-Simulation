package Producer_Consumer;
import Valuables.*;
import Deposit.Deposit;

import java.util.Random;

public class Miner implements Runnable {
    // Miner jest producerem
    private final Deposit<Valuables> deposit;

    public Miner(Deposit<Valuables> deposit) {
        this.deposit = deposit;
    }

    private synchronized void Mine() throws InterruptedException {
        Random randomNumbers = new Random();
        int number = randomNumbers.nextInt(1, 7);
        switch (number) {
            case 0:
                deposit.put(Valuables.getInstance(ValuablesType.WOODENCOIN));
                Log.getInstance().logAction("Miner mined the Wooden Coin");
                break;
            case 1:
                deposit.put(Valuables.getInstance(ValuablesType.GOLDNUGGET));
                Log.getInstance().logAction("Miner mined the Gold Nugget");
                break;
            case 2:
                deposit.put(Valuables.getInstance(ValuablesType.RUBY));
                Log.getInstance().logAction("Miner mined the Ruby");
                break;
            case 3:
                deposit.put(Valuables.getInstance(ValuablesType.JEWEL));
                Log.getInstance().logAction("Miner mined the Jewel");
                break;
            case 4:
                deposit.put(Valuables.getInstance(ValuablesType.SAPPHIRE));
                Log.getInstance().logAction("Miner mined the Sapphire");
                break;
            case 5:
                deposit.put(Valuables.getInstance(ValuablesType.EMERALD));
                Log.getInstance().logAction("Miner mined the Emerald");
                break;
            case 6:
                deposit.put(Valuables.getInstance(ValuablesType.DIAMOND));
                Log.getInstance().logAction("Miner mined the DIAMOND");
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Log.getInstance().logAction("Miner is mining...");
                Mine();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Log.getInstance().logAction("Miner is sleeping...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
