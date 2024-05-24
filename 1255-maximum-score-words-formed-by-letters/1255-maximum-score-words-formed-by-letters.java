class Solution {
    int ans;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character,Integer> letter_map=new HashMap<>();
        ans=0;
        for(char ch:letters)
        {
            letter_map.put(ch,letter_map.getOrDefault(ch,0)+1);
        }
        solve(words,0,letter_map,score,0);
        return ans;
    }
    
    public void solve(String[] words,int i,HashMap<Character,Integer> letters,int[] score,int currscore)
    {
        if(i>=words.length){
            ans=Math.max(ans,currscore);
            return;
        }
        if(isValid(words[i],letters))
        {
            removeLetters(words[i],letters);
            solve(words,i+1,letters,score,currscore+calcscore(words[i],score));
            includeLetters(words[i],letters);
        }
        solve(words,i+1,letters,score,currscore);
        
    }
    
    public boolean isValid(String word,HashMap<Character,Integer> letters)
    {
       HashMap<Character,Integer> wordmap=new HashMap<>();
        for(char ch:word.toCharArray())
        {
            wordmap.put(ch,wordmap.getOrDefault(ch,0)+1);
        }
        for(char ch:wordmap.keySet())
        {
            int val=wordmap.get(ch);
            if(!letters.containsKey(ch)||letters.get(ch)<val) return false;
        }
        return true;
    }
    
    public int calcscore(String word,int[] score)
    {
        int sc=0;
        for(char ch:word.toCharArray())
        {
            int idx=ch-'a';
            sc+=score[idx];
        }
        return sc;
    }
    
    public void removeLetters(String word,HashMap<Character,Integer> letters)
    {
        for(char ch:word.toCharArray())
        {
            if(letters.get(ch)==1)
            {
                letters.remove(ch);
            }else
            {
                letters.put(ch,letters.get(ch)-1);
            }
        } 
    }
    
    public void includeLetters(String word,HashMap<Character,Integer> letters)
    {
        for(char ch:word.toCharArray())
        {
            if(!letters.containsKey(ch))
            {
                letters.put(ch,1);
            }else
            {
                letters.put(ch,letters.get(ch)+1);
            }
        } 
    }
}