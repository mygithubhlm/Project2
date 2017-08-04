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
	static Card[] card = { new Card("ת��"), new Card("ң��ɫ��"), new Card("������"),
			new Card("�ӶῨ"), new Card("������"), new Card("���ؿ�"), new Card("�ڹ꿨"),
			new Card("����"), new Card("��˰��"), new Card("����"), };

	// static {
	// Card[] card = new Card[10];
	//
	// for (int i = 0;i<10;i++) {
	// card[i] = new Card();
	// }
	// card[0].SetName("ת��");
	// card[1].SetName("ң��ɫ��");
	// card[2].SetName("������");
	// card[3].SetName("·�Ͽ�");
	// card[4].SetName("������");
	// card[5].SetName("���ؿ�");
	// card[6].SetName("�ڹ꿨");
	// card[7].SetName("����");
	// card[8].SetName("��˰��");
	// card[9].SetName("����");
	// }
	public PropShop(Player p) {
		this.p = p;
		propsOfp = p.getHaveProp();
		setLayout(new FlowLayout(FlowLayout.LEFT, 2, 5));
		tip1.setText("                ��ӭ�������ĵ��ߵ꣬ÿ��30��ȯ�ĵ��߷ǳ�ʵ�ݣ�           ");
		tip2.setText("                                 ����ѡ��Ҫ����ĵ��߰�~~~                   ");
		button[0] = new JButton("ת��");
		button[0].addActionListener(this);
		button[1] = new JButton("ң��ɫ��");
		button[1].addActionListener(this);
		button[2] = new JButton("������");
		button[2].addActionListener(this);
		button[3] = new JButton("�ӶῨ");
		button[3].addActionListener(this);
		button[4] = new JButton("������");
		button[4].addActionListener(this);
		button[5] = new JButton("���ؿ�");
		button[5].addActionListener(this);
		button[6] = new JButton("�ڹ꿨");
		button[6].addActionListener(this);
		button[7] = new JButton("����");
		button[7].addActionListener(this);
		button[8] = new JButton("��˰��");
		button[8].addActionListener(this);
		button[9] = new JButton("����");
		button[9].addActionListener(this);
		add(tip1);
		add(tip2);
		for (int i = 0; i < 10; i++) {
			add(button[i]);
		}
		setTitle("���ĵ��ߵ�");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button[0]) {
			// �жϵ�ȯ�Ƿ���
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[0].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("ת��")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("ת��");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ�����ת�򿨣�");
			}
		}
		if (e.getSource() == button[1]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[1].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("ң��ɫ��")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("ң��ɫ��");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ�����ң��ɫ�ӣ�");
			}
		}
		if (e.getSource() == button[2]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[2].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("������")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("������");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ�������������");
			}
		}
		if (e.getSource() == button[3]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[3].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("�ӶῨ")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("�ӶῨ");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ������ӶῨ��");
			}
		}
		if (e.getSource() == button[4]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[4].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("������")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("������");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ����þ�������");
			}
		}
		if (e.getSource() == button[5]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[5].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("���ؿ�")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("���ؿ�");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ��������ؿ���");
			}
		}
		if (e.getSource() == button[6]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[6].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("�ڹ꿨")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("�ڹ꿨");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ������ڹ꿨��");
			}
		}
		if (e.getSource() == button[7]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[7].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("����")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("����");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ����ø��񿨣�");
			}
		}
		if (e.getSource() == button[8]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[8].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("��˰��")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("��˰��");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ����ò�˰����");
			}
		}
		if (e.getSource() == button[9]) {
			if (p.getGold() < 30) {
				JOptionPane.showMessageDialog(null, "Sorry! ��ĵ�ȯ����������");
			} else {
				p.setGold(-30);
				card[9].setNum();
				// ����Ѿ��������������ֻ������Ŀ�ۼ�
				if (propsOfp.contains("����")) {
				}
				// ���û����������Ͱ�����Ŀ�ۼӣ�Ȼ�������ּӽ�ȥ
				else {
					p.setHaveProp("����");
				}
				// ArrayList a = p.getHaveProp();
				// System.out.println(a.get(0));
				JOptionPane.showMessageDialog(null, "��ϲ���ɹ����ò��񿨣�");
			}
		}
	}
}
