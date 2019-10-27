//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        char right_parentheses;
        Stack parenthesesStack = new Stack();
        if(s.length()==0){
            return true;
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                parenthesesStack.push(s.charAt(i));
            }
            else{
                if (parenthesesStack.empty())  //若此时栈空，则说明少左括号
                    return false;
                else
                    right_parentheses=parenthesesStack.pop().toString().charAt(0);
                switch (s.charAt(i)){
                    case ')':
                        if(right_parentheses!='('){
                            return false;
                        }
                        break;
                    case '}':
                        if(right_parentheses!='{'){
                            return false;
                        }
                        break;
                    case ']':
                        if(right_parentheses!='['){
                            return false;
                        }
                        break;
                }
            }
        }

        if(parenthesesStack.empty()){   //最后栈空才匹配，若不空说明有多余左括号
            return true;
        }
        else{
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
