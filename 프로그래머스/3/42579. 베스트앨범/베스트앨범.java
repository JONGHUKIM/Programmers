import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.getOrDefault(genre, 0) + play);
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        Stream<Map.Entry<String, Integer>> sortedGenre =
            playMap.entrySet().stream().sorted((o1, o2) -> 
                            Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedGenre.forEach(entry -> {
            
            Stream<int[]> sortedSong = 
                genreMap.get(entry.getKey()).stream().sorted((o1, o2) -> {
                
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                
                return Integer.compare(o2[1], o1[1]);
                
            }).limit(2);
            
            sortedSong.forEach(song -> answerList.add(song[0]));
            
        });        
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}