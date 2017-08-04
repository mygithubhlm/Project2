package Project2;

import javax.swing.JFrame;

public class TestBigMap extends JFrame {
	public TestBigMap(Player x, Player y) {
		setTitle("Monopoly");
		add(new BigMap());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 570);
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
		// setResizable(false);
	}

	// public static void main(String[] args) {
	// TestBigMap frame = new TestBigMap();
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frame.setSize(700, 550);
	// frame.setLocationRelativeTo(null);// Center the frame
	// frame.setVisible(true);
	// }
}
