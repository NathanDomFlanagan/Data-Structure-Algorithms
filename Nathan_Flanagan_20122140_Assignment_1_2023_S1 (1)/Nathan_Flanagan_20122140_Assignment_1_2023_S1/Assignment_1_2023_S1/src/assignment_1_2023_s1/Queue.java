/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_2023_s1;


public class Queue <E extends Comparable>
{   
    // ? Work on this class
    private Node<E> frontNode;
    private Node<E> lastNode;
    private int numElements;

    // ! Didnt add this variable to the methods, have to redo this class 
    LinkedList<E> queue = new LinkedList<E>();

    public Queue()
    {
        this.frontNode = null;
        this.lastNode = null;
        this.numElements = 0;
    }
    
    public Queue(Node frontNode, Node lastNode, int numElements) 
    {
        this.frontNode = frontNode;
        this.lastNode = lastNode;
        this.numElements = numElements;
    }
   
    public void enqueue(E data)
    {
        Node<E> newNode = new Node<>(data); 
        
        if(lastNode == null)
        {
            frontNode = newNode;
            lastNode = newNode;
        }
        else
        {
            lastNode.next = newNode;
            lastNode = newNode;
        }
        numElements++;
    }
    
    public E dequeue()
    {
        if (frontNode == null) 
        {
            return null; 
        }
        E data = (E) frontNode.data;
        frontNode = frontNode.next;
        if (frontNode == null) 
        {
            lastNode = null; 
        }
        numElements--;
        return data;
    }
    
    public void printQueue()
    {
        while (frontNode != null) 
        {
            System.out.print(frontNode.data + " ");
            frontNode = frontNode.next;
        }
        System.out.println();
    }
    
    public int getSize()
    {
        return numElements;
    }
}