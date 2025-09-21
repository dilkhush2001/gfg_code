

/*Complete the function given below*/
class Solution {
    public int maxArea(int matrix[][]) {
        int n=matrix.length;
        int m=matrix[0].length;
         int[] temp = new int[m];
        // for(int j = 0; j < m; j++) {
        //     temp[j] = matrix[0][j];
        // }
        int maxArea = 0; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += matrix[i][j];
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(temp));
        }

        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int area=0;
        int n=heights.length;
        for(int i=0;i<=n; i++){
            
            while(!st.isEmpty() && (i==n || heights[i]<=heights[st.peek()])){
                int h=heights[st.pop()];
                int w=st.isEmpty()? i : i-st.peek()-1;

                area=Math.max(area, h*w);
            }
            st.push(i);

        }
        return area;
    }
}