import java.util.PriorityQueue;
import java.util.Comparator;

public class Heap {
    PriorityQueue<Resume> pq;

    public Heap() {
        pq = new PriorityQueue<>(Comparator.comparingInt(r -> -r.score));
    }

    public void insert(Resume r) {
        pq.add(r);
    }

    public void display() {
        while (!pq.isEmpty()) {
            Resume r = pq.poll();
            System.out.println(r.filename + " --> Score: " + r.score);
        }
    }
}
