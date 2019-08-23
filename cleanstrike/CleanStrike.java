
package cleanstrike;

import java.util.ArrayList;

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
        
        System.out.println("...Clean Strike...");
        System.out.println(String.format("{0} starts the game !!", p1.name));

        playersTurn(p1);

        while(b.getCoins() != 0 && b.getRed() != 0) {

            playersTurn(p2);
        }

        System.out.println(String.format("Game ended. Final score {0} - {1}", p1.getScore(), p2.getScore()));
        System.out.println(String.format("{0} wins !!!", p1.getScore() > p2.getScore() ? p1.name : p2.name));
    }
    
    static void playersTurn(Player p) {
        
        System.out.println(String.format("{0}'s turn. Choose one from the following :", p.name));
        
        int turn = 0;   // get input
        
        switch(turn) {
            
            case 1 :
                p.addScore(1);
                p.addHistory(1);
                b.reduceCoin(1);
                System.out.println(String.format("{0} scores 1 point !!", p.name));
                break;
                
            case 2 :
                p.addScore(2);
                p.addHistory(2);
                b.reduceCoin(2);    // TODO - all but 2 coins in ??
                System.out.println(String.format("{0} scores 2 points !!", p.name));
                break;

            case 3 :
                p.addScore(3);
                p.addHistory(3);
                b.reduceRed();
                System.out.println(String.format("Red covered !! {0} scores 3 points !!", p.name));
                break;

            case 4 :
                p.addScore(-1);
                p.addHistory(4);
                System.out.println(String.format("{0} loses 1 point !!", p.name));
                break;

            case 5 :
                p.addScore(-2);
                p.addHistory(5);
                b.reduceCoin(1);
                System.out.println(String.format("{0} loses 2 points !!", p.name));
                break;

            case 6 :
                p.addHistory(6);
                if(p.noneForLast3Turns()) {
                    p.addScore(-1);
                    System.out.println(String.format("None for last 3 turns. {0} loses 1 point !!", p.name));
                } else {
                    System.out.println(String.format("No points in this turn !!"));
                }
                break;
        }
        System.out.println(String.format("Coins remaining : {0}, Red remaining : {1}", b.getCoins(), b.getRed()));

    }
    
}

