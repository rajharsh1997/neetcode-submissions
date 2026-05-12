class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Build frequency map for t (what we NEED)
        int[] need = new int[128];
        int needCount = 0; // Total characters we need

        for (int i = 0; i < t.length(); i++) {
            if (need[t.charAt(i)] == 0) {
                needCount++; // New unique character
            }
            need[t.charAt(i)]++;
        }

        // Track what we HAVE in current window
        int[] have = new int[128];
        int haveCount = 0; // Count of satisfied unique characters

        // Result tracking
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. Include s[right] in window
            char rightChar = s.charAt(right);
            have[rightChar]++;

            // Did we just satisfy this character's requirement?
            if (need[rightChar] > 0 && have[rightChar] == need[rightChar]) {
                haveCount++;
            }

            // 2. While we HAVE everything we NEED → try to shrink
            while (haveCount == needCount) {
                // 3. Update answer (we found a valid window)
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Try to shrink from left
                char leftChar = s.charAt(left);
                have[leftChar]--;

                // Did we just break a requirement?
                if (need[leftChar] > 0 && have[leftChar] < need[leftChar]) {
                    haveCount--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}