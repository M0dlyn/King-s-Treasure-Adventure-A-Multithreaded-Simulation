package CastleStaff;

import TreasureRoom.AccessManager;
import TreasureRoom.Treasury;

public class Accountant implements Runnable, Person
{
  private final AccessManager accessManager;
  public Accountant(AccessManager accessManager)
  {
    this.accessManager = accessManager;
  }
  @Override public void run()
  {
    while (true)
    {
      try
        {
          Treasury treasury = accessManager.requestRead();
          treasury.lookAtValuables(this);
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
        finally
        {
          accessManager.releaseRead();
        }
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
  public String toString()
  {
    return "Accountant";
  }
}
