package playlist.s1;

public class Song {
    private String singer;
    private String title;

    public Song(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }
}
