import Deposit.Deposit;
import Valuables.Valuables;
import CastleStaff.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
  public static void main(String[] args)
  {
    Deposit<Valuables> deposit = new Deposit<Valuables>(20);
    Miner miner1 = new Miner(deposit);
    ValuableTransporter valuableTransporter1 = new ValuableTransporter(deposit);
    Thread minerThread = new Thread(miner1);
    Thread transporterThread = new Thread(valuableTransporter1);
    minerThread.start();
    transporterThread.start();
  }
}