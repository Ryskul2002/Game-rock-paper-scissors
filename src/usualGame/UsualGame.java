package usualGame;


import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class UsualGame {

    protected static final String TITLES = "|  %-9s|  %-9s|  %-7s|  %-9s|  %-9s   |\n";
    protected int winning;
    protected int defeat;
    protected int draw;
    public int amountAllGame;
    protected double percent;

    public void calculation(UsualGame game) {
        int compare = game.userTurn().compareMove(game.computerTurn());
        switch (compare) {
            case 0:
                game.draw++;
                break;
            case 1:
                game.winning++;
                break;
            case -1:
                game.defeat++;
                break;
        }
    }

    public void countPercent(UsualGame game) {
        int total = game.amountAllGame - game.winning - game.defeat;
        game.percent = ((game.winning + ((double) total) / 2) / game.amountAllGame) * 100;
        if (Double.isNaN(game.percent)) {
            game.percent = 0;
        }
    }

    public Versions computerTurn() {
        int rnd = new Random().nextInt(3);
        if (rnd == 0) {
            return Versions.PAPER;
        } else if (rnd == 1) {
            return Versions.ROCK;
        } else if (rnd == 2) {
            return Versions.SCISSORS;
        }
        return null;
    }

    public Versions userTurn() {
        System.out.println("You need to choose one one version \n 1 -> Paper \n 2 -> Rock \n 3 -> SCISSORS");
        int choice = new Scanner(System.in).nextInt();
        if (choice == 1) {
            return Versions.PAPER;
        } else if (choice == 2) {
            return Versions.ROCK;
        } else if (choice == 3) {
            return Versions.SCISSORS;
        }
        return null;
    }

    public void print(UsualGame game) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        System.out.println("+------------------------------------------------------------------+");
        System.out.printf(TITLES, "VICTORY", "DEFEAT", "DRAW", "ALL GAME", "PERCENT OF WINS");
        System.out.println("|------------------------------------------------------------------|");
        System.out.printf(TITLES, game.winning, game.defeat, game.draw, game.amountAllGame, decimalFormat.format(game.percent) + "%");
        System.out.println("+------------------------------------------------------------------+");
    }
}
