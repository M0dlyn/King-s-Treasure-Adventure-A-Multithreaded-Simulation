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
  @Test
  void checkIfGetMethodShouldReturnValue10(){
    var arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(10);
    assertEquals(10,arrayList.get(2));
  }
  @Test
  void checkIfgetMethodShouldThrowIndexOutOfBoundsException(){ // its throwing different exception
    var  arrayList = new ArrayList<>();
    assertThrows(IndexOutOfBoundsException.class,()->{
      arrayList.get(3);
    });
  }
  @Test
  void checkIfIndexOfShouldReturnValueOf2(){
    var arrayList = new ArrayList<>();
    arrayList.add(10);
    arrayList.add(90);
    arrayList.add(66);
    assertEquals(2,arrayList.indexOf(66));
  }
  @Test
  void checkIfIndexOfShouldReturnValueOfMinus1(){
    var arrayList = new ArrayList<>();
    assertEquals(-1,arrayList.indexOf(90));
  }
  @Test
  void checkIfIsEmptyShouldReturnTrueWhenArrayListIsEmpty(){
    var arrayList = new ArrayList<>();
    assertTrue(arrayList.isEmpty());
  }
  @Test
  void checkIfIsEmptyShouldReturnFalseWhenArrayListIsNotEmpty(){
    var arrayList = new ArrayList<>();
    arrayList.add(1);
    assertFalse(arrayList.isEmpty());
  }
  @Test
  void checkIfIsFullShouldReturnFalseWhenArrayListIsEmpty(){ // method instead of always returning false, always returns true
    var arrayList = new ArrayList<>();
    assertFalse(arrayList.isFull());
  }
  @Test
  void checkIfIsFullShouldReturnTrueWhenArrayListIsNotEmpty(){ // method instead of always returning false, always returns true
    var arrayList = new ArrayList<>();
    arrayList.add(10);
    assertFalse(arrayList.isFull());
  }
  @Test
  void checkIfRemoveByIndexShouldReturnValueOf6(){
    var arrayList = new ArrayList<>();
    arrayList.add(5);
    arrayList.add(6);
    assertEquals(6,arrayList.remove(1));
  }
  @Test
  void checkIfRemoveByIndexShouldReturnIndexOutOfBoundException(){
    var arrayList = new ArrayList<>();
    assertThrows(IndexOutOfBoundsException.class,()->{
      arrayList.remove(2);
    });
  }
  @Test
  void checkIfRemoveByObjectShouldReturnRemovedString(){
    var arrayList = new ArrayList<>();
    arrayList.add("BB");
    arrayList.add("AA");
    assertEquals("AA",arrayList.remove("AA"));
  }
  @Test
  void checkIfRemoveByObjectShouldReturnIllegalStateException(){
    var arrayList = new ArrayList<>();
    assertThrows(IllegalStateException.class,()->{
      arrayList.remove("AA");
    });
  }
  @Test
  void checkIfSetShouldReturnValueOf99(){
    var arrayList = new ArrayList<>();
    arrayList.add(6);
    arrayList.add(8);
    arrayList.add(9);
    arrayList.set(2,99);
    assertEquals(99,arrayList.get(2));
  }
  @Test
  void checkIfSetShouldReturnIndexOutOfBoundsException(){
    var arrayList = new ArrayList<>();
    assertThrows(IndexOutOfBoundsException.class,()->{
      arrayList.set(2,99);
    });
  }
  @Test
  void checkIfSizeShouldReturnValueOf4(){
    var arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    assertEquals(4,arrayList.size());
  }
  @Test
  void checkIfSizeShouldReturnValueOf0(){
    var arrayList = new ArrayList<>();
    assertEquals(0,arrayList.size());
  }
  @Test
  void checkIfToStringShouldReturnCorrectValue1(){  // It's printing out additional space after comma
    var arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    assertEquals("{1,2}",arrayList.toString());
  }
  @Test
  void checkIfToStringShouldReturnCorrectValue2(){  // It's printing out additional space after comma
    var arrayList = new ArrayList<>();
    assertEquals("{}",arrayList.toString());
  }





}

