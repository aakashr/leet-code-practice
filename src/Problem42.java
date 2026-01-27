package src;

public class Problem42 {
        public int trap(int[] height) {
//            int min, max = 0;
//            for (int i = height.length - 1; i >= 0; i--) {
//                int h = height[i];
//                if (h > max) {
//                    max = h;
//                }
//            }
//            System.out.println(max);
//            if (max == 0) return -1;
//
//            min = height[0];
//            for (int h : height) {
//                if (h < min) {
//                    min = h;
//                }
//            }
//
//            System.out.println(min);

            int l=0, r=0;

            int h = height[l];
            while (h <= 0 && l < height.length) {
                l++;
                h = height[l];
            }
            System.out.println(h);

            return 0;
        }

        public static void main(String[] args) {
            Problem42 problem42 = new Problem42();
            int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
            problem42.trap(heights);
        }
}



