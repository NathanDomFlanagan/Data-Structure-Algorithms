/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_2023_s1;


public class Node <E extends Comparable> 
{
    public Node <E> next;
    public E data;
    
    public E getData() 
    {
        return this.data;
    }
    public void setData(E newData) 
    {
        data = newData;
    }
    
    public Node getNext()
    {
        return this.next;
    }
    
    public void setNext(Node newNext)
    {
        next = newNext;
    }
    
    public Node(E data) 
    {
        this.data = data;
        next = null;
    }
    
    public Node() 
    {
        data = null;
        next = null;
    }
    
    public boolean equals(Node node)
    {
        return node.data == getData();
    }
    
    /**
     * return 0 if equal
     * return -1 if <
     * return 1 if >
     * @param node
     * @return 
     */
    public int compareTo(Node node)
    {
        // return 0 if node.data == getData()
        // return -1 node.data < getData();
            // data can be number or string
            // "z" < "b" = 1;
            // "a" < "b" = -1;
        // return 1 node.data > getData();
        int result = getData().compareTo(node.getData());
        
        if(result == 0) 
        {
            return result;
            
        } else if(result < 0)
        {
            return -1;
        } else
        {
            return 1;
        }
    }
}