



import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class MaxHeapTest
{
   private MaxHeap heap;


   @Before
   public void setUp() throws Exception
   {
      heap = new MaxHeap(10);
      heap.insert(new Student("Susan", 60, 3.5));
      heap.insert(new Student("Ben", 70, 3.4));
      heap.insert(new Student("Reed", 120, 4.0));
      heap.insert(new Student("Johnny", 50, 1.2));
	  Student a = new Student("A", 30,4.4);
	  heap.insert(a);
	  heap.changeKey(a, 4.4);
	  heap.changeKey(a, 0.5);
   }

   @Test
   public void test()
   {

//      assertEquals(4.0, heap.extractMax().gpa(), .000001);
//      assertEquals(3.5, heap.extractMax().gpa(), .000001);
//      assertEquals(4.4, heap.extractMax().gpa(), .000001);
//      assertTrue(heap.getMax().gpa() == 4.4);
//	   assertTrue(heap.extractMax().gpa() == 4.4);
      assertTrue(heap.extractMax().gpa() == 4.0);
      assertTrue(heap.extractMax().gpa() == 3.5); 
      assertTrue(heap.extractMax().gpa() == 3.4);
      assertTrue(heap.extractMax().gpa() == 1.2);
      assertTrue(heap.extractMax().gpa() == 0.5);
   }

}
