package Valuables;

import java.util.HashMap;

public class Valuables
{
  private ValuablesType key;
  private static HashMap<ValuablesType,ValuablesInterface> instances = new HashMap<>();
  private Valuables(ValuablesType key){
    this.key = key;
  }
  private static ValuablesInterface createInstance(ValuablesType key){
    return switch (key){
      case DIAMOND -> new Diamond();
      case GOLDNUGGET -> new GoldNugget();
      case JEWEL -> new Jewel();
      case RUBY -> new Ruby();
      case WOODENCOIN -> new WoodenCoin();
      case EMERALD -> new Emerald();
      case SAPPHIRE -> new Sapphire();
    };

  }
  public static synchronized ValuablesInterface getInstance(ValuablesType key){
    if(!instances.containsKey(key)){
      instances.put(key, createInstance(key));
    }
    return instances.get(key);
  }
}
