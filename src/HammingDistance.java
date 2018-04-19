/**
 * Created by changheng on 18/4/19.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(x ^ y);
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j)==49){
                res++;
            }
        }
        return res;
    }

    /**
     * x=01,y=100,x^y=101 temp=101
     * temp=101!=0 true
     *      res=1;
     *      temp = 101& (101-1)=101&100=100
     * temp=100!=0 true
     *      res=2
     *      temp = 100 & (100-1) = 100 & 011=0
     * temp=0 != 0 false quit loop
     *
     *
     * x=01011 y=11000  temp=x^y=10011
     * temp=10011 !=0 true
     *      res=1
     *      temp=10011&10010=10010
     * temp=10010 !=0 true
     *      res=2
     *      temp=10010&10001=10000
     * temp=10000 !=0 true
     *      res=3
     *      temp=10000&01111=0
     * temp=0 != 0 false quit loop
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        while(temp != 0){
            res++;
            temp &= (temp-1);
        }
        return res;
    }


    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        int i = hammingDistance.hammingDistance(1, 4);
        System.out.println(i);
    }
}
