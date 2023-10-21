package dp;

public class LeetCode5 {

    public static void main(String[] args) {
        LeetCode5 main = new LeetCode5();
        main.longestPalindrome("babad");
    }

    public String longestPalindrome(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        String result = s.substring(0, 1);

        int n = s.length();
        boolean[][] record = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            record[i][i] = true;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                int start = j, end = start + i;
                boolean judge = i == 1 || record[start + 1][end - 1];
                record[start][end] = judge & s.charAt(start) == s.charAt(end);
                if (record[start][end]) {
                    result = s.substring(start, end + 1);
                }
            }
        }

        return result;
    }

}
