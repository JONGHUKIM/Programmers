import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {   
        
        // genreMap : (장르 → 해당 장르의 곡 리스트[index, play])
        // 예) classic → [ [0,500], [2,150], [3,800] ]
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        
        // playMap : (장르 → 그 장르에 속한 모든 곡의 총 재생수)
        // 예) classic → 500+150+800 = 1450
        HashMap<String, Integer> playMap = new HashMap<>();
                
        // 1) 장르별로 곡을 묶고, 총 재생수도 누적하는 단계  
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];  // 곡의 장르
            int play = plays[i];       // 해당 곡의 재생 수

            // 처음 등장한 장르라면 리스트/총합 초기화
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());  // 장르별 곡 리스트 생성
                playMap.put(genre, 0);                   // 장르 총 재생수 초기화
            }

            // 해당 장르 리스트에 (index, play) 저장
            genreMap.get(genre).add(new int[]{i, play});

            // 장르 총 재생수 누적
            playMap.put(genre, playMap.get(genre) + play);
        }
        
        // 최종 수록될 "곡 인덱스"를 순서대로 넣을 리스트
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 2) 장르들을 "총 재생수 기준"으로 내림차순 정렬
        //    (조건 1: 가장 인기 많은 장르부터 수록)
        Stream<Map.Entry<String, Integer>> sortedGenre =
            playMap.entrySet().stream()
                   .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        // 3) 정렬된 장르 순서대로 반복
        sortedGenre.forEach(entry -> {
           
            // 그 장르에 속한 곡 리스트를 꺼내 정렬
            // (조건 2: 장르 내에서 재생수 많은 곡 먼저)
            // (조건 3: 재생수 같으면 index(고유번호) 작은 것 먼저)
            Stream<int[]> sortedSongs =
                genreMap.get(entry.getKey()).stream()
                        .sorted((o1, o2) -> {
                            // o1, o2는 각각 int[]{index, play}
                            // o1[1] = play1, o1[0] = index1
                            
                            // 재생수 같으면 index 오름차순
                            if (o1[1] == o2[1]) {
                                return Integer.compare(o1[0], o2[0]);
                            }
                            
                            // 재생수 다르면 재생수 내림차순
                            return Integer.compare(o2[1], o1[1]);
                        })
                        .limit(2);  // 각 장르에서 최대 2곡만 선택
            
            // 선택된 곡들의 index를 answer에 추가
            sortedSongs.forEach(song -> answer.add(song[0]));
        });

        // ArrayList<Integer> → int[] 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
