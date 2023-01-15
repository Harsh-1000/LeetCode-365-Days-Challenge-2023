class Solution {

    public int numberOfGoodPaths(int[] a, int[][] edges) {

        int n = a.length, res = 0;

        List<List<Integer>> g = initializeGraph(n);

        int[] f = new int[n];

        boolean[] vis = new boolean[n];

        DJSet ds = new DJSet(n);

        packUG(g, edges);

        TreeMap<Integer, List<Integer>> d = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            if (!d.containsKey(a[i])) d.put(a[i], new ArrayList<>());

            d.get(a[i]).add(i);

        }

        for (List<Integer> A : d.values()) {

            for (int cur : A) {

                vis[cur] = true;

                for (int child : g.get(cur)) {

                    if (vis[child]) ds.union(child, cur);

                }

            }

            for (int cur : A) res += ++f[ds.find(cur)];

            for (int cur : A) f[ds.find(cur)]--;

        }

        return res;

    }

    List<List<Integer>> initializeGraph(int n) {

        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            g.add(new ArrayList<>());

        }

        return g;

    }

    void packUG(List<List<Integer>> g, int[][] edges) {

        for (int[] a : edges) {

            g.get(a[0]).add(a[1]);

            g.get(a[1]).add(a[0]);

        }

    }

    public class DJSet {

        public int[] p;

        public DJSet(int n) {

            p = new int[n];

            Arrays.fill(p, -1);

        }

        public int find(int x) {

            return p[x] < 0 ? x : (p[x] = find(p[x]));

        }

        public boolean union(int x, int y) {

            x = find(x);

            y = find(y);

            if (x != y) {

                if (p[y] < p[x]) {

                    int d = x;

                    x = y;

                    y = d;

                }

                p[x] += p[y];

                p[y] = x;

            }

            return x == y;

        }

    }

}

        
    
