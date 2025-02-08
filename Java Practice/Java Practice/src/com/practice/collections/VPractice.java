package com.practice.collections;
import java.util.*;

//Vector
public class VPractice {

	public static void main(String[] args) {
	
		Vector v = new Vector(); //Creating a Vector,No generics
		v.add("aditya");// Adding a element without index
		v.add(0,"vamsi"); //Adding a element specifying index, the other elements get shifted
		v.add(2, "wipro");//IF the index is more than the elements present, then error occurs
		System.out.println(v);
		
		//Capacity of a vector, Initially the capacity of the vector is 10, but if the elements occupy 50% of capacity
		//then the capacity increases to another 50%, i.e 20...40...80..etc
		System.out.println(v.capacity());
		
		//Size - shows how many elements are present in vector
		System.out.println(v.size());
		
		Vector v1 = new Vector();
		v1.addAll(v);//addAll() adds all the objects present in the v to v1 
		v1.addAll(1, v); //using index we can add the elements from the specified index to the end of the elements that are present in v
		System.out.println(v.equals(v1)); //equals checks if the object is same or not
		
		System.out.println(v1);
		v1.addElement(v);//addElement adds entire v as an object to v1 - [..,...,...,[v]]
		System.out.println(v1);
		System.out.println(v1.contains("ad")); //contains - checks if the specified object is present or not
		System.out.println(v1.get(1));//gets the object using index
		System.out.println(v1.indexOf(v));//gets index by using object
		
		//Vector is introduced in java 1.0 and Collections introduced in java 1.2
		//But in vector, we can store any type of object which causes a problem, so
		//Generics are introduced in java 1.5
		Vector<Integer> v3 = new Vector<Integer>();
		//Here we can specify the type of Object we want to store in vector
		
		Object[] arr = new Object[]{1, 2, 4};
		Vector v5  =new Vector(Arrays.asList(arr));
		//If we create in this way, then the default capacity of the vector will be the size of the arr object
		System.out.println("capacity and size - "+v5.capacity() + " --- " +v5.size());
		v5.add("fff");
		v5.clear();
		System.out.println("capacity and size - "+v5.capacity() + " --- " +v5.size());
		
		
		

	}

}
