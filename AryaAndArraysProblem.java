package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AryaAndArraysProblem {

public static  void main(String args []) throws IOException {
    Scanner scan=new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t=0;
    int n=0;
    t=Integer.parseInt(reader.readLine());
    for (int i=0; i<t; i++){
        n=Integer.parseInt(reader.readLine());
        String aar="";

        int[] array1=new int[n];
        int[] array2=new int[n];

            array1 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            List<Integer> list1 = Arrays.stream(array1).boxed().collect(Collectors.toList());
            Arrays.sort(array1);
            array2 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            List<Integer> list2 = Arrays.stream(array2).boxed().collect(Collectors.toList());
            Arrays.sort(array2);
            int count=0;
            List<Integer> notMatchedOfArr1=new ArrayList<>();
            List<Integer> notMatchedOfArr2=new ArrayList<>();
            if(Arrays.equals(array1, array2)){
                System.out.println("Yes");
            }else{
                for(int k=0; k<array1.length; k++){
                    if(!list2.contains(array1[k])){
                        notMatchedOfArr1.add(array1[k]);

                    }
                    if(!list1.contains(array2[k])){
                        notMatchedOfArr2.add(array2[k]);

                    }
                }

                if(notMatchedOfArr1.size()<=1 || notMatchedOfArr2.size()<=1 ){
                    long intSum1=list1.stream()
                            .mapToLong(Integer::longValue)
                            .sum();

                    long intSum2=list2.stream()
                            .mapToLong(Integer::longValue)
                            .sum();

                    if(intSum1<intSum2){
                        long diff=intSum2-intSum1;
                        System.out.println(diff+" "+"1");
                    }else  if(intSum1>intSum2){
                        long diff=intSum1-intSum2;
                        System.out.println(diff+" "+"2");
                    }

                }else{
                    System.out.println("No");
                }

            }

    }
}
}
