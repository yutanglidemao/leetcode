package page1;



//
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//        示例：
//
//        输入：nums = [-1,2,1,-4], target = 1
//        输出：2
//        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

/**
 * @author yangren
 */
public class ThreeSumCloset {


    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumCloset(nums,target));
    }


    private static Integer threeSumCloset(int[] nums,int target){
        Integer minTarget = null;
        Integer sum  = 0;
        for (int i = 0;i<nums.length-2;i++){
            int first = nums[i];
            for (int j = i+1;j<nums.length-1;j++){
                int second = nums[j];
                for(int k = j+1;k<nums.length;k++){
                    int third = nums[k];

                    int count = first+second+third;
                    int sub = Math.abs(count-target);
                    if(minTarget == null){
                        minTarget = sub;
                        sum = count;
                    }else if(sub<minTarget){
                        minTarget = sub;
                        sum = count;
                    }
                }
            }
        }
        return sum;
    }

}
