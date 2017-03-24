package WhatIsYourPoison;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntToDoubleFunction;

/**
 * Created by bohdan on 24.03.17.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(find(new int[]{0, 1, 3, 4}));
    }

    public static int find(int[] rats) {
        int[] resMass = new int[10];
        double resNumb = 0;

        for(int i =0; i < resMass.length; i++){
            resMass[i] = 0;
        }

        for(int i = 0; i < rats.length; i++){
            resMass[rats[i]] = 1;
        }

        for(int i = 0; i < resMass.length; i++){
            if(resMass[i] == 1){
                resNumb = resNumb + Math.pow(2, i);;
            }
        }
        return (int)resNumb;
    }
}
