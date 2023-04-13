/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_2023_s1;

// ! DONT USE LOOPS FOR THIS CLASS (GET EXTRA 10 POINTS)
public class LinkedList<E extends Comparable> 
{
    // ? Work on this class
    public int size;
    private Node<E> head;
                            
    public LinkedList() 
    {
        this.size = 0;
        head = null;
    }

    // todo remove not in the function list
    public void addHead(E data) 
    {
        Node<E> newNode = new Node<>(data);
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public Node getHead() 
    {
        return this.head;
    }

    public void add(E data) 
    {    
        Node<E> newNode = new Node<>(data);
        
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            add(head, newNode);
        }
        size++;   
    }

    private void add(Node head, Node node) 
    { 
        if (head.getNext() == null) 
        {
            head.setNext(node);
        } 
        else 
        {
            add(head.getNext(), node);
        }
    }

    public void printLinkedList() 
    {
        if (head == null) 
        {
            return;
        }

        System.out.println(head.getData());
        printLinkedList(head.getNext());
    }

    private void printLinkedList(Node node) 
    {
        if (node == null) 
        {
            return;
        }

        System.out.println(node.getData());
        printLinkedList(node.getNext());
    }

    public boolean contains(Node node) 
    {
        return contains(this.head, node);
    }

    private boolean contains(Node head, Node node) 
    {
        if (head == null) 
        {
            return false;
        } else if (head.equals(node)) 
        {
            return true;
        } else 
        {
            return contains(head.getNext(), node);
        }
    }

    public void remove(Node node) 
    {
        if (head == null) 
        {
            return;
        }
        if (head.equals(node)) 
        {
            head = head.getNext();
            size--;
            return;
        }
        removeFromBody(head, node);
    }

    //WORK ON THE REMOVE METHODS    
    public void remove(int position) 
    {
        if (head == null || position < 0 || position >= size) 
        {
            return;
        }
        if (position == 0) 
        {
            head = head.getNext();
            size--;
            return;
        }
        removeByIndex(head, position);

    }

    private void removeByIndex(Node head, int position) 
    {
        if (position == 1) 
        {
            head.setNext(head.getNext().getNext());
            size--;
            return;
        }
        removeByIndex(head.getNext(), position - 1);
    }

    private void removeFromBody(Node head, Node node) 
    {
        if (head == null || node == null) 
        {
            return;
        }
        if (head.getNext().equals(node)) 
        {
            head.setNext(node.getNext());
            size--;
            return;
        }
        removeFromBody(head.getNext(), node);
    }

    public Node removeFromHead() 
    {
        if (head == null) 
        {
            return null;
        }

        Node<E> nodeToRemove = head;
        head = head.getNext();
        size--;

        return nodeToRemove;
    }

    public Node removeFromTail() 
    {
        if (head == null) 
        {
            return null;
        }

        if (head.getNext() == null) 
        {
            Node<E> nodeToRemove = head;
            head = null;
            size--;
            return nodeToRemove;
        }
        return removeFromTail(head);
    }

    private Node removeFromTail(Node node) 
    {
        if (node.getNext().getNext() == null) 
        {
            Node<E> nodeToRemove = node.getNext();
            node.setNext(null);
            size--;
            return nodeToRemove;
        }
        return removeFromTail(node.getNext());
    }

    public void addInOrder(E data) 
    {
        Node<E> newNode = new Node<>(data);
        if (head == null || data.compareTo(head.getData()) < 0) 
        {
            newNode.setNext(head);
            head = newNode;
        } else 
        {
            addInOrder(head, newNode);
        }
        size++;
    }

    private void addInOrder(Node<E> currentNode, Node<E> newNode) 
    {    
        if (currentNode.getNext() == null || newNode.getData().compareTo(currentNode.getNext().getData()) < 0) 
        {
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        } else 
        {
            addInOrder(currentNode.getNext(), newNode);
        }
    }

    public Node getNode(int index) 
    {
        if (index < 0 || index >= size || head == null) 
        {
            return null;
        }
        return getNode(index, head);
    }

    private Node getNode(int index, Node head) 
    {
        if (index == 0) 
        {
            return head;
        }
        return getNode(index - 1, head.getNext());
    }

    public E getData(int index) 
    {
        Node<E> node = getNode(index);
        if (node != null) 
        {
            return (E) node.getData();
        } else 
        {
            return null;
        }
    }

    private E getData(int index, Node head) 
    {
        if (head == null || index < 0) 
        {
            return null;
        }
        if (index == 0) 
        {
            return (E) head.getData();
        } else 
        {
            return getData(index - 1, head.getNext());
        }
    }
}