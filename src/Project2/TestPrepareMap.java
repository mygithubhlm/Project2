package Project2;

import javax.swing.JFrame;

public class TestPrepareMap extends JFrame {
	public TestPrepareMap(Player x, Player y) {
		setTitle("Monopoly");
		add(new PrepareMap(x, y));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 440);
		System.out.println("11111");
		setLocationRelativeTo(null);// Center the frame
		setVisible(false);
	}
	// public static void main(String[] args) {
	// TestPrepareMap frame = new TestPrepareMap();
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frame.setSize(800, 475);
	// frame.setLocationRelativeTo(null);// Center the frame
	// frame.setVisible(true);
	// }
}
