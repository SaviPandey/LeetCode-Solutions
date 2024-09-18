class Solution {
    public String largestNumber(int[] nums) {
       if (nums == null || nums.length == 0) return "";

       String[] str = new String[nums.length];
       for(int i=0; i<nums.length; i++){
        str[i] = nums[i]+"";
       } 
    //    Arrays.sort(str, new Comparator<String>() {
    //     @Override
    //     public int compare(String i, String j) {
    //         String s1 = i + j;
    //         String s2 = j + i;
    //         return s2.compareTo(s1);
    //     }
    //    });
        Arrays.sort(str, (i, j) -> (j + i).compareTo(i + j)); // Optimized comparator with lambda

        if (str[0].equals("0")) return "0";

    //    if(str[str.length - 1].charAt(0) == '0') return "0";  //Not Printing 00, 000..

        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(s);
        }

        return res.toString();
    }
}