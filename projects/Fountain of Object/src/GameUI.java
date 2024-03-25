import java.util.Scanner;

class GameUI {
    Scanner myScanner = new Scanner(System.in);
    Game game;
    public GameUI () {
        mainMenu ();
    }
    void mainMenu () {
        spacer();
        String text = """
                    1) Start a new game.
                    2) Show rules & info.
                    3) Quit the game.""";
        printColor("yellow", text);
        if (game != null && game.getPlayer().getStatus() == PlayerStatus.ALIVE) {
            printColor("yellow", "4) Continue the game you were playing.");
        }

        do {
            String input = myScanner.nextLine();
            if (defaultFunction(input)) {
                defaultFunctionExecute(input);
                return;
            }

            switch(input) {
                case "1":
                    newGame();
                    return;
                case "2":
                    showInfo();
                    return;
                case "3":
                    printColor("red", "You have quit the game.");
                    return;
                case "4":
                    if (game != null) {
                        winStatus();
                        return;
                    }
                    break;
            }
            printColor("red", "This is not a valid command, please try again.");
        } while (true);
    }
    void newGame () {
        int fieldSize;

        do {
            spacer();
            String text = """
                        How big do you want the field to be?
                        1) 4x4
                        2) 6x6
                        3) 8x8""";
            printColor("cyan", text);

            String input = myScanner.nextLine();

            if (defaultFunction(input)) {
                defaultFunctionExecute(input);
                return;
            }

            fieldSize = switch(input) {
                case "1", "4x4" -> 4;
                case "2", "6x6" -> 6;
                case "3", "8x8" -> 8;
                default 		-> 0;
            };

            if (fieldSize != 0) break;
        } while (true);

        game = new Game(fieldSize);
        printColor("cyan", "You created a new game with a field size of " + fieldSize + "x" + fieldSize + ".");

        winStatus();
    }
    boolean defaultFunction (String input) {
        return switch (input.toLowerCase()) {
            case "quit", "menu", "help" , "cheat" -> true;
            default -> false;
        };
    }
    void defaultFunctionExecute (String input) {
        switch (input.toLowerCase()) {
            case "quit":
                printColor("red", "You have quit the game.");
                System.exit(0);
                break;
            case "menu":
                mainMenu();
                break;
            case "help":
                showInfo();
                break;
            case "cheat":
                game.cheat();
                break;
            default:
        }
    }
    void winStatus () {
        if (game.getRoomType(game.getPlayer().getPos()) == RoomType.PIT) {
            game.getPlayer().setStatus(PlayerStatus.DEAD);
        }
        boolean playerEntrance = game.getRoomType(game.getPlayer().getPos()) == RoomType.ENTRANCE;
        boolean inMaelstromRoom = game.getRoomType(game.getPlayer().getPos()) == RoomType.MAELSTROM;
        boolean playerAlive = game.getPlayer().getStatus() == PlayerStatus.ALIVE;

        if (!playerAlive) {
            spacer();
            printColor("red", "You lost, because you have died.");
            mainMenu();
        } else if (game.checkFountain() && playerEntrance) {
            spacer();
            //"You have won" in different color letters
            System.out.println("\u001B[31mY\u001B[32mo\u001B[33mu \u001B[34mh\u001B[35ma\u001B[36mv\u001B[37me \u001B[32mw\u001B[33mo\u001B[34mn");
        } else if (inMaelstromRoom) {
            game.playerInMaelstromRoom (game.getPlayer().getPos());
            printColor("red", "You entered the same room as the maelstrom, you have both been moved.");
            playerTurn();
        } else {
            playerTurn();
        }
    }
    void playerTurn () {
        showPlayerStatus();
        playerChoice();
        winStatus();
    }
    void playerChoice () {
        Player player = game.getPlayer();
        do {
            printColor("magenta", "What do you want to do? ");
            String input = myScanner.nextLine().toLowerCase();
            if (defaultFunction(input)) {
                defaultFunctionExecute(input);
                return;
            }

            if (input.equals("enable")) {
                if (game.enableFountain()) {
                    break;
                } else {
                    printColor("red", "There is nothing to enable.");
                }
            }
            if (input.equals("disable")) {
                if (game.disableFountain()) {
                    break;
                } else {
                    printColor("red", "There is nothing to disable.");
                }
            }

            Coordinate newCoordinate = switch(input) {
                case "move north" -> player.getPos().plus(0, 1);
                case "move east" -> player.getPos().plus(1, 0);
                case "move south" -> player.getPos().plus(0, -1);
                case "move west" -> player.getPos().plus (-1, 0);
                default -> null;
            };

            if (newCoordinate != null && game.coordinatesContains(newCoordinate)) {
                player.setPos(newCoordinate);
                break;
            }
            printColor("red", "\"" + input + "\" is not a valid command, please try again.");
        } while (true);
    }
    void showPlayerStatus () {
        spacer();
        Coordinate playerPos = game.getPlayer().getPos();
        printColor("magenta", "You are in the room at (Row = " + game.getPlayer().getPos().x() + ", Column = " + game.getPlayer().getPos().y() + ").");

        switch (game.getRoomType(playerPos)) {
            case RoomType.ENTRANCE:
                printColor("magenta", "You see light coming from the cavern entrance.");
                break;
            case RoomType.FOUNTAIN:
                if (game.checkFountain()) printColor("magenta", "You hear the rushing waters from the Fountain of Objects.");
                else printColor("magenta", "You hear water dripping in this room. The Fountain of Objects is here!");
                break;
        }

        nearbyRooms(RoomType.PIT);
        nearbyRooms(RoomType.MAELSTROM);
    }
    void nearbyRooms (RoomType roomType) {
        for (int row = -1; row <= 1; row++) {
            for (int column = -1; column <= 1; column++) {
                int x = game.getPlayer().getPos().x() + row;
                int y = game.getPlayer().getPos().y()+ column;
                new Coordinate(x, y);

                if (game.coordinatesContains(new Coordinate(x, y)) && game.getRoomType(new Coordinate(x, y)) == roomType) {
                    String text = switch (roomType) {
                        case RoomType.PIT       -> "You feel a draft. There is a pit in a nearby room.";
                        case RoomType.MAELSTROM -> "You hear the growling and groaning of a maelstrom nearby.";
                        default                 -> "";
                    };
                    printColor("magenta", text);
                }

            }
        }
    }
    void showInfo () {
        spacer();
        String text = """
                You will start at the entrance and you can move between other rooms by typing commands like the following:
                "move north", "move south", "move east", and "move west". You are not be able to move past the end of the map.
                The map size is determined when creating a new game.

                Your goal is to find the fountain, enable it and than go back to the entrance.
                But there will be some traps along the way, they can kill you, look out for those.

                during playing you can always type in the following commands:
                "menu" to show the main menu again.
                "help" to show this info again.
                "quit" to quit the game.""";
        printColor("blue", text);
        mainMenu();
    }
    void spacer () {
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
    void printColor (String color, String text) {
        String printColor = switch (color) {
            case "red"      -> "\u001B[31m";
            case "green"    -> "\u001B[32m";
            case "yellow"   -> "\u001B[33m";
            case "blue"     -> "\u001B[34m";
            case "magenta"  -> "\u001B[35m";
            case "cyan"     -> "\u001B[36m";
            default         -> "\u001B[0m";
        };

        System.out.println(printColor + text + "\u001B[0m");
    }
}