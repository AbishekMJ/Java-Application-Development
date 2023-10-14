package fullStackdeveloper;

// Program to demonstrate CountPuzzle using Files

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class KnowledgeCounter {
    private String filePath;

    public KnowledgeCounter(String filePath) {
        this.filePath = filePath;
    }

    public int countKnowledge() {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase(); // Convert to lowercase for case-insensitive matching
                count += countOccurrences(line, "knowledge");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    private int countOccurrences(String text, String word) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = text.indexOf(word, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += word.length();
            }
        }

        return count;
    }
}

public class CountPuzzle {
    public static void main(String[] args) {
        String filePath = "FileDemo/log.txt";
        KnowledgeCounter knowledgeCounter = new KnowledgeCounter(filePath);

        int totalCount = knowledgeCounter.countKnowledge();
        System.out.println(totalCount);
    }
}

