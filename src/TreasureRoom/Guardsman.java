package TreasureRoom;

import CastleStaff.Accountant;
import CastleStaff.King;
import CastleStaff.Person;
import CastleStaff.ValuableTransporter;
import Valuables.Valuables;
import Valuables.Log;

import java.util.ArrayList;

public class Guardsman implements Treasury
{
  // Protection proxy
  private Treasury treasury;
  public Guardsman(Treasury treasury)
  {
    this.treasury  = treasury;
  }
  @Override public void addValuables(Person person, ArrayList<Valuables> valuables)
  {
    if(person instanceof ValuableTransporter)
    {
      treasury.addValuables(person, valuables);
    }
    else
    {
      Log.getInstance().logAction(person + "tried to add valuables to the treasure room but guardsman stopped him");
    }
  }

  @Override public void retrieveValuables(Person person)
  {
    if(person instanceof King)
    {
      treasury.retrieveValuables(person);
    }
    else
    {
     Log.getInstance().logAction(person + "tried to steal from the treasure room!! Guardsman stopped him");
    }
  }

  @Override public void lookAtValuables(Person person)
  {
    if(person instanceof Accountant || person instanceof King)
    {
      treasury.lookAtValuables(person);
    }
    else
    {
      Log.getInstance().logAction(person + "tried to look into the treasure room but guardsman stopped him");
    }

  }
}
