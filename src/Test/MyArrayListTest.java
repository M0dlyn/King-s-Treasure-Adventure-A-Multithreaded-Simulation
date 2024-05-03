package Test;

import org.junit.jupiter.api.Test;
import utility.collection.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest
{
  // Ta klasa jest po to żeby tu zrobić unit testing nie ma powiązań do reszty programu
  @Test
  void addObjectToIndex5WhenArrayListIsEmptyShouldThrowIndexOutOfBoundsException(){
    var  arrayList = new ArrayList<>();
    assertThrows(IndexOutOfBoundsException.class,()->{
      arrayList.add(5,80);
    });
  }
  @Test
  void add99ToIndex3WhenArrayListIsNotEmptyShouldAddItCorrectly(){
    var arrayList = new ArrayList<>();
    arrayList.add(10);
    arrayList.add(8);
    arrayList.add(7);
    arrayList.add(1);
    arrayList.add(9);
    arrayList.add(3,99);
    assertEquals(99,arrayList.get(3));
  }
  @Test
  void add99ToIndex3WhenArrayListIsNotEmptyShouldMoveTheValueFromIndex3toIndex4(){
    var arrayList = new ArrayList<>();
    arrayList.add(10);//0
    arrayList.add(8); //1
    arrayList.add(7); //2
    arrayList.add(1); //3
    arrayList.add(9); //4
    arrayList.add(3,99);
    assertEquals(1,arrayList.get(4));
  }
  @Test
  void add10ToArrayListWhenArrayListIsEmptyShouldAddItCorrectly(){
    var arrayList = new ArrayList<>();
    arrayList.add(10);//0
    assertEquals(10,arrayList.get(0));
  }
  @Test
  void checkIf10IsInTheArrayListUsingContainsShouldReturnTrue(){
    var arrayList = new ArrayList<>();
    arrayList.add(10);
    assertTrue(arrayList.contains(10));
  }
  @Test
  void checkIf10IsInTheArrayListUsingContainsShouldReturnFalse(){
    var arrayList = new ArrayList<>();
    assertFalse(arrayList.contains(10));
  }
  @Test
  void checkIfObject10WhenUsingMethodIndexOfShouldReturnIndex0(){
    var arrayList = new ArrayList<>();
    arrayList.add(10);//0
    assertEquals(0,arrayList.indexOf(10));
  }




}

