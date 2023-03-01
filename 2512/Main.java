import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] positive_feedback = { "smart", "brilliant", "studious" };
        String[] negative_feedback = { "not" };
        String[] report = { "this student is not studious", "the student is smart" };
        int[] student_id = { 1, 2 };
        List<Integer> ans = main.topStudents(positive_feedback, negative_feedback, report, student_id, 2);
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        HashSet<String> positive = new HashSet<String>(Arrays.asList(positive_feedback));
        HashSet<String> negative = new HashSet<String>(Arrays.asList(negative_feedback));
        HashMap<Integer, Integer> scoreMap = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                (a, b) -> scoreMap.get(a) == scoreMap.get(b) ? a - b : scoreMap.get(b) - scoreMap.get(a));
        for (int i = 0; i < student_id.length; i++) {
            int score = 0;
            for (String s : report[i].split(" ")) {
                if (positive.contains(s))
                    score += 3;
                else if (negative.contains(s))
                    score--;
            }
            scoreMap.put(student_id[i], score);
            pq.add(student_id[i]);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < k; i++)
            res.add(pq.poll());
        return res;
    }

    public List<Integer> topStudentsArray(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        HashSet<String> positive = new HashSet<String>(Arrays.asList(positive_feedback));
        HashSet<String> negative = new HashSet<String>(Arrays.asList(negative_feedback));
        int[] scores = new int[student_id.length];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                (a, b) -> scores[a] == scores[b] ? student_id[a] - student_id[b] : scores[b] - scores[a]);
        for (int i = 0; i < student_id.length; i++) {
            int score = 0;
            for (String s : report[i].split(" ")) {
                if (positive.contains(s))
                    score += 3;
                else if (negative.contains(s))
                    score--;
            }
            scores[i] = score;
            pq.add(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < k; i++)
            res.add(student_id[pq.poll()]);
        return res;
    }
}