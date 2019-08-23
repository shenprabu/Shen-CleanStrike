/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    }
    
    static void playersTurn(Player p) {
        
        System.out.println("");
        
        int turn = 0;   // get input
        
        switch(turn) {
            
            case 1 :
                p.addScore(1);
                p.addHistory(1);
                b.reduceCoin(1);
                break;
                
            case 2 :
                p.addScore(2);
                p.addHistory(2);
                b.reduceCoin(2);
        }
    }
    
}

