/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_1_2023_s1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Nathan
 */
public class Simulation extends JFrame implements KeyListener 
{
    public ArrayList<PhoneIcon> phoneList;
    
    public ArrayList<PhoneIcon> getPhoneList()
    {
        return phoneList;
    }
    private final JPanel panel;
    private boolean infectedFlag;
    
    public Simulation() 
    {
        this.phoneList = new ArrayList<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Phone Virus Simulation");
        
        this.panel = new JPanel();
        
        addPhone();
        
        this.setSize(1000, 1000);
        this.add(this.panel);
        this.setVisible(true);
        
        this.addKeyListener(this);
        
        this.infectedFlag = false;
    }
    
    private void addPhone() 
    {
        PhoneIcon newPhone = newPhone();
        this.panel.add(newPhone);
        this.phoneList.add(newPhone);
        this.panel.repaint();
    }
    
    public void infectPhone() 
    {
        PhoneIcon infectedPhone = null;

        // find the first infected phone
        for (PhoneIcon phone : phoneList) 
        {
            if (phone.getPhone().isInfected()) 
            {
                infectedPhone = phone;
                break;
            }
        }

        if (infectedPhone == null) 
        {
            return;
        }

        // check if any uninfected phone is within 20 pixels of the infected phone
        for (PhoneIcon phone : phoneList) 
        {
            if (phone != infectedPhone && !phone.getPhone().isInfected()) 
            {
                int dx = infectedPhone.getX() - phone.getX();
                int dy = infectedPhone.getY() - phone.getY();
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance <= 20) 
                {
                    phone.getPhone().infect();
                }
            }
        }
    }
    
    public void deadPhone()
    {
        int index = (int) (Math.random() * phoneList.size());
        PhoneIcon phoneThatIsDead = phoneList.get(index);
        phoneThatIsDead.getPhone().dead();
    }
    
    private PhoneIcon newPhone() 
    {
        PhoneIcon newPhone = new PhoneIcon();
        int x = (int) (Math.random() * (1000 - 50));
        int y = (int) (Math.random() * (1000- 50));
        newPhone.setBounds(x, y, 50, 50);
        
        return newPhone;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
//       throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_UP) 
        {
            addPhone();
            System.out.println("new phone added");
        } else if (e.getKeyCode() == KeyEvent.VK_V && !infectedFlag) 
        { // check if "v" key is pressed and no phone is already infected
            int index = (int) (Math.random() * phoneList.size()); // select a random phone from the list
            PhoneIcon phoneToBeInfected = phoneList.get(index);
            phoneToBeInfected.getPhone().infect(); // infect the phone

            infectedFlag = true; // set infected flag to true
        } 
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("keyReleased");
    }   
}
