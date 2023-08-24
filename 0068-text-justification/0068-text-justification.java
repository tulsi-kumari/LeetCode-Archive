class Solution {
       public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0, wordCount, lineLength; i < words.length; i += wordCount) {
            for (wordCount = 0, lineLength = 0; 
                 i + wordCount < words.length && 
                 lineLength + words[i + wordCount].length() + wordCount <= maxWidth; 
                 wordCount++) {
                lineLength += words[i + wordCount].length();
            }
            
            StringBuilder lineBuilder = new StringBuilder(words[i]);
            
            if (wordCount == 1 || i + wordCount == words.length) {
                for (int j = 1; j < wordCount; j++) {
                    lineBuilder.append(" ").append(words[i + j]);
                }
                lineBuilder.append(" ".repeat(maxWidth - lineBuilder.length()));
            } else {
                int totalSpaces = (maxWidth - lineLength) / (wordCount - 1);
                int extraSpaces = (maxWidth - lineLength) % (wordCount - 1);
                
                for (int j = 1; j < wordCount; j++) {
                    int spacesToAdd = totalSpaces + (extraSpaces-- > 0 ? 1 : 0);
                    lineBuilder.append(" ".repeat(spacesToAdd)).append(words[i + j]);
                }
            } 
            result.add(lineBuilder.toString());
        }   
        return result;
    }
    }
//      public List<String> fullJustify(String[] words, int maxWidth) {
//         List<String> res = new ArrayList<>();
//         List<String> curWords = new ArrayList<>();
//         int curLen = 0;

//         for (String word : words) {
//             if (curLen + word.length() + curWords.size() > maxWidth) {
//                 int totalSpaces = maxWidth - curLen;
//                 int gaps = curWords.size() - 1;
//                 if (gaps == 0) {
//                     res.add(curWords.get(0) + " ".repeat(totalSpaces));
//                 } else {
//                     int spacePerGap = totalSpaces / gaps;
//                     int extraSpaces = totalSpaces % gaps;
//                     StringBuilder line = new StringBuilder();
//                     for (int i = 0; i < curWords.size(); i++) {
//                         line.append(curWords.get(i));
//                         if (i < gaps) {
//                             line.append(" ".repeat(spacePerGap));
//                             if (i < extraSpaces) {
//                                 line.append(' ');
//                             }
//                         }
//                     }
//                     res.add(line.toString());
//                 }
//                 curWords.clear();
//                 curLen = 0;
//             }
//             curWords.add(word);
//             curLen += word.length();
//         }

//         StringBuilder lastLine = new StringBuilder(String.join(" ", curWords));
//         while (lastLine.length() < maxWidth) {
//             lastLine.append(' ');
//         }
//         res.add(lastLine.toString());

//         return res;
//     }
