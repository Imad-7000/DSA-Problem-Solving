import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Result {
    public static void main(String[] args) {
        long[] area = new long[]{1300,1300};
        long[] price = new long[]{22000,24000};
        long reqArea = 15857;
        List<Long> a = new ArrayList<>();
        for(long ar : area)
            a.add(ar);
        List<Long> p = new ArrayList<>();
        for(long pr : price)
            p.add(pr);
       // System.out.println(valuation(reqArea, a, p));
        
       // System.out.println(linearIntrapolate(815240, 817696, 79618, 81027, 80574));
    }
    /*
     * Complete the 'valuation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER reqArea
     *  2. LONG_INTEGER_ARRAY area
     *  3. LONG_INTEGER_ARRAY price
     */

    public static long valuation(long reqArea, List<Long> area, List<Long> price) {
    // Write your code here
        HashMap<Long, HashMap<Integer, Long>> sqFootToTotal = new HashMap<>();
        for(int i = 0 ; i < area.size(); i++){
            long currentArea = area.get(i);
            if(sqFootToTotal.containsKey(currentArea)){
                HashMap<Integer, Long> temp = sqFootToTotal.get(currentArea);
                 temp.put(i, price.get(i));
                sqFootToTotal.put(currentArea, temp);
            }
            else{
                HashMap<Integer, Long> temp = new HashMap<>();
                temp.put(i, price.get(i));
                sqFootToTotal.put(currentArea, temp);
            }
        }
        
        List<long[]> compList = new ArrayList<>();
        for(int i = 0 ; i < area.size(); i++){
            long current = area.get(i);
            HashMap<Integer,Long> temp = sqFootToTotal.get(current);
            if(temp.size() > 1){
                long mean = getMean(temp,i);
                long sd = getSd(temp, mean, i);
                if(!isOutlier(price.get(i), mean, sd)){
                    long[] areaAndPrice = new long[2];
                    areaAndPrice[0] = current;
                    areaAndPrice[1] = price.get(i);
                    compList.add(areaAndPrice);
                }
                    
            }
            else{
                long[] areaAndPrice = new long[2];
                areaAndPrice[0] = current;
                areaAndPrice[1] = price.get(i);
                compList.add(areaAndPrice);
            }
        } 
        
        //*-----------------------Code Begins for Estimating reqArea Price-------------------------*//
        
        if(compList.size() == 0){
            long val = 1000 * reqArea;
            return finalCheck(val);
        }
        if(compList.size() == 1){
            long val = compList.get(0)[1];
            return finalCheck(val);
        }
        
        Collections.sort(compList, new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b){
                int result = Long.compare(a[0], b[0]);
              
                return result;
            }   
        });
        
        print(compList);
    
        if(reqArea < compList.get(0)[0]){
            List<long[]> meanOfNearest = getMean(compList, true);
            long[] t = meanOfNearest.get(0);
            long[] t1 = meanOfNearest.get(1);
            long val = linearIntrapolate(t[1], t1[1], t[0], t1[0], reqArea);
            return finalCheck(val);
        }
        
        if(reqArea > compList.get(compList.size() - 1)[0]){
            List<long[]> meanOfNearest = getMean(compList, false);
            long[] t = meanOfNearest.get(0);
            long[] t1 = meanOfNearest.get(1);
            long val = linearIntrapolate(t1[1], t[1], t1[0], t[0], reqArea);
            return finalCheck(val);
        }
        long finalAns = 0;
        for(int i = 0; i < compList.size(); i++){
            long[] areaAndPrice = compList.get(i);
            if(reqArea == areaAndPrice[0]){
                int j = i;
                long sum = 0;
                long count = 0;
                while(j < compList.size() && compList.get(j)[0] == reqArea){
                    sum += compList.get(j)[1];
                    count++;
                    j++;
                }
                finalAns = finalCheck(sum/count);
                break;
            }
            if(reqArea > areaAndPrice[0] && reqArea < compList.get(i + 1)[0]){
                finalAns = linearIntrapolate(areaAndPrice[1], compList.get(i + 1)[1], areaAndPrice[0], compList.get(i + 1)[0], reqArea);
                finalAns = finalCheck(finalAns);
                break;
            }    
        }
        
        return finalAns;
    }

    public static void print(List<long[]> compList){
        System.out.println();
        for(int i = 0; i < compList.size();i++){
            System.out.print(compList.get(i)[0] + "       " + compList.get(i)[1]);
            System.out.println();
        }
    }
    
    public static long linearIntrapolate(long price1, long price2, long area1, long area2, long reqArea){
        long price = price2 - price1;
        long area = area2 - area1;
        double val1 = (double) price / (double) area;
        long val2 = reqArea - area1;
        return (long) (price1 + (val1 * val2));
    }
    
    public static long finalCheck(long val){
        if(val < Math.pow(10,3))
            return (long)Math.pow(10,3);
        else if(val > Math.pow(10,6))
            return (long) Math.pow(10,6);
        else 
            return val;
    }
    
    public static boolean isOutlier(long curPrice, long mean, long sd){
        long val1 = Math.abs(curPrice - mean);
        long val2 = 3 * sd;
        if(val1 > val2)
            return true;
        return false;
    }
    
    public static long getMean(HashMap<Integer, Long> indexToPrice,int currentIndex){
        long sum = 0;
        long count =  0;
        Iterator<Map.Entry<Integer, Long>> itr = indexToPrice.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer, Long> entry = itr.next();
            if(entry.getKey() != currentIndex){
                sum += entry.getValue();
                count++;
            }
        }
        return sum/count;
    }
    
    public static long getSd(HashMap<Integer, Long> indexToPrice, long mean, int currentIndex){
        long count = 0;
        long sd = 0;
        Iterator<Map.Entry<Integer, Long>> itr = indexToPrice.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer, Long> entry = itr.next();
            if(entry.getKey() != currentIndex){
                sd += Math.pow(entry.getValue() - mean,2); 
                count++;    
            }
        }
        return (long)Math.sqrt(sd/count);
    }

    public static List<long[]> getMean(List<long[]> compList, boolean isForward){
        
        List<long[]> temp = new ArrayList<>();
        if(isForward){
            long val = compList.get(0)[0];
            double priceSum = compList.get(0)[1];
            double count = 1;
            int i = 1;
            int k = 0;
            while(i < compList.size() && k < 2){
                if(compList.get(i)[0] == val){
                    priceSum += compList.get(i)[1];
                    count++;
                }
                else{
                    long[] t = new long[2];
                    t[0] = val;
                    t[1] = (long)(priceSum / count);
                    temp.add(t);
                    k++;
                    val = compList.get(i)[0];
                    priceSum = compList.get(i)[1];
                    count = 1;
                }
                i++;
            }
            
            if(k < 2){
                long[] t = new long[2];
                t[0] = val;
                t[1] = (long)(priceSum / count);
                temp.add(t);
            }
            
            if(temp.size() != 2){
                temp.add(new long[]{0,0});
            }
        }
        else{
            long val = compList.get(compList.size() - 1)[0];
            double priceSum = compList.get(compList.size() - 1)[1];
            double count = 1;
            int i = compList.size() - 2;
            int k = 0;
            while(i >= 0 && k < 2){
                if(compList.get(i)[0] == val){
                    priceSum += compList.get(i)[1];
                    count++;
                }
                else{
                    long[] t = new long[2];
                    t[0] = val;
                    t[1] = (long)(priceSum / count);
                    temp.add(t);
                    k++;
                    val = compList.get(i)[0];
                    priceSum = compList.get(i)[1];
                    count = 1;
                }
                i--;
            }
            
            if(k < 2){
                long[] t = new long[2];
                t[0] = val;
                t[1] = (long)(priceSum / count);
                temp.add(t);
            }
            
            if(temp.size() != 2){
                temp.add(new long[]{0,0});
            }
        }
        return temp;
    }
}
