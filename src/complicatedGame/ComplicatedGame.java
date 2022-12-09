package complicatedGame;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ComplicatedGame {

    protected static final String TITLES = "|  %-9s|  %-9s|  %-7s|  %-9s|  %-9s   |\n";
    protected int winning;
    protected int defeat;
    protected int draw;
    public int amountAllGame;
    protected double percent;

    public void calculation(ComplicatedGame c) {
        try {
            int compare = c.userTurn().compareMove(c.computerTurn());
            switch (compare) {
                case 0:
                    c.draw++;
                    break;
                case 1:
                    c.winning++;
                    break;
                case -1:
                    c.defeat++;
                    break;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void countPercent(ComplicatedGame c) {
        int total = c.amountAllGame - c.winning - c.defeat;
        c.percent = ((c.winning + ((double) total) / 2) / c.amountAllGame) * 100;
        if (Double.isNaN(c.percent)) {
            c.percent = 0;
        }
    }

    public ComplicatedVersions computerTurn() {
        int rnd = new Random().nextInt(5);
        switch (rnd) {
            case 0:
                return ComplicatedVersions.PAPER;
            case 1:
                return ComplicatedVersions.ROCK;
            case 2:
                return ComplicatedVersions.SCISSORS;
            case 3:
                return ComplicatedVersions.LIZARD;
            case 4:
                return ComplicatedVersions.SPOCK;
        }
        return null;
    }

    public ComplicatedVersions userTurn() {
        System.out.println("You need to choose one of version \n 1 -> Paper \n 2 -> Rock \n 3 -> Scissors \n 4 -> Lizard \n 5-> Spock");
        try {
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    return ComplicatedVersions.PAPER;
                case 2:
                    return ComplicatedVersions.ROCK;
                case 3:
                    return ComplicatedVersions.SCISSORS;
                case 4:
                    return ComplicatedVersions.LIZARD;
                case 5:
                    return ComplicatedVersions.SPOCK;
                default:
                    System.out.println("You should enter correctly \n 1 -> Paper \n 2 -> Rock \n 3 -> Scissors \n 4 -> Lizard \n 5-> Spock");
            }
        } catch (InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void print(ComplicatedGame c) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        System.out.println("+------------------------------------------------------------------+");
        System.out.printf(TITLES, "VICTORY", "DEFEAT", "DRAW", "ALL GAME", "PERCENT OF WINS");
        System.out.println("|------------------------------------------------------------------|");
        System.out.printf(TITLES, c.winning, c.defeat, c.draw, c.amountAllGame, decimalFormat.format(c.percent) + "%");
        System.out.println("+------------------------------------------------------------------+");
    }
}
