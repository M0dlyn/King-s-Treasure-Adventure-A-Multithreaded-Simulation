package Valuables;

public class Log
{
  // Singleton Log, ta klasa służy do printowania działań Threadow w konsoli: używamy jej w klasie Miner i klasie ValuableTransporter
  private static Log instance;
  private Log(){}

  public static synchronized Log getInstance(){
    if(instance == null){
      instance = new Log();
    }
    return instance;
  }
  public void logAction(String action) {
    System.out.println(action);
  }

}
