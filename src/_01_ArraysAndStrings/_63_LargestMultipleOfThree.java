package _01_ArraysAndStrings;
import java.util.*;

public class _63_LargestMultipleOfThree {
    public static String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        int sum = 0;

        for (int i = 0; i < n; i++) sum += digits[i];
        Arrays.sort(digits);

        if (sum % 3 == 0) {
        if (digits[n - 1] == 0) return "0";

        String s = "";
        for (int i = n - 1; i >= 0; i--) s += digits[i];
        return s;
        }

        else if (sum % 3 == 1) {
        boolean ideaFound = false;

        for (int i = 0; i < n; i++) {
        if (digits[i] % 3 == 1) {
        ideaFound = true;
        digits[i] = -1;
        break;
        }
        }

        if (!ideaFound) {
        int[] idnes = new int[2];
        idnes[0] = -1;
        idnes[1] = -1;

        for (int i = 0; i < n; i++) {
        if (digits[i] % 3 == 2) {
        if (idnes[0] == -1) idnes[0] = i;
        else { idnes[1] = i; break; }
        }
        }

        if (idnes[1] != -1) {
        digits[idnes[0]] = -1;
        digits[idnes[1]] = -1;
        } else return "";
        }

        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
        if (digits[i] != -1) ans += digits[i];
        }
        return ans;
        }

        else {
        boolean ideaFound = false;

        for (int i = 0; i < n; i++) {
        if (digits[i] % 3 == 2) {
        ideaFound = true;
        digits[i] = -1;
        break;
        }
        }

        if (!ideaFound) {
        int[] idnes = new int[2];
        idnes[0] = -1;
        idnes[1] = -1;

        for (int i = 0; i < n; i++) {
        if (digits[i] % 3 == 1) {
        if (idnes[0] == -1) idnes[0] = i;
        else { idnes[1] = i; break; }
        }
        }

        if (idnes[1] != -1) {
        digits[idnes[0]] = -1;
        digits[idnes[1]] = -1;
        } else return "";
        }

        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
        if (digits[i] != -1) ans += digits[i];
        }
        return ans;
        }
        }

// ---------- MAIN WITH USER INPUT ----------
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of digits: ");
        int n = sc.nextInt();

        int[] digits = new int[n];
        System.out.println("Enter digits: ");

        for (int i = 0; i < n; i++) {
        digits[i] = sc.nextInt();
        }

        String result = largestMultipleOfThree(digits);
        System.out.println("Largest Multiple of Three = " + result);
        }
        }