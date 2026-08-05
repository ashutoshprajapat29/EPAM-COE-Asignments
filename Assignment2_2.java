/* A country's transportation department models its highway system as a connected undirected graph. Each city is represented by a vertex, while highways are represented by edges. During emergencies, rescue teams need to travel from the capital city (City 1) to all other cities. However, not every city is considered safely reachable because some routes may contain too many intermediate cities.

A city is called efficiently reachable if the length of the shortest path from City 1 to that city is less than or equal to D roads. Determine the total number of efficiently reachable cities, including the capital. Unreachable cities are not counted.
Input Format
First line: N M D
Next M lines: u v (roads)
Output Format
Print the number of efficiently reachable cities.
Constraints
1 ≤ N ≤ 10^5
0 ≤ M ≤ 2×10^5
0 ≤ D ≤ N
No self-loops
Sample Input
7 8 2
1 2
1 3
2 4
2 5
3 6
6 7
5 7
4 6
Sample Output
6
Explanation
Run BFS from City 1 to compute the shortest distance to every city. Count cities whose distance is at most D.
Example
Input:
6 5 1
1 2
2 3
1 4
4 5
5 6

*/



    import java.util.*;

public class Assignment2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        // Adjacency List
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Distance array
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();

        // BFS from City 1
        dist[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // Count efficiently reachable cities
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] != -1 && dist[i] <= D) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}

