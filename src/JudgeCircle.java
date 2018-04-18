/**
 * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。

 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
 * Created by changheng on 18/4/17.
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        if(moves==null || moves.length()==0){
            return true;
        }
        int x = 0;
        int y = 0;
        char[] moveChars = moves.toCharArray();
        for (char moveChar : moveChars) {
            switch (moveChar){
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }
        }
        return x==0 && y==0;
    }
}
