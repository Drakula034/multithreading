package org.example;

public class FastFoodResturantSynchronizedMethod {
    private String lastClientName;
    private int numberOfBurgersSold;

    public synchronized void  buyBurger(String clientName){
        alongRunningProcess();
        this.lastClientName = clientName;
        numberOfBurgersSold++;
        System.out.println(clientName + " bought a burger");
    }

    public void alongRunningProcess(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getLastClientName() {
        return lastClientName;
    }

    public void setLastClientName(String lastClientName) {
        this.lastClientName = lastClientName;
    }

    public int getNumberOfBurgersSold() {
        return numberOfBurgersSold;
    }

    public void setNumberOfBurgersSold(int numberOfBurgersSold) {
        this.numberOfBurgersSold = numberOfBurgersSold;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        FastFoodResturantSynchronizedMethod fastFoodResturant = new FastFoodResturantSynchronizedMethod();

        Thread t1 = new Thread(()->{
            fastFoodResturant.buyBurger("Mike");

        });

        Thread t2 = new Thread(()->{
            fastFoodResturant.buyBurger("Jane");
        });

        Thread t3 = new Thread(() -> {
            fastFoodResturant.buyBurger("Bob");
        });

        Thread t4 = new Thread(() -> {
            fastFoodResturant.buyBurger("Alice");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Total number of burger sold: " + fastFoodResturant.getNumberOfBurgersSold());
        System.out.println("Last name of client is " + fastFoodResturant.getLastClientName());
        System.out.println("Total execution time : " + (System.currentTimeMillis()-start) + " in ms");
    }
}
