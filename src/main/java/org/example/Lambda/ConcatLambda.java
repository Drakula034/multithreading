package org.example.Lambda;

public class ConcatLambda {

    public static void main(String[] args) {
        ConcatenateInterface concatenateInterface = (a,b)->a.concat(b);

        System.out.println(concatenateInterface.sconcat("hello","Abhishek"));
    }
}
