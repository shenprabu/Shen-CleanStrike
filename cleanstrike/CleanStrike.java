package cleanstrike;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author test
 */
public class CleanStrike {

    /**
     * @param args the command line arguments
     */
    static Board b;

    public static void main(String[] args) {
        // TODO code application logic here
        
        b = new Board();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        System.out.println("||...Clean Strike...||");
        System.out.println(String.format("%s starts the game !!", p1.name));

        int i = 0;
        do {
            if (i % 2 == 0) {
                playersTurn(p1);
            } else {
                playersTurn(p2);
            }
            i++;
        } while (b.getCoins() != 0 || b.getRed() != 0);

        System.out.println(String.format("Game ended. Final score is %s - %s", p1.getScore(), p2.getScore()));
//        System.out.println(String.format("%s wins !!!", p1.getScore() > p2.getScore() ? p1.name : p2.name));
        
        int p1Score = p1.getScore();
        int p2Score = p2.getScore();
        
        if (p1Score > p2Score ? isGameWon(p1Score, p2Score) : isGameWon(p2Score, p1Score)) {
            System.out.println(String.format("%s wins !!! ;)", p1Score > p2Score ? p1.name : p2.name));
        } else {
            System.out.println("Game is drawn. coz, no solid winner !! :)");
        }
    }
    
    static boolean isGameWon(int score1, int score2) {
        if(score1 >= 5 && score1 - score2 > 3) {     // winning score should be atleast 5 or 3 points higher that losing score.
            return true;
        }
        return false;
    }

    static void playersTurn(Player p) {

        System.out.println();
        System.out.println(String.format("%s's turn. Choose one from the following :", p.name));
        System.out.println("1. Strike");
        System.out.println("2. Multistrike");
        System.out.println("3. Red strike");
        System.out.println("4. Striker Strike");
        System.out.println("5. Defunct coin");
        System.out.println("6. None");
        System.out.println("> ");

        Scanner scanner = new Scanner(System.in);

        try {
            int stroke = scanner.nextInt();
            boolean isMultiStrikeAvailable = b.isMultiStrikeAvailable();
            boolean isRedStrikeAvailable = b.isRedStrikeAvailable();
            int strokePoint = 0;
                    
            switch (stroke) {

                case Stroke.STRIKE:
                    
                    //p.addScore(1);
                    strokePoint = 1;
                    b.reduceCoin(1);
                    System.out.println(String.format("%s scores 1 point !!", p.name));
                    break;

                case Stroke.MULTISTRIKE:
                    
                    if (isMultiStrikeAvailable) {
                        //p.addScore(2);
                        strokePoint = 2;
                        b.reduceCoin(2);    // TODO - all but 2 coins in ??
                        System.out.println(String.format("%s scores 2 points !!", p.name));
                    } else {
                        System.out.println("Multi Strike not available..");
                        playersTurn(p);
                    }
                    break;

                case Stroke.RED_STRIKE:
                    
                    if (isRedStrikeAvailable) {
                        //p.addScore(3);
                        strokePoint = 3;
                        b.reduceRed();
                        System.out.println(String.format("Red covered !! %s scores 3 points !!", p.name));
                    } else {
                        System.out.println("Red Strike not available..");
                        playersTurn(p);
                    }
                    break;

                case Stroke.STRIKER_STRIKE:
                    
                    //p.addScore(-1);
                    strokePoint = -1;
                    System.out.println(String.format("%s loses 1 point !!", p.name));
                    break;

                case Stroke.DEFUNCT_COIN:
                    
                    //p.addScore(-2);
                    strokePoint = -2;
                    p.addHistory(5);
                    b.reduceCoin(1);
                    System.out.println(String.format("%s loses 2 points !!", p.name));
                    break;

                case Stroke.NONE:
                    
                    if (p.getNoneStreak() == 2) {   // if 3 stokes continuously are none
                        //p.addScore(-1);
                        strokePoint = -1;
                        System.out.println(String.format("None for last 3 turns. %s loses 1 point !!", p.name));
                        p.resetNoneStreak();
                    } else {
                        System.out.println(String.format("No points in this turn !!"));
                        p.addNoneSteak();
                    }
                    break;

                default:
                    
                    System.out.println("wrong input :( Try again...");
                    playersTurn(p);

            }
            p.addScore(strokePoint);
            
            if (stroke >= Stroke.STRIKE && stroke <= Stroke.getMax() && !(stroke == Stroke.MULTISTRIKE && !isMultiStrikeAvailable) && !(stroke == Stroke.RED_STRIKE && !isRedStrikeAvailable)) {
                System.out.println(String.format("Coins remaining : %s, Red remaining : %s", b.getCoins(), b.getRed()));
                
                p.addHistory(stroke);
                if(stroke != Stroke.NONE) {
                    p.resetNoneStreak();
                }
            }
            

        } catch (InputMismatchException e) {
            System.out.println("wrong input :( Try again...");
            playersTurn(p);
        }

    }

}
