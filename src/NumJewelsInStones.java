/**
 *
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

 J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

 示例 1:

 输入: J = "aA", S = "aAAbbbb"
 输出: 3
 示例 2:

 输入: J = "z", S = "ZZ"
 输出: 0
 注意:

 S 和 J 最多含有50个字母。
 J 中的字符不重复。
 * Created by changheng on 18/4/19.
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;

        char[] charsS = S.toCharArray();
        char[] charsJ = J.toCharArray();
        for (int i = 0; i < charsS.length; i++) {
            for (int j = 0; j < charsJ.length; j++) {
                if(charsS[i] == charsJ[j]){
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    //A-65, z-122
    public int numJewelsInStones2(String J, String S) {
        byte[] jChar = new byte[58];//58 = 'z' - 'A'
        for(char c : J.toCharArray()) {
            jChar[c-'A'] = 1;//初始化标识位
        }
        int result = 0;
        for(char c : S.toCharArray()) {
            if(jChar[c-'A']==1){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
        System.out.println(numJewelsInStones.numJewelsInStones("z", "ZZ"));
    }
}
