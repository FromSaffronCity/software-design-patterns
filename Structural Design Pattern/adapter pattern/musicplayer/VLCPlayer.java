package musicplayer;

import music.MusicFile;

public class VLCPlayer implements AdvancedMediaPlayer {
    /* adaptee concrete class */

    public VLCPlayer() {
        /* do nothing */
    }

    @Override
    public String play(MusicFile musicFile) {
        return "playing vlc file: "+musicFile.getName();
    }
}
