
package quiz_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener {
    
    Score(String name, int score)
    {
         getContentPane().setBackground(Color.white);
        setBounds(400,150,750,550);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel heading = new JLabel("Thankyou " + name + " for playing simple minds" );
        heading.setFont(new Font("Tahuma", Font.PLAIN, 26));
        heading.setBounds(45, 30, 700, 30);
        add(heading);
        
        JLabel lbl_score = new JLabel("Your Score is " + score );
        lbl_score .setFont(new Font("Tahoma", Font.PLAIN, 26));
        lbl_score .setBounds(350, 200, 300, 30);
        add(lbl_score );
         
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 40);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Login();
    }
    
     public static void main(String[] args)
     {
         new Score("user",0);
     }
}
