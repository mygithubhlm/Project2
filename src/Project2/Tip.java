package Project2;

import javax.swing.*;

import java.awt.event.*;

public class Tip extends JFrame implements ActionListener {
	private JLabel tipMessage1 = new JLabel("    ��ϲ�� ����ɹ�!");
	// private JLabel tipMessage2 = new JLabel("   ��(��o��)���������������");
	private JButton forTrue = new JButton("ȷ��");

	public Tip() {
		setLayout(null);
		add(tipMessage1);
		tipMessage1.setBounds(0, 0, 200, 30);
		add(forTrue);
		forTrue.addActionListener(this);
		forTrue.setBounds(30, 35, 70, 40);
		setTitle("���ؽ���");
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
