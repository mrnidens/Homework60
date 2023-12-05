package ait.tarakansrace.model;

import java.util.Random;

public class Tarakan implements Runnable {
        Random random = new Random();

        int number;
        int maxIterations;
        boolean finished = false;

    public Tarakan(int number, int maxIterations) {
        this.number = number;
        this.maxIterations = maxIterations;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
        public void run() {
            System.out.println("Tarakan " + number + ", started");
            for (int i = 0; i < maxIterations; i++) {
                System.out.println("Tarakan " + number + ", running " + i + ". distance");
                try {
                    Thread.sleep(random.nextInt(2,6));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finished = true;
            System.out.println("Tarakan " + number + " finished");
        }
    }

