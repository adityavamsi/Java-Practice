package com.practice.collections;

import java.util.Stack;

public class StackPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> st = new Stack<String>();
		st.push("1st");
		st.push("2nd");
		st.push("3rd");
		System.out.println(st.peek()); //shows the top element
		System.out.println(st.pop());//deletes the top element
		System.out.println(st.search("2nd")); //shows the nth element from top of the stack - ans-> 1
		System.out.println(st.empty()); //checks if st is empty or not -  comes from stack class


	}
	
	/* 
	 * What the use of stack class extending vector class? 
	 * Since we wont use vector methods in stack because of LIFO principle and 
	 * stack has separate methods to perform. Shouldn't stack be treated as a separate class directly implementing list?
	 * 
	 * 
	 * The design of Java’s Stack class is largely historical. Here’s why it extends Vector and what that means:

Historical Context and Code Reuse:

When the Java Collections Framework was first developed, Vector was one of the primary, dynamically resizable array classes available. Instead of writing a new data structure from scratch, the designers chose to extend Vector to quickly provide stack functionality. This allowed them to reuse the dynamic array capabilities (such as automatic resizing and indexed access) that Vector already provided.

LIFO Methods Added on Top of Vector:
Although Stack extends Vector, it adds specific methods like push(), pop(), and peek() that enforce the Last-In-First-Out (LIFO) principle. In practice, if you use these methods, you are working with the stack abstraction. However, because Stack inherits all of Vector’s methods, it’s still possible to call methods that don’t adhere to the strict LIFO behavior. This is one of the recognized drawbacks of the design.

Encapsulation vs. Legacy Support:
Ideally, one might want a stack class that encapsulates its behavior completely without exposing non-stack methods. A better design might have been to have Stack implement a specific interface or use composition rather than inheritance to hide the underlying data structure. But since Stack was created in a time when the Collections Framework was less mature, the simpler approach of extending Vector was chosen. Changing this design now would break backward compatibility for many existing applications.

Modern Alternatives:
Because of these issues (e.g., exposing more methods than necessary and not fully enforcing the stack abstraction), modern Java programming often favors using the Deque interface (with implementations like ArrayDeque or LinkedList) when a stack is needed. These alternatives provide a cleaner abstraction without exposing unnecessary operations.

In summary, while it might seem that a stack should be a completely separate class, the decision to extend Vector was made for convenience and historical reasons. Today, although Stack is still part of Java for legacy support, it’s generally recommended to use Deque implementations for new code.*/

}
