package Set;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<String>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<String>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

    }
}
