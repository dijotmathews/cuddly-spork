public class WaterContainer {

//https://www.youtube.com/watch?v=UuiTKBwPgAo

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;

        int result = 0;
        while(l < r) {
            int wall = Integer.min(height[l], height[r]);
            int area = wall * (r - l);

            result = Integer.max(result, area);

            if(wall == height[l]) {
                l++;
            } else {
                r--;

            }

        }
        return result;
    }
     public static void main(String[] args) {
         int[] height = {1,8,6,2,5,4,8,3,7};
//         int[] height = {1,1};

        System.out.println(maxArea(height));

     }
}
