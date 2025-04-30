import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Ranker {
    Trie trie = new Trie();
    Heap heap = new Heap();
    String keywordFile, resumeDir;

    public Ranker(String keywordFile, String resumeDir) {
        this.keywordFile = keywordFile;
        this.resumeDir = resumeDir;
        loadKeywords();
    }

    private void loadKeywords() {
        try (BufferedReader br = new BufferedReader(new FileReader(keywordFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                trie.insert(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Keyword file loading error");
        }
    }

    public void rankResumes() {
        try {
            Files.list(Paths.get(resumeDir))
                .filter(p -> p.toString().endsWith(".txt"))
                .forEach(p -> {
                    try {
                        int score = 0;
                        List<String> lines = Files.readAllLines(p);
                        for (String line : lines) {
                            for (String word : line.split("\\W+")) {
                                if (trie.search(word))
                                    score++;
                            }
                        }
                        heap.insert(new Resume(p.getFileName().toString(), score));
                    } catch (IOException e) {
                        System.err.println("Failed to read resume: " + p.getFileName());
                    }
                });
        } catch (IOException e) {
            System.err.println("Failed to read resume directory");
        }

        heap.display();
    }
}
