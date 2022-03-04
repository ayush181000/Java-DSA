package com.ayush;

public class sol {
    public static void main(String[] args) {
        int n = 5;
        int sum =0;
        int start = 1;
        int end = 1;
        int counter = 1;

        while(start <= n/2+1){

            sum = sum + end;
            if(sum > n){
                start ++;
                sum=0;
                end = start-1;
            }
            if(sum == n){
                counter ++;
                start ++;
                end= start;
            }
            end++;

        }
        System.out.println(counter);
    }
}
