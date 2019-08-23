
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

    int getCoins() {
        return this.coins;
    }

    int getRed() {
        return this.red;
    }
    
    void reduceCoin(int coins) {
        if(this.coins >= coins) {
            this.coins = this.coins - coins;
        }
    }

    void reduceRed() {
        this.red = 0;
    }

    boolean isStrikeAvailable() {
        return this.coins > 0;
    }

    boolean isMultiStrikeAvailable() {
        return this.coins > 1;
    }

    boolean isRedStrikeAvailable() {
        return this.red != 0;
    }
}
