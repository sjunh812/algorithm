import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, GenreInfo> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.get(genres[i]).setMusicList(i, plays[i]);
            } else {
                map.put(genres[i], new GenreInfo(i, plays[i]));
            }   
        }
        
        ArrayList<GenreInfo> genreInfoList = new ArrayList<>(map.values());
        Collections.sort(genreInfoList);
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for (GenreInfo genreInfo : genreInfoList) {
            int genreCnt = 0;
            while (!genreInfo.getMusicList().isEmpty() && genreCnt < 2) {
                Music music = genreInfo.getMusicList().poll();
                answerList.add(music.getNumber());
                genreCnt++;
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

class GenreInfo implements Comparable<GenreInfo> {
    
    private int totalPlay;
    private PriorityQueue<Music> pq;
    
    public GenreInfo(int number, int play) {
        this.totalPlay = play;
        pq = new PriorityQueue<Music>();  
        pq.offer(new Music(number, play));
    }
    
    public PriorityQueue<Music> getMusicList() {
        return this.pq;
    }
    
    public void setMusicList(int number, int play) {
        this.totalPlay += play;
        pq.offer(new Music(number, play));
    }
    
    public int getTotalPlay() {
        return this.totalPlay;
    }
    
    @Override
    public int compareTo(GenreInfo other) {
        return other.totalPlay - this.totalPlay;
    }
}

class Music implements Comparable<Music> {
    
    private int number;
    private int play;
    
    public Music(int number, int play) {
        this.number = number;
        this.play = play;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public int getPlay() {
        return this.play;
    }
    
    @Override
    public int compareTo(Music other) {
        if (this.play == other.play) return this.number - other.number;
        return other.play - this.play;
    }
}