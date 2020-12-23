package page1;



//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
//    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
//        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。


public class Question11 {

    public static void main(String[] args) {
        int[] height = { 1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length -1; i++) {
            int startHeight = height[i];
            for (int j = i+1;j<height.length;j++){
                int endHeight = height[j];
                int currentSize = Math.min(startHeight,endHeight)*(j-i);
                if(currentSize>max){
                    max = currentSize;
                }
            }
        }
        return max;
    }

    public static int maxArea2(int[] height){
        int ans = 0;
        int left = 0;
        int right = height.length -1;

        while (left<right){
            int container = Math.min(height[left],height[right]) * (right - left);
            if(ans<container){
                ans = container;
            }
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }

}
