package org.example.Lambda;

public class HelloWorldOldWay implements HelloWorldInterface{

    @Override
    public String sayHelloWorld() {
        return "Hello World";
    }

    public static void main(String[] args) {
        HelloWorldOldWay oldWay = new HelloWorldOldWay();
        System.out.println(oldWay.sayHelloWorld());
    }
}
