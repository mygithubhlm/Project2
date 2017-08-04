package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

//import card.CardSystem;
public class Save {
	Save(Player a, Player b) throws IOException {
		// FileWriter output = new FileWriter(new File("saveve.txt"));
		JFileChooser dlg = new JFileChooser();
		dlg.setDialogTitle("Save");
		int result = dlg.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = dlg.getSelectedFile();
			FileWriter output = new FileWriter(file);

			// 存储游戏时间
			output.write(BigMap.playTimes + "\r\n");
			// output.write(BigMap.shijian+"\r\n");
			// 存储A玩家信息
			// 储存现金
			output.write(a.getCash() + "\r\n");
			output.write(a.getDeposit() + "\r\n");
			output.write(a.getDirection() + "\r\n");
			output.write(a.getLocation() + "\r\n");
			output.write(a.getGold() + "\r\n");
			output.write(a.getHouseNum() + "\r\n");
			output.write(a.getHouseValue() + "\r\n");
			// output.write(a.getHaveProp()+"\r\n");
			output.write(a.getTotalValue() + "\r\n");
			// 存储B玩家信息
			output.write(b.getCash() + "\r\n");
			output.write(b.getDeposit() + "\r\n");
			output.write(b.getDirection() + "\r\n");
			output.write(b.getLocation() + "\r\n");
			output.write(b.getGold() + "\r\n");
			output.write(b.getHouseNum() + "\r\n");
			output.write(b.getHouseValue() + "\r\n");
			// output.write(b.getHaveProp()+"\r\n");
			output.write(b.getTotalValue() + "\r\n");
			// 存储房产信息
			for (int i = 0; i <= 37; i++) {
				output.write(FireEvent.land[i].getOwner() + "\r\n");
				output.write(FireEvent.land[i].getHouseValue() + "\r\n");
				output.write(FireEvent.land[i].getHouseLevel() + "\r\n");
				output.write(FireEvent.land[i].getItemName() + "\r\n");
			}

			// 存储卡牌信息
			for (int i = 0; i < 10; i++) {
				output.write(PropShop.card[i].getName() + "\r\n");
				output.write(PropShop.card[i].getNum() + "\r\n");

			}
			output.close();
		}

	}
}
