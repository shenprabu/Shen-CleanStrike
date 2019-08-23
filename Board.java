/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleanstrike;

/**
 *
 * @author test
 */
public class Board {
    
    private int coins;
    private int red;
    
    Board() {
        this.coins = 9;
        this.red = 1;
    }
    
    void reduceCoin(int coins) {
        this.coins = this.coins - coins;
        
    }
}
