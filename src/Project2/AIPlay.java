package Project2;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AIPlay extends JFrame implements java.io.Serializable {

	ButtonListener listener = new ButtonListener();
	static boolean AIplay = false;
	static Player a = new Player();
	static Player b = new Player();
	int i;
	int i_f;
	int i2;// = 20 + b.getLocation();// - diceResult;
	int i2_f;// = (b.getLocation() + 19 - 1 + 38) % 38;
	static Date shijian = new Date();
	Location[] land = FireEvent.land;
	// 初始化土地的坐标
	int[][] p = {
			{ 38, 236, 45, 32 },// button 1
			{ 84, 236, 45, 32 },// button 2
			{ 128, 236, 45, 32 },
			{ 172, 236, 45, 32 },
			{ 215, 237, 45, 32 },
			{ 258, 237, 44, 32 },
			{ 302, 237, 44, 32 },// button7
			{ 346, 237, 44, 32 },
			{ 390, 237, 44, 32 },
			{ 434, 235, 44, 33 },

			{ 434, 270, 44, 32 },// button 11
			{ 477, 270, 44, 32 },
			{ 522, 270, 44, 32 },
			{ 563, 270, 44, 32 },

			{ 563, 302, 48, 32 },// button 15
			{ 563, 334, 48, 32 }, { 563, 366, 48, 32 },
			{ 563, 398, 48, 32 },
			{ 564, 430, 48, 33 },
			{ 564, 464, 48, 33 },

			{ 520, 465, 44, 32 },// button 21
			{ 476, 465, 44, 32 }, { 432, 465, 44, 32 }, { 388, 465, 44, 32 },
			{ 344, 465, 44, 32 },
			{ 300, 465, 44, 32 },
			{ 256, 465, 44, 32 },// button27
			{ 212, 465, 44, 32 }, { 168, 465, 44, 32 }, { 124, 465, 44, 32 },
			{ 80, 465, 44, 32 }, { 38, 465, 44, 32 },

			{ 37, 431, 44, 32 },// button 33
			{ 37, 399, 48, 32 }, { 37, 365, 48, 32 }, { 37, 333, 48, 32 },
			{ 37, 301, 48, 32 }, { 37, 269, 48, 32 },// button 38
	};

	// The background map
	int conDice = 0;
	static int conPlay = 0;
	static int playTimes = 0;
	static int diceResult;

	static boolean useDiceProp = false;
	// static boolean useTurnPropa = false;
	// static boolean useTurnPropb = false;
	static boolean useStopProp = false;
	static int diceNumber = 0;
	static boolean musicOn = false;
	private ImageIcon bigMap = new ImageIcon("icons/bigmap3.jpg");

	// All kinds of buttons
	private ImageIcon bt1Image = new ImageIcon("icons/bigbt1.jpg");
	private ImageIcon bt1Image2 = new ImageIcon("icons/bigbt1.jpg");
	private ImageIcon bt1Image3 = new ImageIcon("icons/bigbt1.jpg");
	private ImageIcon bt1Image4 = new ImageIcon("icons/bigbt1.jpg");
	private ImageIcon bt1Image5 = new ImageIcon("icons/bigbt1.jpg");
	private ImageIcon bt1Image6 = new ImageIcon("icons/bigbt1_1.jpg");
	private ImageIcon bt1Image7 = new ImageIcon("icons/bigbt1_1.jpg");
	private ImageIcon bt1Image8 = new ImageIcon("icons/bigbt1_1.jpg");
	private ImageIcon bt1Image9 = new ImageIcon("icons/bigbt1_1.jpg");
	private ImageIcon bt1Image10 = new ImageIcon("icons/bigbt1_1.jpg");
	private ImageIcon bt1Image11 = new ImageIcon("icons/bigbt1_1.jpg");
	private ImageIcon bt2Image = new ImageIcon("icons/bigbt2.jpg");
	private ImageIcon bt3Image = new ImageIcon("icons/bigbt3.jpg");
	private ImageIcon bt4Image = new ImageIcon("icons/bigbt4.jpg");
	private ImageIcon bt5Image = new ImageIcon("icons/big空地.jpg");
	private ImageIcon bt6Image = new ImageIcon("icons/big新闻.jpg");
	private ImageIcon bt7Image = new ImageIcon("icons/big银行.jpg");
	private ImageIcon bt8Image = new ImageIcon("icons/big商店.jpg");
	private ImageIcon bt91Image = new ImageIcon("icons/big券10.jpg");
	private ImageIcon bt92Image = new ImageIcon("icons/big券30.jpg");
	private ImageIcon bt93Image = new ImageIcon("icons/big券50.jpg");

	// 道具
	private ImageIcon IconProps = new ImageIcon("icons/道具.jpg");

	// music
	private ImageIcon IconMusic = new ImageIcon("icons/musicIcon.png");

	// save File
	private ImageIcon IconSave = new ImageIcon("icons/save.jpg");
	private ImageIcon IconEnd = new ImageIcon("icons/read2.jpg");

	// The two players
	private ImageIcon player1 = new ImageIcon("icons/pGril.jpg");
	private ImageIcon player1Icon = new ImageIcon("icons/pGrilIcon.jpg");
	private ImageIcon messageOfAImage = new ImageIcon("icons/newGril2.jpg");

	private ImageIcon player2 = new ImageIcon("icons/pBoy.jpg");
	private ImageIcon player2Icon = new ImageIcon("icons/pBoyIcon.jpg");
	private ImageIcon messageOfBImage = new ImageIcon("icons/newBoy2.jpg");

	// the dices
	private ImageIcon dice_0 = new ImageIcon("icons/dice0.png");
	private ImageIcon dice_1 = new ImageIcon("icons/dice1.png");
	private ImageIcon dice_2 = new ImageIcon("icons/dice2.png");
	private ImageIcon dice_3 = new ImageIcon("icons/dice3.png");
	private ImageIcon dice_4 = new ImageIcon("icons/dice4.png");
	private ImageIcon dice_5 = new ImageIcon("icons/dice5.png");
	private ImageIcon dice_6 = new ImageIcon("icons/dice6.png");

	// Create a label to hold button
	JLabel jp = new JLabel(bigMap);

	// Create a label to hold player1
	JLabel pjl1 = new JLabel(player1);

	// Create a label to hold player2
	JLabel pjl2 = new JLabel(player2);
	// Create six buttons to hold dices
	JButton dice1 = new JButton(dice_1);
	//
	JButton btConfirm = new JButton();
	//
	JButton btSave = new JButton(IconSave);
	JButton btEnd = new JButton(IconEnd);
	// Create buttons
	JButton bt11 = new JButton(bt1Image);
	JButton bt12 = new JButton(bt1Image2);
	JButton bt13 = new JButton(bt1Image3);
	JButton bt14 = new JButton(bt1Image4);
	JButton bt15 = new JButton(bt1Image5);
	JButton bt16 = new JButton(bt1Image6);
	JButton bt17 = new JButton(bt1Image7);
	JButton bt18 = new JButton(bt1Image8);
	JButton bt19 = new JButton(bt1Image9);
	JButton bt110 = new JButton(bt1Image10);
	JButton bt111 = new JButton(bt1Image11);
	JButton bt112 = new JButton(bt1Image);
	JButton bt113 = new JButton(bt1Image);
	JButton bt114 = new JButton(bt1Image);
	JButton bt115 = new JButton(bt1Image);
	JButton bt116 = new JButton(bt1Image10);
	JButton bt117 = new JButton(bt1Image10);
	JButton bt118 = new JButton(bt1Image10);
	JButton bt119 = new JButton(bt1Image10);
	JButton bt120 = new JButton(bt1Image10);

	JButton btProps = new JButton(IconProps);

	JButton btMusic = new JButton(IconMusic);

	// JPanel playerAIcon = new JPanel();
	JButton playerAIcon = new JButton(player1Icon);
	JButton btmessageOfA = new JButton(messageOfAImage);
	JButton playerBIcon = new JButton(player2Icon);
	JButton btmessageOfB = new JButton(messageOfBImage);

	JButton bt2 = new JButton(bt1Image3);
	JButton bt3 = new JButton(bt3Image);
	JButton bt41 = new JButton(bt4Image);// 彩票
	JButton bt42 = new JButton(bt4Image);
	// JButton bt43 = new JButton(bt4Image);
	JButton bt51 = new JButton(bt5Image);// 空地
	JButton bt52 = new JButton(bt5Image);
	JButton bt53 = new JButton(bt5Image);
	// JButton bt54
	JButton bt61 = new JButton(bt6Image);// 新闻
	JButton bt62 = new JButton(bt6Image);
	JButton bt71 = new JButton(bt7Image);// 银行
	JButton bt72 = new JButton(bt7Image);
	JButton bt81 = new JButton(bt8Image);// shop
	JButton bt82 = new JButton(bt8Image);
	JButton bt91 = new JButton(bt91Image);// 点券10
	JButton bt912 = new JButton(bt91Image);
	JButton bt913 = new JButton(bt91Image);
	JButton bt92 = new JButton(bt92Image);// 点券30
	JButton bt922 = new JButton(bt92Image);
	JButton bt93 = new JButton(bt93Image);// 点券50

	// PlayerA's message
	JLabel name1 = new JLabel("玩家A ");
	JLabel name11 = new JLabel("Little A");
	JPanel p1 = new JPanel(new GridLayout(2, 1));

	// PlayerA's message
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

	// PlayerB's message
	JLabel name2 = new JLabel("玩家B");
	JLabel name21 = new JLabel("AI");
	JPanel p2 = new JPanel(new GridLayout(2, 1));

	// PlayerB's message
	JLabel cash21 = new JLabel("现金：");
	JLabel cash2 = new JLabel();
	JLabel deposit21 = new JLabel("存款：");
	JLabel deposit2 = new JLabel("10000");
	JLabel gold21 = new JLabel("点券：");
	JLabel gold2 = new JLabel("2000 ");
	JLabel houseValue21 = new JLabel("房产：");
	JLabel houseValue2 = new JLabel("20000");
	JLabel totalValue21 = new JLabel("资产：");
	JLabel totalValue2 = new JLabel("200000");
	JPanel p4 = new JPanel(new GridLayout(5, 2));

	// 游戏信息
	JPanel gameMessage = new JPanel();
	JTextArea message = new JTextArea();
	JLabel time = new JLabel();
	JTextArea whoPlay = new JTextArea(" 现在是 " + "\n玩家A的" + "\n操作时间");
	JLabel playName = new JLabel("A");
	Music music = new Music();

	public AIPlay() {
		setLayout(null);
		a.setName("Little A");
		b.setName("AI");

		// the game message
		// Date a1 = new Date();
		String theDisplay = "大富翁欢迎你" + "\n游戏开始时间" + "\n为今天默认游" + "\n戏时间四个月";
		message.setText(theDisplay);
		Font f = new Font("Times", Font.ITALIC, 16);
		message.setFont(f);
		message.setForeground(Color.GREEN);
		message.setBackground(Color.BLACK);
		// message.setCaretColor(Color.RED);
		gameMessage.add(time);
		time.setText(shijian.getTime(playTimes, a, b));
		// time.addAncestorListener(listener);
		time.setFont(f);
		time.setForeground(Color.RED);
		time.setBounds(853, 140, 130, 60);

		//
		Font f1 = new Font("Times", Font.ITALIC, 24);
		whoPlay.setFont(f1);
		whoPlay.setBackground(Color.BLACK);
		whoPlay.setForeground(Color.RED);

		gameMessage.add(message);
		gameMessage.add(whoPlay);
		gameMessage.setBorder(new TitledBorder("游戏信息"));
		gameMessage.setBounds(851, 138, 136, 260);
		add(gameMessage);

		// The message of playerA
		Font font = new Font("Times", Font.ITALIC, 40);
		p1.add(name1);
		name1.setFont(font);
		name1.setForeground(Color.RED);
		p1.add(name11);
		name11.setFont(font);
		name11.setForeground(Color.YELLOW);
		p1.setBorder(new TitledBorder("玩家A信息"));
		p1.setBounds(693, 0, 158, 137);
		add(p1);

		p2.add(name2);
		name2.setFont(font);
		name2.setForeground(Color.RED);
		p2.add(name21);
		name21.setFont(font);
		name21.setForeground(Color.YELLOW);
		p2.setBorder(new TitledBorder("玩家B信息"));
		p2.setBounds(693, 395, 158, 137);
		add(p2);

		// put buttons into panel
		jp.add(playerAIcon);
		jp.add(playerBIcon);

		jp.add(btSave);
		jp.add(btEnd);
		jp.add(bt11);
		jp.add(bt12);
		jp.add(bt13);
		jp.add(bt14);
		jp.add(bt15);
		jp.add(bt16);
		jp.add(bt17);
		jp.add(bt18);
		jp.add(bt19);
		jp.add(bt110);
		jp.add(bt111);
		jp.add(bt112);
		jp.add(bt113);
		jp.add(bt114);
		jp.add(bt115);
		jp.add(bt116);
		jp.add(bt117);
		jp.add(bt118);
		jp.add(bt119);
		jp.add(bt120);

		jp.add(bt2);
		jp.add(bt3);
		jp.add(bt41);
		jp.add(bt42);
		// jp.add(bt43);
		jp.add(bt51);
		jp.add(bt52);
		jp.add(bt53);
		jp.add(bt61);
		jp.add(bt62);
		jp.add(bt71);
		jp.add(bt72);
		jp.add(bt81);
		jp.add(bt82);
		jp.add(bt91);
		jp.add(bt912);
		jp.add(bt913);
		jp.add(bt92);
		jp.add(bt922);
		jp.add(bt93);
		jp.add(dice1);
		jp.add(btProps);
		jp.add(btMusic);
		add(btmessageOfA);
		btmessageOfA.addActionListener(listener);
		add(btmessageOfB);
		btmessageOfB.addActionListener(listener);

		btmessageOfA.setBounds(693, 138, 158, 128);
		btmessageOfB.setBounds(693, 268, 158, 128);
		btMusic.setToolTipText("点击播放/停止音乐");
		btMusic.setBounds(233, 280, 66, 66);
		btMusic.addActionListener(listener);

		btSave.setBounds(480, 374, 68, 89);
		btSave.setToolTipText("点击保存");
		btSave.addActionListener(listener);

		btEnd.setBounds(128, 160, 65, 74);
		btEnd.setToolTipText("点击结束回合");
		btEnd.addActionListener(listener);
		// dice1.setBounds(200, 190, 204, 204);
		btProps.setToolTipText("点击使用道具");
		btProps.setBounds(45, 160, 65, 74);
		btProps.addActionListener(listener);
		// set buttons's position
		playerAIcon.setBounds(p[a.getLocation()][0], p[a.getLocation()][1],
				p[a.getLocation()][2], p[a.getLocation()][3]);
		playerBIcon.setBounds(p[(b.getLocation() + 19) % 38][0],
				p[(b.getLocation() + 19) % 38][1],
				p[(b.getLocation() + 19) % 38][2],
				p[(b.getLocation() + 19) % 38][3]);
		bt11.setBounds(37, 269, 48, 32);
		bt11.setToolTipText("土星4号，当前等级：" + land[37].getHouseLevel() + "拥有者:"
				+ land[37].getOwner());
		bt12.setBounds(37, 301, 48, 32);
		bt12.setToolTipText("土星3号，当前等级：" + land[36].getHouseLevel() + "拥有者:"
				+ land[36].getOwner());
		bt13.setBounds(37, 333, 48, 32);
		bt13.setToolTipText("土星2号，当前等级：" + land[35].getHouseLevel() + "拥有者:"
				+ land[35].getOwner());
		bt14.setBounds(37, 365, 48, 32);
		bt14.setToolTipText("土星1号，当前等级：" + land[34].getHouseLevel() + "拥有者:"
				+ land[34].getOwner());
		bt15.setBounds(37, 399, 48, 32);
		bt15.setToolTipText("火星4号，当前等级：" + land[33].getHouseLevel() + "拥有者:"
				+ land[33].getOwner());
		//
		// bt16.setBounds(215,235,45,32);
		bt16.setBounds(258, 237, 44, 32);
		bt16.setToolTipText("金星1号，当前等级：" + land[5].getHouseLevel() + "拥有者:"
				+ land[5].getOwner());
		bt17.setBounds(302, 237, 44, 32);
		bt17.setToolTipText("金星2号，当前等级：" + land[6].getHouseLevel() + "拥有者:"
				+ land[6].getOwner());
		bt18.setBounds(346, 237, 44, 32);
		bt18.setToolTipText("金星3号，当前等级：" + land[7].getHouseLevel() + "拥有者:"
				+ land[7].getOwner());
		bt19.setBounds(390, 237, 44, 32);
		bt19.setToolTipText("金星4号，当前等级：" + land[8].getHouseLevel() + "拥有者:"
				+ land[8].getOwner());
		bt110.setBounds(477, 270, 44, 32);
		bt110.setToolTipText("木星1号，当前等级：" + land[11].getHouseLevel() + "拥有者:"
				+ land[11].getOwner());
		bt111.setBounds(522, 270, 44, 32);
		bt111.setToolTipText("木星2号，当前等级：" + land[12].getHouseLevel() + "拥有者:"
				+ land[12].getOwner());
		//
		bt112.setBounds(563, 302, 48, 32);
		bt112.setToolTipText("木星3号，当前等级：" + land[14].getHouseLevel() + "拥有者:"
				+ land[14].getOwner());
		bt113.setBounds(563, 334, 48, 32);
		bt113.setToolTipText("木星4号，当前等级：" + land[15].getHouseLevel() + "拥有者:"
				+ land[15].getOwner());
		bt114.setBounds(563, 366, 48, 32);
		bt114.setToolTipText("水星1号，当前等级：" + land[16].getHouseLevel() + "拥有者:"
				+ land[16].getOwner());
		bt115.setBounds(563, 398, 48, 32);
		bt115.setToolTipText("水星2号，当前等级：" + land[17].getHouseLevel() + "拥有者:"
				+ land[17].getOwner());

		//
		bt116.setBounds(300, 465, 44, 32);
		bt116.setToolTipText("火星3号，当前等级：" + land[21].getHouseLevel() + "拥有者:"
				+ land[21].getOwner());
		bt117.setBounds(344, 465, 44, 32);
		bt117.setToolTipText("火星2号，当前等级：" + land[22].getHouseLevel() + "拥有者:"
				+ land[22].getOwner());
		bt118.setBounds(388, 465, 44, 32);
		bt118.setToolTipText("火星1号，当前等级：" + land[23].getHouseLevel() + "拥有者:"
				+ land[23].getOwner());
		bt119.setBounds(432, 465, 44, 32);
		bt119.setToolTipText("水星4号，当前等级：" + land[24].getHouseLevel() + "拥有者:"
				+ land[24].getOwner());
		bt120.setBounds(476, 465, 46, 32);
		bt120.setToolTipText("水星3号，当前等级：" + land[25].getHouseLevel() + "拥有者:"
				+ land[25].getOwner());
		// bt3.setBounds(0, 60, 40, 30);
		bt41.setBounds(128, 464, 44, 33);//
		bt41.setToolTipText("彩票店，可以花费200元购买彩票哦");
		bt42.setBounds(564, 430, 48, 32);
		bt42.setToolTipText("彩票店，可以花费200元购买彩票哦");
		// bt43.setBounds(85, 235,45, 32);
		// bt43.setToolTipText("彩票店，可以花费200元购买彩票哦");
		bt51.setBounds(38, 235, 46, 32);// 空地
		bt52.setBounds(564, 464, 48, 32);
		bt53.setBounds(37, 431, 48, 32);
		bt61.setBounds(566, 268, 44, 34);// 新闻
		bt61.setToolTipText("大富翁电台，随机播放一则新闻。");
		bt62.setBounds(37, 464, 48, 32);
		bt62.setToolTipText("大富翁电台，随机播放一则新闻。");
		bt71.setBounds(170, 237, 44, 32);
		bt71.setToolTipText("大富翁银行旗舰店。");
		bt72.setBounds(214, 464, 44, 32);// bank
		bt72.setToolTipText("大富翁银行旗舰店。");
		bt81.setBounds(214, 237, 44, 32);
		bt81.setToolTipText("大富翁道具店。");
		bt82.setBounds(170, 463, 44, 34);
		bt82.setToolTipText("大富翁道具店。");
		bt91.setBounds(126, 237, 44, 32);// 10
		bt91.setToolTipText("在这您将获得10个点券。");
		bt912.setBounds(434, 237, 44, 32);
		bt912.setToolTipText("在这您将获得10个点券。");
		bt913.setBounds(258, 464, 44, 32);
		bt913.setToolTipText("在这您将获得10个点券。");
		bt92.setBounds(434, 269, 44, 32);// 30
		bt92.setToolTipText("在这您将获得30个点券。");
		bt922.setBounds(83, 464, 44, 32);
		bt922.setToolTipText("在这您将获得30个点券。");
		bt93.setBounds(521, 464, 43, 32);// 50
		bt93.setToolTipText("在这您将获得50个点券。");
		// bt1.setBounds(0, 90, 20, 17);

		// put the panel of player into panel
		add(jp);
		jp.setBounds(0, 0, 691, 532);

		// put the photo of playerA into panel
		add(pjl1);
		pjl1.setBounds(855, 0, 130, 135);

		// pt the photo of playerB into panel
		add(pjl2);
		pjl2.setBounds(855, 395, 130, 135);
		// put the dices into the panel

		jp.add(dice1);
		dice1.addActionListener(listener);
		dice1.setBounds(233, 366, 66, 66);

		setTitle("Monopoly");
		// add(new BigMap());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 570);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);

	}

	// 声明两个timer的监听对象
	Timer timer = new Timer(50, new TimerListener());
	Timer timer2 = new Timer(500, new Timer2Listener());

	// Timer timerProp = new Timer(500,new TimerPropListener());
	public static void useDiceProp(int diceNumber1) {
		useDiceProp = true;
		diceNumber = diceNumber1;
	}

	public static void useStopProp(Player p) {
		useStopProp = true;
		diceNumber = 0;
	}

	// timer.start();
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			playTimes++;

			if (e.getSource() == dice1) {
				// cash1.setText(a.getCash()-1000+"");
				// if (conPlay % 2 == 0) {
				// whoPlay.setText(" 现在是 " + "\n玩家B的" + "\n操作时间");
				// // a.setLocation(diceResult);
				// } else {
				// whoPlay.setText(" 现在是 " + "\n玩家A的" + "\n操作时间");
				// // a.setLocation(diceResult);
				// }
				if (conPlay % 2 == 0) {
					time.setText(shijian.getTime(playTimes, a, b));
					timer.start();
				}
				if (conPlay % 2 == 1) {
					JOptionPane
							.showMessageDialog(null, "如果你的操作已经完成，请点击结束回合按钮！");
				}
			}
			if (e.getSource() == btProps) {
				if (conPlay % 2 == 0) {
					UseProps use = new UseProps(a, b);
					use.setVisible(true);
					// try {
					// Thread.sleep(5000);
					// use.dispose();
					// } catch (InterruptedException ex) {
					// // TODO Auto-generated catch block
					// ex.printStackTrace();
					// }
				}
			}
			for (int i = 0; i < 10; i++) {
				if (e.getSource() == UseProps.prop[i]) {
					if (UseProps.prop[i].getText().equals("遥控色子")) {
						System.out.println("button start");
						time.setText(shijian.getTime(playTimes, a, b));
						timer.start();
						System.out.println("timer start");
					}
				}
			}
			if (e.getSource() == btMusic) {
				if (musicOn == false)
					musicOn = true;
				else
					musicOn = false;
				music.sing(musicOn);
			}
			//查看玩家A的基本信息
			if (e.getSource() == btmessageOfA) {
				MessageOfA message1 = new MessageOfA(a);
				message1.setVisible(true);
			}
			//查看玩家B的基本信息
			if (e.getSource() == btmessageOfB) {
				MessageOfB message2 = new MessageOfB(b);
				message2.setVisible(true);
			}
            //保存玩家信息
			if (e.getSource() == btSave) {
				try {
					Save save = new Save(a, b);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//结束回合
			if (e.getSource() == btEnd) {
				if (conPlay % 2 == 0) {
					whoPlay.setText(" 现在是 " + "\n玩家B的" + "\n操作时间");
					// a.setLocation(diceResult);
				} else {
					whoPlay.setText(" 现在是 " + "\n玩家A的" + "\n操作时间");
					// a.setLocation(diceResult);
				}
				if (conPlay % 2 == 0) {
				} else
					timer.start();
				// conPlay++;
			}
		}
	}
   //监听类，对掷色子做出响应
	class TimerListener implements ActionListener {

		// Handle ActionEvent
		public void actionPerformed(ActionEvent e) {
			int random = (int) (Math.random() * 6 + 1);
			switch (random) {
			case 1: {

				dice1.setIcon(dice_1);
			}
				break;
			case 2: {
				dice1.setIcon(dice_2);
			}
				break;
			case 3: {
				dice1.setIcon(dice_3);
			}
				break;
			case 4: {
				dice1.setIcon(dice_4);
			}
				break;
			case 5: {
				dice1.setIcon(dice_5);
			}
				break;
			case 6: {
				dice1.setIcon(dice_6);
			}
				break;
			default:
			}
			conDice++;
			if (conDice > 30) {
				timer.stop();
				if (useDiceProp == true || useStopProp == true) {
					diceResult = diceNumber;
					useDiceProp = false;
					useStopProp = false;
				} else
					diceResult = (int) (Math.random() * 6 + 1);
				switch (diceResult) {
				case 0: {
					dice1.setIcon(dice_0);
				}
					break;
				case 1: {
					dice1.setIcon(dice_1);
				}
					break;
				case 2: {
					dice1.setIcon(dice_2);
				}
					break;
				case 3: {
					dice1.setIcon(dice_3);
				}
					break;
				case 4: {
					dice1.setIcon(dice_4);
				}
					break;
				case 5: {
					dice1.setIcon(dice_5);
				}
					break;
				case 6: {
					dice1.setIcon(dice_6);
				}
					break;
				default:
				}
				i = (a.getLocation() + 1) % 38; // - diceResult + 1;
				i_f = (a.getLocation() - 1 + 38) % 38;
				i2 = (20 + b.getLocation()) % 38;// - diceResult;
				i2_f = (b.getLocation() + 19 - 1 + 38) % 38;
				System.out.println(diceResult);
				conDice = 0;
				timer2.start();
				System.out.println("time2 start");
			}
		}
	}
//对人物的走做出响应
	class Timer2Listener implements ActionListener {
		int con2 = 0;

		// int i = a.getLocation() + 1; // - diceResult + 1;
		// int i_f = (a.getLocation() - 1 + 38) % 38;
		// int i2 = 20 + b.getLocation();// - diceResult;
		// int i2_f = (b.getLocation() + 19 - 1 + 38) % 38;

		// Handle ActionEvent
		public void actionPerformed(ActionEvent e) {
			// FireEvent sign = new FireEvent(j);
			System.out.println(diceResult + " a" + "a's locaton:"
					+ a.getLocation());

			if (conPlay % 2 == 0) {
				AIplay = false;
				// 用了转向卡时
				if (a.getDirection() == 1) {
					if (con2 >= diceResult) {
						timer2.stop();
						a.setLocation(-diceResult);
						AIFireEvent sign = new AIFireEvent(a.getLocation(), a,
								b, AIplay);
						System.out.println("a.Position " + a.getLocation());
						sign.setVisible(true);
						conPlay++;
						con2 = 0;
					} else {
						playerAIcon.setBounds(p[i_f][0], p[i][1], p[i][2],
								p[i][3]);
						i_f--;
						if (i_f >= 38)
							i_f = i_f % 38;
						if (i_f < 0)
							i_f = i_f + 38;
						con2++;
					}

				}
				// 没有用转向卡
				else {
					if (con2 >= diceResult) {
						timer2.stop();
						a.setLocation(diceResult);
						AIFireEvent sign = new AIFireEvent(a.getLocation(), a,
								b, AIplay);
						System.out.println("a.Position " + a.getLocation());
						sign.setVisible(true);
						conPlay++;
						con2 = 0;
					} else {
						playerAIcon.setBounds(p[i][0], p[i][1], p[i][2],
								p[i][3]);
						i++;
						if (i >= 38)
							i = i % 38;
						con2++;
					}
				}

			} // 玩家b的操作
			else {
				AIplay = true;
				// 没有使用转向卡
				if (b.getDirection() == 0) {
					if (con2 >= diceResult) {
						timer2.stop();
						b.setLocation(diceResult);
						AIFireEvent sign = new AIFireEvent(
								(b.getLocation() + 19) % 38, b, a, AIplay);
						System.out.println("b.Position "
								+ (int) ((b.getLocation() + 19)) % 38);
						sign.setVisible(true);
						conPlay++;
						con2 = 0;
					} else {
						if (i2 >= 38)
							i2 = i2 % 38;
						playerBIcon.setBounds(p[i2][0], p[i2][1], p[i2][2],
								p[i2][3]);
						i2++;
						// if (i2 >= 38)
						// i2 = i2 % 38;
						con2++;
					}
				}
				//
				if (b.getDirection() == 1) {

					if (con2 >= diceResult) {
						timer2.stop();
						b.setLocation(-diceResult);
						AIFireEvent sign = new AIFireEvent(
								(b.getLocation() + 19) % 38, b, a, AIplay);
						System.out.println("b.Position "
								+ (int) ((b.getLocation() + 19)) % 38);
						sign.setVisible(true);
						conPlay++;
						con2 = 0;
					} else {
						playerBIcon.setBounds(p[i2_f][0], p[i2_f][1],
								p[i2_f][2], p[i2_f][3]);
						i2_f--;
						if (i2_f >= 38)
							i2_f = i2_f % 38;
						if (i2_f < 0)
							i2_f = i2_f + 38;
						con2++;
					}
				}
			}
		}
	}

	class TimerPropMoneyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 监听购买土地的事件
			if (e.getSource() == FireEvent.btLandOK) {
				if (conPlay % 2 == 0)
					cash1.setText(String.valueOf(a.getCash() - 1000));
				else
					cash2.setText(String.valueOf(a.getCash() - 1000));
			}
			// 监听取款事件
			if (e.getSource() == FireEvent.btCash) {
				cash1.setText(String.valueOf(a.getCash()));
				cash2.setText(String.valueOf(b.getCash()));
				deposit1.setText(String.valueOf(a.getDeposit()));
				deposit2.setText(String.valueOf(b.getDeposit()));
			}
			// 监听存款事件。
			if (e.getSource() == FireEvent.btDecash) {
				cash1.setText(String.valueOf(a.getCash()));
				cash2.setText(String.valueOf(b.getCash()));
				deposit1.setText(String.valueOf(a.getDeposit()));
				deposit2.setText(String.valueOf(b.getDeposit()));
			}
		}
	}
}
