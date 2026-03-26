package src;

public class Problem443 {
    public int compress(char[] chars) {
        int num = chars.length, i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<num) {
            char cur = chars[i];
            int j = i+1;
            while(j < num && cur == chars[j]) {
                j++;
            }
            if (j > i+1) {
                sb.append(cur).append(j-i);
                i = j;
            } else {
                sb.append(cur);
                i++;
            }
        }

        int idx = 0;
        for (char c: sb.toString().toCharArray()) {
            chars[idx++] = c;
        }

        return sb.toString().length();
    }

    public static void main(String[] args) {
        Problem443 obj = new Problem443();
        String[][] testCases = {{"aabbccc", "6"}, {"abbbbbbbbbbbb","4" }, {"a", "1"}};
        String format = "Input: %s; Result: %s";

        for (String[] tc: testCases) {
            String result = String.format(format, tc[0], obj.compress(tc[0].toCharArray()) == Integer.parseInt(tc[1]));
            System.out.println(result);
        }

    }
}
