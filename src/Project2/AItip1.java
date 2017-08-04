package Project2;

import javax.swing.*;

public class AItip1 extends JFrame {
	private JLabel tip1 = new JLabel();
	private JLabel tip2 = new JLabel();

	public AItip1() {
		setLayout(null);
		tip1.setText("花费1000元购买土地成功！");
		tip1.setBounds(10, 10, 100, 30);
		add(tip1);
		setTitle("Monopoly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(130, 50);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}
}
