package special_problems.system_out;
/***
 *https://leetcode-cn.com/problems/count-and-say/
 */

class PracticeOne {
    //考察使用程序实现特殊输出
    //每个相隔的相同数字串为一组
    public String countAndSay(int n) {
        String first = "1";
        for(int i = 0; i < n - 1; i++){//找寻第n个外观数列，遍历n-1次
            StringBuilder sb = new StringBuilder();
            char[] ch = first.toCharArray();
            char c = ch[0];
            int count = 1;

            for(int j = 1; j < ch.length; j++){//该for循环得出第n次的外观数列
                if(ch[j] != c){
                    sb.append(count).append(c);
                    c = ch[j];
                    count = 1;
                }else{
                    count++;
                }
            }

            sb.append(count).append(ch[ch.length - 1]);//处理末尾char数字
            first = sb.toString();
        }
        return first;
    }
}