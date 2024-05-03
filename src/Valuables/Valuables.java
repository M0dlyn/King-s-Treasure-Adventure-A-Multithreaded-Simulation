package Valuables;

import java.util.HashMap;

public class Valuables
{
  private ValuablesType key;
  private int value;
  private static HashMap<ValuablesType,Valuables> instances = new HashMap<>();
  private Valuables(ValuablesType key, int value){
    this.key = key;
    this.value = value;
  }
  private static Valuables createInstance(ValuablesType key){
    int value = 0;
     switch (key) {
      case DIAMOND:
        value = 100;
        break;
      case GOLDNUGGET:
        value = 50;
        break;
      case JEWEL:
        value = 80;
        break;
      case RUBY:
        value = 75;
        break;
      case WOODENCOIN:
        value = 10;
        break;
      case EMERALD:
        value = 90;
        break;
      case SAPPHIRE:
        value = 85;
        break;
    }
    return new Valuables(key,value);
  }
  public static synchronized Valuables getInstance(ValuablesType key){
    if(!instances.containsKey(key)){
      instances.put(key, createInstance(key));
    }
    return instances.get(key);
  }
}
