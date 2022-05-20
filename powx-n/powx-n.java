class Solution {
   public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }
        return myPowHelper(x, N);
    }

    private double myPowHelper(double x, long N) {
        double extra = 1.0;
        while (N > 1) {
            if (N % 2 == 1) {
                extra = extra * x;
                N--;
            }

            x = x * x;
            N = N/2;
        }
        return x * extra;
    }
}