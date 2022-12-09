import complicatedGame.ComplicatedGame;
import usualGame.UsualGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("You must choose one of version. D/E");
        String version = new Scanner(System.in).nextLine();
        if (version.toLowerCase().charAt(0) == 'd') {
            complicatedGame();
        } else if (version.toLowerCase().charAt(0) == 'e') {
            usualGame();
        } else {
            System.out.println("Enter correctly! D -> difficult \n E -> easy");
        }
    }

    public static void usualGame() {
        UsualGame game = new UsualGame();
        while (true) {
            System.out.println("Do you want to play one more time? Y/N ");
            String answerOfUser = new Scanner(System.in).nextLine();
            if (answerOfUser.toLowerCase().charAt(0) == 'y') {
                game.amountAllGame++;
                game.calculation(game);
            } else {
                System.out.println("GAME END!");
                break;
            }
        }
        game.countPercent(game);
        game.print(game);
    }

    public static void complicatedGame() {
        ComplicatedGame c = new ComplicatedGame();
        while (true) {
            System.out.println("Do you want to play one more time? Y/N ");
            String answerOfUser = new Scanner(System.in).nextLine();
            if (answerOfUser.toLowerCase().charAt(0) == 'y') {
                c.amountAllGame++;
                c.calculation(c);
            } else {
                System.out.println("GAME END!");
                break;
            }
        }
        c.countPercent(c);
        c.print(c);
    }
}
