import javax.swing.*;
import java.awt.*;

public class TestImageIcon extends JFrame {
  private ImageIcon playerIcon = new ImageIcon("icons/boy.jpg");
  private ImageIcon playerIcon1 = new ImageIcon("icons/dice1.png");
  JButton a = new JButton(playerIcon1);
  JLabel b = new JLabel(playerIcon);
  public TestImageIcon() {
	  setLayout(null);
	  b.add(a);
	  a.setBounds(0, 0, 204, 204);
	  add(b);
	  b.setBounds(0, 0, 500, 500);
  }
  
  public static void main(String[] args) {
	  TestImageIcon frame = new TestImageIcon();
	  frame.setTitle("fff");
	  frame.setSize(600,600);
	  frame.setLocationRelativeTo(null);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  
  }
}
