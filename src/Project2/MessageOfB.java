package Project2;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class MessageOfB extends JFrame {
//	private ImageIcon b = new ImageIcon(" ");
	JLabel cash21 = new JLabel("�ֽ�");
	JLabel cash2 = new JLabel();
	JLabel deposit21 = new JLabel("��");
	JLabel deposit2 = new JLabel("10000");
	JLabel gold21 = new JLabel("��ȯ��");
	JLabel gold2 = new JLabel("2000 ");
	JLabel houseValue21 = new JLabel("������");
	JLabel houseValue2 = new JLabel("20000");
	JLabel totalValue21 = new JLabel("�ʲ���");
	JLabel totalValue2 = new JLabel("200000");
	JPanel p4 = new JPanel(new GridLayout(5, 2));

	//���B���ʲ���Ϣ
	public MessageOfB(Player b) {
		setLayout(null);
		p4.add(cash21);
		p4.add(cash2);
		cash2.setText(String.valueOf(b.getCash()));
		p4.add(deposit21);
		p4.add(deposit2);
		deposit2.setText(String.valueOf(b.getDeposit()));
		p4.add(gold21);
		p4.add(gold2);
		gold2.setText(String.valueOf(b.getGold()));
		p4.add(houseValue21);
		p4.add(houseValue2);
		houseValue2.setText(String.valueOf(b.getHouseValue()));
		p4.add(totalValue21);
		p4.add(totalValue2);
		totalValue2.setText(String.valueOf(b.getTotalValue()));
		p4.setBorder(new TitledBorder("���B�ʲ���Ϣ"));
		p4.setBounds(3, 3, 158, 128);
		add(p4);

		setTitle("���B���ʲ���Ϣ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(180, 175);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}

}
