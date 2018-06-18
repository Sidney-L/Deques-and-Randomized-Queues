import java.util.Iterator;
import java.util.NoSuchElementException;
public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int size;
    
    private class Node{
	private Item item;
	private Node previous;
	private Node next;
    }
    private class DequeIterator implements Iterator<Item> {
	    private Node current = first;
	    @Override
	    public boolean hasNext() {
		return current != null;
	    }

	    @Override
	    public Item next() {
		if (!hasNext()) {
		    throw new NoSuchElementException();
		}
		Item item = current.item;
		current = current.next;
		return item;
	    }
	    
	    public void remove(){
		throw new UnsupportedOperationException();
	    }
    }
    public Deque() {
	size = 0;
	first = null;
	last = null;
    }
    
    public boolean isEmpty() {
	return size==0;
    }
    
    public int size() {
	return size;
    }
    
    public void addFirst(Item item) {
	if (item == null){
	    throw new IllegalArgumentException();
	}
	Node oldFirst = first;
	first = new Node();
	first.item = item;
	first.previous = null;
	first.next = oldFirst;
	if (oldFirst != null){
	    oldFirst.previous = first;
	}
	else{
	    last = first;
	}
	size++;
    }
    
    public void addLast(Item item) {
	if (item == null){
	    throw new IllegalArgumentException();
	}
	Node oldLast = last;
	last = new Node();
	last.item = item;
	last.next = null;
	last.previous = oldLast;
	if (oldLast != null){
	    oldLast.next = last;
	}
	else{
	    first = last;
	}
	size++;
    }
    
    public Item removeFirst() {
	if (isEmpty()){
	    throw new NoSuchElementException();
	}
	Node oldFirst = first;
	first = first.next;
	if (first != null){
	    first.previous = null;
	}
	else{
	   last = null;
	}
	size--;
	return oldFirst.item;
    }
    
    public Item removeLast() {
	if (isEmpty()){
	    throw new NoSuchElementException();
	}
	Node oldLast = last;
	last = last.previous;
	if (last != null){
	    last.next = null;
	}
	else{
	    first = null;
	}
	size--;
	return oldLast.item;
    }
    
    public Iterator<Item> iterator() {
	return new DequeIterator();
    }
    
    
}
