package Project2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TipBank extends JFrame implements ActionListener {
	private Player p;
	private ImageIcon bankImage = new ImageIcon("icons/tipBank.jpg");
	private JLabel tipBank = new JLabel(bankImage);
	private JLabel tipMessage1 = new JLabel("请输入您的取款金额，并点击取款按钮！");
	private JLabel tipMessage2 = new JLabel("请输入您的存款金额，并点击存款按钮！");
	private JTextField jtfOutCash = new JTextField("请输入取款金额");
	private JTextField jtfInCash = new JTextField("请输入存款金额");
	private JButton btInCash = new JButton("取款");
	private JButton btOutCash = new JButton("存款");

	// private JLabel tipMessage2 = new JLabel("   额(⊙o⊙)…，请检查你的输入");
	// private JButton forTrue = new JButton("确定");

	JLabel cash11 = new JLabel("现金：");
	JLabel cash1 = new JLabel("10000");
	JLabel deposit11 = new JLabel("存款：");
	JLabel deposit1 = new JLabel("10000");
	JLabel gold11 = new JLabel("点券：");
	JLabel gold1 = new JLabel("2000 ");
	JLabel houseValue11 = new JLabel("房产：");
	JLabel houseValue1 = new JLabel("20000");
	JLabel totalValue11 = new JLabel("资产：");
	JLabel totalValue1 = new JLabel("200000");
	JPanel p3 = new JPanel(new GridLayout(5, 2));

	public TipBank(Player p) {
		this.p = p;
		setLayout(null);
		// tip1
		tipBank.add(tipMessage1);
		tipMessage1.setBounds(20, 20, 150, 30);

		// text field
		tipBank.add(jtfOutCash);
		jtfOutCash.setBounds(20, 50, 150, 30);

		// the button for cash
		tipBank.add(btOutCash);
		btOutCash.addActionListener(this);
		btOutCash.setBounds(67, 90, 60, 30);

		// tip2
		tipBank.add(tipMessage2);
		tipMessage2.setBounds(20, 160, 150, 30);

		// text field
		tipBank.add(jtfInCash);
		jtfInCash.setBounds(20, 190, 150, 30);

		// the button for cash
		tipBank.add(btInCash);
		btInCash.addActionListener(this);
		btInCash.setBounds(67, 230, 60, 30);

		add(tipBank);
		tipBank.setBounds(0, 0, 580, 310);

		p3.add(cash11);
		p3.add(cash1);
		cash1.setText(String.valueOf(p.getCash()));
		p3.add(deposit11);
		p3.add(deposit1);
		deposit1.setText(p.getDeposit() + "");
		p3.add(gold11);
		p3.add(gold1);
		gold1.setText(p.getGold() + "");
		p3.add(houseValue11);
		p3.add(houseValue1);
		houseValue1.setText(p.getHouseValue() + "");
		p3.add(totalValue11);
		p3.add(totalValue1);
		totalValue1.setText(p.getTotalValue() + "");
		p3.setBorder(new TitledBorder("你的资产信息"));
		p3.setBounds(440, 0, 130, 310);
		tipBank.add(p3);

		setTitle("艾尔·马强银行");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(580, 350);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
		// tipBank.
		// forTrue.addActionListener(this);
		//
		// forTrue.setBounds(70, 35, 60, 40);
	}

	public void actionPerformed(ActionEvent e) {
		// 取款按钮
		if (e.getSource() == btOutCash) {
			try {
				int cash = Integer.parseInt(jtfOutCash.getText());
				if (p.getCash() > cash && cash >= 0) {
					p.setCash(-cash);
					p.setDeposit(cash);
					setVisible(false);
					JOptionPane.showMessageDialog(null, "存款成功!");
				} else {
					this.setVisible(true);
					JOptionPane.showMessageDialog(null, "对不起，您的输入有误！");
				}
			} catch (Exception ex) {
				this.setVisible(true);
				JOptionPane.showMessageDialog(null, "对不起，您的输入有误！");
			}
		}
		// 存款按钮
		if (e.getSource() == btInCash) {
			try {
				int deCash = Integer.parseInt(jtfInCash.getText());
				if (p.getDeposit() > deCash && deCash >= 0) {
					p.setCash(deCash);
					p.setDeposit(-deCash);
					setVisible(false);
					JOptionPane.showMessageDialog(null, "取款成功!");
				} else {
					this.setVisible(true);
					JOptionPane.showMessageDialog(null, "对不起，您的输入有误！");
				}
			} catch (Exception ex) {
				this.setVisible(true);
				JOptionPane.showMessageDialog(null, "对不起，您的输入有误！");
			}
		}
	}
}
