package com.qaprosoft.yakubovichAlexander.linkedList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LinkList {

	private final static Logger LOGGER = LogManager.getLogger(LinkList.class);

	private Node head;
	private Node tail;
	private int size;

	

	public LinkList() {
		size = 0;
		head = null;
		tail = null;
	}

	public void addNode(int item) {
		Node node = new Node();
		node.item = item;
		node.next = null;

		if (head == null) {
			head = node;
			tail = node;
			tail.next = null;
			tail.prev = null;
			size = 1;
		} else {
			Node prev = this.tail;
			tail.next = node;
			tail = node;
			tail.prev = prev;
			size++;
		}
	}

	public void addFirst(int item) {
		Node node = new Node();
		node.item = item;
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}

	public void addIndex(int item, int position) {
		Node node = new Node();
		node.item = item;
		Node temp = null;
		if (position < size && position > 0) {
			temp = head;
			for (int i = 1; i < position; i++) {
				temp = temp.next;
			}
			temp = tail;
			for (int i = size; i > position; i--) {
				temp = temp.prev;
			}
		}
		node.next = temp.next;
		temp.next.prev = node;
		node.prev = temp;
		temp.next = node;
		size++;
	}

	public void deleteFirstNode() {
		if (head != null) {
			head = head.next;
			head.prev = null;
			size--;
		}
	}

	public void deleteLastNode() {
		if (tail != null) {
			tail = tail.prev;
			tail.next = null;
			size--;
		}
	}

	public void deleteIndex(int position) {
		Node temp = null;
		if (position < size && position > 0) {
			temp = head;
			for (int i = 1; i < position; i++) {
				temp = temp.next;
			}
			temp = tail;
			for (int i = size - 1; i > position; i--) {
				temp = temp.prev;
			}
		}
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		size--;
	}

	public void printList() {
		Node temp = head;
		for (int i = 0; i < size; i++) {
			LOGGER.info(temp.item);
			temp = temp.next;
		}
	}
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
