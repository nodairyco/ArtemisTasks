import java.util.*;
public class Album {
    private int releaseYear;
    private Song[] songs;
    private String title;

    public Album(String title, Song[] songs) {
        this.title = title;
        this.songs = songs;
    }
    public Album(String title, Song[] songs, int releaseYear) throws Error{
        this.title = title;
        if (releaseYear < 0) {
            throw new Error("Release year can't be negative.");
        } else {
            this.releaseYear = releaseYear;
        }
        this.songs = songs;
    }
    public Boolean isEqual(Song a, Song b) {
        return a.getTitle().equals(b.getTitle()) && a.getReleaseYear() == b.getReleaseYear();
    }
    public int addSongs(Song[] newSongs) {
        List<Song> first = new ArrayList<>(Arrays.stream(newSongs).toList());
        List<Song> second = new ArrayList<>(Arrays.stream(this.songs).toList());
        for (Song newSong : newSongs) {
            for (Song song : songs) {
                if (newSong.equals(song)) {
                    first.remove(newSong);
                }
            }
        }
        second.addAll(first);
        ArrayList<Song> thirdList = new ArrayList<>(second);
        this.songs = thirdList.toArray(new Song[0]);
        return first.size();
    }
    public Song[] shuffle() {
        ArrayList<Song> temp = new ArrayList<>(Arrays.stream(this.songs).toList());
        Collections.shuffle(temp);

        return temp.toArray(new Song[0]);
    }
    public Song[] sortByTitle (boolean isAscending) {
        Song[] tempArray = Arrays.copyOf(this.songs, this.songs.length);
        if (isAscending) {
            Arrays.sort(tempArray, Comparator.comparing(Song::getTitle));
            return tempArray;
        } else {
            Arrays.sort(tempArray, Comparator.comparing(Song::getTitle).reversed());
            return tempArray;
        }
    }
    public Song[] sortByDuration(boolean isAscending) {
        Song[] tempArray = Arrays.copyOf(this.songs, this.songs.length);
        if (isAscending) {
            Arrays.sort(tempArray, Comparator.comparing(Song::getDuration));
            return tempArray;
        } else {
            Arrays.sort(tempArray, Comparator.comparing(Song::getDuration).reversed());
            return tempArray;
        }
    }
    public Song[] sortByReleaseYear(boolean isAscending) {
        Song[] tempArray = Arrays.copyOf(this.songs, this.songs.length);
        if (isAscending) {
            Arrays.sort(tempArray, Comparator.comparing(Song::getReleaseYear));
            return tempArray;
        } else {
            Arrays.sort(tempArray, Comparator.comparing(Song::getReleaseYear).reversed());
            return tempArray;
        }
    }
    public Song[] sortByPopularity (boolean isAscending) {
        Song[] tempArray = Arrays.copyOf(this.songs, this.songs.length);
        if (isAscending) {
            Arrays.sort(tempArray, Comparator.comparing(Song::getLikes));
            return tempArray;
        } else {
            Arrays.sort(tempArray, Comparator.comparing(Song::getLikes).reversed());
            return tempArray;
        }
    }
    public static Song[] reverse(Song[] songs) {
        Song[] toBeReversedArray = Arrays.copyOf(songs, songs.length);
        int length = toBeReversedArray.length;
        for (int i = 0; i < length / 2; i++) {
            Song temp = toBeReversedArray[i];
            toBeReversedArray[i] = toBeReversedArray[length - 1 - i];
            toBeReversedArray[length - 1 - i] = temp;
        }
        return toBeReversedArray;
    }

    @Override
    public String toString() {
        return "Album{" +
                "releaseYear=" + releaseYear +
                ", songs=" + Arrays.toString(songs) +
                ", title='" + title + '\'' +
                '}';
    }
    public int returnAllLikes() {
        int temp = 0;
        for(int i = 0; i < songs.length; i ++) {
            temp += songs[i].getLikes();
        }
        return temp;
    }
    public Song mostLiked() {
        Song[] tempArray = Arrays.copyOf(songs, songs.length);
        Arrays.sort(tempArray, Comparator.comparing(Song::getLikes));
        return tempArray[tempArray.length - 1];
    }
    public Song leastLiked() {
        Song[] tempArray = Arrays.copyOf(songs, songs.length);
        Arrays.sort(tempArray, Comparator.comparing(Song::getLikes).reversed());
        return tempArray[tempArray.length - 1];
    }
    public int getReleaseYear() {
        return releaseYear;
    }

    public Song[] getSongs() {
        return songs;
    }

    public String getTitle() {
        return title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
