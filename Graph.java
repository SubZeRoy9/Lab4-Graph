 /* Roy Turner
  * CSCI 3200;
  * Lab 4;
  * ****************************************************************
  */
import java.util.*;
public class Graph {

    int[][] adjMatrix;

    public Graph(int[][] adj){
        this.adjMatrix=adj;
    }

    public int numVertices(){ //O(1)
        return adjMatrix.length;
    }

    public int numEdges(){//O(n*n)
        int count=0;
        for(int i=0;i<adjMatrix.length;i++)
            for(int j=0;j<adjMatrix.length;j++)
                if(adjMatrix[i][j]!=0) count++;
        return count;
    }

    public ArrayList getNeighbors(int u){//O(n)
        //evaluate all elements at row u
        ArrayList list = new ArrayList();
        for(int i=0;i<adjMatrix.length;i++)
            if(adjMatrix[u][i]!=0) list.add(i);
        return list;
    }

    public boolean isWeighted() {
        boolean temp = false;
        // If an edge is greater than 1 then adjMatrix is weighted.
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] > 0 && adjMatrix[i][j] > 1)
                    temp = true;
            }
        }
        return temp;
    }

    public boolean isDirected(){//O(n*n)
        /*this method check whether a graph is directed or not, return true for yes and false for no*/
        boolean temp = false;
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != adjMatrix[j][i])
                    temp = true;
            }
        }
        return temp;
    }

    public boolean isComplete(){//O(n*n)
        for (int i = 0; i < numVertices(); i++) {
            for (int j = i+1; j < numVertices(); j++) {
                if (adjMatrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //return true if vertex u and v are neighbors
    public boolean isNeighbor(int u, int v) { //O(1)
        if (adjMatrix[u][v] != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getDegree(int u) { //O(n)
        int count = 0;
        //iterate through row, if there is an edge, increment count
        for (int i = 0; i < adjMatrix[u].length; i++)   {
            if (adjMatrix[u][i] > 0) {
                count = count + 1;
            }
        }
        return count;
    }

   public int hasMaxDegree() { //O(n^2)
        // find max
       int maxDegree = 0;
       int v = 0;

       for (int i = 0; i < adjMatrix.length; i++) {
           int numD = getDegree(i);
           if (numD > maxDegree) {
               maxDegree = numD;
               v = i;
           }
       }
       return v;
   }
    public boolean insertEdge(int u, int v, int weight) { //O(1)
        if (adjMatrix[u][v] == 0 || adjMatrix[v][u] == 0) {
                adjMatrix[u][v] = weight;
                adjMatrix[v][u] = weight;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeEdge(int u, int v){ //O(1)
        /*this method remove the edge between u and v if there is an edge*/
        //if undirected graph and edge exists, remove edge and return true
        //otherwise, return false
        if (adjMatrix[u][v] != 0 || adjMatrix[v][u] != 0) {
                adjMatrix[u][v] = 0;
                adjMatrix[v][u] = 0;
                return true;
        }
        return false;
    }
    public ArrayList<Integer> BFS(int start) { //O(n^2)
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[numVertices()];
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            traversal.add(vertex);
            ArrayList<Integer> neighbors = getNeighbors(vertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return traversal;
    }


        public ArrayList<Integer> DFS(int start) {//O(n^2)
            //Based on the discussion we had in class and the implementation shown on slides, implement DFS.
            //Based on the order where the vertex has been checked, return a DFS traversal sequence as an ArrayList.
            ArrayList<Integer> visited = new ArrayList<Integer>();
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(start);

            while (!stack.empty()) {
                int node = stack.pop();
                if (!visited.contains(node)) {
                    visited.add(node);
                    for (int i = adjMatrix.length - 1; i >= 0; i--) {
                        if (adjMatrix[node][i] != 0 && !visited.contains(i)) {
                            stack.push(i);
                        }
                    }
                }
            }
            return visited;
        }

        public void print () {
                int bound = adjMatrix.length;
                if (bound > 10) bound = 10;
                for (int i = 0; i < bound; i++) {
                    for (int j = 0; j < bound; j++)
                        System.out.print(adjMatrix[i][j] + "\t");
                    System.out.println();
                }
            }
        }