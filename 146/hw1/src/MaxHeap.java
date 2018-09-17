


import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap<T>
{
   private ArrayList<T> students;
   
   public MaxHeap(int capacity)
   {
      students = new ArrayList<T>(capacity);
   }
      
   public MaxHeap(Collection<T> collection)
   {
      students = new ArrayList<T>(collection);
      for(int i = size()/2; i >= 0; i--)
      {
         maxHeapify(i);
      }
   }
   
   public T getMax()
   {
      if(size() < 1)
      {
         throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
      }
      return students.get(0);
   }
   
   public T extractMax()
   {
      T value = getMax();
      students.set(0,students.get(size()-1));
      students.remove(size()-1);
      maxHeapify(0);
      return value;
   }
   
   
   public void insert(T elt)
   {
	   students.add(elt);
	   int index =  size()-1;
	   bubbleUp(index);
   }
   
   public void changeKey(Student s, double newGPA)
   {
	  int index = students.indexOf(s);
	  double oldGPA = s.gpa();

	  s.setGPA(newGPA);
      if(newGPA < oldGPA)
      {
    	  maxHeapify(index);
      }
      else 
      {
		 bubbleUp(index);
      }
   }

   private void bubbleUp(int index)
   {
//		 while(students.get(index).gpa() > students.get(parent(index)).gpa())
//		 {
//			 swap(index,parent(index));
//			 index = parent(index);
//		 }
		 
		 if(((Student)(students.get(index))).gpa() > ((Student)(students.get(parent(index)))).gpa())
		 {
			 swap(index,parent(index));
			 index = parent(index);
			 bubbleUp(index);
		 }
   }
 
   /*private double gpa(int index)
   {
	   return (students.get(index)).gpa();
   }*/
   
   private int parent(int index)
   {
      return (index - 1)/2;
   }
   
   private int left(int index)
   {
      return 2 * index + 1;
   }
   
   private int right(int index)
   {
      return 2 * index + 2;
   }
   
   private int size()
   {
      return students.size();
   }
   
   private void swap(int from, int to)
   {
      T val = students.get(from);
      students.set(from,  students.get(to));
      students.set(to,  val);
   }
   
   public int compareTo(T other)
   {
	  return this.compareTo(other);
   }
   
   private void maxHeapify(int index)
   {
      int left = left(index);
      int right = right(index);
      int largest = index;
      if (left <  size() && ( students.get(left).compareTo(students.get(largest)) > 0)
      {
         largest = left;
      }
      if (right <  size() && ((students.get(right))).compareTo(students.get(largest)) > 0)
      {
         largest = right;
      }
      if (largest != index)
      {
         swap(index, largest);
         maxHeapify(largest);
      }  
   }
  
}
