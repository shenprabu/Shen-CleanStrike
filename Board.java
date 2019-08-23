
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
