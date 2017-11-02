import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	
	private static Robot robot = null;
	private static int locateTable = 1;
	private static int alertLocateX = 0;
	private static int alertLocateY = 0;
	
	
	public static void main(String[] args) {
		interactionWithUser();
		threadChangeTab();
	}	
	
	private static void interactionWithUser() {
		Scanner scan = new Scanner (System.in);  
		System.out.println("Where is the position of Alert?");
		System.out.println("X is ...");
		alertLocateX = scan.nextInt();
		System.out.println("Y is ...");
		alertLocateY = scan.nextInt();
	}
	
	private static void threadChangeTab() {
		try {
			robot = new Robot();
			//Exemplo of Thread with Time for Schedule Executors...
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

			Runnable task = () -> {
			    try {
			        TimeUnit.SECONDS.sleep(2);
			        if (locateTable == 1) {
			        	changeTab(100,12);
			        	confirmAlert(alertLocateX, alertLocateY);
					}else if (locateTable == 2) {
						changeTab(300,12);
						confirmAlert(alertLocateX, alertLocateY);
					}else if( locateTable == 3){
						changeTab(500,12);
						confirmAlert(alertLocateX, alertLocateY);
					}else {
						System.out.println("Do Nothing.");
					}
			    }
			    catch (InterruptedException e) {
			        System.err.println("task interrupted");
			    }
			};
			executor.scheduleWithFixedDelay(task, 0, 30, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	private static void confirmAlert(int x, int y) {
		mouseMove(x, y);
		System.out.println("Confirm");
	}
	
	private static void changeTab(int x, int y) {
		mouseMove(x, y);
		System.out.println("Change Table!!!");

	}
	
	private static void mouseMove(int x, int y) {
		robot.mouseMove(x, y);
		clickAction();
		if (locateTable == 1) {
			locateTable++;
		}else if (locateTable == 2) {
			locateTable++;
		} else {
			locateTable = 1;
		}
	}
	
	private static void clickAction() {
		robot.delay(2);
		robot.mousePress(MouseEvent.BUTTON1_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
	}
	
	

}