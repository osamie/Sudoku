// The "Queue" class.
// Implements a queue using a linked list. A queue consists of a list (a 
// sequence) of elements of type E. The elements can be added to and 
// removed from the list in a first-in-first-out (FIFO) basis.
import java.util.*;
public class Queue<E> {
	
	private LinkEntry<E> lastNode;
	   
	private final int capacity = 100; 
	
	private int size;
	
	
	// Create a new Queue object. The queue is empty to start.
	public Queue(){
		lastNode = null;
	}

	// Add element to the rear of the queue. The queue must not be full.
	public void arrive  (E element)throws Exception {
		
		if(full()) throw new Exception("Cannot perform operation: list is full");
		
		LinkEntry newNode = new LinkEntry(element,null);
	
		//insert the new node
		if(empty()){
			//insertion into empty queue
			newNode.setLink(newNode);
			
			++size; //increase the size after an insertion
		}
		
		else {
			//insertion into non empty queue
			if (!full()) //the queue must not be full
			{
				newNode.setLink(lastNode.getLink());
				lastNode.setLink(newNode);
				++size;
			} //end if
				
		}
		
		lastNode = newNode; //new node is at the back
		
		
		
	} //end arrive

	// Remove the element at the front of the queue. The queue must not be
	// empty.
	E leave() throws Exception{
		
		if(!empty()) //queue is not empty, remove from the front
		{
			LinkEntry<E>firstNode = lastNode.getLink();
			
			if(firstNode == lastNode) //this is a special case when there is only one node in the queue 
			{
				lastNode = null;
				
				
				
			}
			
			else{
				lastNode.setLink(firstNode.getLink());
			}
			
			--size;
			return firstNode.getElement();
			
		}
		
		//the queue is empty, so throw an exception
		
		throw new Exception("Cannot perform operation: queue is Empty!");
		
	}

	// Return the element at the front of the queue, without
	// changing the queueu. The queue must not be empty.
	E peek() throws Exception{
		if(!empty()){
			//queue is not empty, so retrieve the front element
			
			LinkEntry<E> firstNode = lastNode.getLink();
			
			return firstNode.getElement();
		}
		
		throw new Exception("Cannot perform peek() operation: Queue is empty!");
	}

	// Return number of elements in the queue.
	int length() {
		return size;
		
	}

	// Return true if the queue contains no elements.
	boolean empty() {
		return (size==0);
	}

	// Return true if the queue cannot hold any more elements.
	boolean full(){
		return (size==capacity);
		
	}
	
	public static void main(String []args){
		Queue aq=new Queue();
		
		for(int i = 0; i<9;i++){
			//aq.arrive()
		}
	}
} /* Queue class */
