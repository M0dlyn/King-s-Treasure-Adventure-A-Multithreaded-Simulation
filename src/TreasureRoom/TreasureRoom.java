package TreasureRoom;

import CastleStaff.Person;
import Valuables.Log;
import Valuables.Valuables;

import java.util.ArrayList;

public class TreasureRoom implements Treasury
{
  // Real subject
  private ArrayList<Valuables> listOfValuables;
  public TreasureRoom(){
    this.listOfValuables = new ArrayList<>();
  }
  @Override public void addValuables(Person person, ArrayList<Valuables> valuables)
  {
    int totalValue = 0;
    for (int i = 0; i < valuables.size(); i++)
    {
      totalValue += valuables.get(i).getValue();
    }
    listOfValuables.addAll(valuables);
    Log.getInstance().logAction("Valuables of the value " + totalValue + " has been added to the treasure room by " + person);
  }

  @Override public void retrieveValuables(Person person)
  {
    int totalValue = 0;
    for (int i = 0; i < listOfValuables.size(); i++)
    {
      totalValue += listOfValuables.get(i).getValue();
    }
    Log.getInstance().logAction(person + " is taking the valuables from the treasure room...");
    listOfValuables.clear();
    Log.getInstance().logAction(person + " has taken valuables of the total value: " + totalValue);
  }

  @Override public void lookAtValuables(Person person)
  {
    /* We can extend it so the list of what valuables are in the treasure room e.g. [Emerald,Jewel,Diamond etc.] */
    int totalValue = 0;
    for (int i = 0; i < listOfValuables.size(); i++)
    {
      totalValue += listOfValuables.get(i).getValue();
    }
    Log.getInstance().logAction(person + "is looking at the valuables in the treasure room");
    Log.getInstance().logAction("Valuables has total value of: " + totalValue);

  }
}
