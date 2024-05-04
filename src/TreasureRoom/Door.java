package TreasureRoom;

public class Door implements AccessManager
{
  private Treasury treasury;
  private int readers;
  private int writers;
  private int current;
  private int next;
  public Door(Treasury treasury){
    this.treasury = treasury;
    this.readers = 0;
    this.writers = 0;
    this.current = 0;
    this.next = 0;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    if (readers == 0) {
      notifyAll();
    }
  }

  @Override public synchronized Treasury requestRead() throws InterruptedException
  {
    int myNumber = next;
    next++;
    while (myNumber != current) {
      wait();
    }
    while(writers > 0) {
      wait();
    }
    readers++;
    current++;
    notifyAll();
    return treasury;
  }

  @Override public synchronized void releaseWrite()
  {
    writers--;
    if (writers == 0) {
      notifyAll();
    }
  }

  @Override public synchronized Treasury requestWrite() throws InterruptedException
  {
    int myNumber = next;
    next++;
    while(myNumber != current) {
      wait();
    }
    while(writers > 0 || readers > 0) {
      wait();
    }
    writers++;
    current++;
    notifyAll();
    return treasury;
  }
}
