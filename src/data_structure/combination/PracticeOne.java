package data_structure.combination;
//组合[ˌkɒmbɪˈneɪʃn]

import java.util.ArrayList;
import java.util.List;
/**
 * 题目链接：https://leetcode-cn.com/problems/combination-sum/
 * */
//组合I所给数组的元素都不相同且元素可以重复获取，而组合II所给元素可以相同但元素不能重复获取，并且不能包含相同元素的组合
//O(每一种组合的长度之和，表示遍历获得了多少个数) //O(target) 最差情况递归了target层，例如每个组合数都为1的情况，1+1+1+1+1+1=6=target，获得每个1都要递归1次，即遍历1层
class PracticOne {
    //选择跳过一个数或不跳过一个数，使每种组合都被遍历到
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list=new ArrayList<>();
        dfs(list,candidates,target,0);
        return ans;
    }
    public void dfs(List<Integer> list,int[] candidates,int target,int index){
        if(target==0){//组合的和达到所求 //可以重复拿元素的(判断到达数组末尾)和(判断到达所求)顺序无所谓，因为到达数组末尾时并且到达所求，还可以在此之前通过递归dfs(到达所求的集合,末尾-1)使到达所求的结果被获取
            ans.add(new ArrayList<>(list));
            return;
        }
        if(index==candidates.length) return;//到达数组末尾
        //让组合获得该数
        if(target-candidates[index]>=0){
            list.add(candidates[index]);
            dfs(list,candidates,target-candidates[index],index);//组合的和只差target-candidates[index]
            //且index还是为index，让一个数可以获得多次
            list.remove(list.size()-1);//回溯，让跳过该数的递归所获得的list为最初的
        }
        //让组合跳过该数
        dfs(list,candidates,target,index+1);
    }
}
