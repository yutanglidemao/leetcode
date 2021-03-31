package page1;


//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"

public class Question14 {


    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));

        String[] strs1 = {"cir", "car"};
        System.out.println(longestCommonPrefix(strs1));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();

        int prefix = 0;
        while (true) {
            if (strs[0].length() == prefix) {
                return sb.toString();
            }

            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == prefix) {
                    return sb.toString();
                } else {
                    if (strs[i].charAt(prefix) != strs[0].charAt(prefix)) {
                        return sb.toString();
                    }
                }
            }

            sb.append(strs[0].charAt(prefix));
            prefix++;
        }
    }
}
