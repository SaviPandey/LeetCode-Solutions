import java.util.*;
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        return (!(str1 + str2).equals(str2 + str1)) ? "" : str1.substring(0, gcd(n1, n2) );
    }
    //Euclidean Algorithm
    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        } else {
            return gcd(b, a % b );
        }

    }
}