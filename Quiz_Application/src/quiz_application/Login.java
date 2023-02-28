
package quiz_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
     JButton rule,back;
     JTextField tf;
        Login(){
            getContentPane().setBackground(Color.white);
            setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0,600,480);
            add(image);
            
            JLabel heading = new JLabel("Simple Minds");
            heading.setBounds(780,60,300,45);
            heading.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
            heading.setForeground(Color.blue);
            add(heading);
            
            JLabel name = new JLabel("Enter Your Name");
            name.setBounds(810,150,300,20);
            name.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
            name.setForeground(Color.blue);
            add(name);
            
            
            tf = new JTextField();
            tf.setBounds(735,200,300,25);
            tf.setFont(new Font("Times New Roman",Font.BOLD,15));
            add(tf);
            
            
            rule = new JButton("Rules");
            rule.setBounds(735,270,120,25);
            rule.setBackground(new Color(30,144,254));
            rule.setForeground(Color.white);
            rule.addActionListener(this);
            add(rule);
            
            
            back = new JButton("Back");
            back.setBounds(915,270,120,25);
            back.setBackground(new Color(30,144,254));
            back.setForeground(Color.white);
            back.addActionListener(this);
            add(back);
            
            
            
            setSize(1200,500);
            setLocation(120,150);
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource()==rule){
                
                String name = tf.getText();
                setVisible(false);
                new Rules(name);
            }
            else if(ae.getSource()==back){
                setVisible(false);
            }
        }
     public static void main(String[] args){
         
         new Login();
     }
}
