package Valuables;

public class Emerald implements ValuablesInterface
{
  private int value;
  public Emerald(){
    value = 90;
  }

  @Override public int getValue()
  {
    return value;
  }
}
