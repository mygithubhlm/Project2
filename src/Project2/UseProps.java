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
	private JButton checkMessageOfProp = new JButton("�鿴���߹���");
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

	// ���pΪʹ�õ��ߵĶ������npΪ���ߵ����ö���
	public UseProps(Player p, Player np) {
		this.p = p;
		this.np = np;
		for (int i = 0; i < prop.length; i++) {
			prop[i] = new JButton();
		}
		setLayout(null);

		//
		PropShop.propsOfp = p.getHaveProp();
		if (p.getHaveProp().contains("ң��ɫ��")) {
			card[0].setNum();
		} else {
			PropShop.propsOfp.add("ң��ɫ��");
			card[1].setNum();
		}
		//

		int number = PropShop.propsOfp.size();

		BigMap.ButtonListener listener = tem.new ButtonListener();
		if (number > 0) {
			checkMessageOfProp.addActionListener(this);
			checkMessageOfProp.setBounds(20, 5, 120, 25);
			labelProp.add(checkMessageOfProp);
			label.setText("         ��ѡ����Ҫʹ�õĵ��ߣ� ");
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
			setTitle("ʹ�õ���");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(570, 337);// (number + 2) * 40 + 50);
			setLocationRelativeTo(null);// Center the frame
			setVisible(false);
		} else {
			label.setText("         ��Ǹ����Ŀǰû�е��߿��á�");
			label.setBounds(0, 0, 250, 30);
			add(label);
			// add(jbtOK);
			setTitle("ʹ�õ���");
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
				if (prop[i].getText().equals("ң��ɫ��")) {
					System.out.println("yaokongshaiziˮˮˮˮ");
					try {
						String diceNumberInput = JOptionPane
								.showInputDialog("����һ��1��6�����֣�");
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
									"ֻ������1��6������ooo~~~");
						// setVisible(true);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "����������룡");
					}
				}
				// card2
				if (prop[i].getText().equals("ת��")) {
					if (Math.abs((np.getLocation() + 19) % 38 - p.getLocation()) <= 5) {
						np.setDirection();
						this.setVisible(false);
						JOptionPane.showMessageDialog(null,
								"�ٺ٣���û������Ѿ�����Ķ��ֵ�ͷ�ˣ�");
						if (card[i].getNum() > 0)
							card[i].reduceNum();
						if (card[i].getNum() == 0)
							p.getHaveProp().remove(i);
					} else {
						JOptionPane.showMessageDialog(null,
								"ֻ���ھ������5�����ڲ���ʹ��ת�򿨣�");

					}
				}// card3
				if (prop[i].getText().equals("������")) {
					BigMap.useStopProp(p);
					this.setVisible(false);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
					JOptionPane.showMessageDialog(null,
							"������ʹ�óɹ������ɸ�Ӱɣ�\n�������벻���Ľ��Ŷ!");
				}// card4
				if (prop[i].getText().equals("�ӶῨ")) {
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
									"�ӶῨʹ�óɹ����ɹ���ȡ�Է�һ�ſ���");
						} else {
							JOptionPane.showMessageDialog(null,
									"ֻ�е�����Է�5�����ڲ���ʹ���ӶῨ");
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
									"�ӶῨʹ�óɹ����ɹ���ȡ�Է�һ�ſ���");
						} else {
							JOptionPane.showMessageDialog(null,
									"ֻ�е�����Է�5�����ڲ���ʹ���ӶῨ");
						}
					}
				}// card5
				if (prop[i].getText().equals("������")) {
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
							"������ʹ�óɹ���\n�������ǵ��ֽ���һ���ģ�");
				}// card6
				if (prop[i].getText().equals("���ؿ�")) {
					FireEvent land = new FireEvent(p.getLocation(), p, np);
					land.UseLandProp(p.getLocation(), p);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
				}// card7
				if (prop[i].getText().equals("��˰��")) {
					int depositOfB = np.getDeposit();
					int interest = (int) (np.getDeposit() * 0.3);
					np.setDeposit(-interest);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
					JOptionPane.showMessageDialog(null, "��˰��ʹ�óɹ�!");
				}// card8
				if (prop[i].getText().equals("����")) {
					int cashOfPlayer = p.getCash();
					int temp = (int) (cashOfPlayer * 0.3);
					p.setCash(temp);
					if (card[i].getNum() > 0)
						card[i].reduceNum();
					if (card[i].getNum() == 0)
						p.getHaveProp().remove(i);
					JOptionPane.showMessageDialog(null, "����ʹ�óɹ�������˴��������");
				}// card9
				if (prop[i].getText().equals("����")) {
					int rr = (int) (Math.random() * 10 + 1);
					if (p.getHaveProp().contains(card[rr].getName())) {
						card[rr].setNum();
					} else
						p.getHaveProp().add(card[rr].getName());
					JOptionPane.showMessageDialog(null,
							"�����٣�������һ�ŵ��߿������ҵõ�10���ȯ");
				}
				if (prop[i].getText().equals("�ڹ꿨")) {

				}
			}
		}
		if (e.getSource() == checkMessageOfProp) {
			JOptionPane.showMessageDialog(null, "0---���񿨣�ʹ��ʱ�������һ�ſ�Ƭ��������10���ȯ"
					+ "\n1---ת�򿨣�ʹ�岽���ڵ��Ǹ�����ͷ��" + "\n2---ң��ɫ�ӣ����Կ���ɫ�ӵĽ����"
					+ "\n3---��������ʹ�Լ�ͣ����ԭλ�ò��ٴγ����õص��¼���"
					+ "\n4---�ӶῨ�������öԷ���һ�ſ�Ƭ�������10���ȯ��"
					+ "\n5---�ڹ꿨��ʹ�����о��ٶȽ�����͡�"
					+ "\n6---���ؿ�����ͣ���������˵��������ڵأ������ڽ��ɹ�·��"
					+ "\n�󽫸�������Ѿ�Ϊ���У���ͣ������������ֱ�Ӿ�Ϊ���� "
					+ "\n7---��������ʹ�Լ��ͶԷ���ҵ��ֽ�ƽ�����䡣"
					+ "\n8---��˰����ǿ�н��Է�30%�Ĵ���˰(����˰�������˰���ķ����ߣ���"
					+ "\n9---���񿨣�ʹ��ʱʹ�Լ����ֽ����Ӱٷ�֮ʮ��");

		}
	}
}
