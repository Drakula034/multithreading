package org.example.Lambda;

public class IncrementByFiveTraditional implements IncrementByFive{
    @Override
    public int incrementByFive(int a) {
        return a + 5;
    }

    public static void main(String[] args) {
        IncrementByFive traditional = new IncrementByFiveTraditional();
        System.out.println(traditional.incrementByFive(10));
    }
}
