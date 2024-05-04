package TreasureRoom;

import CastleStaff.Person;
import Valuables.Valuables;

import java.util.ArrayList;

public interface Treasury
{
  void addValuables(Person person, ArrayList<Valuables> valuables);
  ArrayList<Valuables> retrieveValuables(Person person); // void type most likely will be changed
  void lookAtValuables(Person person);

}
