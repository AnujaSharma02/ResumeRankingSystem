# Resume Ranking System 

This project ranks resumes based on job-specific keywords using core data structures like Trie and Heap. It’s built in Java and intended to demonstrate efficient document filtering and relevance scoring.

# Features
- Trie for fast keyword matching
- Max Heap for resume ranking
- Easy-to-configure keyword and resume folders

# Setup

1. Clone the repo
2. Add keywords to `keywords.txt`
3. Put resumes in `resumes/` (in `.txt` format)
4. Run the program

# Run

```bash
javac -d bin src/*.java
java -cp bin Main
