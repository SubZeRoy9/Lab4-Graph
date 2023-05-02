
public class Main {
    public static void main(String[] args) {
        int[][] testGraph =
                        {{0, 80,	0,	25,	60,	0,	0,	0,	0,	0},
                        {80, 0,	25,	0,	0,	0,	21,	0,	0,	0},
                        {0,	25,	0,	40,	0,	20,	23,	0,	0,	0},
                        {25, 0,	40,	0,	55,	35,	0,	0,	0,	0},
                        {60, 0,	0,	55,	0,	0,	0,	0,	0,	0},
                        {0,	0,	20,	35,	0,	0,	0,	20,	0,	0},
                        {0,	21,	23,	0,	0,	0,	0,	25,	10,	0},
                        {0,	0,	0,	0,	0,	20,	25,	0,	0,	12},
                        {0,	0,	0,	0,	0,	0,	10,	0,	0,	30},
                        {0,	0,	0,	0,	0,	0,	0,	12,	30,	0}};

        Graph graph = new Graph(testGraph);
        graph.print();
        System.out.println("*****************************************************************");
        System.out.println("\n" + graph.hasMaxDegree());
        System.out.println("\n" + graph.getDegree(4));
        System.out.println("\n" + graph.isWeighted());
        System.out.println("\n" + graph.isDirected());
        System.out.println("\n" + graph.BFS(1));
        System.out.println("\n" + graph.DFS(1));
        System.out.println("\n" + graph.isNeighbor(1, 3));
        System.out.println("\n" + graph.isComplete());
        System.out.println("Directed Graph?"+graph.isDirected());
        System.out.println("Weighted Graph? "+graph.isWeighted());
        System.out.println(graph.removeEdge(1, 3));
        System.out.println("\n" + graph.insertEdge(0, 6));
        System.out.println("*****************************************************************");
    }

}