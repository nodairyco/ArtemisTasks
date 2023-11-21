import javax.naming.directory.AttributeInUseException;

public class Song {
    private int releaseYear;
    private String title;
    private int duration;
    private int likes;
    public Song(String title,int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }
    public Song(String title, int releaseYear, int duration) {
        this.releaseYear = releaseYear;
        this.title = title;
        if(duration > 0) {
            this.duration = duration;
        } else {
            this.duration = 60;
        }
        this.likes = 0;
    }
    public Song(String title, int releaseYear, int duration, int likes) {
        this.releaseYear = releaseYear;
        this.title = title;
        if(duration > 0) {
            this.duration = duration;
        } else {
            this.duration = 60;
        }
        this.likes = Math.max(likes, 0);
    }
    public boolean setDuration(int newDuration) {
        if (newDuration <= 0|| newDuration > 720 ||this.duration == newDuration) {
            return false;
        } else {
            this.duration = newDuration;
            return true;
        }
    }
    public boolean isEqual(Song song) {
        return this.releaseYear == song.releaseYear && this.duration == song.duration && this.title.equals(song.title);
    }
    public void like() {
        this.likes = likes++;
    }
    public void unLike() {
        this.likes = likes--;
        if (likes-- < 0) {
            this.likes = 0;
        }
    }
    @Override
    public String toString() {
        return "Song{" +
                "releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", likes=" + likes +
                '}';
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getDuration() {
        return duration;
    }
    public String getTitle() {
        return title;
    }
    public int getLikes() {
        return likes;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
}
