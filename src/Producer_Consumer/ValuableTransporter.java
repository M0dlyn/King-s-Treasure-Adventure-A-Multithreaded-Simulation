package Producer_Consumer;

import Deposit.Deposit;
import Valuables.*;
import java.util.ArrayList;

import java.util.Random;

public class ValuableTransporter implements Runnable {
    private Deposit<Valuables> deposit;
    private ArrayList valuablesToTransport;
    public ValuableTransporter(Deposit<Valuables> deposit){
        this.deposit = deposit;
        this.valuablesToTransport = new ArrayList<>();
    }
    private synchronized void Take() throws InterruptedException {
        Random randomNumbers = new Random();
        int targetValue = randomNumbers.nextInt(151) + 50;
        int value = 0;
        while(value<targetValue){
           Log.getInstance().logAction("Valuable Transporter is taking...");
           Valuables takenValuable = deposit.take();
           Log.getInstance().logAction("Valuable Transporter took valuable of the value: " + takenValuable.getValue());
           valuablesToTransport.add(takenValuable);
           int takenValue = takenValuable.getValue();
           value += takenValue;
        }
        valuablesToTransport.clear();

        /* TODO Here we need to make the list for the transporter so the taken goods are saved
         After transporting the valuables the list needs to be cleared and the
         Thread needs to sleep and then continue his job */

    }

    @Override
    public void run() {
        while(true){
            try {
                Take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Log.getInstance().logAction("Valuable Transporter is sleeping...");
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
