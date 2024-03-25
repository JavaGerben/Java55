import java.util.Scanner;

class GameUI {
    Scanner myScanner = new Scanner(System.in);
    Game game;
    public GameUI () {
        showInfo ();
    }
    private void mainMenu () {
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
    private void newGame () {
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
    private boolean defaultFunction (String input) {
        return switch (input.toLowerCase()) {
            case "quit", "menu", "help" , "cheat" -> true;
            default -> false;
        };
    }
    private void defaultFunctionExecute (String input) {
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
    private void winStatus () {
        if (game.getRoomType(game.getPlayer().getPos()) == RoomType.PIT || game.getRoomType(game.getPlayer().getPos()) == RoomType.AMAROK) {
            game.getPlayer().setStatus(PlayerStatus.DEAD);
        }

        if (game.getPlayer().getStatus() == PlayerStatus.DEAD) {
            spacer();
            printColor("red", "You lost, because you have died.");
            mainMenu();
        } else if (game.checkFountain() && game.getRoomType(game.getPlayer().getPos()) == RoomType.ENTRANCE) {
            spacer();
            //"You have won" in different color letters
            System.out.println("\u001B[31mY\u001B[32mo\u001B[33mu \u001B[34mh\u001B[35ma\u001B[36mv\u001B[37me \u001B[32mw\u001B[33mo\u001B[34mn");
        } else if (game.getRoomType(game.getPlayer().getPos()) == RoomType.MAELSTROM) {
            game.playerInMaelstromRoom (game.getPlayer().getPos());
            printColor("red", "You entered the same room as the maelstrom, you have both been moved.");
            playerTurn();
        } else {
            playerTurn();
        }
    }
    private void playerTurn () {
        showPlayerStatus();
        playerChoice();
        winStatus();
    }
    private void playerChoice () {
        do {
            printColor("magenta", "What do you want to do? ");
            String input = myScanner.nextLine().toLowerCase();
            if (defaultFunction(input)) {
                defaultFunctionExecute(input);
                return;
            }

            switch (input.toLowerCase()) {
                case "enable", "disable", "move north", "move east", "move south", "move west",
                        "shoot north", "shoot east", "shoot south", "shoot west":
                    validPlayerInput(input);
                    return;
                default:
                    printColor("red", "\"" + input + "\" is not a valid command, please try again.");
                    break;
            }
        } while (true);
    }
    private void validPlayerInput (String input) {
        if (input.equals("enable") && !game.enableFountain()) {
            printColor("red", "There is nothing to enable.");
        }

        if (input.equals("disable") && !game.disableFountain()) {
            printColor("red", "There is nothing to disable.");
        }
        if (input.startsWith("move")) {
            playerInputMove(input);
        }
        if (input.startsWith("shoot")) {
            playerInputShoot(input);
        }
    }
    private void playerInputMove(String input) {
        Player player = game.getPlayer();
        Coordinate newCoordinate = switch(input) {
            case "move north" -> player.getPos().plus(0, 1);
            case "move east" -> player.getPos().plus(1, 0);
            case "move south" -> player.getPos().plus(0, -1);
            case "move west" -> player.getPos().plus (-1, 0);
            default -> null;
        };

        if (newCoordinate != null && game.coordinatesContains(newCoordinate)) {
            player.setPos(newCoordinate);

        } else {
            printColor("red", "\"" + input + "\" is not a valid command, please try again.");
        }
    }
    private void playerInputShoot(String input) {
        Player player = game.getPlayer();
        if (player.getArrows() > 0) {
            Coordinate newCoordinate = switch (input) {
                case "shoot north" -> player.getPos().plus(0, 1);
                case "shoot east" -> player.getPos().plus(1, 0);
                case "shoot south" -> player.getPos().plus(0, -1);
                case "shoot west" -> player.getPos().plus(-1, 0);
                default -> null;
            };

            if (newCoordinate != null && game.coordinatesContains(newCoordinate)) {
                RoomType roomType = game.getRoomType(newCoordinate);
                if (roomType == RoomType.AMAROK || roomType == RoomType.MAELSTROM) {
                    game.killBeast(newCoordinate);
                    player.shootArrow();
                    printColor("magenta", "You've shot a beast.");
                } else {
                    printColor("magenta", "You missed.");
                }
            } else {
                printColor("red", "\"" + input + "\" is not a valid command, please try again.");
            }
        } else {
            printColor("red", "You don't have any arrows left.");
        }
    }
    private void showPlayerStatus () {
        spacer();
        Coordinate playerPos = game.getPlayer().getPos();
        printColor("magenta", "You are in the room at (Row = " + game.getPlayer().getPos().x() + ", Column = " + game.getPlayer().getPos().y() + ").");
        printColor("magenta", "You have " + game.getPlayer().getArrows() + " arrow(s) left.");
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
        nearbyRooms(RoomType.AMAROK);
    }
    private void nearbyRooms (RoomType roomType) {
        for (int row = -1; row <= 1; row++) {
            for (int column = -1; column <= 1; column++) {
                int x = game.getPlayer().getPos().x() + row;
                int y = game.getPlayer().getPos().y()+ column;
                new Coordinate(x, y);

                if (game.coordinatesContains(new Coordinate(x, y)) && game.getRoomType(new Coordinate(x, y)) == roomType) {
                    String text = switch (roomType) {
                        case RoomType.PIT       -> "You feel a draft. There is a pit in a nearby room.";
                        case RoomType.MAELSTROM -> "You hear the growling and groaning of a maelstrom nearby.";
                        case RoomType.AMAROK    -> "You can smell the rotten stench of an amarok in a nearby room.";
                        default                 -> throw new IllegalStateException("Unexpected value: " + roomType);
                    };
                    printColor("magenta", text);
                }

            }
        }
    }
    private void showInfo () {
        spacer();
        String text = """
                You enter the Cavern of Objects, a maze of rooms filled with dangerous pits in search
                of the Fountain of Objects. Light is visible only in the entrance, and no other light
                is seen anywhere in the caverns. You must navigate the Caverns with your other senses.
                Find the Fountain of Objects, activate it, and return to the entrance. Look out for
                pits. You will feel a breeze if a pit is in an adjacent room. If you enter a room with
                a pit, you will die. Maelstroms are violent forces of sentient wind. Entering a room
                with one could transport you to any other location in the caverns. You will be able to
                hear their growling and groaning in nearby rooms. Amaroks roam the caverns.
                Encountering one is certain death, but you can smell their rotten stench in nearby rooms.
                You carry with you a bow and a quiver of arrows. You can use them to shoot monsters in
                the caverns but be warned: you have a limited supply.""";
        printColor("blue", text);
        mainMenu();
    }
    private void spacer () {
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
    private void printColor (String color, String text) {
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