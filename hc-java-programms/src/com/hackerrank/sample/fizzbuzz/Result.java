package com.hackerrank.sample.fizzbuzz;

class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {

        for(int i=1; i<= n ; i++){
            // Write your code here
            if(i%3 == 0 && i%5 ==0){
                System.out.println("FizzBuzz");
            }else if(i%3 == 0){
                System.out.println("Fizz");
            } else if(i%5 == 0){
                System.out.println("Buzz");
            } else{
                System.out.println(i);
            }
        }
    }

}
