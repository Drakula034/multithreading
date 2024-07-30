package org.example.Lambda;

public class RunnableExample {
    public static void main(String[] args) {
//        Runnable Traditional

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i = 0; i < 10; i++){
                    sum += i;
                }
                System.out.println("Traditional: " + sum);
            }
        };

        new Thread(runnable).start();

//        implement using lambda

        Runnable runnable1 = ( )->{
             int sum = 0;
             for(int i = 0; i < 10; i++){
                 sum += i;
             }
            System.out.println("Runnable Lamda sum: "+ sum);
        };

        new Thread(runnable1).start();

//        Implement using Thread with lambda

        new Thread(()->{
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("Thread Lambda sum: "+ sum);
        }).start();
    }
}
