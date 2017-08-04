package Project2;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class PropShop extends JFrame implements ActionListener {
	private Player p;
	private JLabel tip1 = new JLabel();
	private JLabel tip2 = new JLabel();
	private JButton[] button = new JButton[10];
	static ArrayList propsOfp;// = new ArrayList();
	static Card[] card = { new Card("转向卡"), new Card("遥控色子"), new Card("滞留卡"),
			new Card("掠夺卡"), new Card("均富卡"), new Card("土地卡"), new Card("乌龟卡"),
			new Card("福神卡"), new Card("查税卡"), new Card("财神卡"), };

	// static {
	// Card[] card = new Card[10];
	//
	// for (int i = 0;i<10;i++) {
	// card[i] = new Card();
	// }
	// card[0].SetName("转向卡");
	// card[1].SetName("遥控色子");
	// card[2].SetName("滞留卡");
	// card[3].SetName("路障卡");
	// card[4].SetName("均富卡");
	// card[5].SetName("土地卡");
	// card[6].SetName("乌龟卡");
	// card[7].SetName("福神卡");
	// card[8].SetName("查税卡");
	// card[9].SetName("财神卡");
	// }
	public PropShop(Player p) {
		this.p = p;
		propsOfp = p.getHaveProp();
		setLayout(new FlowLayout(FlowLayout.LEFT, 2, 5));
		tip1.setText("                欢迎来到凯文道具店，每件30点券的道具非常实惠，           ");
		tip2.setText("                                 来挑选你要购买的道具吧~~~                   ");
		button[0] = new JButton("转向卡");
		button[0].addActionListener(this);
		button[1] = new JButton("遥控色子");
		button[1].addActionListener(this);
		button[2] = new JButton("滞留卡");
		button[2].addActionListener(this);
		button[3] = new JButton("掠夺卡");
		button[3].addActionListener(this);
		button[4] = new JButton("均富卡");
		button[4].addActionListener(this);
		button[5] = new JButton("土地卡");
		button[5].addActionListener(this);
		button[6] = new JButton("乌龟卡");
		button[6].addActionListener(this);
		button[7] = new JButton("福神卡");
		button[7].addActionListener(this);
		button[8] = new JButton("查税卡");
		button[8].addActionListener(this);
		button[9] = new JButton("财神卡");
		button[9].addActionListener(this);
		add(tip1);
		add(tip2);
		for (int i = 0; i < 10; i++) {
			add(button[i]);
		}
		setTitle("凯文道具店");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button[0]) {
			// 判断点券是否够用
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[0].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("转向卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("转向卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得转向卡！");
			}
		}
		if (e.getSource() == button[1]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[1].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("遥控色子")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("遥控色子");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得遥控色子！");
			}
		}
		if (e.getSource() == button[2]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[2].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("滞留卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("滞留卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得滞留卡！");
			}
		}
		if (e.getSource() == button[3]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[3].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("掠夺卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("掠夺卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得掠夺卡！");
			}
		}
		if (e.getSource() == button[4]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[4].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("均富卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("均富卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得均富卡！");
			}
		}
		if (e.getSource() == button[5]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[5].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("土地卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("土地卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得土地卡！");
			}
		}
		if (e.getSource() == button[6]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[6].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("乌龟卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("乌龟卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得乌龟卡！");
			}
		}
		if (e.getSource() == button[7]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[7].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("福神卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("福神卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得福神卡！");
			}
		}
		if (e.getSource() == button[8]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[8].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("查税卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("查税卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得查税卡！");
			}
		}
		if (e.getSource() == button[9]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! 你的点券不够啦！！");
			} else {
				p.setGold(-30);
				card[9].setNum();
				// 如果已经有了这个卡，就只把其数目累加
				if (propsOfp.contains("财神卡")) {
				}
				// 如果没有这个卡，就把其数目累加，然后将其名字加进去
				else {
					p.setHaveProp("财神卡");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "恭喜，成功购得财神卡！");
			}
		}
	}
}
