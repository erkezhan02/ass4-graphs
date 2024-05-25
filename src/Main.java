public class Main {
    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search djk = new DijkstraSearch(weightedGraph, new Vertex("Almaty"));
        outputPath(djk, new Vertex("Kyzylorda"));

        System.out.println("--------------------------------");

        WeightedGraph graph = new WeightedGraph(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search dfs = new BreadthFirstSearch(graph, new Vertex("Almaty"));
        outputPath(dfs, new Vertex("Kyzylorda"));

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search bfs = new BreadthFirstSearch(graph, new Vertex("Almaty"));
        outputPath(bfs, new Vertex("Kyzylorda"));
    }

    public static void fillWithoutWeights(WeightedGraph graph) {
        graph.addEdge(new Vertex("Almaty"), new Vertex("Astana"), 1);
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Atyrau"), 1);
        graph.addEdge(new Vertex("Atyrau"), new Vertex("Astana"), 1);
        graph.addEdge(new Vertex("Almaty"), new Vertex("Shymkent"), 1);
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Astana"), 1);
        graph.addEdge(new Vertex("Astana"), new Vertex("Kostanay"), 1);
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Kyzylorda"), 1);
    }

    public static void fillWithWeights(WeightedGraph graph) {
        graph.addEdge(new Vertex("Almaty"), new Vertex("Astana"), 2.1);
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Atyrau"), 7.8);
        graph.addEdge(new Vertex("Atyrau"), new Vertex("Astana"), 7.1);
        graph.addEdge(new Vertex("Almaty"), new Vertex("Shymkent"), 7.2);
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Astana"), 3.9);
        graph.addEdge(new Vertex("Astana"), new Vertex("Kostanay"), 3.5);
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Kyzylorda"), 5.4);
    }

    public static void outputPath(Search search, Vertex key) {
        for (Object v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}
