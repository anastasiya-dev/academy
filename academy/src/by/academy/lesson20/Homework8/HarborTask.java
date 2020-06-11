package by.academy.lesson20.Homework8;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class HarborTask {
	private static final int HARBOR_CAPACITY_LOAD = 120;
	private static int CONTAINERS_IN_HARBOR = 50;
	private static final int COUNT_PORTS = 5;
	private static final Semaphore SEMAPHORE = new Semaphore(COUNT_PORTS, true);
	private static final int COUNT_SHIPS = 7;
	private static boolean[] PORTS = null;
	private static Random rnd = new Random();

	public static void main(String[] args) {

		System.out.printf("Inititally %d containers in the harbor.\n", CONTAINERS_IN_HARBOR);
		PORTS = new boolean[COUNT_PORTS];
		for (int i = 0; i < COUNT_PORTS; i++) {
			PORTS[i] = true;
		}

		for (int i = 1; i <= COUNT_SHIPS; i++) {
			new Thread(new Ship(i)).start();
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
			}
		}
	}

	public static class Ship implements Runnable {

		int shipNum;
		final int shipCapacity;
		int shipFactLoad;
		int containersToUnload;
		int containersToLoad;

		public Ship(int shipNum) {
			this.shipNum = shipNum;
			// ship capacity between 50 and 99
			this.shipCapacity = Math.max(rnd.nextInt(10) * 10, 50) + rnd.nextInt(10);
			loadDefinition();
		}
		
		public void loadDefinition() {
			this.shipFactLoad = rnd.nextInt(shipCapacity) + 1;
			this.containersToUnload = rnd.nextInt(shipFactLoad) + 1;
			this.containersToLoad = rnd.nextInt(shipCapacity - shipFactLoad + containersToUnload + 1);
		}

		@Override
		public void run() {
			while (CONTAINERS_IN_HARBOR != 0) {
				System.out.printf("    Ship %d with capacity %d and load %d comes to the harbor\n", shipNum,
						shipCapacity, shipFactLoad);
				System.out.printf("\tIt is willing to unload %d containers and load %d containers\n", containersToUnload,
						containersToLoad);
				
				try {
					SEMAPHORE.acquire();
					System.out.printf("    Ship %d searches for a free port\n", shipNum);
					int portNum = -1;
					synchronized (PORTS) {
						for (int i = 0; i < COUNT_PORTS; i++) {
							if (PORTS[i]) {
								PORTS[i] = false;
								portNum = i + 1;
								System.out.printf("    Ship %d is at the port %d.\n", shipNum, portNum);
								break;
							}
						}
					}

					Thread.sleep((int) (Math.random() * 5 + 1) * 1000);

					// unload
								
					{
						containersToUnload = Math.min(containersToUnload,
								HARBOR_CAPACITY_LOAD - CONTAINERS_IN_HARBOR);
						shipFactLoad -= containersToUnload;
						CONTAINERS_IN_HARBOR += containersToUnload;
						System.out.printf("\tShip %d unloaded %d containers\n", shipNum, containersToUnload);
					}

					// load
					// сделано так, что корабль не будет загружать обратно свои же контейнеры
					{
						containersToLoad = Math.min(containersToLoad, CONTAINERS_IN_HARBOR - containersToUnload);
						shipFactLoad += containersToLoad;
						CONTAINERS_IN_HARBOR -= containersToLoad;
						System.out.printf("\tShip %d loaded %d containers\n", shipNum, containersToLoad);
					}

					synchronized (PORTS) {
						PORTS[portNum - 1] = true;
					}
					System.out.printf("    Ship %d leaves the harbor with %d containers.\n", shipNum, shipFactLoad);
					System.out.printf("There are %d containers in the harbor.\n", CONTAINERS_IN_HARBOR);
					SEMAPHORE.release();
					Thread.sleep((int) (Math.random() * 30 + 1) * 1000);
					loadDefinition();

				} catch (InterruptedException e) {
				}				
			}
		}
	}
}
