package by.academy.lesson4.Homework2.HW2_Task3;

public class HW2_Task3_Main {
	public static void main (String[] args) {
		
		HW2_Task3_SteamIron item1 = new HW2_Task3_SteamIron();
		item1.getSwitch();
		int capacity1 []= {2200, 230, 50};
		item1.setCapacity(capacity1);
		item1.setPrice(100);
		item1.setHeatSettings(5);
		item1.setMaxTemp(205);
		item1.setWaterTankSize(2.2);
		item1.setHeight(180);
		item1.info();
		item1.changeMode();
		item1.getSwitch();
		item1.changeMode();
		item1.getSwitch();
		item1.unFolded();
		item1.fold();
		
		Portable item4 = new HW2_Task3_SteamIron();
		item4.unFolded();
		item4.fold();
						
		HW2_Task3_IroningAppliances item2 = new HW2_Task3_IroningAppliances();
		item2.changeMode();
		item2.getSwitch();
		int capacity2 []= {2000, 200, 55};
		item2.setCapacity(capacity2);
		item2.setPrice(80);
		item2.setHeatSettings(4);
		item2.setMaxTemp(180);
		//the following 2 are not applicable for ironing appliances which are not steam irons
//		item2.setWaterTankSize(2.2);
//		item2.setHeight(180);
		item2.info();

		//not allowed to create an instance of an abstract class
//		HW2_Task3_ElectricAppliances item3 = new HW2_Task3_ElectricAppliances();
//		item3.changeMode();
//		item3.getSwitch();
//		int capacity3 []= {2000, 220, 60};
//		item3.setCapacity(capacity3);
//		item3.setPrice(80);
//		item3.setHeatSettings(4);
//		item3.setMaxTemp(180);
//		item3.setWaterTankSize(2.2);
//		item3.setHeight(180);
//		item3.info();
	}

}
