package Project2;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class MessageOfA extends JFrame {
    JLabel cash11 = new JLabel("�ֽ�");
	JLabel cash1 = new JLabel("10000");
	JLabel deposit11 = new JLabel("��");
	JLabel deposit1 = new JLabel("10000");
	JLabel gold11 = new JLabel("��ȯ��");
	JLabel gold1 = new JLabel("2000 ");
	JLabel houseValue11 = new JLabel("������");
	JLabel houseValue1 = new JLabel("20000");
	JLabel totalValue11 = new JLabel("�ʲ���");
	JLabel totalValue1 = new JLabel("200000");
	JPanel p3 = new JPanel(new GridLayout(5, 2));

	//���A���ʲ���Ϣ
   public MessageOfA (Player a) {
	   
	   setLayout(null);
	   // The message of playerA
	    p3.add(cash11);
		p3.add(cash1);
		cash1.setText(String.valueOf(a.getCash()));
		p3.add(deposit11);
		p3.add(deposit1);
		deposit1.setText(a.getDeposit() + "");
		p3.add(gold11);
		p3.add(gold1);
		gold1.setText(a.getGold() + "");
		p3.add(houseValue11);
		p3.add(houseValue1);
		houseValue1.setText(a.getHouseValue() + "");
		p3.add(totalValue11);
		p3.add(totalValue1);
		totalValue1.setText(a.getTotalValue() + "");
		p3.setBorder(new TitledBorder("���A�ʲ���Ϣ"));
		p3.setBounds(3, 3, 158, 130);
		add(p3);
		setTitle("���A���ʲ���Ϣ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(180, 175);
		setLocationRelativeTo(null);// Center the frame
		setVisible(true);
   }
//		public void actionPerformed (ActionEvent e) {
////			if (e.getSource()==bt1) {
////				timee.start();
////			}
////			if (e.getSource()==timee) {
////				System.out.println("222");
////			}
//		}
   }

