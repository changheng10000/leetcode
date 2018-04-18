import java.util.Objects;

/**
 * Created by changheng on 18/4/16.
 */
public class StrStr {

    /**
     * 实现方法1
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;

        for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * strStr1 推演过程  heystask="hello", needle="ll" haystack.length() - needle.length() + 1=4 (代表了检查的次数)
     * i=0
     *      i<4成立
     *      j=0
     *          j<2成立
     *          haystack.charAt(i + j=1)='h',needle.charAt(j)='l',不等,跳出当前循环
     * i=1
     *      i<4成立
     *      j=0
     *          j<2成立
     *          haystack.charAt(i + j=1)='e',needle.charAt(j)='l',不等,跳出当前循环
     * i=2
     *      i<4成立
     *      j=0
     *          j<2成立
     *          haystack.charAt(i + j=2)='l',needle.charAt(j=0)='l',相等(找到子串中第一个字符在原串中的位置)
     *      j=1
     *          j<2成立
     *          haystack.charAt(i + j=3)='l',needle.charAt(j=1)='l',相等i(判断子串剩下的字符是否依次和原串中的字符相同)
     *      j=2
     *          j<2不成立,退出当前循环
     *      j=needle.length()成立
     *      返回i
     *
     *
     */



    /**JDK实现方法- public int indexOf(String str)
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     */
    static int strStr2(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        int sourceCount = source.length;
        char[] target = needle.toCharArray();
        int targetCount = target.length;

        if (targetCount == 0) {
            return 0;
        }

        char first = target[0];
        int max = sourceCount - targetCount;//大海中最大搜索索引(考虑最差情况,只能在大海的末端找到针,比如haystack="heeeeell",needle="ll",max就等于两者长度之差)

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first){}
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++){}//比较剩余子串和原串

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }

    /**strStr2推演过程 haystask="hellolllo", needl="lll", sourceCount=9, targetCount=3
     * first = target[targetOffset]='l', max=sourceOffset + (sourceCount - targetCount)=0 + (9-3)=6
     * i=sourceOffset + fromIndex=0
     *      i<=max(0<=6)成立
     *      source[i]=source[0]='h',first='l', 不相等
     *          ++i<=max(1<=6)成立, source[i] != first('e'!='l')成立
     *          ++i<=max(2<=6)成立, source[i] != first('l'!='l')不成立
     *      i <= max(2<=6)成立
     *          j=3,end=5
     *          k=1
     *              3<5&&'l'=='l'成立
     *          j=4,k=2
     *              4<5&&'o'=='l'不成立
     *      4==5不成立,继续下次循环
     * i=1
     *      1<=6 is true
     *      'e'!='l' is true
     *          i=2,2<=6&&'l'!='l' is false
     *      2<=6 is true
     *      j=3,end=5
     *      k=1
     *              3<5&&'l'=='l'成立
     *          j=4,k=2
     *              4<5&&'o'=='l'不成立
     *      4==5不成立,继续下次循环
     * i=2
     *      2<=6 is true
     *      'l'!='l' is false
     *      2<=6 is true
     *      j=3,end=5
     *      k=1
     *              3<5&&'l'=='l'成立
     *          j=4,k=2
     *              4<5&&'o'=='l'不成立
     *      4==5不成立,继续下次循环
     * i=3
     *      3<=6 is true
     *      'l'!='l' is false
     *      3<=6 is true
     *      j=4,end=6
     *      k=1
     *              4<6&&'o'=='l' is false
     *      5==6不成立,继续下次循环
     * i=4
     *      4<=6 is true
     *      'o'!='l' is true
     *          i=5, 5<=6&&'l'!='l' is false
     *      5<=6 is true
     *      j=6, end=8
     *      k=1
     *         6<8&& 'l'=='l' is true
     *      k=2,j=7
     *         7<8&& 'l'=='l' is true
     *      k=3,j=8
     *          8<8 is false ,exit current loop
     *      8==8 is true
     *          return i - sourceOffset=5
     *
     *
     */

    /**
     *异常情况:
     *  1.传入参数为空(已加入判断)
     *  2.针比大海还大(max为负,直接返回-1)
     *  3.
     *
     */
    public static int strStr3(String haystack, String needle){
        if (needle==null || Objects.equals(needle, "")){
            return 0;
        }

        if(haystack==null || Objects.equals(haystack, "")){
            return -1;
        }

        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();
        for(int i = 0; i <= max; i++){
            //找到第一个字符
            if(haystack.charAt(i) != first){
                while (++i<=max && haystack.charAt(i) != first){}//i可能会超过max 比如haystack="bbaa", needle="aab"

            }

            if(i<=max){//如果不加这个判断,可能会发生有数组越界异常 比如haystack="bbaa", needle="aab"
                int j = i+1;//原串剩余串起始索引
                int end = j + (needle.length()-1);
                for(int k = 1; j<end && haystack.charAt(j)==needle.charAt(k); k++, j++){}

                if(j==end){
                    return i;
                }
            }


        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr3("hellolllo", "lll"));
    }
}
