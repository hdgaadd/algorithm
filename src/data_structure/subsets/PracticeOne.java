package data_structure.subsets;
//子集[ˈsʌbset]
import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/subsets/
 */
//TimeComplexity:O(n!)
//SpaceComplexity:O(n!)
class PracticeOne {
    //动态规划
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());//空集
        for(int num:nums){
            for(int i=0,j=res.size();i<j;i++){//j=res.size()固定res长度
                List<Integer> list=new ArrayList<>(res.get(i));
                list.add(num);//每到下一个元素，就在已有的所有子集的基础上，再加上该元素
                res.add(list);
            }
        }
        return res;
    }
}