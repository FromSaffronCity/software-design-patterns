package musicplayer;

import music.MusicFile;

public class MP4Player implements AdvancedMediaPlayer {
    /* adaptee concrete class */

    public MP4Player() {
        /* do nothing */
    }

    @Override
    public String play(MusicFile musicFile) {
        return "playing mp4 file: "+musicFile.getName();
    }
}
