import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] bank = { "AAAACCCC", "AAACCCCC", "AACCCCCC", "AAGCCCCC", "AAACGCTC", };
        System.out.println(main.minMutation("AAAAACCC", "AACCCCCC", bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        map.put(start, new HashSet<String>());
        for (String gene : bank)
            map.put(gene, new HashSet<String>());
        for (int i = -1; i < bank.length - 1; i++) {
            String gene1 = i == -1 ? start : bank[i];
            for (int j = i + 1; j < bank.length; j++) {
                String gene2 = bank[j];
                if (isConnected(gene1, gene2)) {
                    map.get(gene1).add(gene2);
                    map.get(gene2).add(gene1);
                }
            }
        }
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> checked = new HashSet<String>();
        queue.add(start);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(end))
                    return depth;
                checked.add(gene);
                for (String adjGene : map.get(gene))
                    if (!checked.contains(adjGene))
                        queue.add(adjGene);
            }
            depth++;
        }
        return -1;
    }

    private boolean isConnected(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++)
            count += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
        return count == 1;
    }
}