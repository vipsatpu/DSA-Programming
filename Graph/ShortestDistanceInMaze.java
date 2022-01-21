public class Solution {
    static int maxn = 100009;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    public static boolean inside(int x, int y, int n, int m) {
        return (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1);
    }
    public int solve(int[][] A, int[] B, int[] C) {
        return findMinDist(A, B, C);
    }
    public static int findMinDist(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int sx = start[0];
        int sy = start[1];
        int ex = destination[0];
        int ey = destination[1];
        int[][] v = new int[n][m];
        for (int[] row: v)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue < Pair > pq = new PriorityQueue < Pair > (new CustomComp());
        int i;
        int d, d1;
        int x, y;
        int x1, y1;
        int x2, y2;
        pq.offer(new Pair(0, sx, sy));
        while (pq.size() != 0 && v[ex][ey] == Integer.MAX_VALUE) {
            Pair temp = pq.poll();
            x = temp.b;
            y = temp.c;
            d = temp.a;
            if (v[x][y] != Integer.MAX_VALUE) {
                continue;
            } else {
                v[x][y] = d;
            }
            for (i = 0; i < 4; ++i) {
                x1 = x;
                y1 = y;
                d1 = 0;
                while (true) {
                    x2 = x1 + dx[i];
                    y2 = y1 + dy[i];
                    if (inside(x2, y2, n, m) == true && maze[x2][y2] == 0) {
                        x1 = x2;
                        y1 = y2;
                        ++d1;
                    } else {
                        break;
                    }
                }
                if (d1 > 0 && v[x1][y1] == Integer.MAX_VALUE) {
                    pq.offer(new Pair(d + d1, x1, y1));
                }
            }
        }
        int res = -1;
        if (v[ex][ey] != Integer.MAX_VALUE)
            res = v[ex][ey];
        return res;
    }
}
class Pair {
    int a, b, c;
    public Pair(int u, int v, int w) {
        this.a = u;
        this.b = v;
        this.c = w;
    }
}
class CustomComp implements Comparator < Pair > {
    public int compare(Pair aa, Pair bb) {
        return aa.a - bb.a;
    }
}