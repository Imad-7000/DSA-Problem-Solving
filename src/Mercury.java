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
    public static void calcMissing(List<String> readings){
        List<Double> mercuryLevels = new ArrayList<>();
        for(int i = 0 ; i < readings.size(); i++){
            System.out.println(readings.get(i));
            String[] rowData = readings.get(i).split("\\s+");
            System.out.println(rowData.length);
            if(rowData[2].contains("M")){
                mercuryLevels.add(Double.NaN);
            }else{
                mercuryLevels.add(Double.parseDouble(rowData[2]));
            }
        } 

        print(mercuryLevels);
    }

    public static void print(List<Double> list){
        for(Double d: list)
            System.out.println(d + " ----");
    }
}
