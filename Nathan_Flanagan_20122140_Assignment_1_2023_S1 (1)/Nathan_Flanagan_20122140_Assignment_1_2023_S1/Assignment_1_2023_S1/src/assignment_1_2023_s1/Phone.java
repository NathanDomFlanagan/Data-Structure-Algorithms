/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_1_2023_s1;

import java.awt.Color;

/**
 * class that represents a phone object
 * 
 * a phone is either healthy, infected or dead
 * if infected, it needs to be repaired. 
 * if it cannot be repaired within 500 frames it dies
 * @author Nathan
 */
public class Phone extends Thread 
{
    private boolean infected;
    private boolean dead;
    private boolean beingRepaired;
    private int lifespan;
    
    
    
    public Phone() 
    {
        this.infected = false;
        this.dead = false;
        this.beingRepaired = false;
        //lifespan of 2 seconds
        this.lifespan = 2;
    }
    
    @Override
    public void run()
    {
        while (lifespan > 0) 
        {
            if (infected) 
            {
                decreaseLifeSpan();
            }
            try 
            {
                Thread.sleep(1000); // wait for 1 second before checking again
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
        dead = true;
    }
    public boolean isDead() 
    {
        return lifespan == 0;
    }
    
    public boolean isInfected() 
    {
        return this.infected;
    }
    
    public void infect() 
    {
        this.infected = true;
        Color RED = Color.RED;
        
    }
    
    public void dead()
    {
        this.dead = true;
    }
    
    public boolean isRepairing()
    {
        return this.beingRepaired;
    }
    
    public void beingRepaired()
    {
        this.beingRepaired = true;
    }
    
    public void decreaseLifeSpan() 
    {
        this.lifespan--;
    }
    
    //Added the synchronized repair method
    public synchronized void repair() 
    {
        if (this.infected) 
        {
            try 
            {
                Thread.sleep(5000); // sleep for 5 seconds to simulate repair time
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            this.infected = false;
        }
    }

    void setInfected(boolean b) 
    {
        this.infected = true; 
    }
}
