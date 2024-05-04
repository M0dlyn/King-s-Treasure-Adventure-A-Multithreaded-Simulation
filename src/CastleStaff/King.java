package CastleStaff;

import TreasureRoom.AccessManager;
import TreasureRoom.Treasury;
import Valuables.*;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable, Person
{
  private final AccessManager accessManager;
  public King(AccessManager accessManager)
  {
    this.accessManager = accessManager;
  }
  @Override public void run()
  {
    Random randomNumbers = new Random();
    int targetValue = randomNumbers.nextInt(151) + 300;
    while (true)
    {
      try
      {
        int totalValue = 0;
        Treasury treasury = accessManager.requestWrite();
        ArrayList<Valuables> valuablesTaken = treasury.retrieveValuables(this);
        for (int i = 0; i < valuablesTaken.size(); i++)
        {
          totalValue += valuablesTaken.get(i).getValue();
        }
        if(totalValue>=targetValue)
        {
          Log.getInstance().logAction("King is throwing a party!!!!!! (Wasting all the money)");
          try {
            Thread.sleep(15000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
        else
        {
          Log.getInstance().logAction("King cancel the scheduled party. Returning valuables back to treasure room...");
          treasury.addValuables(this,valuablesTaken);
          try {
            Thread.sleep(10000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      finally
      {
        accessManager.releaseWrite();
      }
    }
  }
  public String toString()
  {
    return "King";
  }
}
