package musicplayer;

import music.MusicFile;

public class FLVPlayer implements AdvancedMediaPlayer {
    /* adaptee concrete class */

    public FLVPlayer() {
        /* do nothing */
    }

    @Override
    public String play(MusicFile musicFile) {
        return "playing flv file: "+musicFile.getName();
    }
}
