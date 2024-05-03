package Producer_Consumer;

import Deposit.Deposit;
import Valuables.Valuables;

import java.util.Random;

public class ValuableTransporter implements Runnable {
    private Deposit<Valuables> deposit;
    public ValuableTransporter(Deposit<Valuables> deposit){
        this.deposit = deposit;
    }
    private void Take() throws InterruptedException {
        Random randomNumbers = new Random();
        int targetValue = randomNumbers.nextInt(151) + 50;
        int value = 0;
        while(value<targetValue){
           Valuables takenValuable = deposit.take();
           takenValuable.getValue();
        }
    }

    @Override
    public void run() {

    }
}
