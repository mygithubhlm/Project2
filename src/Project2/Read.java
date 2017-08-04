package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

//import card.CardSystem;

public class Read {
	private ImageIcon 多啦A梦1 = new ImageIcon("photo/多啦A梦1.jpg");
	private ImageIcon 多啦A梦2 = new ImageIcon("photo/多啦A梦2.jpg");
	private ImageIcon 多啦A梦3 = new ImageIcon("photo/多啦A梦3.jpg");
	private ImageIcon 野比大雄1 = new ImageIcon("photo/野比大雄1.jpg");
	private ImageIcon 野比大雄2 = new ImageIcon("photo/野比大雄2.jpg");
	private ImageIcon 野比大雄3 = new ImageIcon("photo/野比大雄3.jpg");
	private ImageIcon 路障 = new ImageIcon("photo/路障.png");

	Read(Player a, Player b) throws FileNotFoundException {
		JFileChooser dlg = new JFileChooser();
		dlg.setDialogTitle("Read");
		int result = dlg.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = dlg.getSelectedFile();
			Scanner input = new Scanner(file);

			// Scanner input=new Scanner(new File("saveve.txt"));
			// 读系统信息
			BigMap.playTimes = Integer.parseInt(input.nextLine());
			// BigMap.shijian = input.
			// 读A信息
			a.readCash(Integer.parseInt(input.nextLine()));
			a.readDeposit(Integer.parseInt(input.nextLine()));
			a.readDirection(Integer.parseInt(input.nextLine()));
			a.readLocation(Integer.parseInt(input.nextLine()));
			a.readGold(Integer.parseInt(input.nextLine()));
			a.readHouseNum(Integer.parseInt(input.nextLine()));
			a.readHouseValue(Integer.parseInt(input.nextLine()));
			// a.readHaveProp(Integer.parseInt(input.nextLine()));
			a.readTotalValue(Integer.parseInt(input.nextLine()));
			// 读B信息
			b.readCash(Integer.parseInt(input.nextLine()));
			b.readDeposit(Integer.parseInt(input.nextLine()));
			b.readDirection(Integer.parseInt(input.nextLine()));
			b.readLocation(Integer.parseInt(input.nextLine()));
			b.readGold(Integer.parseInt(input.nextLine()));
			b.readHouseNum(Integer.parseInt(input.nextLine()));
			b.readHouseValue(Integer.parseInt(input.nextLine()));
			// b.readHaveProp(input.);
			b.readTotalValue(Integer.parseInt(input.nextLine()));
			// 读房产信息
			for (int i = 0; i <= 37; i++) {
				FireEvent.land[i].readOwner(input.nextLine());
				FireEvent.land[i].readHouseValue(input.nextInt());
				FireEvent.land[i].readLevel(input.nextInt());
				FireEvent.land[i].readItemName(input.nextLine());
			}
			// 读卡牌信息
			for (int i = 0; i < 10; i++) {
				PropShop.card[i].readName(input.nextLine());
				PropShop.card[i].readNum(Integer.parseInt(input.nextLine()));
			}
		}
	}
}
// }

