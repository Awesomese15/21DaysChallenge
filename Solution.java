package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    static List<String>listOfNumbers=new ArrayList<>();
    private   String swap(String str, int i, int j)
    {
        char temp;
        char [] charArray=str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


public void  permute(String binaryString){
    List<String> answer = new ArrayList<>();
   permute(binaryString, new String());
}

public static List<String> retrunPermutedNumber(String number){
    if(!listOfNumbers.contains(number)){
        listOfNumbers.add(number);
    }

    return listOfNumbers;
}

public static void permute(String binaryString,String decisionSoFar){
    String perm="";
    if(binaryString.isEmpty()){
        retrunPermutedNumber(decisionSoFar);

    }

    for (int i = 0; i < binaryString.length(); i++) {

        String decisions = decisionSoFar+binaryString.charAt(i);
        String newBinaryString=binaryString;
        permute(newBinaryString.substring(0,i)+newBinaryString.substring(i+1,binaryString.length()), decisions);
    }


}


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Solution solution=new Solution();

        int t=0;
        int n=0;
        t=scan.nextInt();
        for (int i=0; i<t; i++){

            n=scan.nextInt();


           String binaryString= Integer.toBinaryString(n);

            listOfNumbers.clear();
            solution.permute(binaryString);
            int output=0;
            for(String bits : listOfNumbers){

                output=output+Integer.parseInt(bits,2);


            }
          System.out.println(output);
        }
    }
}
