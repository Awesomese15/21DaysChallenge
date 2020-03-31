package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    static  List<String>numbers=new ArrayList<>();
    public List<String> permute(String str, int l, int r)
    {




        if (l == r){


            if(!numbers.contains(str)){
                numbers.add(str);
            }


        }

        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }

        return numbers;

    }

    private   String swap(String str, int i, int j)
    {
        char temp;
        char [] charArray=str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
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


            numbers.clear();
            List<String> listOfBits= solution.permute(binaryString,0,binaryString.length()-1);
            int output=0;
            for(String bits : listOfBits){

                output=output+Integer.parseInt(bits,2);


            }
            System.out.println(output);
        }
    }
}
