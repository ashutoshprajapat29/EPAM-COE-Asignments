/* A multinational organization maintains its internal communication infrastructure in the form of a tree, where each server is represented by a node, and each communication link is represented by an edge. The root server (Server 1) is the central authentication server. Every server stores a unique security key represented by an integer. During periodic audits, the organization wants to verify whether the communication path between the root server and every other server satisfies a security policy.

A server is considered trusted if the XOR of all security keys on the path from the root server to that server is greater than or equal to a given threshold K. Your task is to determine how many servers in the network are trusted. The root server is also included in the evaluation.
Input Format
First line: N K
Second line: N integers (security keys)
Next N-1 lines: u v (tree edges)
Output Format
Print the number of trusted servers.
Constraints
1 ≤ N ≤ 10^5
0 ≤ K ≤ 10^9
0 ≤ Key ≤ 10^9
Input graph is a tree
Sample Input
7 5
3 6 2 7 1 4 5
1 2
1 3
2 4
2 5
3 6
3 7
Sample Output
4
Explanation
Compute the XOR value along the path from the root (Server 1) to every server. Count the servers whose path XOR is at least K.
Example
Input:
5 2
1 3 2 5 6
1 2
1 3
3 4
3 5

Output:
3
*/


 import java.util.Scanner;
import java.util.ArrayList;

public class Assignment2_1{
    // Global variables so we can access them easily inside dfs
    static int trustedCount = 0;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] keys;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

   
        int N = sc.nextInt();
        K = sc.nextInt();

        keys = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            keys[i] = sc.nextInt();
        }

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<Integer>());
        }

       
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();


            adj.get(u).add(v);
            adj.get(v).add(u);
        }

       
        dfs(1, 0, 0);

     
        System.out.println(trustedCount);
        
        sc.close();
    }

    
    static void dfs(int curr, int parent, int currentXor) {
        // Calculate XOR including the current server's key
        int newXor = currentXor ^ keys[curr];

      
        if (newXor >= K) {
            trustedCount++;
        }

    
        for (int neighbor : adj.get(curr)) {
           
            if (neighbor != parent) {
                dfs(neighbor, curr, newXor);
            }
        }
    }
}

