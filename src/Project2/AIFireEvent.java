package Project2;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AIFireEvent extends JPanel implements ActionListener, Runnable {
	//��ʾ��Ϸ���еľ���
	int conPlay = BigMap.conPlay;
	boolean AIplay ;
	BigMap listenerMoney1 = new BigMap();
	BigMap.TimerPropMoneyListener listenerMoney2 = listenerMoney1.new TimerPropMoneyListener();
	private JLabel tipMessage = new JLabel();
	private JPanel panel = new JPanel();
	private JTextField jtfCash = new JTextField("����������");
	private JTextField jtfDecash = new JTextField("������ȡ����");
	JLabel tipBuy = new JLabel();
	JLabel tipLevel = new JLabel();
	JLabel tipDo = new JLabel();
	static JButton btLandOK = new JButton("OK");
	static JButton btLandNO = new JButton("NO");
	static JButton btCash = new JButton("���");
	static JButton btDecash = new JButton("ȡ��");
	private int location;
	private Player p;
	private Player np;
	static Location[] land = new Location[38];
	static {
		for (int i = 0; i < 38; i++) {
			land[i] = new Location();
		}
		//��ʼ����������
		 land[0].setItemName("���ͣ��յ�");
		 land[1].setItemName("���ͣ��յ�");
		land[2].setItemName("��ϲ�㣬���10����ȯ����");
		land[3].setItemName("��ӭ������������ǿ����~~~~");
		land[4].setItemName("��ӭ�������̵��ߵ꣬\n���������������Ҫ��\n���ֵ��ߣ���������������ɣ�!");
		land[5].setItemName("��ӭ��������1�ţ�\n�������һ��õ�");
		land[6].setItemName("��ӭ��������2�ţ�������һ��õأ�");
		land[7].setItemName("��ӭ��������3�ţ�������һ��õأ�");
		land[8].setItemName("��ӭ��������4�ţ�������һ��õأ�");
		land[9].setItemName("��ϲ�㣬���10����ȯ����");
		land[10].setItemName("��ϲ�㣬���30����ȯ����");
		land[11].setItemName("��ӭ����ľ��1�ţ�������һ��õأ�");
		land[12].setItemName("��ӭ����ľ��2�ţ�������һ��õأ�");
		land[13].setItemName("�����Ƕ�����������̨��\n����Ϊ���������һ������~~");
		land[14].setItemName("��ӭ����ľ��3�ţ�������һ��õأ�");
		land[15].setItemName("��ӭ����ľ��4�ţ�������һ��õأ�");
		land[16].setItemName("��ӭ����ˮ��1�ţ�������һ��õأ�");
		land[17].setItemName("��ӭ����ˮ��2�ţ�������һ��õأ�");
		land[18].setItemName("��ӭ��������������Ʊ�꣬�����ѡ�����Ʊ��");
//		land[19]�յ�
		land[20].setItemName("��ϲ�㣬���50����ȯ����");
		land[21].setItemName("��ӭ����ˮ��3�ţ�������һ��õأ�");
		land[22].setItemName("��ӭ����ˮ��4�ţ�������һ��õأ�");
		land[23].setItemName("��ӭ��������1�ţ�������һ��õأ�");
		land[24].setItemName("��ӭ��������2�ţ�������һ��õأ�");
		land[25].setItemName("��ӭ��������3�ţ�������һ��õأ�");
		land[26].setItemName("��ϲ�㣬���10����ȯ����");
		land[27].setItemName("��ӭ������������~~~~");
		land[28].setItemName("��ӭ�������̵��ߵ꣬\n���������������Ҫ��\n���ֵ��ߣ���������ɣ�!");
		land[29].setItemName("��ӭ��������������Ʊ�꣬�����ѡ�����Ʊ��");
		land[30].setItemName("��ϲ�㣬���30����ȯ����");
		land[31].setItemName("�����Ƕ�����������̨��\n����Ϊ���������һ������~~");
		// �յ�
		land[33].setItemName("��ӭ��������4�ţ�������һ��õأ�");
		land[34].setItemName("��ӭ��������1�ţ�������һ��õأ�");
		land[35].setItemName("��ӭ��������2�ţ�������һ��õأ�");
		land[36].setItemName("��ӭ��������3�ţ�������һ��õأ�");
		land[37].setItemName("��ӭ��������4�ţ�������һ��õأ�");
	}
    public AIFireEvent() {
    }
	public AIFireEvent(int location, Player p,Player np,boolean AIplay) {
		this.location = location;
		this.p = p;
		this.AIplay = AIplay;
		setLayout(null);
		switch (location) {
		//�ɳ��۵ķ���
	    case 5:
		case 6:
		case 7:
		case 8:
		case 11:
		case 12:
		case 14:
		case 15:
		case 16:
		case 17:
		case 21:
		case 22:
		case 23:
		case 24:
		case 25:
		case 33:
		case 34:
		case 35:
		case 36:
		case 37: {
			  //�������
			if (AIplay==true) {
					if (land[location].getOwner().equals("��")) {
						//�ֽ����1000
					if (p.getCash()>=1000) {
					land[location].setOwner(p.getName());
					p.setCash(-1000);
					p.setHouseNum();
					p.setHouseValue(1000);
					}
					//�ֽ�����1000
					else {
					}
					if (land[location].getOwner().equals(np.getName())) {
						//�����ڵ�Ϊ���˵ķ���ʱ
						int roadMoney = 200*land[location].getHouseLevel();
						
						//�ж��ֽ��Ƿ�����֧����·��
						if(p.getCash()>=roadMoney) {
						p.setCash(-roadMoney);
						np.setCash(roadMoney);
						}
						//�ֽ𲻹���ʱҪ�ô����֧����·��
						else {
							int lastMoney = roadMoney - p.getCash();
							if (p.getDeposit()>=lastMoney) {
							    p.setCash(-p.getCash());
							    p.setDeposit(-lastMoney);
							    np.setCash(roadMoney);
							}else {
								//�����Ҳ��������֧����·��ʱ��������
								boolean haveHouse = false;
								int leastMoney = roadMoney - p.getCash() - p.getDeposit();
								for (int i = 0;i<38;i++) {
									if (land[i].getOwner()==(p.getName())) {
										p.setCash(-p.getCash());
										p.setDeposit(-p.getDeposit());
										np.setCash(roadMoney);
										haveHouse = true;
										land[i].setOwner(p.getName());
										int houseSellMoney = 1000*land[i].getHouseLevel();
										int theLittleMoney = houseSellMoney - leastMoney;
										p.setCash(theLittleMoney);
									}
								}
								if (haveHouse==false) {
									System.exit(0);
								}
							}
						}
					}
					}
			}
			
			//���ǵ������ʱ
			if (AIplay==false) {
			//�����ڵ�����Ϊ�Լ��ķ���ʱ
			if (land[location].getOwner()==p.getName()) {
				int option = JOptionPane.showConfirmDialog(null, land[location].getItemName() + "\n��ǰ�ȼ���"
					+ land[location].getHouseLevel() + ",   ӵ���ߣ� "
					+ land[location].getOwner()
					+"\n     ������������");
				if (option == 0) {
					//�ж��ֽ��Ƿ��㹻
					if (p.getCash()>500) {
						//�жϷ����ǲ��Ǵﵽ���������
						if (land[location].getHouseValue()>=5) {
						JOptionPane.showMessageDialog(null, "���ķ����Ѿ��ﵽ��߼���");
						}else {
					      JOptionPane.showMessageDialog(null, "��ϲ������500Ԫ�����ɹ���");
					      land[location].setHouseLevel(p);
				          p.setCash(-500);
				          p.setHouseValue(1000);
						}
				}
					else {
						JOptionPane.showMessageDialog(null, "�Բ�������ֽ��㣬�޷�����������");
					}
				}
			
			}//��������δ�۳�ʱ
			else if(land[location].getOwner().equals("��")){
				int option = JOptionPane.showConfirmDialog(null, land[location].getItemName() + "\n��ǰ�ȼ���"
						+ land[location].getHouseLevel() + ",   ӵ���ߣ� "
						+ land[location].getOwner()
						+"\n     ������������");
					//�ж��ֽ��Ƿ��㹻
					 if (p.getCash()>1000) {
						JOptionPane.showMessageDialog(null, "��ϲ������1000���ø�����");
						land[location].setOwner(p.getName());
						p.setCash(-1000);
						p.setHouseNum();
						p.setHouseValue(1000);
					}
			         else {
				     JOptionPane.showMessageDialog(null,"�Բ�������ֽ��㣬�����޷���������أ�");
						
					}
				}
//			}
			else {
				//�����ڵ�Ϊ���˵ķ���ʱ
				int roadMoney = 200*land[location].getHouseLevel();
				
				//�ж��ֽ��Ƿ�����֧����·��
				if(p.getCash()>=roadMoney) {
				JOptionPane.showMessageDialog(null, "��Ŷ��������˱��˵ĵ����ϣ�"
						+ "\n��ǿ�н���"+roadMoney+"�Ĺ�·��~~555");
				p.setCash(-roadMoney);
				np.setCash(roadMoney);
				}
				//�ֽ𲻹���ʱҪ�ô����֧����·��
				else {
					int lastMoney = roadMoney - p.getCash();
					if (p.getDeposit()>=lastMoney) {
						JOptionPane.showMessageDialog(null , "��Ŷ��������˱��˵ĵ����ϣ���������ֽ�"
								+ "\n�����ã����Դ���Ĵ������ȡһ����"
								+ "\n��ǿ�н���"+roadMoney+"�Ĺ�·��~~555");
					    p.setCash(-p.getCash());
					    p.setDeposit(-lastMoney);
					    np.setCash(roadMoney);
					}else {
						//�����Ҳ��������֧����·��ʱ��������
						boolean haveHouse = false;
						int leastMoney = roadMoney - p.getCash() - p.getDeposit();
						for (int i = 0;i<38;i++) {
							if (land[i].getOwner()==(p.getName())) {
								p.setCash(-p.getCash());
								p.setDeposit(-p.getDeposit());
								np.setCash(roadMoney);
								haveHouse = true;
								land[i].setOwner(p.getName());
								int houseSellMoney = 1000*land[i].getHouseLevel();
								int theLittleMoney = houseSellMoney - leastMoney;
								p.setCash(theLittleMoney);
							}
						}
						if (haveHouse==false) {
							JOptionPane.showMessageDialog(null, "�Բ������ļҲ��������⽻Ǯ�ˣ������Ʋ�"
									+ "\n��ϲ���"+np.getName()+"��ʤ������");
							System.exit(0);
						}
					}
				}
			}
		}
		}
			break;
			//����
		case 3:
		case 27: {
			if(AIplay==false) {
			// ��ʾ��Ϣ1���е�λ����Ϣ
			int option = JOptionPane.showConfirmDialog(null,land[location].getItemName()+"\nҪ��ȥ����ô��" ); 
			 if (option == 0) {
				TipBank temp = new TipBank(p);
				temp.setVisible(true);
			 }else{
				 
			 }
//			tipMessage.setText(land[location].getItemName());
			panel.add(tipMessage);
			tipMessage.setBounds(0, 0, 500, 20);
			// ��ʾ��Ϣ2�Ƿ���д�ȡ��
			tipDo.setText("������һ���Ľ�ѡ������Ҫ���еĲ�����");
			panel.add(tipDo);
			tipDo.setBounds(0, 22, 500, 20);
			add(panel);
			panel.setBounds(0, 0, 500, 50);
			// ����button
			add(btCash);
			btCash.setBounds(0, 50, 70, 30);
			add(jtfCash);
			jtfCash.setBounds(75, 50, 400, 30);
			add(btDecash);
			btDecash.setBounds(0, 90, 70, 30);
			add(jtfDecash);
			jtfDecash.setBounds(75, 90, 400, 30);

			btCash.addActionListener(this);
			btCash.addActionListener(listenerMoney2);
			btDecash.addActionListener(this);
			btDecash.addActionListener(listenerMoney2);

//			setTitle("��������ǿ������");
//			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			setSize(510, 170);
//			setLocationRelativeTo(null);// Center the frame
//			setVisible(false);

		}
		}
			break;
			//the ���͵�ȯ��
		case 2:
		case 9:
		case 26:
			if (AIplay==false) {
			JOptionPane.showMessageDialog(jtfDecash, "��ϲ����10��ȯ��");
			p.setGold(10);
			}
			break;
			//the prop shop
		case 4:
		case 28:
			if (AIplay==false) {
			PropShop buyProp = new PropShop(p);
			buyProp.setVisible(true);
			}
			break;
			//the ���͵�ȯ��
		case 10:
		case 30:
			if (AIplay==false) {
			JOptionPane.showMessageDialog(null, "��ϲ����30��ȯ��");
			p.setGold(30);
			}
			break;
			//the ���͵�ȯ��
		case 20:
			if (AIplay==false) {
			JOptionPane.showMessageDialog(null, "��ϲ����50��ȯ��");
			p.setGold(50);
			}
			break;
			//����
		case 13:
		case 31:
			int random = (int)(Math.random()*4+1);
			if (random==1) {
				//event1 : �������������������
				if(p.getHouseValue()>np.getHouseValue()) {
					p.setCash(1000);
					JOptionPane.showMessageDialog(null, "�������������������"+p.getName()+"1000Ԫ");
				}//������˷�����ͬʱ
				else if (p.getHouseValue()==np.getHouseValue()) {
					int ii = (int)(Math.random()*2+1) ;
					if (ii==1){
						p.setCash(1000);
						JOptionPane.showMessageDialog(null, "�����������˵����"+p.getName()+"1000Ԫ");	
					}else{
						np.setCash(1000);
						JOptionPane.showMessageDialog(null, "�����������˵����"+np.getName()+"1000Ԫ");	
					}
				}else {
					np.setCash(1000);
					JOptionPane.showMessageDialog(null, "�������������������"+np.getName()+"1000Ԫ");
				}
			}
			if(random ==2){
				 //event1 : ���������������ٵ����
				if(p.getHouseValue()>np.getHouseValue()) {
					np.setCash(1000);
					JOptionPane.showMessageDialog(null, "���������������ٵ����"+np.getName()+"1000Ԫ");
				}//������˷�����ͬʱ
				else if (p.getHouseValue()==np.getHouseValue()) {
					int ii = (int)(Math.random()*2+1) ;
					if (ii==1){
						p.setCash(1000);
						JOptionPane.showMessageDialog(null, "�����������˵����"+p.getName()+"1000Ԫ");	
					}else{
						np.setCash(1000);
						JOptionPane.showMessageDialog(null, "�����������˵����"+np.getName()+"1000Ԫ");	
					}
				}else {
					p.setCash(1000);
					JOptionPane.showMessageDialog(null, "���������������ٵ����"+p.getName()+"1000Ԫ");
				}
			}
			if (random == 3) {
				//event3 :
				JOptionPane.showMessageDialog(null, "���ϵ��ڱ��ˣ�ÿ�˽���10%����Ϣ");
				p.setDeposit((int)(p.getDeposit()*0.1));
				np.setDeposit((int)(np.getDeposit()*0.1));
			}
			if (random == 4) {
				//event4 :
				int i = (int)(Math.random()*10+1);
				ArrayList propsOfA = p.getHaveProp();
				Card[] card = PropShop.card;
				if (propsOfA.contains(card[i].getName())) {
					card[i].setNum();
				}
				else {
					propsOfA.add(card[i].getName());
				}
				
				int j = (int)(Math.random()*10+1);
				ArrayList propsOfB = np.getHaveProp();
				if (propsOfB.contains(card[j].getName())) {
					card[j].setNum();
				}
				else {
					propsOfB.add(card[j].getName());
				}
				JOptionPane.showMessageDialog(null, "���ǿ������ˣ���������ÿ�˻��һ�ѵ��ߣ�Cheers��");
			}
		default:
		}
	}

	public void UseLandProp (int location ,Player p) {
		this.location = location;
		this.p  = p;
		land[location].setOwner(p.getName());
		JOptionPane.showMessageDialog(null, "���ؿ�ʹ�óɹ�������������ˣ�");
		
	}
	public void run() {
		 try {
		 Thread.sleep(2000);
		 setVisible(false);  //�رմ���
//		 System.exit(0);
		 } catch (InterruptedException e) {
		 e.printStackTrace();
		 }
	}
	public void actionPerformed(ActionEvent e) {
		// ���
//		if (e.getSource() == btLandOK) {
//			if (p.getCash() < 1000) {
//				JOptionPane.showMessageDialog(null, "���������ȥȡ��Ǯ�ɣ����Ǯ�����ˡ���");
//				this.setVisible(false);
//			} else {
//				land[location].setOwner(p.getName());
//				p.setCash(-1000);
//				this.setVisible(false);
//				JOptionPane.showMessageDialog(null, "��ϲ������ɹ���");
//			}
//		}
//		// �����
//		if (e.getSource() == btLandNO) {
//			this.setVisible(false);
//		}
	
	}

}