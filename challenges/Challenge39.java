import java.util.*;

public class Challenge39 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		ArrayList<RobotCommand> list = new ArrayList<>();
		
		RobotCommand commandOne = commands(myScanner.nextLine().toLowerCase());
		RobotCommand commandTwo = commands(myScanner.nextLine().toLowerCase());
		RobotCommand commandThree = commands(myScanner.nextLine().toLowerCase());
		
		list.add(commandOne);
		list.add(commandTwo);
		list.add(commandThree);
		
		Robot robot = new Robot(list);
		robot.run();
	}
	
	private static RobotCommand commands (String command) {	
		return switch(command) {
			case "on" -> new OnCommand();
			case "off" -> new OffCommand();
			case "north" -> new NorthCommand();
			case "south" -> new SouthCommand();
			case "west" -> new WestCommand();
			case "east" -> new EastCommand();
			default -> null;
		};
	}
}
class Robot {
    private int x;

    private int y;

    private boolean isPowered;

    public void moveX(int step) {
        if (isPowered) x += step;
    }

    public void moveY(int step) {
        if (isPowered) y += step;
    }

    private final RobotCommand[] commands = new RobotCommand[3];

    public Robot(List<RobotCommand> inputCommands) {
        if (inputCommands.size() != 3) throw new IllegalArgumentException("Error: Need three commands.");
        inputCommands.toArray(commands);
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }
	
    public void run() {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }
}

public abstract class RobotCommand {
	public abstract void run(Robot robot);
}
public class OnCommand extends RobotCommand {
	public void run(Robot robot) {
		robot.setPowered(true);
	}
}
public class OffCommand extends RobotCommand {
	public void run(Robot robot) {
		robot.setPowered(false);
	}
}
public class NorthCommand extends RobotCommand {
	public void run(Robot robot) {
		robot.moveY(1);
	}
}
public class SouthCommand extends RobotCommand {
	public void run(Robot robot) {
		robot.moveY(-1);
	}
}
public class WestCommand extends RobotCommand {
	public void run(Robot robot) {
		robot.moveX(1);
	}
}
public class EastCommand  extends RobotCommand {
	public void run(Robot robot) {
		robot.moveX(-1);
	}
}