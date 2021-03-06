package Project2;

import javax.swing.*;

import Project2.StartMap.ButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrepareMap extends JFrame {
	// TestBigMap a = new TestBigMap();
	private ImageIcon prepareMap = new ImageIcon("icons/xxx.jpg");
	private ImageIcon prepareBt1 = new ImageIcon("icons/xxxbt1.jpg");
	private ImageIcon prepareBt2 = new ImageIcon("icons/xxxbt2.jpg");
	Player x = BigMap.a;
	Player y = BigMap.b;
	// Create a label as background picture
	JLabel prepareImage = new JLabel(prepareMap);

	// add buttons into label
	JButton preparebt1 = new JButton(prepareBt1);
	JButton preparebt2 = new JButton(prepareBt2);

	public PrepareMap(Player x, Player y) {
		setLayout(null);

		// Put buttons into label
		prepareImage.add(preparebt1);
		prepareImage.add(preparebt2);

		System.out.println("22");
		// Set the position of the buttons
		preparebt1.setBounds(30, 150, 233, 90);
		preparebt2.setBounds(30, 270, 233, 90);

		// Add the label into panel
		add(prepareImage);
		prepareImage.setBounds(0, 0, 800, 440);
		ButtonListener listener = new ButtonListener();

		preparebt1.addActionListener(listener);
		preparebt2.addActionListener(listener);
		// TestBigMap a = new TestBigMap( x, y);
		setTitle("����");
		// add(new PrepareMap(x,y));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 440);
		System.out.println("11111");
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}

	class ButtonListener implements ActionListener {
		// public ButtonListener(Player x,Player y){
		// TestBigMap a = new TestBigMap(x,y);
		// }
		public void actionPerformed(ActionEvent e) {
			TestBigMap a = new TestBigMap(x, y);
			if (e.getSource() == preparebt1) {
				// System.out.println("11111");
				a.setVisible(true);
				setVisible(false);

			}
			if (e.getSource() == preparebt2) {
				AIPlay ai = new AIPlay();
				ai.setVisible(true);
			}
		}
	}

}
