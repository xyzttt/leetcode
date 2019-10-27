//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*if(strs.length==0){
            return "";
        }
        String str=strs[0];
        for(int i=1;i<strs.length;i++){
            while (strs[i].indexOf(str)!=0){
                str=str.substring(0,str.length()-1);
            }
        }
        return str;*/
        if(strs.length==0){
            return "";
        }
        int minLength=strs[0].length();
        for(String str:strs){
            minLength = Math.min(str.length(),minLength);
        }
        for(int i=0;i<minLength;i++){  //外层循环和内层循环不可以交换
            for(String str:strs){      //这样比较是比较每一个字符串i位和第一个字符穿的前缀，若交换循环，则是比较当前字符串和第一个字符串
                if(strs[0].charAt(i)!=str.charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0].substring(0,minLength);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
