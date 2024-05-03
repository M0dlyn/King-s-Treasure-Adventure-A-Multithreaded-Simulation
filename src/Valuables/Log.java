package Valuables;

public class Log
{
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
