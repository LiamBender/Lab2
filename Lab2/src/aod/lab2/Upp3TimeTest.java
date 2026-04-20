package aod.lab2;

import java.util.Random;

public class Upp3TimeTest {

    public static void main(String[] args) {
        int[] randomSizes = {20000, 40000, 80000, 160000, 320000};
        int[] sortedSizes = {1000, 2000, 4000, 8000, 16000};
        int searches = 1000;

        System.out.println("Slumpade Heltal");
        System.out.println("n\tTid (ns)\tKvot");

        long prevTime = 0;
        for (int n : randomSizes) {
            long time = testRandom(n, searches);

            if (prevTime == 0) {
                System.out.println(n + "\t" + time + "\t-");
            } else {
                double kvot = (double) time / prevTime;
                System.out.println(n + "\t" + time + "\t" + kvot);
            }

            prevTime = time;
        }

        System.out.println();
        System.out.println("Sorterade Heltal");
        System.out.println("n\tTid (ns)\tKvot");

        prevTime = 0;
        for (int n : sortedSizes) {
            long time = testSorted(n, searches);

            if (prevTime == 0) {
                System.out.println(n + "\t" + time + "\t-");
            } else {
                double kvot = (double) time / prevTime;
                System.out.println(n + "\t" + time + "\t" + kvot);
            }

            prevTime = time;
        }
    }

    public static long testRandom(int n, int searches) {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        Random r = new Random(123);

        for (int i = 0; i < n; i++) {
            t.add(r.nextInt(n * 10));
        }

        long start = System.nanoTime();

        for (int i = 0; i < searches; i++) {
            t.searchFor(r.nextInt(n * 10));
        }

        long stop = System.nanoTime();
        return stop - start;
    }

    public static long testSorted(int n, int searches) {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        Random r = new Random(123);

        for (int i = 0; i < n; i++) {
            t.add(i);
        }

        long start = System.nanoTime();

        for (int i = 0; i < searches; i++) {
            t.searchFor(r.nextInt(n * 2));
        }

        long stop = System.nanoTime();
        return stop - start;
    }
}