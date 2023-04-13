/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_2023_s1;


public class Stack <E extends Comparable>{
    
    // ? Work on this class
    private Node<E> top;
    private int size;   

    // ! Didnt add this variable to the methods, have to redo this class 
    LinkedList<E> stack = new LinkedList<E>();

    public Stack() 
    {
        this.top = null;
        this.size = 0;
    }
    public void push(E data)
    {
        Node newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    public E pop()
    {
        if (top == null) {
            return null; 
        }
        E data = top.data;
        top = top.next;
        size--;
        return data;
    }
    
    public void printStack()
    {
        Node currentNode = top;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    
    public int getSize()
    {
        return size;
    }
}