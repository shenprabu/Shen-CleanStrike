
package cleanstrike;

import java.util.ArrayList;

/**
 *
 * @author test
 */
public class Player {
        
    public String name;
    private int score;
    private ArrayList<Integer> history; 
    
    Player(String name) {
        this.name = name;
        this.score = 0;
        this.history = new ArrayList();
    }
    
    void addScore(int point) {
        this.score = this.score + point;
    }
    
    int getScore() {
        return this.score;
    }
    
    void addHistory(int turn) {
        this.history.add(turn);
    }
    
    boolean noneForLast3Turns() {
        
        int size = this.history.size();
        
        if(size < 3) {
            return false;
        }
        
        if(this.history.get(size - 1) == 6 && this.history.get(size - 2) == 6 && this.history.get(size - 3) == 6) {
            // TODO - if player continuously scores none for 4 time, score will be deduced twice.
            return true;
        }
        return false;
    }
   
}
