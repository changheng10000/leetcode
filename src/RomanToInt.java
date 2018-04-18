import java.util.*;

/**
 *   罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并排放置的的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

     在罗马数字中，小的数字在大的数字的右边。但 4 不写作 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数减小数得到的数值 4 。同样地，数字 9 表示为 IX。这个规则只适用于以下六种情况：

     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 范围内
 * Created by changheng on 18/4/17.
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        String[] split = s.split("");
        Integer res = 0;

        int length = split.length;
        for (int i = 0; i < length; i++) {
            Roman roman = Roman.parse(split[i]);

//            switch (roman){
//                case I:
//                    if(i != length-1 && (split[i+1].equals(Roman.V.name()) || split[i+1].equals(Roman.X.name()))){
//                        res += Roman.parse(split[i+1]).getValue()-roman.getValue();
//                        i++;
//                        continue;
//                    }
//                    break;
//                case X:
//                    if(i != length-1 && (split[i+1].equals(Roman.L.name()) || split[i+1].equals(Roman.C.name()))){
//                        res += Roman.parse(split[i+1]).getValue()-roman.getValue();
//                        i++;
//                        continue;
//                    }
//                    break;
//                case C:
//                    if(i != length-1 && (split[i+1].equals(Roman.D.name()) || split[i+1].equals(Roman.M.name()))){
//                        res += Roman.parse(split[i+1]).getValue()-roman.getValue();
//                        i++;
//                        continue;
//                    }
//                    break;
//            }
            if(i!=length-1){
                Roman romanNext = Roman.parse(split[i+1]);
                if(romanNext.getValue() > roman.getValue()){
                    res -= roman.getValue();
                    continue;
                }
            }

            res += roman.getValue();

        }

        return res;
    }

    enum Roman{
        I(1),V(5),X(10),L(50),C(100),D(500),M(1000);

        private int value;

        Roman(int value) {
            this.value = value;
        }

        public static Roman parse(String romanLetter){
            if(romanLetter==null){
                return null;
            }
            for (Roman roman : Roman.values()) {
                if(romanLetter.equals(roman.name())){
                    return roman;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("DCXXI"));
    }
}
