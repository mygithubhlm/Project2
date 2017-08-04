package Project2;

import java.util.*;

import javax.swing.JOptionPane;

public class Date {
	static int year;
	static int month;
	static int day;
//用于计算时间
	public static String getTime(int day1, Player x, Player y) {
		int interestMoney1;
		int interestMoney2;
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DATE) + day1;

		if (month == 1 && day > 31) {
			month = 2;
			day = day - 31;
		}
		if (month == 2 && day > 28 + 31) {
			month = 3;
			day = day - 31 - 28;
		}
		if (month == 3 && day > 31 + 28 + 31) {
			month = 4;
			day = day - 31 - 28 - 31;
		}
		if (month == 4 && day > 31 + 28 + 31 + 30) {
			month = 5;
			day = day - 31 - 28 - 31 - 30;
		}
		if (month == 5 && day > 31 + 28 + 31 + 30 + 31) {
			month = 6;
			day = day - 31 - 28 - 31 - 30 - 31;
		}
		if ((month == 1 && day == 31) || (month == 2 && day == 28)
				|| (month == 3 && day == 31) || (month == 4 && day == 30)
				|| (month == 5 && day == 31)) {
			JOptionPane.showMessageDialog(null, "月底啦，马强有福利发放，\n每人获得10%的利息！");
			interestMoney1 = (int) (x.getDeposit() * 0.1);
			x.setDeposit(interestMoney1);
			interestMoney2 = (int) (y.getDeposit() * 0.1);
			y.setDeposit(interestMoney2);
		}
		if (day1 >= 120) {
			if (x.getTotalValue() > y.getTotalValue())
				JOptionPane.showMessageDialog(null,
						"世界末日突然降临，游戏只能强行结束\n恭喜玩家A获得胜利");
			else if (x.getTotalValue() == y.getTotalValue())
				JOptionPane.showMessageDialog(null, "世界末日突然降临，游戏只能强行结束\n两家和局！");
			else
				JOptionPane.showMessageDialog(null,
						"世界末日突然降临，游戏只能强行结束\n恭喜玩家B获得胜利");
			System.exit(0);
		}
		return year + "年" + month + "月" + day + "日";
	}
}