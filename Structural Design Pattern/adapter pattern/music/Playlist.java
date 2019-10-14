package music;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Playlist {
    private String name;
    private double size;
    private int duration;
    private List<MusicFile> playlist;

    public Playlist(String name) {
        this.name = name;
        playlist = new ArrayList<>();
    }

    public void addMusicFile(MusicFile musicFile) {
        playlist.add(musicFile);
        size += musicFile.getSize();
        duration += musicFile.getDuration();

        return ;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        /* keeping this for later usage */
        return size;
    }

    public int getDuration() {
        return duration;
    }

    /* additional */
    public String getTime() {
        int minute = duration/60;
        int second = duration%60;

        return minute+" minute "+second+" second";
    }

    @Override
    public String toString() {
        String temp = "<< playlist >> "+name+" ("+size+" MB, "+getTime()+")"+"\n\n";
        temp += "includes:-"+"\n";

        Iterator iterator = playlist.iterator();
        int count = 0;

        while(iterator.hasNext()) {
            MusicFile musicFile = (MusicFile) iterator.next();

            temp += "\t"+(++count)+". "+musicFile;
        }

        return temp+"\n";
    }

    public int getPlaylistLength() {
        return playlist.size();
    }

    public MusicFile getMusicFile(int index) {
        return playlist.get(index);
    }

    /* a copy constructor for this class may be added for more accurate operation */
}
