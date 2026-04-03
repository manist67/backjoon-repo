import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class Solution {
    private class Song {
        public int idx;
        public int play;
        public String genre;
        public Song(int idx, String genre, int play) {
            this.idx = idx;
            this.play = play;
            this.genre = genre;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> genreCounts = new HashMap();
        HashMap<String, List<Song>> genreAndSong = new HashMap();
        
        for(int i = 0 ; i < genres.length; i++) {
            int count = genreCounts.getOrDefault(genres[i], 0);
            genreCounts.put(genres[i], count + plays[i]);
            
            List<Song> Songs =  genreAndSong.getOrDefault(genres[i], new ArrayList<Song>());
            Songs.add(new Song(i, genres[i], plays[i]));
            genreAndSong.put(genres[i], Songs);
        }
        
        for(String key : genreAndSong.keySet()) {
            genreAndSong.get(key).sort((a,b)->b.play-a.play);
        }
        
        List<Map.Entry<String, Integer>> genreList = new ArrayList(genreCounts.entrySet());
        genreList.sort((a, b)->b.getValue().compareTo(a.getValue()));
        
        for(var genreEntry : genreList) {
            List<Song> songs = genreAndSong.get(genreEntry.getKey());
            answer.add(songs.get(0).idx);
            if(songs.size() >= 2) {
                answer.add(songs.get(1).idx);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}