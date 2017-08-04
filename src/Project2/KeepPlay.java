package Project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

public class KeepPlay extends JFrame implements ActionListener {
	Player x = BigMap.a;
	Player y = BigMap.b;
	private JLabel tip0 = new JLabel();
	private JButton forTrue = new JButton("开始");
	private JButton choose = new JButton("选择");
	
   //读取文件
	public KeepPlay() {
		setLayout(null);
		tip0.setText("选择你要读取的文件，然后点击开始按钮。");
		add(tip0);
		tip0.setBounds(10, 10, 300, 25);
		add(forTrue);
		forTrue.addActionListener(this);
		forTrue.setBounds(160, 40, 60, 30);
		add(choose);
		choose.addActionListener(this);
		choose.setBounds(80, 40, 60, 30);
		setTitle("继续游戏");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(330, 130);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == choose) {
			//读取文件
			try {
				Read read = new Read(x, y);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			TestBigMap big = new TestBigMap(x, y);
			big.setVisible(true);
			setVisible(false);
		}
		if (e.getSource() == forTrue) {
			TestBigMap big = new TestBigMap(x, y);
			big.setVisible(true);
			setVisible(false);
		}
	}
}
