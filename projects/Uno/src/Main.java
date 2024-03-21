import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        Game game = new Game();
        playerTurn(game);
    }

    public static void playerTurn(Game game) {
        if (readyCheck(game)) {
            clearScreen();
            showCards(game);
            pickACard(game);
            if (!winCheck(game)) {
                game.nextPlayer();
                playerTurn(game);
            }
        }
    }
    public static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    public static void showCards(Game game) {
        System.out.println("The card on the table is a " + game.getPlayedCard().getCardColor().getValue() + " " + game.getPlayedCard().getCardCharacter().getValue());
        System.out.println("you have the following cards on hand: ");

        ArrayList<Card> cards = game.getCurrentplayer().getCards();
        for (Card card : cards) {
            System.out.print(card.getCardColor().getValue() + " " + card.getCardCharacter().getValue());
            if (cards.indexOf(card) != (cards.size() -  1)){
                System.out.print(", ");
            }
        }
    }
    public static void pickACard(Game game) {
        Card cardToPlay = null;

       if (game.getPlayedCard().getCardCharacter() == CardCharacter.DRAW && !game.specialCardExecuted) {
            System.out.println("The previous player played a draw card, you have to draw 2 cards, the turn will go to the next player.");
            game.specialCardExecuted = true;
            game.getCurrentplayer().drawCards(game, 2);
        } else {
            System.out.println("\nPlease select a card out of your hand or draw a card");
            String playCard = myScanner.nextLine();
            if (playCard.equalsIgnoreCase("draw")) {
                game.getCurrentplayer().drawCards(game, 1);
            } else {
                cardToPlay = compareHandCardToString(game, playCard);
                if (cardToPlay != null && tryToPLayCard(game, cardToPlay)) {
                    if (cardToPlay.getCardCharacter() == CardCharacter.REVERSE) game.directionChange();
                    if (cardToPlay.getCardCharacter() == CardCharacter.SKIP) game.nextPlayer();
                    game.setPlayedCard(cardToPlay);
                    game.getCurrentplayer().playCard(cardToPlay);
                } else {
                    System.out.println("You cannot play this, please select type in a card that you are allowed to play.");
                    pickACard(game);
                }
            }
        }

    }
    public static Card compareHandCardToString (Game game, String playCard) {
        ArrayList<Card> cards = game.getCurrentplayer().getCards();
        for (Card card : cards) {
            if (playCard.equals(card.getCardColor().getValue() + " " + card.getCardCharacter().getValue())) {
                return card;
            }
        }
        return null;
    }

    public static boolean tryToPLayCard(Game game, Card cardToPlay) {
        Card playedCard = game.getPlayedCard();

        if (playedCard.getCardColor() == cardToPlay.getCardColor()) {
            return true;
        } else return playedCard.getCardCharacter() == cardToPlay.getCardCharacter();
    }

    public static boolean readyCheck(Game game) {
        System.out.println("It's " + game.getCurrentplayer().getName() + "'s turn.\nAre you ready?");
        return myScanner.nextLine().equalsIgnoreCase("yes");
    }

    public static boolean winCheck(Game game) {
        return game.getCurrentplayer().getCards().isEmpty();
        }
}

enum CardColor {
    RED("red"),
    BLUE("blue"),
    YELLOW("yellow"),
    GREEN("green");

    private final String value;
    CardColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}    ZERO("0"),
ONE("1"),
TWO("2"),
THREE("3"),
FOUR("4"),
FIVE("5"),
SIX("6"),
SEVEN("7"),
EIGHT("8"),
NINE("9"),
DRAW("draw"),
REVERSE("reverse"),
SKIP("skip");

private final String value;
CardCharacter(String value) {
    this.value = value;
}

public String getValue() {
    return value;
}

enum CardCharacter {
}
class Card {
    CardColor cardColor;
    CardCharacter cardCharacter;
    public Card (CardColor cardColor, CardCharacter cardCharacter) {
        this.cardColor = cardColor;
        this.cardCharacter = cardCharacter;
    }
    public CardColor getCardColor() {
        return cardColor;
    }
    public CardCharacter getCardCharacter() {
        return cardCharacter;
    }
}
class Player {
    String name;
    ArrayList<Card> cards = new ArrayList<>();

    public Player (String name) { this.name = name; }

    public void drawCards (Game game, int addCount) {
        for (int i = cards.size(); i < addCount; i++) {
            cards.add(game.getCard());
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void playCard(Card card) {
        cards.remove(card);
    }
}
class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> cardDeck = new ArrayList<>();
    private Card playedCard;
    private Player currentplayer;
    boolean specialCardExecuted;
    static Scanner myScanner = new Scanner(System.in);
    public Game () {
        System.out.println("With how many players do you want to play Uno?");
        int playerCount = myScanner.nextInt();
        myScanner.nextLine();
        for (int i = 0; i < playerCount; i++) newPlayer(i);
        currentplayer = players.getFirst();
        shuffleDeck(); //creating card deck
        for (Player player : players) player.drawCards(this, 7);//give cards to the players
        playedCard = getCard();
        specialCardExecuted = false;
    }
    private void newPlayer(int playerCount) {
        System.out.println("Please enter the name of player "+ ++playerCount);
        Player player = new Player(myScanner.nextLine());
        players.add(player);
    }
    public void shuffleDeck() {
        for (CardColor cardColor : CardColor.values()) {
            for (CardCharacter cardCharacter : CardCharacter.values()) {
                Card newCard = new Card(cardColor, cardCharacter);
                cardDeck.add(newCard);
                if (cardCharacter != CardCharacter.ZERO) cardDeck.add(newCard);
            }
        }
    }
    public Card getCard () {
        int randomNumber = (int)(Math.random() * cardDeck.size());
        playedCard = cardDeck.get(randomNumber);
        cardDeck.remove(randomNumber);
        return playedCard;
    }
    public Card getPlayedCard() {
        return playedCard;
    }
    public void setPlayedCard(Card playedCard) {
        this.playedCard = playedCard;
    }
    public void nextPlayer () {
        if (currentplayer != players.getLast()) {
            currentplayer = players.get(players.indexOf(currentplayer) + 1);
        } else {
            currentplayer = players.getFirst();
        }
    }
    public void directionChange() {
        players.reversed();
    }
    public Player getCurrentplayer() {
        return currentplayer;
    }
}