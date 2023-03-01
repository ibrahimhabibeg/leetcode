import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<List<String>>();
        List<String> ticket1 = new ArrayList<String>(Arrays.asList(new String[] { "MUC", "LHR" }));
        tickets.add(ticket1);
        List<String> ticket2 = new ArrayList<String>(Arrays.asList(new String[] { "JFK", "MUC" }));
        tickets.add(ticket2);
        List<String> ticket3 = new ArrayList<String>(Arrays.asList(new String[] { "SFO", "SJC" }));
        tickets.add(ticket3);
        List<String> ticket4 = new ArrayList<String>(Arrays.asList(new String[] { "LHR", "SFO" }));
        tickets.add(ticket4);
        Main main = new Main();
        System.out.println(main.findItinerary(tickets).size());
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new ArrayList<String>());
            graph.putIfAbsent(ticket.get(1), new ArrayList<String>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        for (String key : graph.keySet()) 
            Collections.sort(graph.get(key));
        List<String> res = new ArrayList<String>();
        backtrack("JFK", graph, res, tickets.size());
        return res;
    }

    private boolean backtrack(String node, HashMap<String, List<String>> graph, List<String> res, int edgesCount) {
        res.add(node);
        if (res.size() == edgesCount + 1)
            return true;
        for (int i = 0; i < graph.get(node).size(); i++) {
            String adj = graph.get(node).remove(i);
            if (backtrack(adj, graph, res, edgesCount))
                return true;
            graph.get(node).add(i, adj);
        }
        res.remove(res.size() - 1);
        return false;
    }
}