/**
 *
 * Created by changheng on 18/4/17.
 */
public class ReverseWords {


    //请编写一个函数，其功能是将输入的字符串反转过来
    public String reverseString(String s) {
        if(s==null || s.length()==0){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }

    public String reverseString2(String s) {
        if(s==null || s.length()==0){
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        char[] reverse = new char[length];
        for (int i = 0; i < length; i++) {
            reverse[i] = chars[length-1-i];
        }
        return new String(reverse);
    }

    public String reverseString3(String s) {

        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *输入: "Let's take LeetCode contest" 输出: "s'teL ekat edoCteeL tsetnoc"
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        //"Let's take LeetCode contest"
        if(s==null || s.length()==0){
            return s;
        }

        char[] chars = s.toCharArray();

        StringBuilder reverse = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            char aChar = chars[i];
            if (32 == aChar ) {
                reverse.append(builder.reverse());
                reverse.append(aChar);
                builder = new StringBuilder();
            } else {
                builder.append(aChar);
            }
            if(i == charsLength-1){
                reverse.append(builder.reverse());
            }
        }

        return reverse.toString();
    }

    public String reverseWords2(String s) {
        int start = 0;
        int end = 0;
        char[] words = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            start = findHead(words, i);
            end = findTail(words, start + 1);
            reverse(words, start, end);
            i = end;
        }

        return new String(words);
    }

    public void reverse(char[] nums, int start, int end){
        for (int i = start, j = end; i < j; i++,j--) {
            char num = nums[i];
            nums[i] = nums[j];
            nums[j] = num;
        }
    }

    public int findHead(char[] words, int index){
        if (index == words.length){
            return words.length - 1;
        }
        for (int i = index; i < words.length; i++) {
            if (words[i] != ' '){
                return i;
            }
        }
        return words.length - 1;
    }

    public int findTail(char[] words, int index){
        for (int i = index; i < words.length; i++) {
            if (words[i] == ' '){
                return i - 1;
            }
        }
        return words.length - 1;
    }

    public static void main(String[] args) {
//        assert reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc");
    }

}
