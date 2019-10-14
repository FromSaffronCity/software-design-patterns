package music;

public class MusicFile {
    private String name;
    private String type;
    private double size;  // in mega bytes
    private int duration;  // in seconds

    public MusicFile(String name, String type, double size, int duration) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getSize() {
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
        return name+" ("+type+", "+size+" MB, "+getTime()+")"+"\n";
    }
}
