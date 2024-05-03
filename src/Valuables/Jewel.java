package Valuables;

public class Jewel implements ValuablesInterface
{
  private int value;
  public Jewel(){
    value = 50;
  }

  @Override public int getValue()
  {
    return value;
  }
}
