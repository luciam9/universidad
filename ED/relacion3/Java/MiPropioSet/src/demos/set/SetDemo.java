/**
 * @author Pepe Gallardo, Data Structures, Grado en Informática. UMA.
 *
 * Example for testing sets.
 */

package demos.set;

import dataStructures.set.Set;
import dataStructures.set.SortedLinkedSet;

public class SetDemo {

	static public void main(String[] args) {
		
		Set<Integer> s1 = new SortedLinkedSet<>();
		for(Integer x : new Integer[] {7, 3, 1, 3, 5, 1}) {
			s1.insert(x);
		}		
		
		// Testing insert. Output should be  SortedLinkedSet(1,3,5,7)
		System.out.println(s1);

		// Testing iterator. Output should be  1 3 5 7
		for(Integer x : s1) {
			System.out.print(x + " ");
		}
		System.out.println();

		
		
		Set<Integer> s2 = new SortedLinkedSet<>(s1);

		// Testing copy constructor. Output should be  SortedLinkedSet(1,3,5,7)
		System.out.println(s2);
		
		
		s2.delete(8);

		// Testing delete. Output should be  SortedLinkedSet(1,3,5,7)
		System.out.println(s2);
		
		
		s2.delete(5);

		// Testing delete. Output should be  SortedLinkedSet(1,3,7)
		System.out.println(s2);

		
		s2.delete(1);

		// Testing delete. Output should be  SortedLinkedSet(3,7)
		System.out.println(s2);
		
		
		
		Set<Integer> s3 = new SortedLinkedSet<>();
		for(Integer x : new Integer[] {7, 3, 8, 6}) {
			s3.insert(x);
		}		
		
				
		Set<Integer> s4 = new SortedLinkedSet<>(s1);
		s4.union(s3); 
		
		// Testing union. Output should be  SortedLinkedSet(1,3,5,6,7,8)
		System.out.println(s4);
		
		
		
		Set<Integer> s5 = new SortedLinkedSet<>(s1);
		s5.intersection(s3); 
		
		// Testing intersection. Output should be  SortedLinkedSet(3,7)
		System.out.println(s5);
		

		
		Set<Integer> s6 = new SortedLinkedSet<>(s1);
		s6.difference(s3); 
		
		// Testing difference. Output should be  SortedLinkedSet(1,5)
		System.out.println(s6);		
	}	
}
