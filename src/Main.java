import Deposit.Deposit;
import Valuables.Valuables;
import Producer_Consumer.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
  public static void main(String[] args)
  {
    Deposit<Valuables> deposit = new Deposit<Valuables>(20);
    Miner miner1 = new Miner(deposit);
    ValuableTransporter valuableTransporter1 = new ValuableTransporter(deposit);
    miner1.run();
    valuableTransporter1.run();
  }
}