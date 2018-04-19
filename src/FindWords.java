import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 示例1:

 输入: ["Hello", "Alaska", "Dad", "Peace"]
 输出: ["Alaska", "Dad"]
 注意:

 你可以重复使用键盘上同一字符。
 你可以假设输入的字符串将只包含字母。
 * Created by changheng on 18/4/19.
 */

public class FindWords {
    /**
     * 实现伪代码
     * 遍历待查数组
     * 判断每个单词的字符在同一行中
     *      
     * 如果在同一行,加入结果数组
     * 遍历结束
     * 返回结果
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        String up = "qwertyuiopQWERTYUIOP";
        String middle = "asdfghjklASDFGHJKL";
        String down = "zxcvbnmZXCVBNM";

        List<String> res = new ArrayList<>();
        for (String word : words) {
            String first = word.substring(0, 1);
            if(up.contains(first)){
                if(isSameline(word, up)){
                    res.add(word);
                }
            }else if(middle.contains(first)){
                if(isSameline(word, middle)){
                    res.add(word);
                }
            }else{
                if(isSameline(word, down)){
                    res.add(word);
                }
            }

        }

        return res.toArray(new String[]{});
    }

    private boolean isSameline(String word, String line){
        for (int i = 1; i < word.length(); i++) {
            if(!line.contains(word.substring(i, i+1))){
                return false;
            }
        }
        return true;
    }


    private static byte[] keyBoard = new byte[]{
            1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2,
            4,4,4,4,4,4,
            1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2
    };

    /**
     * 使用标志位
     * @param words
     * @return
     */
    public String[] findWords2(String[] words) {
        List<String> result = new ArrayList<>();
        int tmp;
        boolean flag;
        for(String word : words) {
            tmp = keyBoard[word.charAt(0) - 'A'];
            flag = true;
            for(char c:word.toCharArray()) {
                if(tmp != keyBoard[c - 'A']) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        String[] strings = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words = findWords.findWords(strings);
        for (String word : words) {
            System.out.println(word);
        }
    }


}
