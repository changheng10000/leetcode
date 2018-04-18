import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串
 * Created by changheng on 18/4/17.
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s==null){
            return false;
        }

        if(s.equals("")){
            return true;
        }

        char[] chars = s.toCharArray();
        if(chars.length % 2 != 0){
            return false;
        }

        char roundBracketLeft = '(';
        char roundBracketRight = ')';
        char squareBracketLeft = '[';
        char squareBracketRight = ']';
        char braceLeft = '{';
        char braceRight = '}';

        List<Character> left = new ArrayList<>();
        left.add(roundBracketLeft);
        left.add(squareBracketLeft);
        left.add(braceLeft);

        List<Character> right = new ArrayList<>();
        right.add(roundBracketRight);
        right.add(squareBracketRight);
        right.add(braceRight);

        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');

        LinkedList<Character> characterLinkedList = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            characterLinkedList.push(chars[i]);
        }

        Character first = null;
        Character next = null;

        for (char aChar : chars) {
            first = characterLinkedList.pop();
            if(left.contains(first)){

            }else if(right.contains(first)){

            }
        }


        return false;
    }

    public boolean isValid2(String s){
        if (s == null || s.length() == 0) {
            return true;
        }
        final char[] charArray = s.toCharArray();
        final Stack<Character> stack = new Stack<Character>();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
