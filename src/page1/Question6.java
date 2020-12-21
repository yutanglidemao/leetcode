package page1;

//
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//        比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//        L   C   I   R
//        E T O E S I I G
//        E   D   H   N
//        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
//        请你实现这个将字符串进行指定行数变换的函数：
//
//        string convert(string s, int numRows);
//        示例 1:
//
//        输入: s = "LEETCODEISHIRING", numRows = 3
//        输出: "LCIRETOESIIGEDHN"
//        示例 2:
//
//        输入: s = "LEETCODEISHIRING", numRows = 4
//        输出: "LDREOEIIECIHNTSG"
//        解释:
//
//        L     D     R
//        E   O E   I I
//        E C   I H   N
//        T     S     G
//


import java.util.ArrayList;
import java.util.List;

public class Question6 {


    public static void main(String[] args) {
        System.out.println(convert("ABCD",2));
        System.out.println(goDownConvert("ABCD",2));
    }

    /**
     * 二维数组解法
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s,int numRows){
        if(numRows == 1){
            return s;
        }
        char[][] ans = new char[s.length()][numRows];

        int columnCount = 0;
        int rowCount = 0;

        if(numRows == 2){
            for (int i = 0;i<s.length();i++){
                if(i!=0&&i%2==0){
                    rowCount++;
                    columnCount = 0;
                    ans[rowCount][columnCount] = s.charAt(i);
                    columnCount++;
                }else{
                    ans[rowCount][columnCount] = s.charAt(i);
                    columnCount++;
                }
            }
        }else{
            boolean flag = false;


            for (int i =0 ;i<s.length();i++){
                if(flag){
                    rowCount++;
                    columnCount = columnCount -1;
                    ans[rowCount][columnCount] = s.charAt(i);
                    if(columnCount == 1){
                        flag = false;
                        rowCount++;
                        columnCount = 0;
                    }
                }else{
                    ans[rowCount][columnCount] = s.charAt(i);
                    columnCount++;
                    if(columnCount == numRows){
                        flag = true;
                        columnCount--;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();

            for (int j = 0;j<numRows;j++){
                for (int i =0;i<s.length();i++){
                if(ans[i][j]!='\0'){
                    result.append(ans[i][j]);
                }
            }
        }

        return result.toString();
    }


    public static String goDownConvert(String s,int numRows){
        if(numRows == 1){
            return s;
        }
        // 保存每一行的数据
        List<StringBuilder> results = new ArrayList<>();
        // 总共会有多少行
        for (int i = 0;i<Math.min(s.length(),numRows);i++){
           results.add(new StringBuilder());
        }

        Integer currentRow = 0;
        boolean goDown = false;

        for (int i = 0; i < s.length(); i++) {
            results.get(currentRow).append(s.charAt(i));
            // 只有当前在第一行或者最后一行的时候才会更换方向
            if(currentRow == 0 || currentRow == numRows-1 ) goDown = !goDown;
            // 如果是往下，则行数加1，如果是网上，则行数减1
            currentRow+= goDown? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : results) ret.append(row);
        return ret.toString();
    }


}
