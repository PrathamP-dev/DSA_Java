// 166 Fraction to Recurring Decimal

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder res = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) res.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        res.append(num / den);
        num %= den;

        if (num == 0) return res.toString();

        res.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (num != 0) {
            if (map.containsKey(num)) {
                int idx = map.get(num);
                res.insert(idx, "(");
                res.append(")");
                break;
            }

            map.put(num, res.length());

            num *= 10;
            res.append(num / den);
            num %= den;
        }

        return res.toString();
    }
}
