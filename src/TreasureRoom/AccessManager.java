package TreasureRoom;

public interface AccessManager
{
  void releaseRead();

  Treasury requestRead() throws InterruptedException;

  void releaseWrite();

  Treasury requestWrite() throws InterruptedException;
}
