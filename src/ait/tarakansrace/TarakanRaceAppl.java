package ait.tarakansrace;
import ait.tarakansrace.model.Tarakan;
import java.util.Scanner;

public class TarakanRaceAppl {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount of tarakans");
        int amountTarakans = scanner.nextInt();

        System.out.println("Enter amount of iterations");
        int amountIterations = scanner.nextInt();


        int numberOfWinner = -1;

        Tarakan[] tarakans = new Tarakan[amountTarakans];
        for (int i = 0; i < tarakans.length; i++) {
            tarakans[i] = new Tarakan(i, amountIterations);
        }

        Thread[] threads = new Thread[amountTarakans];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tarakans[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            if(numberOfWinner == -1 && tarakans[i].isFinished()) {
                numberOfWinner = i;
            }
            threads[i].join();
        }
        System.out.println("Winner is number " + numberOfWinner);
        System.out.println("Tarakans race finished");

    }
}
