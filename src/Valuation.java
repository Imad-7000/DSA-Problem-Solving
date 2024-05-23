import java.util.*;

public class Valuation {
    public static void main(String[] args) {
        // Example usage
        long reqArea = 2500L;
        List<Long> area = Arrays.asList(1200L,1200L,1200L,2000L);
        List<Long> price = Arrays.asList(15000L, 11000L, 17000L, 25000L);

        long estimatedPrice = valuation(reqArea, area, price);
        System.out.println("Estimated Price: " + estimatedPrice);
    }

    public static long valuation(long reqArea, List<Long> area, List<Long> price) {
        List<Long> allAreaFinal = new ArrayList<>();
        List<Long> allPriceFinal = new ArrayList<>();
        Map<Long, List<Long>> listOfHouses = new HashMap<>();

        // -----Group prices by area-----
        for (int i = 0; i < area.size(); i++) {
            listOfHouses.putIfAbsent(area.get(i), new ArrayList<>());
            listOfHouses.get(area.get(i)).add(price.get(i));
        }
        // --- outliers -------
        for (int i = 0; i < area.size(); i++) {
            long priceIdx = price.get(i);
            long areaIdx = area.get(i);
            List<Long> compList = new ArrayList<>(listOfHouses.get(areaIdx));
            compList.remove(priceIdx);
            double meanPrice = compList.isEmpty() ? Double.NaN : getMean(compList);
            double std = compList.isEmpty() ? Double.NaN : getStdDev(compList, meanPrice);

            double priceToMeanDiff = Math.abs(priceIdx - meanPrice);
            if (priceToMeanDiff > 3 * std) {
                continue;
            }

            allAreaFinal.add(areaIdx);
            allPriceFinal.add(priceIdx);
        }

        //--edge cases------
        if (allAreaFinal.isEmpty()) {
            long ans = 1000 * reqArea;
            return Math.max(1000, Math.min(ans, 1000000));
        }

        if (allAreaFinal.size() == 1) {
            long ans = allPriceFinal.get(0);
            return Math.max(1000, Math.min(ans, 1000000));
        }

        // ------If the requested area is already in the final areas----
        if (allAreaFinal.contains(reqArea)) {
            double sum = 0;
            double count = 0;
            for (int i = 0; i < allAreaFinal.size(); i++) {
                if (allAreaFinal.get(i).equals(reqArea)) {
                    sum += allPriceFinal.get(i);
                    count++;
                }
            }
            double meanPrice = sum/count;
            long ans = Math.round(meanPrice);
            return Math.max(1000, Math.min(ans, 1000000));
        }

        // ----Find areas just smaller and larger than the requested area----
        Long smallerArea = null;
        Long largerArea = null;
        for (Long a : allAreaFinal) {
            if (a < reqArea && (smallerArea == null || a > smallerArea)) {
                smallerArea = a;
            }
            if (a > reqArea && (largerArea == null || a < largerArea)) {
                largerArea = a;
            }
        }

        // Interpolate if both smaller and larger areas are found
        if (smallerArea != null && largerArea != null) {
            List<Integer> smallerIndices = new ArrayList<>();
            List<Integer> largerIndices = new ArrayList<>();
            for (int i = 0; i < allAreaFinal.size(); i++) {
                if (allAreaFinal.get(i).equals(smallerArea)) {
                    smallerIndices.add(i);
                }
                if (allAreaFinal.get(i).equals(largerArea)) {
                    largerIndices.add(i);
                }
            }
            double smallerMeanPrice = smallerIndices.stream().mapToDouble(i -> allPriceFinal.get(i)).average().orElse(Double.NaN);
            double largerMeanPrice = largerIndices.stream().mapToDouble(i -> allPriceFinal.get(i)).average().orElse(Double.NaN);

            double interpolatedPrice = smallerMeanPrice + ((largerMeanPrice - smallerMeanPrice) / (largerArea - smallerArea)) * (reqArea - smallerArea);
            long ans = Math.round(interpolatedPrice);
            return Math.max(1000, Math.min(ans, 1000000));
        }

        // Extrapolate if only smaller area is found
        if (smallerArea != null) {
            List<Long> largestAreas = new ArrayList<>(new HashSet<>(allAreaFinal));
            largestAreas.sort(Collections.reverseOrder());
            List<Double> meanPrices = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                final long areaIdx = largestAreas.get(i);
                double sum = 0;
                double count = 0;
                for(int j = 0; j < allAreaFinal.size();j++){
                    if(areaIdx == allAreaFinal.get(j)){
                        sum += allPriceFinal.get(j);
                        count++;
                    }
                }
                meanPrices.add(sum/count);
            }

            double extrapolatedPrice = meanPrices.get(1) + (reqArea - largestAreas.get(1)) * (meanPrices.get(1) - meanPrices.get(0)) / (largestAreas.get(1) - largestAreas.get(0));
            long ans = Math.round(extrapolatedPrice);
            return Math.max(1000, Math.min(ans, 1000000));
        }

        // Default return value if no conditions match
        return 1000;
    }
     public static double getMean(List<Long> compList){
        double sum = 0;
        double count = 0;

        for(int i = 0 ; i < compList.size(); i++){
            sum += compList.get(i);
            count++;
        }
        return sum/count;
    }
    public static double getStdDev(List<Long> compList, double meanPrice) {
        double sum = 0.0;
        for (long price : compList) {
            sum += Math.pow(price - meanPrice, 2);
        }
        return Math.sqrt(sum / compList.size());
    }
}
