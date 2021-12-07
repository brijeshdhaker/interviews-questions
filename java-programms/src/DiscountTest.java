import java.util.ArrayList;
import java.util.List;

public class DiscountTest {

    /*
     * Complete the 'calculateAmount' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static long calculateAmount(List<Integer> prices) {
        long totalcost = 0;
        for(int i =0 ;i < prices.size(); i++){
            if(i==0){
                totalcost = new Long(prices.get(0));
            }else{
                long actual_currnet = 0;
                long p = new Long(prices.get(i-1)).longValue();
                long c = new Long(prices.get(i)).longValue();
                if(i==1){
                    actual_currnet = c - p;
                }else{
                    long min = 0;
                    actual_currnet = Math.max(c - Math.min(p,c),0);
                }
                if(actual_currnet < 0){
                    actual_currnet=0;
                }
                totalcost = totalcost + actual_currnet;
            }
        }
        return totalcost;
    }


    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>();
        prices.add(1);
        prices.add(3);
        prices.add(5);
        prices.add(4);
        long totalcost = DiscountTest.calculateAmount(prices);
        System.out.println(totalcost);
    }
}
