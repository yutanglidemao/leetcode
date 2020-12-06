package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
 */
public class Question1 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if(numRows==1){
            List<Integer> rowResult = new ArrayList();
            rowResult.add(1);
            result.add(rowResult);
        }else if(numRows == 2){
            List<Integer> rowResult1 =new ArrayList();
            rowResult1.add(1);
            result.add(rowResult1);

            List<Integer> rowResult2 = new ArrayList();
            rowResult2.add(1);
            rowResult2.add(1);
            result.add(rowResult2);
        }else if(numRows>2){
            List<Integer> rowResult1 =new ArrayList();
            rowResult1.add(1);
            result.add(rowResult1);

            List<Integer> rowResult2 = new ArrayList();
            rowResult2.add(1);
            rowResult2.add(1);
            result.add(rowResult2);


            for(int i =2 ;i<numRows;i++){
                List<Integer> rowResult = new ArrayList();
                rowResult.add(1);
                for(int j = 1 ;j<i;j++){
                    List<Integer> lastResult = result.get(result.size() - 1);
                    rowResult.add(lastResult.get(j-1)+lastResult.get(j));
                }
                rowResult.add(1);
                result.add(rowResult);
            }
        }



        return result;
    }

}
