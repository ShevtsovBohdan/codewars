package codewars.LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lcs("132535365", "123456789"));
    }

    public static String lcs(String x, String y) {
        char[] xArr =  x.toCharArray();
        char[] yArr = y.toCharArray();


        int j = 0;

        String[] lineY = new String[yArr.length];
        String resLineY;
        String resLineX;
        String[] lineX = new String[xArr.length];

        for(int i = 0; i < yArr.length; i++){
            lineY[i] = search(xArr, yArr, i, j);
        }
        for(int i = 0; i < xArr.length; i++){
            lineX[i] = search(yArr, xArr, i, j);
        }
        resLineY = getString(yArr, lineY);

        resLineX = getString(xArr, lineX);

        if(resLineX.length() >= resLineY.length()){
            return resLineX;
        } else return resLineY;

    }

    private static String getString(char[] Arr, String[] lineX) {
        String resLineX;
        if(Arr.length != 0) {
            String max = lineX[0];
            for (int k = 0; k < Arr.length - 1; k++) {
                if (lineX[k + 1].length() > lineX[k].length()) {
                    max = lineX[k];
                }
            }
            resLineX = max;
        } else resLineX = "";
        return resLineX;
    }


    public static String search(char[] xArr, char[] yArr, int i, int j) {
        ArrayList<Integer> happyIndex = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int saveJ = 0;
        while(j < xArr.length && i < yArr.length) {
            if(xArr[j] == yArr[i]) {
                happyIndex.add(i);
                i++;
                saveJ = j;
                continue;
            }
            j++;
            if(j == xArr.length - 1 && i + 1 <= yArr.length - 1){
                j = saveJ + 1;
                i = i + 1;
            }
        }

        for(Integer ind : happyIndex){
            line.append(yArr[ind]);
        }
        return line.toString();
    }

}
