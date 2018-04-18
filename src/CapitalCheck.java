/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。

 我们定义，在以下情况时，单词的大写用法是正确的：

 全部字母都是大写，比如"USA"。
 单词中所有字母都不是大写，比如"leetcode"。
 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 否则，我们定义这个单词没有正确使用大写字母。

 示例 1:

 输入: "USA"
 输出: True
 示例 2:

 输入: "FlaG"
 输出: False
 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * Created by changheng on 18/4/17.
 */
public class CapitalCheck {
    /**
     * ascii 码大写字母 : 65~90; 小写字母:97~122
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        if(word==null || word.length()==0){
            return false;
        }

        if(word.length() == 1){
            return true;
        }

        char[] chars = word.toCharArray();
        char firstLetter = chars[0];
        int length = chars.length;


        for (int i = 0; i < length; i++) {
            char letter = chars[i];

            if(!isLattinLetter(letter)){
                //不是拉丁字母
                return false;
            }

            int j = i;
            while (isUpperCase(firstLetter)){
                if(j < length && isUpperCase(chars[++j])){
                    if(j==length-1){
                        //都是大写字母
                        return true;
                    }
                }else{
                    break;
                }
            }


            j = i;
            while (true){

                if(j < length && isLowerCase(chars[++j])){
                    if(j==length-1){
                        //都是小写字母
                        return true;
                    }
                }else{
                    return false;
                }
            }
        }

        return false;
    }

    public boolean detectCapitalUse2(String word) {
        boolean firstLetterCap = false;  //首字母是否大写
        int count = 0;  //大写字母个数
        for(int i = 0; i < word.length();i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                count++;
                if(i == 0) firstLetterCap = true;
            }
        }

        return (count==0) || (count==1 && firstLetterCap) || (count == word.length());
    }

    private boolean isLattinLetter(char letter){
        return isLowerCase(letter) || isUpperCase(letter);
    }

    private boolean isLowerCase(char letter){
        return letter>=97 && letter<=122;
    }

    private boolean isUpperCase(char letter){
        return letter>=65 && letter<=90;
    }

    public static void main(String[] args) {
        CapitalCheck capitalCheck =  new CapitalCheck();
        System.out.println(capitalCheck.detectCapitalUse("AAAAASDFLJHASDLFKJAHS"));;
        System.out.println(capitalCheck.detectCapitalUse("Leetcode"));;
        System.out.println(capitalCheck.detectCapitalUse("leeTcode"));;
        System.out.println(capitalCheck.detectCapitalUse("Google"));;
        System.out.println(capitalCheck.detectCapitalUse("GoOgle"));;
        System.out.println(capitalCheck.detectCapitalUse("GooglE"));;
        System.out.println(capitalCheck.detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));;
    }
}
