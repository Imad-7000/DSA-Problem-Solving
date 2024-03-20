package Sorting;
import java.util.*;

public class JeeRanking {

    public static void main(String[] args) {
        Ranking rank1 = new Ranking(98, 99, 100);
        Ranking rank2 = new Ranking(100, 100, 100);
        Ranking rank3 = new Ranking(70, 99, 100);
        Ranking rank4 = new Ranking(91, 95, 85);
        Ranking rank5 = new Ranking(93, 96, 99);
        Ranking rank6 = new Ranking(99, 98, 100);
        Ranking rank7 = new Ranking(98, 99, 99);
        Ranking rank8 = new Ranking(98, 100, 99);
        Ranking rank9 = new Ranking(100, 98, 99);
        Ranking rank10 = new Ranking(100, 99, 98);

        HashMap<String, Ranking> hashMap = new HashMap<>();
        hashMap.put("Ali", rank1);
        hashMap.put("Mustafa", rank2);
        hashMap.put("Jacob", rank3);
        hashMap.put("Kratos", rank4);
        hashMap.put("lola", rank5);
        hashMap.put("baba", rank6);
        hashMap.put("kamali", rank7);
        hashMap.put("Trevor", rank8);
        hashMap.put("Hasan", rank9);
        hashMap.put("Alka", rank10);

        System.out.println(Topper(hashMap));

    }

    public static String Topper(HashMap<String, Ranking> marks) {

        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, Ranking>> itr = marks.entrySet().iterator();
        while (itr.hasNext())
            arrayList.add(itr.next().getKey());

        CustomSort customSort = new CustomSort(marks);
        Collections.sort(arrayList, customSort);
        return arrayList.get(0);
    }

}

class CustomSort implements Comparator<String> {
    private final HashMap<String, Ranking> hashMap;

    public CustomSort(HashMap<String, Ranking> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public int compare(String o1, String o2) {
        int totalFreq = hashMap.get(o2).getTotal().compareTo(hashMap.get(o1).getTotal());
        int mathFreq = hashMap.get(o2).getMaths().compareTo(hashMap.get(o1).getMaths());
        int phyFreq = hashMap.get(o2).getPhysics().compareTo(hashMap.get(o1).getPhysics());
        int chemFreq = hashMap.get(o2).getChemistry().compareTo(hashMap.get(o1).getChemistry());


        if (totalFreq == 0) {
            if (mathFreq == 0) {
                if (phyFreq == 0) {
                    return chemFreq;
                } else {
                    return phyFreq;
                }
            } else {
                return mathFreq;
            }
        } else {
            return totalFreq;
        }
    }


}


class Ranking {
    public Integer Maths;
    public Integer Physics;
    public Integer Chemistry;
    public Integer Total;

    public Ranking(int Maths, int Physics, int Chemistry) {
        this.Maths = Maths;
        this.Physics = Physics;
        this.Chemistry = Chemistry;
    }

    public Integer getTotal() {
        return this.Maths + this.Physics + this.Chemistry;
    }

    public Integer getMaths() {
        return this.Maths;
    }

    public Integer getPhysics() {
        return Physics;
    }

    public Integer getChemistry() {
        return Chemistry;
    }
}
