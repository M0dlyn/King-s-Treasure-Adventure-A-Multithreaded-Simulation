package CastleStaff;

import Deposit.Deposit;
import TreasureRoom.AccessManager;
import TreasureRoom.Treasury;
import Valuables.*;
import java.util.ArrayList;

import java.util.Random;

public class ValuableTransporter implements Runnable, Person{
    // Valuable Transporter jest consumerem
    private Deposit<Valuables> deposit;
    private ArrayList<Valuables> valuablesToTransport;
    private final AccessManager accessManager;
    public ValuableTransporter(Deposit<Valuables> deposit, AccessManager accessManager){
        this.deposit = deposit;
        this.valuablesToTransport = new ArrayList<>();
        this.accessManager = accessManager;
    }
    private synchronized void Take() throws InterruptedException {
        Random randomNumbers = new Random();
        int targetValue = randomNumbers.nextInt(151) + 150;
        int value = 0;
        while(value<targetValue){
           Log.getInstance().logAction("Valuable Transporter is taking...");
           Valuables takenValuable = deposit.take();
           Log.getInstance().logAction("Valuable Transporter took valuable of the value: " + takenValuable.getValue());
           valuablesToTransport.add(takenValuable);
           int takenValue = takenValuable.getValue();
           value += takenValue;
            try {
                Treasury treasury = accessManager.requestWrite();
                Log.getInstance().logAction("Valuable Transporter went to the Treasure room");
                treasury.addValuables(this, valuablesToTransport);
                valuablesToTransport.clear();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                accessManager.releaseWrite();
            }
        }

        /* Here we need to make the list for the transporter so the taken goods are saved
         After transporting the valuables the list needs to be cleared and the
         Thread needs to sleep and then continue his job -> later we will change that so the transporter will put the goods
         inside the treasure room */

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
    public String toString(){
        return "Valuable Transporter";
    }
}
