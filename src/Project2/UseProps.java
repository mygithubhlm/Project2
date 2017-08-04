package Project2;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class UseProps extends JFrame implements ActionListener {
	Card[] card = PropShop.card;
	BigMap tem = new BigMap();
	private ImageIcon usePropImage = new ImageIcon("icons/useProp.jpg");
	private JLabel labelProp = new JLabel(usePropImage);
	private JLabel label = new JLabel();
	private JLabel listOfProps = new JLabel();
	private JButton checkMessageOfProp = new JButton("查看道具功能");
	private JButton jbtOK = new JButton("OK");

	// the buttons of props
	static JButton[] prop = new JButton[20];
	private Player p;
	private Player np;

	// the list of number of buttons
	private JPanel panel = new JPanel();
	private JLabel Condice = new JLabel();
	private JLabel numDice = new JLabel();
	private JLabel turnProp = new JLabel();
	private JLabel numTurn = new JLabel();

	// the number of props
	JLabel[] cardName = { new JLabel(card[0].getName()),
			new JLabel(card[1].getName()), new JLabel(card[2].getName()),
			new JLabel(card[3].getName()), new JLabel(card[4].getName()),
			new JLabel(card[5].getName()), new JLabel(card[6].getName()),
			new JLabel(card[7].getName()), new JLabel(card[8].getName()),
			new JLabel(card[9].getName()) };
	JPanel cardNum = new JPanel(new GridLayout(10, 2));
	JLabel cardNum0 = new JLabel();
	JLabel cardNum1 = new JLabel();// new
									// JLabel(String.valueOf(card[0].getNum());
	JLabel cardNum2 = new JLabel();// String.valueOf(card[0].getNum());
	JLabel cardNum3 = new JLabel();
	JLabel cardNum4 = new JLabel();
	JLabel cardNum5 = new JLabel();
	JLabel cardNum6 = new JLabel();
	JLabel cardNum7 = new JLabel();
	JLabel cardNum8 = new JLabel();
	JLabel cardNum9 = new JLabel();

	// 玩家p为使用道具的对象，玩家np为道具的作用对象
	public UseProps(Player p, Player np) {
		this.p = p;
		this.np = np;
		for (int i = 0; i < prop.length; i++) {
			prop[i] = new JButton();
		}
		setLayout(null);

		//
		PropShop.propsOfp = p.getHaveProp();
		if (p.getHaveProp().contains("遥控色子")) {
			card[0].setNum();
		} else {
			PropShop.propsOfp.add("遥控色子");
			card[1].setNum();
		}
		//

		int number = PropShop.propsOfp.size();

		BigMap.ButtonListener listener = tem.new ButtonListener();
		if (number > 0) {
			checkMessageOfProp.addActionListener(this);
			checkMessageOfProp.setBounds(20, 5, 120, 25);
			labelProp.add(checkMessageOfProp);
			label.setText("         请选择你要使用的道具： ");
			labelProp.add(label);
			label.setBounds(0, 35, 200, 14);
			for (int i = 0; i < number; i++) {
				prop[i].setText(PropShop.propsOfp.get(i) + "");
				prop[i].addActionListener(this);
				// prop[i].addActionListener(listener);
				labelProp.add(prop[i]);
				prop[i].setBounds(20, 5 + 25 * (i + 2), 100, 20);
				System.out.println(PropShop.propsOfp.get(i));
			}
			// //
			cardNum.add(cardName[0]);
			cardNum0.setText(String.valueOf(card[0].getNum()));
			cardNum.add(cardNum0);
			//
			cardNum.add(cardName[1]);
			cardNum1.setText(String.valueOf(card[1].getNum()));
			cardNum.add(cardNum1);
			//
			cardNum.add(cardName[2]);
			cardNum2.setText(String.valueOf(card[2].getNum()));
			cardNum.add(cardNum2);
			//
			cardNum.add(cardName[3]);
			cardNum3.setText(String.valueOf(card[3].getNum()));
			cardNum.add(cardNum3);
			//
			cardNum.add(cardName[4]);
			cardNum4.setText(String.valueOf(card[4].getNum()));
			cardNum.add(cardNum4);
			//
			cardNum.add(cardName[5]);
			cardNum5.setText(String.valueOf(card[5].getNum()));
			cardNum.add(cardNum5);
			//
			cardNum.add(cardName[6]);
			cardNum6.setText(String.valueOf(card[6].getNum()));
			cardNum.add(cardNum6);
			//
			cardNum.add(cardName[7]);
			cardNum7.setText(String.valueOf(card[7].getNum()));
			cardNum.add(cardNum7);
			//
			cardNum.add(cardName[8]);
			cardNum8.setText(String.valueOf(card[8].getNum()));
			cardNum.add(cardNum8);
			//
			cardNum.add(cardName[9]);
			cardNum9.setText(String.valueOf(card[9].getNum()));
			cardNum.add(cardNum9);
			//
			labelProp.add(cardNum);
			cardNum.setBounds(400, 0, 150, 300);
			add(labelProp);
			labelProp.setBounds(0, 0, 551, 300);
			setTitle("使用道具");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(570, 337);// (number + 2) * 40 + 50);
			setLocationRelativeTo(null);// Center the frame
			setVisible(false);
		} else {
			label.setText("         抱歉，你目前没有道具可用。");
			label.setBounds(0, 0, 250, 30);
			add(label);
			// add(jbtOK);
			setTitle("使用道具");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(250, 70);
			setLocationRelativeTo(null);// Center the frame
			setVisible(false);

			try {
				Thread.sleep(2000);
				this.dispose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			// card1
			if (e.getSource() == prop[i]) {
				if (prop[i].getText().equals("遥控色子")) {
					System.out.println("yaokongshaizi水水水水");
					try {
						String diceNumberInput = JOptionPane
								.showInputDialog("输入一个1到6的数字：");
						int diceNumber1 = Integer.parseInt(diceNumberInput);
						if (diceNumberInput.equals(null))
							this.setVisible(false);
						else if (diceNumber1 >= 1 && diceNumber1 <= 6) {
							BigMap.useDiceProp(diceNumber1);
							this.setVisible(false);
							if (card[i].getNum() > 0)
								card[i].reduceNum();
							if (card[i].getNum() == 0)
								p.getHaveProp().remove(i);
						} else
							JOptionPane.showMessageDialog(null,
									"只能输入1到6的数字ooo~~~");
						// setVisible(true);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "请检查你的输入！");
					}
				}
				// card2
				if (prop[i].getText().equals("转向卡")) {
					if (Math.abs((np.getLocation() + 19) % 38 - p.getLocation()) <= 5) {
						np.setDirection();
						this.setVisible(false);
						JOptionPane.showMessageDialog(null,
								"嘿嘿，你好坏，你已经把你的对手掉头了！");
						if (card[i].getNum() > 0)
							card[i].reduceNum();
						if (card[i].getNum() == 0)
							p.getHaveProp().remove(i);
					} else {
						JOptionPane.showMessageDialog(null,
								"只有在距离对手5步以内才能使用转向卡！");

					}
				}// card3
				if (prop[i].getText().equals("滞留卡")) {
					BigMap.useStopProp(p);
					this.setVisible(false);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
					JOptionPane.showMessageDialog(null,
							"滞留卡使用成功！点击筛子吧，\n会有意想不到的结果哦!");
				}// card4
				if (prop[i].getText().equals("掠夺卡")) {
					if (BigMap.conPlay % 2 == 0) {
						if (Math.abs(p.getLocation() - (np.getLocation() + 19)
								% 38) <= 5) {
							int cardNum = np.getHaveProp().size();
							int ron = (int) (Math.random() * cardNum + 1);
							np.getHaveProp().remove(ron);
							if (p.getHaveProp().contains(card[ron].getName())) {
								card[ron].setNum();
							} else
								p.getHaveProp().add(card[ron].getName());
							JOptionPane.showMessageDialog(null,
									"掠夺卡使用成功！成功夺取对方一张卡！");
						} else {
							JOptionPane.showMessageDialog(null,
									"只有当距离对方5步以内才能使用掠夺卡");
						}
					} else {
						if (Math.abs((np.getLocation() + 19) % 38
								- p.getLocation()) <= 5) {
							int cardNum = np.getHaveProp().size();
							int ron = (int) (Math.random() * cardNum + 1);
							np.getHaveProp().remove(ron);
							if (p.getHaveProp().contains(card[ron].getName())) {
								card[ron].setNum();
							} else
								p.getHaveProp().add(card[ron].getName());
							JOptionPane.showMessageDialog(null,
									"掠夺卡使用成功！成功夺取对方一张卡！");
						} else {
							JOptionPane.showMessageDialog(null,
									"只有当距离对方5步以内才能使用掠夺卡");
						}
					}
				}// card5
				if (prop[i].getText().equals("均富卡")) {
					int money1 = p.getCash();
					int money2 = np.getCash();
					int midMoney = (money1 + money2) / 2;
					int temp1 = money1 - midMoney;
					p.setCash(temp1);
					int temp2 = money2 - midMoney;
					np.setCash(temp2);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
					JOptionPane.showMessageDialog(null,
							"均富卡使用成功！\n现在你们的现金是一样的！");
				}// card6
				if (prop[i].getText().equals("土地卡")) {
					FireEvent land = new FireEvent(p.getLocation(), p, np);
					land.UseLandProp(p.getLocation(), p);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
				}// card7
				if (prop[i].getText().equals("查税卡")) {
					int depositOfB = np.getDeposit();
					int interest = (int) (np.getDeposit() * 0.3);
					np.setDeposit(-interest);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
					JOptionPane.showMessageDialog(null, "查税卡使用成功!");
				}// card8
				if (prop[i].getText().equals("财神卡")) {
					int cashOfPlayer = p.getCash();
					int temp = (int) (cashOfPlayer * 0.3);
					p.setCash(temp);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
					JOptionPane.showMessageDialog(null, "财神卡使用成功，你见了大便宜啦！");
				}// card9
				if (prop[i].getText().equals("福神卡")) {
					int rr = (int) (Math.random() * 10 + 1);
					if (p.getHaveProp().contains(card[rr].getName())) {
						card[rr].setNum();
					} else
						p.getHaveProp().add(card[rr].getName());
					JOptionPane.showMessageDialog(null,
							"福神降临，你获得了一张道具卡，并且得到10点点券");
				}
				if (prop[i].getText().equals("乌龟卡")) {

				}
			}
		}
		if (e.getSource() == checkMessageOfProp) {
			JOptionPane.showMessageDialog(null, "0---福神卡：使用时立即获得一张卡片，并增加10点点券"
					+ "\n1---转向卡：使五步以内的那个他掉头。" + "\n2---遥控色子：可以控制色子的结果。"
					+ "\n3---滞留卡：使自己停留在原位置并再次出发该地的事件。"
					+ "\n4---掠夺卡：随机获得对方的一张卡片，并获得10点点券。"
					+ "\n5---乌龟卡：使对手行军速度降至最低。"
					+ "\n6---土地卡：若停留在其他人的土地所在地，可以在缴纳过路费"
					+ "\n后将该土地免费据为己有；若停留在无主土地直接据为己有 "
					+ "\n7---均富卡：使自己和对方玩家的现金平均分配。"
					+ "\n8---查税卡：强行将对方30%的存款缴税(所缴税款并不给查税卡的发动者）。"
					+ "\n9---财神卡：使用时使自己的现金增加百分之十。");

		}
	}
}
