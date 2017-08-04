package Project2;

import javax.swing.*;

import java.awt.event.*;

public class Tip extends JFrame implements ActionListener {
	private JLabel tipMessage1 = new JLabel("    恭喜， 购买成功!");
	// private JLabel tipMessage2 = new JLabel("   额(⊙o⊙)…，请检查你的输入");
	private JButton forTrue = new JButton("确定");

	public Tip() {
		setLayout(null);
		add(tipMessage1);
		tipMessage1.setBounds(0, 0, 200, 30);
		add(forTrue);
		forTrue.addActionListener(this);
		forTrue.setBounds(30, 35, 70, 40);
		setTitle("土地交易");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(150, 120);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forTrue) {
			this.setVisible(false);
		}
	}
}
