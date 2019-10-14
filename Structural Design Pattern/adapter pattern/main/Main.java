package main;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import music.*;
import musicplayer.AudioPlayer;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<MusicFile> previousMusicFilesHistory = new ArrayList<>();
    private static AudioPlayer audioPlayer = new AudioPlayer();
    private static Playlist playlist;
    private static String input;
    private static int choice;

    public static String getPreviousMusicFilesHistory() {
        Iterator iterator = previousMusicFilesHistory.iterator();
        int count = 0;

        String temp = "\n"+"<previous music files>"+"\n";

        while(iterator.hasNext()) {
            MusicFile musicFile = (MusicFile) iterator.next();

            temp += "\t"+(++count)+". "+musicFile;
        }

        return temp+"\n";
    }

    public static MusicFile addMusicFile() {
        String name = null;
        String type = null;
        double size;
        int duration;

        System.out.println("\n"+"<options>");
        System.out.println("1. pick from previous music files");
        System.out.println("2. create new music file");

        System.out.print("\n"+"choice(1/2): ");
        choice = scanner.nextInt();
        input = scanner.nextLine();  // for catching newline

        if(choice == 1) {
            if(previousMusicFilesHistory.size() == 0) {
                System.out.println("\n"+"-- no music file created yet --"+"\n");
            } else {
                System.out.println(getPreviousMusicFilesHistory());
                System.out.print("choice: ");
                choice = scanner.nextInt();
                input = scanner.nextLine();  // for catching newline

                if(choice<1 || choice>previousMusicFilesHistory.size()) {
                    System.out.println("\n"+"invalid choice made, try again..."+"\n");
                } else {
                    return previousMusicFilesHistory.get(--choice);
                }
            }

        } else if(choice == 2) {
            System.out.print("\n"+"enter music file name: ");
            name = scanner.nextLine();
            System.out.print("\n"+"enter music file type: ");
            type = scanner.nextLine();
            System.out.print("\n"+"enter music file size (in mega Bytes): ");
            size = scanner.nextDouble();
            System.out.print("\n"+"enter music file duration (in seconds): ");
            duration = scanner.nextInt();

            return new MusicFile(name, type, size, duration);

        } else {
            System.out.println("\n"+"invalid choice made, try again..."+"\n");
        }

        return null;
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("options:-");
            System.out.println("1. create new playlist");
            System.out.println("2. add music file to new playlist");
            System.out.println("3. show new playlist");
            System.out.println("4. upload new playlist");
            System.out.println("5. show current playlist");
            System.out.println("6. add music file to current playlist");
            System.out.println("7. play current playlist");
            System.out.println("8. show previous music files history");
            System.out.println("9. exit");

            System.out.print("\n"+"choice(1/2/3/4/5/6/7/8/9): ");
            choice = scanner.nextInt();
            input = scanner.nextLine();  // for catching newline

            if(choice == 1) {
                System.out.print("\n"+"enter playlist name: ");
                input = scanner.nextLine();

                playlist = new Playlist(input);
                System.out.println("new playlist created"+"\n");

            } else if(choice == 2) {
                if(playlist == null) {
                    System.out.println("\n"+"-- no new playlist created yet --"+"\n");
                } else {
                    MusicFile musicFile = addMusicFile();

                    if(musicFile != null) {
                        previousMusicFilesHistory.add(musicFile);
                        playlist.addMusicFile(musicFile);
                        System.out.println("music file added"+"\n");
                    }
                }

            } else if(choice == 3) {
                if(playlist == null) {
                    System.out.println("\n"+"-- no new playlist created yet --"+"\n");
                } else {
                    System.out.println("\n"+playlist+"\n");
                }

            } else if(choice == 4) {
                if(playlist == null) {
                    System.out.println("\n"+"-- no new playlist created yet --"+"\n");
                } else {
                    if(!audioPlayer.getIsPlaying()) {
                        audioPlayer.uploadPlaylist(playlist);
                        playlist = null;  // NOTICE
                    } else {
                        System.out.println("\n"+"currently, another playlist is being played"+"\n");
                        System.out.print("enter elapsed time(in seconds): ");
                        int elapsedTime = scanner.nextInt();

                        if(elapsedTime>=audioPlayer.getDuration()) {
                            audioPlayer.uploadPlaylist(playlist);
                            playlist = null;  // NOTICE
                        } else {
                            System.out.println("\n"+"-- playlist can not be uploaded --"+"\n");
                        }
                    }
                }

            } else if(choice == 5) {
                audioPlayer.showPlaylist();

            } else if(choice == 6) {
                if(audioPlayer.getIsUploaded()) {
                    MusicFile musicFile = addMusicFile();

                    if(musicFile != null) {
                        previousMusicFilesHistory.add(musicFile);
                        audioPlayer.addMusicFile(musicFile);
                        System.out.println("music file added"+"\n");
                    }
                } else {
                    System.out.println("\n"+"-- playlist not uploaded --"+"\n");
                }

            } else if(choice == 7) {
                audioPlayer.playPlaylist();

            } else if(choice == 8) {
                System.out.println(getPreviousMusicFilesHistory());

            } else if(choice == 9) {
                System.out.println("\n"+"exiting...");
                break;

            } else {
                System.out.println("\n"+"invalid choice made, try again..."+"\n");
            }
        }

        return ;

        /* duplicacy can be handled for more accurate operation */
    }
}
