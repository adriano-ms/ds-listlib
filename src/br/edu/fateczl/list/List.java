package br.edu.fateczl.list;

public class List<T> {
	
	private Node<T> first;
	
	public List() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		int count = 0;
		Node<T> aux = first;
		while(aux != null) {
			aux = aux.getNext();
			count++;
		}
		return count;
	}
	
	private Node<T> getNode(int position) throws Exception{
		if(isEmpty()) 
			throw new Exception("Empty list");
		
		if(position < 0 || position > size() - 1) 
			throw new Exception("Invalid position");
		
		Node<T> aux = first;
		for(int i = 0; i < position; i++) {
			aux = aux.getNext();
		}
		
		return aux;
	}
	
	public void addFirst(T data) {
		Node<T> node = new Node<>(data, first);
		first = node;
	}
	
	public void addLast(T data) throws Exception {
		if(isEmpty()) {
			addFirst(data);
		} else {
			getNode(size() - 1).setNext(new Node<>(data, null));
		}
	}

	public void add(T data, int position) throws Exception {
		
		int size = size();
		
		if(position < 0) 
			throw new Exception("Invalid position");
		
		if(position == 0) {
			addFirst(data);
		} else if(position == size) {
			addLast(data);
		} else {
			Node<T> element = new Node<>(data, null);
			Node<T> previous = getNode(position - 1);
			element.setNext(previous.getNext());
			previous.setNext(element);
		}
	}
	
	public void removeFirst() throws Exception {
		if(isEmpty()) 
			throw new Exception("Empty list");
		
		first = first.getNext();
	}
	
	public void removeLast() throws Exception {
		if(isEmpty()) 
			throw new Exception("Empty list");
		
		int size = size();
		
		if(size == 1) {
			removeFirst();
		} else {
			getNode(size - 2).setNext(null);
		}	
	}
	
	public void remove(int position) throws Exception {
		if(isEmpty()) 
			throw new Exception("Empty list");
		
		int size = size();
		
		if(position < 0 || position > size - 1) 
			throw new Exception("Invalid position");
		
		if(position == 0) {
			removeFirst();
		} else if(position == size) {
			removeLast();
		} else {
			Node<T> previous = getNode(position - 1);
			previous.setNext(previous.getNext().getNext());
		}
	}
	
	public T get(int position) throws Exception {
		if(isEmpty()) 
			throw new Exception("Empty list");
		
		int size = size();
		
		if(position < 0 || position > size - 1) 
			throw new Exception("Invalid position");
		
		if(position == 0) 
			return first.getData();
		
		if(position == size) 
			return getNode(size - 1).getData();
		
		return getNode(position).getData();
		
	}
}
