
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
    private int noneStreak;
    
    Player(String name) {
        this.name = name;
        this.score = 0;
        this.history = new ArrayList();
        this.noneStreak = 0;
    }
    
    void addScore(int point) {
        this.score = this.score + point;
    }
    
    int getScore() {
        return this.score;
    }
    
    void addHistory(int stroke) {
        this.history.add(stroke);
    }
    
    void addNoneSteak() {
        this.noneStreak++;
    }
    
    int getNoneStreak() {
        return this.noneStreak;
    }
    
    void resetNoneStreak() {
        this.noneStreak = 0;
    }
   
}
