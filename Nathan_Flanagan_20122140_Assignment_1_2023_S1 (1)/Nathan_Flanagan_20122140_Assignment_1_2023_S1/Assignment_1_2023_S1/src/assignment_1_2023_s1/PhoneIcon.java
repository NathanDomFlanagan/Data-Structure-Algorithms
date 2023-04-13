/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_1_2023_s1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * a class that represents the phone icon image
 * @author Nathan
 */

public class PhoneIcon extends JPanel
{
    private final Phone phone;
    //New code here
    private final int MOVE_AMOUNT = 10;
    private final int MOVE_TIMER_DELAY_MS = 250;// update phone position every 250ms
    private final Random rand = new Random();
    
    public PhoneIcon() 
    {
        this.phone = new Phone();
        // green as default for healthy
        this.setBackground(Color.GREEN);
        // 50,50 is this pixels?
        this.setPreferredSize(new Dimension(50, 50));
        //Create Time object here to trigger event 
        Timer moveTimer = new Timer(MOVE_TIMER_DELAY_MS, e -> 
        {
            // random move amount in [-MOVE_AMOUNT, MOVE_AMOUNT]
            int x = rand.nextInt(MOVE_AMOUNT * 2 + 1) - MOVE_AMOUNT; 
            int y = rand.nextInt(MOVE_AMOUNT * 2 + 1) - MOVE_AMOUNT;
            movePhone(x, y);
        });
        moveTimer.start();
    }
 
    public Phone getPhone() 
    {
        return this.phone;
    }
    
    @Override
    public void paint(Graphics g) 
    {
        paintComponent(g);
        g.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));
        g.drawString("P", 25, 25);
        
        if(this.getPhone().isInfected())
        {          
            this.setBackground(Color.RED);
        }
       
        if(this.getPhone().isDead())
        {
            this.setBackground(Color.BLACK);
        }
        
        if(this.getPhone().isRepairing())
        {
            this.setBackground(Color.ORANGE);
        }
        // handle repaint for when phone in infected or dead, repaired ember/orange
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        if (phone.isInfected()) 
        {
            g2d.setColor(Color.RED);
        } else if (phone.isDead())
        {
            g2d.setColor(Color.BLACK);
        } else
        {
            g2d.setColor(Color.GREEN);
        }

        g2d.fillOval(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
    
    // This method moves the phone icon by the given x and y amounts
    private void movePhone(int x, int y) 
    {
        int curX = this.getX();
        int curY = this.getY();
        int newX = curX + x;
        int newY = curY + y;
        // Ensure the phone icon stays within the bounds of parent container
        if (newX < 0) 
        {
            newX = 0;
        } else if (newX > getParent().getWidth() - getWidth()) 
        {
            newX = getParent().getWidth() - getWidth();
        }
        if (newY < 0) 
        {
            newY = 0;
        } else if (newY > getParent().getHeight() - getHeight()) 
        {
            newY = getParent().getHeight() - getHeight();
        }
        this.setLocation(newX, newY);
    }
}
