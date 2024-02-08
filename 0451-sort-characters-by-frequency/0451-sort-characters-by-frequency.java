class Solution {
    public String frequencySort(String s) {
        // Create a HashMap to store character-frequency pairs
        HashMap<Character, Integer> hm = new HashMap<>();

        // Iterate through the string to count character frequencies
        for(int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Create a List of Lists to store character-frequency pairs
        List<List<Integer>> lst = new ArrayList<>();
        
        // Convert HashMap entries into a List of Lists
        for (Map.Entry<Character,Integer> itx : hm.entrySet()) {
            List<Integer> temp = new ArrayList<>();

            int a = itx.getKey(); // Character
            int b = itx.getValue(); // Frequency

            temp.add(a);
            temp.add(b);

            lst.add(temp);  
            System.out.println(temp);
        } 

        // Sort the List of Lists based on frequency in descending order
        Collections.sort(lst , (a,b) -> {
            return b.get(1) - a.get(1);
        });

        // Construct the sorted string based on the sorted List of Lists
        String ans = "";
        for(int i = 0; i < lst.size(); i++) {
            int a1 = lst.get(i).get(0);
            char a = (char)a1;
            for(int j = 0; j < lst.get(i).get(1); j++) {
                ans = ans + a;
            }
        }
        return ans;
    }
}