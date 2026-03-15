// LC 1622 Fancy Sequence
// This is the POD for 15th March, 2026
  
class Fancy {

    static final int MOD = 1000000007;
    List<Long> list;
    long mul;
    long add;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {
        long inv = modInverse(mul);
        long stored = ((val - add + MOD) % MOD * inv) % MOD;
        list.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        long val = list.get(idx);
        return (int)((val * mul % MOD + add) % MOD);
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % MOD;

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
