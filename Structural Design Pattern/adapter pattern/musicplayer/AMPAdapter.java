package musicplayer;

import music.MusicFile;

public class AMPAdapter implements MediaPlayer {
    /* adapter class */

    private AdvancedMediaPlayer advancedMediaPlayer;

    public AMPAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public String play(MusicFile musicFile) {
        return advancedMediaPlayer.play(musicFile);
    }
}
