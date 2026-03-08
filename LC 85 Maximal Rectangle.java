// LC 85 Maximal Rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            max = Math.max(max, largestRectangle(height));
        }

        return max;
    }

    private int largestRectangle(int[] h){
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for(int i = 0; i <= h.length; i++){
            int height = (i == h.length) ? 0 : h[i];

            while(!st.isEmpty() && height < h[st.peek()]){
                int cur = h[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, cur * width);
            }

            st.push(i);
        }

        return max;
    }
}
