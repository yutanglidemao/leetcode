package page1;

//输入: "babad"
//        输出: "bab"
//        注意: "aba" 也是一个有效答案。
public class Question5 {

    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(longestPalindrome(s));
    }


    public static String longestPalindrome(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = "";

        // 先计算长度为1的数据，再计算长度为2的数据，以此往下计算
        for (int strLength = 0; strLength < s.length(); strLength++) {
            for (int i = 0; i < s.length()-strLength; i++) {
                // 首位需要比较的数据
                int j = i + strLength;
                if(strLength == 0){
                    dp[i][j] = true;
                }else if(strLength == 1){
                    dp[i][j]= s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }

                if(dp[i][j] && strLength+1>=ans.length()){
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }



}
