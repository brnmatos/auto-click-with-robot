import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	
	private static Robot robot = null;
	
	public static void main(String[] args) {
		try {
			robot = new Robot();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//THREAD JAVA 8
			//Exemplo of Thread with Time for Schedule Executors...
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

			Runnable task = () -> {
			    try {
			        TimeUnit.SECONDS.sleep(2);
			        //bclick(100, 100);
			        //bclick(970,300);
			        bclick(1210,300);
			    }
			    catch (InterruptedException e) {
			        System.err.println("task interrupted");
			    }
			};
			executor.scheduleWithFixedDelay(task, 0, 60, TimeUnit.SECONDS);
	}

	public Main() {
		super();
	}
	
	
	public static void bclick (int x, int y) {
		robot.mouseMove(x, y);
		robot.delay(2);
		robot.mousePress(MouseEvent.BUTTON1_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
		System.out.println("Clicked!!!");

	}

}