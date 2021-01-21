import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class DiceRoll extends JPanel implements ActionListener
{
   JButton button = new JButton("Roll Dice");
   Random rand = new Random();
   int number = 0;
   Font font = new Font("Arial", Font.BOLD, 18);
   String numberText = "";
   Color lightBlue = new Color(153, 204, 255);
   
   public DiceRoll()
   {
      setBackground(lightBlue);
      add(button);
      button.setBackground(Color.BLACK);
      button.setForeground(Color.WHITE);
      button.addActionListener(this);
   }
  
   public void actionPerformed(ActionEvent e) // Event when clicking the button
   {
      number = rand.nextInt(6) + 1; // sets number to a randomly generated number between 1 and 6
      numberText = "You rolled a " + number + ".";
      repaint();
    }
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      
    if(number > 0 && number <= 6) // Creates the white square for the dice
    {
     g.setColor(Color.BLACK);
     g.fillRoundRect(60, 55, 160, 160, 40, 40);
     g.setColor(Color.WHITE);
     g.fillRoundRect(65, 60, 150, 150, 30, 30);
     g.setColor(Color.black); 
    } 
    else
    {
    }
     
    switch (number) { // Creates the dots on the dice depending on what number is generated
      case 1:  g.fillOval(130, 125, 20, 20); // middle dot
               break;
      case 2:  g.fillOval(170, 80, 20, 20); // Top right dot
               g.fillOval(90, 170, 20, 20); // Bottom left dot
               break;
      case 3:  g.fillOval(170, 80, 20, 20); // Top right dot
               g.fillOval(90, 170, 20, 20); // Bottom left dot
               g.fillOval(130, 125, 20, 20); // middle dot
               break;
      case 4:  g.fillOval(170, 80, 20, 20); // Top right dot
               g.fillOval(90, 80, 20, 20); // Top left dot
               g.fillOval(170, 170, 20, 20); // Bottom right dot
               g.fillOval(90, 170, 20, 20); // Bottom left dot
               break;
      case 5:  g.fillOval(170, 80, 20, 20); // Top right dot
               g.fillOval(90, 80, 20, 20); // Top left dot
               g.fillOval(170, 170, 20, 20); // Bottom right dot
               g.fillOval(90, 170, 20, 20); // Bottom left dot
               g.fillOval(130, 125, 20, 20); // middle dot
               break;
      case 6:  g.fillOval(170, 80, 20, 20); // Top right dot
               g.fillOval(170, 125, 20, 20); // Middle right dot
               g.fillOval(90, 125, 20, 20); // Middle left dot
               g.fillOval(90, 80, 20, 20); // Top left dot
               g.fillOval(170, 170, 20, 20); // Bottom right dot
               g.fillOval(90, 170, 20, 20); // Bottom left dot
               break;
      default: 
               break;
        }
      g.setFont(font);
      g.drawString(numberText, 75, 250); // Displays text to state what you rolled
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new DiceRoll());
      frame.setTitle("Dice Roller");
      frame.setSize(300, 320);
      frame.setVisible(true);
   }
}