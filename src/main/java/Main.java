import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> commandsList = new ArrayList<>();


        commandsList.add("N");
        commandsList.add("S");
        commandsList.add("E");
        commandsList.add("W");
        commandsList.add("W");
        commandsList.add("W");
        commandsList.add("S");

        Rover rover = new Rover(1, 1);

        System.out.println("intial position x :" + rover.getX() + " y :" + rover.getY());

        commandsList.forEach(c -> {
            try {
                executeCommand(c, rover);
                System.out.println("X :" + rover.getX() + " Y :" + rover.getY());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println("terminal position x :" + rover.getX() + " y :" + rover.getY());
    }

    static void executeCommand(String cmd, Rover rover) throws IOException {
        switch (cmd) {
            case "N" -> rover.moveRoverLeftRight(true, false);
            case "S" -> rover.moveRoverLeftRight(false, true);
            case "E" -> rover.moveRoverForwardBackward(true, false);
            case "W" -> rover.moveRoverForwardBackward(false, true);
            default -> System.out.println("Unknown command");
        }
    }
}
