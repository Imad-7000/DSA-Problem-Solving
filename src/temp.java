import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class temp {
    public static long valuation(long reqArea, List<Long> area, List<Long> price) {
        // Write your code here
            List<Long> filteredAreas = new ArrayList<>();
            List<Long> filteredPrices = new ArrayList<>();
            HashMap<Long, List<Long>> priceByArea = new HashMap<>();
            //Part 1 - Outlier Detection
            //Group prices by Area List
            for(int i = 0 ; i < area.size(); i++)
                priceByArea.computeIfAbsent(area.get(i), k -> new ArrayList<>()).add(price.get(i));
                
            //Remove outliers if any
            for(int i = 0; i < area.size(); i++){
                long currentPrice = price.get(i);
                long currentArea = area.get(i);
                List<Long> comparisonPrices = new ArrayList<>(priceByArea.get(currentArea));
                comparisonPrices.remove(currentPrice);
                
                double meanPrice = comparisonPrices.isEmpty() ? Double.NaN : calculateMean(comparisonPrices);
                double standardDeviation = comparisonPrices.isEmpty() ? Double.NaN : calculateStandardDeviation(comparisonPrices, meanPrice);
                
                if(Math.abs(currentPrice - meanPrice) > 3 * standardDeviation)
                    continue;
                
                filteredAreas.add(currentArea);
                filteredPrices.add(currentPrice);
            }
            
            //Part 2  - calculation
            //Handle case when empty, only 1 compList member or List contains reqArea
            if(filteredAreas.isEmpty()){
                long result = 1000 * reqArea;
                return Math.max(1000, Math.min(result, 1000000));
            }
            
            if(filteredAreas.size() == 1){
                long result = filteredPrices.get(0);
                return Math.max(1000, Math.min(result, 1000000));
            }
            
            if(filteredAreas.contains(reqArea)){
                double total = 0;
                double count = 0;
                for(int i = 0; i < filteredAreas.size(); i++){
                    if(filteredAreas.get(i).equals(reqArea)){
                        total += filteredPrices.get(i);
                        count++;
                    }
                }
                double meanPrice = total/count;
                long result = Math.round(meanPrice);
                return Math.max(1000, Math.min(result, 1000000));
                
            }
            
            //Find areas jsut smaller and larger than required area
            Long smallerArea = null;
            Long largerArea = null;
            
            for(Long curArea : filteredAreas){
                if(curArea < reqArea && (smallerArea == null || curArea > smallerArea))
                    smallerArea = curArea;
                if(curArea > reqArea && (largerArea == null || curArea < largerArea))
                    largerArea = curArea;
            }
            
            //If both not null, then find interpolated value
            if(smallerArea != null && largerArea != null){
                double sumSmaller = 0;
                int countSmaller = 0;
                for (int i = 0; i < filteredAreas.size(); i++) {
                    if (filteredAreas.get(i).equals(smallerArea)) {
                        sumSmaller += filteredPrices.get(i);
                        countSmaller++;
                    }
                }
                double smallerMean = countSmaller > 0 ? sumSmaller / countSmaller : Double.NaN;
    
                double sumLarger = 0;
                int countLarger = 0;
                for (int i = 0; i < filteredAreas.size(); i++) {
                    if (filteredAreas.get(i).equals(largerArea)) {
                        sumLarger += filteredPrices.get(i);
                        countLarger++;
                    }
                }
                double largerMean = countLarger > 0 ? sumLarger / countLarger : Double.NaN;     
                
                double val1 = (largerMean - smallerMean)/(largerArea - smallerArea);
                double interpolatedValue = smallerMean + val1 * (reqArea - smallerArea);
                long result = Math.round(interpolatedValue);
                return Math.max(1000, Math.min(result, 1000000));
            }
            
            //if Smaller Area is present, extrapolated price is calculated
            if(smallerArea != null){
                List<Long> uniqueAreas = new ArrayList<>(new HashSet<>(filteredAreas));
                uniqueAreas.sort(Collections.reverseOrder());
                List<Double> meanPrices = new ArrayList<>();
                    for (int i = 0; i < Math.min(2, uniqueAreas.size()); i++) {
                        Long curArea = uniqueAreas.get(i);
                        double sum = 0;
                        long count = 0;
                        for (int j = 0; j < filteredAreas.size(); j++) {
                            if (filteredAreas.get(j).equals(curArea)) {
                            sum += filteredPrices.get(j);
                            count++;
                        }
                    }
                    meanPrices.add(sum / count);
                }
                double meanPrice1 = meanPrices.get(1);
                double meanPrice0 = meanPrices.get(0);
                long area1 = uniqueAreas.get(1);
                long area0 = uniqueAreas.get(0);
    
                double meanPriceDifference = meanPrice1 - meanPrice0;
                long areaDifference = area1 - area0;
                double interpolationFactor = (double) (reqArea - area1) / areaDifference;
                double interpolatedValue = meanPriceDifference * interpolationFactor;
                double extrapolatedPrice = meanPrice1 + interpolatedValue;
                long result = Math.round(extrapolatedPrice);
                return Math.max(1000, Math.min(result, 1000000));
            }
            return 1000;
        }
        
        
        //Helper Functions
        
        public static double calculateMean(List<Long> comparisonPrices){
            double sum = 0;
            for(Long price : comparisonPrices)
                sum += price;
            return sum/comparisonPrices.size();
        }
        
        public static double calculateStandardDeviation(List<Long> comparisonPrices,double meanPrice){
            double sum = 0;
            for(Long price : comparisonPrices)
                sum += Math.pow(price - meanPrice, 2);
            return Math.sqrt(sum / comparisonPrices.size());
        }
}
