import java.util.*;

/**
 * 726. Number of Atoms
 * Hard
 * 
 * Given a string formula representing a chemical formula, return the count of each atom.
 * 
 * The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 * 
 * One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.
 * 
 * For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
 * Two formulas are concatenated together to produce another formula.
 * 
 * For example, "H2O2He3Mg4" is also a formula.
 * A formula placed in parentheses, and a count (optionally added) is also a formula.
 * 
 * For example, "(H2O2)" and "(H2O2)3" are formulas.
 * Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 * 
 * The test cases are generated so that all the values in the output fit in a 32-bit integer.
 * 
 * Example 1:
 * Input: formula = "H2O"
 * Output: "H2O"
 * Explanation: The count of elements are {'H': 2, 'O': 1}.
 * 
 * Example 2:
 * Input: formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * 
 * Example 3:
 * Input: formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * 
 * Constraints:
 * 1 <= formula.length <= 1000
 * formula consists of English letters, digits, '(', and ')'.
 * formula is always valid.
 */

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        int[] stack = new int[1000];
        int top = 0, multiplier = 1, freq = 0;
        char[] c = formula.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                int end = i--;
                while (i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--;
                String key = new String(c, i + 1, end - i);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                String key = new String(c, i, 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= '0' && c[i] <= '9') {
                freq = c[i] - '0';
                int p = 10;
                while (i - 1 >= 0 && c[i - 1] >= '0' && c[i - 1] <= '9') {
                    freq += p * (c[--i] - '0');
                    p *= 10;
                }
            } else if (c[i] == ')') {
                stack[top++] = multiplier;
                multiplier *= Math.max(freq, 1);
                freq = 0;
            } else {
                multiplier = stack[--top];
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            int f = map.get(key);
            if (f > 1) sb.append(f);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NumberOfAtoms solution = new NumberOfAtoms();
        System.out.println(solution.countOfAtoms("H2O")); // Output: "H2O"
        System.out.println(solution.countOfAtoms("Mg(OH)2")); // Output: "H2MgO2"
        System.out.println(solution.countOfAtoms("K4(ON(SO3)2)2")); // Output: "K4N2O14S4"
    }
}

