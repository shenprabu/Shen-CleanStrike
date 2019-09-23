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
public class Stroke {
    
    public static final int STRIKE = 1;
    public static final int MULTISTRIKE = 2;
    public static final int RED_STRIKE = 3;
    public static final int STRIKER_STRIKE = 4;
    public static final int DEFUNCT_COIN = 5;
    public static final int NONE = 6;
    
    public static int getMax() {
        return NONE;
    }
}
