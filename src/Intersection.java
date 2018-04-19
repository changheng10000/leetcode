import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 给定两个数组，写一个函数来计算它们的交集。

 例子:

 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

 提示:

 每个在结果中的元素必定是唯一的。
 我们可以不考虑输出结果的顺序
 * Created by changheng on 18/4/19.
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0){
            return new int[]{};
        }
        Set<Integer> nums1Set = int2Set(nums1);
        Set<Integer> nums2Set = int2Set(nums2);
        nums1Set.retainAll(nums2Set);
        return  set2IntArr(nums1Set.toArray(new Integer[]{}));

    }

    private int[] set2IntArr(Integer[] integers) {
        int[] arr = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            arr[i] = integers[i];
        }

        return arr;
    }


    private Set<Integer> int2Set(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i : nums) {
            numsSet.add(i);
        }

        return numsSet;
    }

    public static void main(String[] args) {
        Intersection intersection= new Intersection();
        int[] intersection1 = intersection.intersection(new int[]{1,2,2,2,1}, new int[]{1,2,2});
        for (int i : intersection1) {
            System.out.println(i);
        }
    }
}
