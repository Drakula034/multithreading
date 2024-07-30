package org.example;

import java.util.stream.IntStream;

public class SumOfNumberUsingRunnableExample {
    public static int[] numbers = IntStream.rangeClosed(0,5000).toArray();
    public static int sum = 0;

    public static int total = IntStream.rangeClosed(0,5000).sum();
    public static void main(String[] args) throws InterruptedException {

        Worker1Parallel worker1 = new Worker1Parallel(numbers);
        Worker2Parallel worker2 = new Worker2Parallel(numbers);

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Sum of 5000 integers in parallel is :" + sum);
        System.out.println("Sum of 5000 integers in inStream is : " + total);

    }

    public static void add(int toAdd){
        sum += toAdd;
    }
}

class Worker1Parallel implements Runnable {

    int[]array;
    int sum = 0;
    public Worker1Parallel(int[] array){
        this.array = array;
    }

    @Override
    public void run() {
        for(int i = 0; i < array.length/2; i++){
            sum += array[i];
        }

        SumOfNumberUsingRunnableExample.add(sum);

    }
}

class Worker2Parallel implements Runnable {
    int[] array;
     int sum = 0;
    public Worker2Parallel(int[] array) {
        this.array = array;
    }



    @Override
    public void run() {
        for(int i = array.length/2; i < array.length; i++) {
            sum += array[i];
        }
        SumOfNumberUsingRunnableExample.add(sum);

    }
}
