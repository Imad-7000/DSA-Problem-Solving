public class MangoesAndPineapples {

    public static void main(String[] args) {
        System.out.println(solve("MMPPPPMMMP", 10));
    }

    public static int solve(String s, int n){
        int p1 =0;
        int p2 =0;
        int m1=0;
        int m2=0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'M')
                m2++;
            else
                m1++;
        }
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'M'){
                m1++;
                m2--;
            }

            if(s.charAt(i) == 'P'){
                p1++;
                p2--;
            }

            if((m1 > 0 || p1 > 0) && (m2 > 0 || p2 > 0)){
                if(m1!=m2 && p1!= p2)
                    return i + 1;
            }

        }
        return -1;
    }
}
