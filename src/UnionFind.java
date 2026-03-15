package src;

public class UnionFind {
    int[] parent;
    int[] rank;

    public void initialize(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i=0;i<n;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        int cur = node;

        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return false;
        }

        if (rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int res = n;
        int[][] edges =  {{0,1}, {1,2}, {3,0}};
        UnionFind obj = new UnionFind();
        obj.initialize(4);

        for (int[] edge: edges) {
            if (obj.union(edge[0], edge[1])) {
                res --;
            }
        }
        System.out.println(res);
    }

}
