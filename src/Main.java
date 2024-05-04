import Deposit.Deposit;
import TreasureRoom.AccessManager;
import TreasureRoom.Door;
import TreasureRoom.*;
import TreasureRoom.Treasury;
import Valuables.Valuables;
import CastleStaff.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
  public static void main(String[] args)
  {
    Deposit<Valuables> deposit = new Deposit<Valuables>(20);
    Treasury treasureRoom = new TreasureRoom();
    Treasury guardsman = new Guardsman(treasureRoom);
    AccessManager door = new Door(treasureRoom);
    Miner miner1 = new Miner(deposit);
    Accountant accountant1 = new Accountant(door);
    King king1 = new King(door);
    ValuableTransporter valuableTransporter1 = new ValuableTransporter(deposit,door);
    Thread minerThread = new Thread(miner1);
    Thread transporterThread = new Thread(valuableTransporter1);
    Thread accountantThread = new Thread(accountant1);
    Thread kingThread = new Thread(king1);
    minerThread.start();
    transporterThread.start();
    accountantThread.start();
    kingThread.start();
  }
}