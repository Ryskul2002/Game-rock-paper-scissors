import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String TITLES = "|  %-9s|  %-9s|  %-7s|  %-9s|  %-9s   |\n";

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Game game = new Game();
        int i = 0;
        while (i < 6){
            System.out.println("Do you want to play one more time? Y/N ");
            String answerOfUser = new Scanner(System.in).nextLine();
            if (answerOfUser.toLowerCase().charAt(0) == 'y') {
                playAgain();
                i++;
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

    public static void playAgain() {

    }

}
