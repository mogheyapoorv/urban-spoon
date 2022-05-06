class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] s1_count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1_count[s1.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2_count = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2_count[s2.charAt(i + j) - 'a']++;
            }
            if (matcher(s1_count, s2_count)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean matcher(int[] s1, int[]s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}