class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int arr[] = new int[n+1];

        for(int c : citations) {
            if(c > n)
                arr[n]++ ;//If size greater than n then increase last element only
            else 
                arr[c]++ ;   //Else increment index of that c
        } 
        int count = 0;

        for(int i = n; i >= 0; i--) {
            count = count + arr[i];
            if(count >= i )
                return i;
        }
        return 0;
    }
}