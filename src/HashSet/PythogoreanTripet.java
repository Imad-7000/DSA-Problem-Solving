package HashSet;

import java.util.HashSet;

public class PythogoreanTripet {
    
    public void main(String args[]){
        int n = 100;
        System.out.println(pythogoreanTriplet(n));
    }

    public int pythogoreanTriplet(int n){
        int count  = 0;
        HashSet<Integer> hash = new HashSet<>();
        
        for(int i = 1; i < n ; i++)
            hash.add(i*i);
        
        for(int i = 2 ; i < n; i++){

            for(int j = i + 1; j < n ;j ++)
            {
                if( hash.contains((i* i) + (j*j)))
                    count++;
            }
        }


        return count;
    }
}
