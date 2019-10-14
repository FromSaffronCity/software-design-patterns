package musicplayer;

import music.*;

public class AudioPlayer implements MediaPlayer {
    /* client class */

    private Playlist playlist;
    private AMPAdapter ampAdapter;
    private boolean isPlaying;

    public AudioPlayer() {
        /* do nothing */
    }

    @Override
    public String play(MusicFile musicFile) {
        return "playing mp3 file: "+musicFile.getName();  // by default, play mp3 files
    }

    public String playMusicFile(MusicFile musicFile) {
        if(musicFile.getType().equalsIgnoreCase("mp3")) {
            return play(musicFile);
        } else if(musicFile.getType().equalsIgnoreCase("mp4")) {
            ampAdapter = new AMPAdapter(new MP4Player());
            return ampAdapter.play(musicFile);
        } else if(musicFile.getType().equalsIgnoreCase("vlc")) {
            ampAdapter = new AMPAdapter(new VLCPlayer());
            return ampAdapter.play(musicFile);
        } else if(musicFile.getType().equalsIgnoreCase("flv")) {
            ampAdapter = new AMPAdapter(new FLVPlayer());
            return ampAdapter.play(musicFile);
        } else {
            return "-- unsupported file format ("+musicFile.getName()+"."+musicFile.getType()+"), unable to play music file --";
        }
    }

    public void uploadPlaylist(Playlist playlist) {
        isPlaying = false;  // NOTICE: stops playing

        this.playlist = playlist;
        System.out.println("\n"+"-- playlist uploaded --"+"\n");

        return ;
    }

    public void showPlaylist() {
        isPlaying = false;  // NOTICE: stops playing

        if(playlist == null) {
            System.out.println("\n"+"-- playlist not uploaded --"+"\n");
        } else {
            System.out.println("\n"+playlist+"\n");
        }

        return ;
    }

    public void addMusicFile(MusicFile musicFile) {
        isPlaying = false;  // NOTICE: stops playing

        if(playlist == null) {
            System.out.println("\n"+"-- playlist not uploaded --"+"\n");
        } else {
            playlist.addMusicFile(musicFile);
        }

        return ;
    }

    public void playPlaylist() {
        if(playlist == null) {
            System.out.println("\n"+"-- playlist not uploaded --"+"\n");
        } else {
            isPlaying = true;  // NOTICE: starts playing

            System.out.println("\n"+"playing "+playlist.getName()+"..."+"\n");

            for(int i=0; i<playlist.getPlaylistLength(); i++) {
                System.out.println("\t"+playMusicFile(playlist.getMusicFile(i))+"\n");
            }

            System.out.println("\n"+"<total elapsed time: "+playlist.getTime()+">"+"\n");
        }

        return ;
    }

    /* additional */
    public boolean getIsUploaded() {
        return (playlist != null);
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public int getDuration() {
        return playlist.getDuration();
    }
}
