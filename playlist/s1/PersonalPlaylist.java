package playlist.s1;

public class PersonalPlaylist extends PlayList{
    
    public void remove(Song song) {
        getTracks().remove(song);
        getSingers().remove(song.getSinger());
    }
}
