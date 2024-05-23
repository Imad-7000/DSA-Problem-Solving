import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Mercury {
    public static void main(String[] args) {
        List<String> temp = new ArrayList<>();
        String v1 = "1/3/2012 16:00:00   Missing_1";
        String v2 = "1/3/2012 16:00:00   27.47";
        temp.add(v1);
        temp.add(v2);
        calcMissing(temp);
    }
     public static void calcMissing(List<String> readings) {
    // Write your code here
        List<Double> mercuryLevels = new ArrayList<>();
        
        //----read mercury levels, store NaN if missing
        for(int i = 0 ; i < readings.size(); i++){
          
            String[] rowData = readings.get(i).split("\\s+");
            if(rowData[2].contains("M")){
                mercuryLevels.add(Double.NaN);
            }else{
                mercuryLevels.add(Double.parseDouble(rowData[2]));
            }
        }
        
        //-----Find missing val on the basis of interpolated value of nearest left and right readings
        for(int i = 0 ; i < mercuryLevels.size(); i++){
            if(mercuryLevels.get(i).equals(Double.NaN)){
                Double[] leftLev = getLeftVal(mercuryLevels,i);
                Double[] rightLev = getRightVal(mercuryLevels, i);
                if(leftLev.length == 1)
                    System.out.println(rightLev[1]);
                else if(rightLev.length == 1)
                    System.out.println(leftLev[1]);
                else{
                    Double interpolatedVal = linearInterpolation(leftLev[0],rightLev[0],leftLev[1],rightLev[1],i);
                    System.out.println(new BigDecimal(interpolatedVal).setScale(2, RoundingMode.HALF_UP));
                }
            }    
        }
        

    }
    
    public static Double linearInterpolation(Double lidx, Double ridx, Double lval, Double rval, int curIdx){
        Double pos1 = curIdx - lidx;
        Double pos2 = ridx - lidx;
        Double pos = pos1/pos2;
        Double val1 = rval - lval;
        return lval + (pos * val1);
    }
    
    public static Double[] getLeftVal(List<Double> leftLevels, int idx){
        for(int i = idx - 1; i>= 0; i--){
            if(!leftLevels.get(i).equals(Double.NaN))
                return new Double[]{(double)i, leftLevels.get(i)};
        }
        return new Double[]{0.0};
    }
    
    public static Double[] getRightVal(List<Double> rightLevels, int idx){
        for(int i = idx + 1; i < rightLevels.size(); i++){
            if(!rightLevels.get(i).equals(Double.NaN))
                return new Double[]{(double)i, rightLevels.get(i)};
        }
        return new Double[]{0.0};
    }
}
