/**
 * Created by lileilei on 2017/3/23.
 */
public class Search {
    public void OrderSearch(int[] num, int target){
        int pos=-1;
        for (int i = 0; i <num.length ; i++) {
            if(num[i]==target){
                pos=i;
                break;
            }
        }
        System.out.println(pos);
    }
}
