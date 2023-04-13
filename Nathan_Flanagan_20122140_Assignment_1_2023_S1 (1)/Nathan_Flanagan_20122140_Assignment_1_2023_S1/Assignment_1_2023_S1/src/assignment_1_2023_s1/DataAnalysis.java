/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_2023_s1;

public class DataAnalysis <E extends Comparable>
{
    private Queue <E> queue = new Queue();
    private Stack <E> stack = new Stack();
    private E[] data;
    

    // ! Redo this class because of the other errors
    //TODO Idk if this class is needed for the grades as the test is commented out?
    public DataAnalysis(E[] data)
    {
        this.data = data;
       
        for (E elem : data) 
        {
            queue.enqueue(elem);
            stack.push(elem);
        }
    }
    
    public boolean isSymmetrical() 
    {
        int queueSize = queue.getSize();
        int stackSize = stack.getSize();
        if (queueSize != stackSize) 
        {
            return false;
        }
        for (int i = 0; i < queueSize; i++)
        {
            E front = queue.dequeue();
            E back = stack.pop();
            if (front.compareTo(back) != 0) 
            {
            return false;
            }
        }
        return true;
    }
    
    public boolean bracketEvaluator()
    {
        for (E elements : data) 
        {
            char c = elements.toString().charAt(0);
            if (c == '(' || c == '{' || c == '[') 
            {
                stack.push(elements);
            } else if (c == ')' || c == '}' || c == ']') 
            {
                if (stack.getSize() == 0) 
                {
                    return false;
                }
                char top = stack.pop().toString().charAt(0);
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) 
                {
                  return false;
                }
            }
        }
        return stack.getSize() == 0;
    }
}