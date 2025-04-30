public class Main {
    public static void main(String[] args) {
        Ranker ranker = new Ranker("keywords.txt", "resumes/");
        ranker.rankResumes();
    }
}
