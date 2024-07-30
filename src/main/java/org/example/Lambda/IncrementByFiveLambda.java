package org.example.Lambda;

public class IncrementByFiveLambda {

    public static void main(String[] args) {
        IncrementByFive incrementByFive = (x) -> x + 5;

        System.out.println(incrementByFive.incrementByFive(100));
    }
}
