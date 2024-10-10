package exercise.medium;

public class CountConformingBitmasks {
    public static boolean conforms(int a, int b) {
        // Convert a and b to unsigned long to handle them as unsigned integers
        long unsignedA = Integer.toUnsignedLong(a);
        long unsignedB = Integer.toUnsignedLong(b);
        // Perform bitwise AND and check if unsignedA conforms to unsignedB
        return (unsignedA & unsignedB) == unsignedB;
    }



    int zeros(int n) {
        int res = 0;
        for(int i = 0; i < 30; i++) { // ensure 30-bit checks
            if((n & (1 << i)) == 0) {
                res++;
            }
        }
        return res;
    }

    int confs(int n){
        return (1 << zeros(n)) ;
    }

    public int solution(int a, int b, int c) {
        long unsignedA = Integer.toUnsignedLong(a);
        long unsignedB = Integer.toUnsignedLong(b);
        long unsignedC = Integer.toUnsignedLong(c);

        long unionAB = unsignedA | unsignedB;
        long unionAC = unsignedA | unsignedC;
        long unionBC = unsignedB | unsignedC;
        long unionABC = unsignedA | unsignedB | unsignedC;

        // Applying inclusion-exclusion principle correctly
        return confs(a) + confs(b) + confs(c)
                - confs((int) unionAB) - confs((int) unionAC) - confs((int) unionBC)
                + confs((int) unionABC);
    }


    // Existing methods...

    public static void main(String[] args) {
        CountConformingBitmasks solution = new CountConformingBitmasks();

        // Test cases
        //System.out.println(solution.solution1(1073741727, 1073741631, 1073741679)); // Example test case
        // System.out.println(solution.solution(1073741824, 1073741824, 1073741824)); // All bits set except the last one
        System.out.println(solution.solution(1073741727, 1073741631, 1073741679)); // All bits unset
    }
}


