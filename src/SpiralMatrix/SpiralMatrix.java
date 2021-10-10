package SpiralMatrix;
/**
 *给你一个正整数n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的n * n正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 */
public class SpiralMatrix {
    //按照从左到右、从上到下、从右到左、从下到上遍历
    //当所有方格被遍历时退出循环
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;//l、r表示一行
        int num = 1;
        int ans = n * n;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
                if (num > ans) return res;
            }
            t++;//该行不再遍历
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
                if (num > ans) return res;
            }
            r--;//该列不再遍历
            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
                if (num > ans) return res;
            }
            b--;//该行不再遍历
            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
                if (num > ans) return res;
            }
            l++;//该列不再遍历
        }
    }
}
