	import javax.swing.*;

	import java.awt.*;
import java.awt.event.*;

	///����һ����¼�ࡣ��Ƴ�һ���̳��������ࡣ

	///WIDTH��ָ���������ܵĿ�ȡ�

	///HEIGHT��ָ���������ܵĳ��ȡ�

	public class HelloWorld2 extends JPanel

	{

		private static final long serialVersionUID = 1834511718758119719L;

		static final int WIDTH = 300;

		static final int HEIGHT = 300;

		JFrame loginframe;

		// /���������鲼�ַ�ʽ��������ķ���

		// /xָ�ؼ�λ�ڵڼ��С�

		// /yָ�ؼ�λ�ڵڼ��С�

		// /wָ�ؼ���Ҫռ���С�

		// /hָ�ؼ���Ҫռ���С�

		public void add(ImageIcon c, GridBagConstraints constraints, int x, int y,
				int w, int h)

		{

			constraints.gridx = x;

			constraints.gridy = y;

			constraints.gridwidth = w;

			constraints.gridheight = h;

			 constraints.insets=new Insets(5,5,5,5);

			 constraints.ipadx=10;

			 constraints.ipady=10;

			 constraints.fill = GridBagConstraints.BOTH;

			// ���������鲼�ַ�ʽ�������

//			add(c, constraints); // ����ط��ǵ��õĸ����add����

		} // �˷���������ӿؼ���������

		// /����һ������������

		// / loginframe�Ǿ���ָ�������Ŀ��

		// / setDefaultCloseOperation����һ��ʹ�ô�������Ĺرտؼ���Ч����ⷽ��

		// / lay��һ�������鲼�ֹ������Ķ���

		// / nameinput�����������û������ı���

		// / passwordinput����������������ı���

		// / title��������ʾ����ı�ǩ��

		// / name��������ʾ���������ı�ǩ��

		// / password��������ʾ�����롱�ı�ǩ��

		// / ok��һ����ť��ʹ����ϵͳ��

		// / cancel��һ����ť��ʹ�˳������ϵͳ��

		// / ok.addActionListener��һ������ϵͳ�����¼�����������

		// / cancel.addActionListener��һ���˳�ϵͳ�ͽ��涯���¼��ļ���������

		HelloWorld2()

		{

			loginframe = new JFrame("��ӭ����Java����");

			loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			GridBagLayout lay = new GridBagLayout();

			setLayout(lay); // ����panel�Ĳ���ʹ��grid

			loginframe.add(this, BorderLayout.WEST);// frame�Ĳ���ʹ��BorderLayout

			loginframe.setSize(WIDTH, HEIGHT);

			Toolkit kit = Toolkit.getDefaultToolkit();

			Dimension screenSize = kit.getScreenSize(); // ϵͳ�����ȡ����

			int width = screenSize.width;

			int height = screenSize.height;

			int x = (width - WIDTH) / 2;

			int y = (height - HEIGHT) / 2;

			loginframe.setLocation(x, y);

			JButton ok = new JButton("��¼");

			JButton cancel = new JButton("����");

			JLabel title = new JLabel("��ӭ����Java����");

			JLabel name = new JLabel("�û���");

			JLabel password = new JLabel("�� ��");
			ImageIcon icon1 = new ImageIcon("icons/dice1");
	         
			final JTextField nameinput = new JTextField(15);

			final JTextField passwordinput = new JTextField(15);
//			JButton fangKuang = new JButton();

			GridBagConstraints constraints = new GridBagConstraints();

			constraints.fill = GridBagConstraints.NONE;

			constraints.anchor = GridBagConstraints.EAST;

			constraints.weightx = 4;

			constraints.weighty = 4;

			//

//			add(title, constraints, 1, 0, 3, 1); // ʹ�������鲼����ӿؼ�
            add(icon1,constraints,0,1,2,1);
//			add(name, constraints, 0, 1, 2, 1);

//			add(password, constraints, 0, 2, 1,1 );
//
//			add(nameinput, constraints, 1, 1, 1, 1);
//
//			add(passwordinput, constraints, 1, 2, 1, 1);
//
//			add(ok, constraints, 0, 3, 1, 1);

//			add(cancel, constraints, 1, 3, 1, 1);
//			add(fangKuang, constraints,2,2,1,1);
//			add(fangKuang, constraints,3,3,1,1);
//			add(fangKuang, constraints,4,4,1,1);
//			add(fangKuang, constraints,5,5,1,1);
		    loginframe.setResizable(false);

			loginframe.setVisible(true);

		}


//		private void add(ImageIcon icon1, GridBagConstraints constraints,
//				int x, int y, int w, int h) {
//			// TODO Auto-generated method stub
//			constraints.gridx = x;
//
//			constraints.gridy = y;
//
//			constraints.gridwidth = w;
//
//			constraints.gridheight = h;

//		}

		public static void main(String[] args) {

			HelloWorld2 hello = new HelloWorld2();

		}

	}


