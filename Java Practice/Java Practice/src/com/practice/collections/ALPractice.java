package com.practice.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ALPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		//System.out.println(a.capacity());
		//Adv of arraylist over vector - arraylist is created with an default capacity of 0 where as vector is 10.
		// - Arraylist is not synchronized(handles thread simultaneously)
		a.add(1);
		Collections.synchronizedList(a); //if you want to make it synchronized
		//All methods are same as Vector
	}

}

//1. Why Doesn’t ArrayList Expose capacity()?
//You might be thinking that if the capacity() method is only for checking the internal capacity, it shouldn’t be confusing. And that’s a good point!
//
//The main reason the ArrayList class doesn't expose capacity() publicly is design simplicity. Java's design philosophy emphasizes making things easy and intuitive for the majority of developers who don’t need to micromanage things like internal memory management.
//
//Here’s a key thought behind it:
//
//Automatic Memory Management: For the majority of use cases, developers don’t need to worry about the capacity of the internal array. ArrayList resizes automatically and efficiently, so exposing capacity() could lead developers to overthink and potentially try to control it unnecessarily.
//
//By not exposing capacity(), Java encourages developers to work with the ArrayList based on its size() and the data it contains. It abstracts away memory concerns unless you explicitly call ensureCapacity(), which signals that you might care about performance optimization, but without delving into internal details.
//
//In short, it was a design decision to keep things simple and avoid providing low-level methods like capacity() unless it's truly necessary for performance tuning.
//
//2. How Does ArrayList Resize Internally?
//Now, onto the more technical question: Does ArrayList double its capacity or increase it by 50% when it grows?
//
//The short answer is: It depends on the Java version.
//
//For Java 1.7 and onwards, the ArrayList doubles its internal array size when it needs more capacity.
//For earlier versions (prior to Java 1.7), ArrayList increased its capacity by 50% when it grew.
//Let’s explore this in more detail:
//
//ArrayList Resizing Mechanism (Java 1.7 and Later)
//In Java 1.7 and later, when the internal array of an ArrayList becomes full (i.e., its capacity is exceeded), ArrayList doubles its capacity to ensure that there is enough room for additional elements.
//
//This "doubling" strategy has a couple of benefits:
//
//Amortized Cost: The doubling strategy results in an amortized constant time complexity for adding elements. While the operation of resizing is costly (i.e., copying all the elements to a new array), it doesn’t happen every time an element is added. It only happens when the array becomes full, and the array is doubled in size, reducing the frequency of costly resize operations.
//Performance Optimization: Doubling the size prevents the list from resizing too frequently, reducing the overall overhead as the list grows.
//How it works:
//
//Suppose the ArrayList starts with an initial capacity of 10.
//When the 11th element is added, the capacity increases to 20 (doubling).
//When the 21st element is added, the capacity increases to 40, and so on.
//ArrayList Resizing Mechanism (Java 1.6 and Earlier)
//For versions of Java prior to 1.7, the ArrayList would only increase its internal capacity by 50% of the current capacity when it needed more space.
//
//For example:
//
//Starting with an initial capacity of 10, when the 11th element is added, the capacity increases to 15 (50% more than 10).
//When the 16th element is added, the capacity increases to 22 (50% more than 15), and so on.
//This approach still works well, but the 50% growth factor doesn’t reduce the number of resizing operations as much as doubling does. As a result, resizing operations may be more frequent, especially as the list grows larger.
//
//Why the Change from 50% to Doubling (Java 1.7 and onwards)?
//The move from a 50% increase to doubling was made to optimize the number of resizing operations and to make ArrayList perform better when dealing with large datasets. Doubling the size ensures fewer resizing operations and better performance when adding elements.
//
//3. How to Ensure Capacity (Manually) in ArrayList?
//You can manually control the capacity of an ArrayList to optimize performance in certain cases using the ensureCapacity(int minCapacity) method.
//
//ensureCapacity(): This method is used to increase the capacity of the list to at least the specified minimum capacity. It’s a way to ensure that the ArrayList won’t need to resize if you’re about to add a large number of elements.