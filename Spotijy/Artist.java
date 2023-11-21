import java.util.Arrays;
import java.util.Comparator;
public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;

    public Artist(String firstName, String lastName, int birthYear, Album[] albums) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = null;
    }
    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }

    public Song mostLikedSong() {
        Album[] tempAlbums = Arrays.copyOf(albums, albums.length);
        Song[] tempSingles = Arrays.copyOf(singles, singles.length);

        Arrays.sort(tempAlbums, Comparator.comparing(Album::returnAllLikes));
        Arrays.sort(tempSingles, Comparator.comparing(Song::getLikes));

        for (int i = 0; i < albums.length; i ++) {
            Arrays.sort(tempAlbums[i].getSongs(), Comparator.comparing(Song::getLikes));
        }
        Song maxVal = tempAlbums[0].getSongs()[0];
        for(int i = 0; i < albums.length; i ++) {
            if(tempAlbums[i].mostLiked().getLikes() > maxVal.getLikes()) {
                maxVal = tempAlbums[i].mostLiked();
            }
        }
        if (maxVal.getLikes() <= tempSingles[tempSingles.length - 1].getLikes()) {
            maxVal = tempSingles[tempSingles.length - 1];
        }
        return maxVal;
    }
    public Song leastLikedSong() {
        Album[] tempAlbums = Arrays.copyOf(albums, albums.length);
        Song[] tempSingles = Arrays.copyOf(singles, singles.length);

        Arrays.sort(tempAlbums, Comparator.comparing(Album::returnAllLikes).reversed());
        Arrays.sort(tempSingles, Comparator.comparing(Song::getLikes).reversed());

        for (int i = albums.length-1; i > 0; i --) {
            Arrays.sort(tempAlbums[i].getSongs(), Comparator.comparing(Song::getLikes).reversed());
        }
        Song maxVal = tempAlbums[0].getSongs()[0];
        for(int i = 0; i < albums.length; i ++) {
            if(tempAlbums[i].leastLiked().getLikes() < maxVal.getLikes()) {
                maxVal = tempAlbums[i].leastLiked();
            }
        }
        if (maxVal.getLikes() >= tempSingles[tempSingles.length - 1].getLikes()) {
            maxVal = tempSingles[tempSingles.length - 1];
        }
        return maxVal;
    }
    public int totalLikes() {
        int temp = 0;
        for (Song single : singles) {
            temp += single.getLikes();
        }
        for (Album album : albums) {
            temp += album.returnAllLikes();
        }
        return temp;
    }
    public boolean isEqual(Artist other) {
        return this.firstName.equals(other.firstName) &&
                this.lastName.equals(other.lastName) &&
                this.birthYear == (other.birthYear);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public Album[] getAlbums() {
        return albums;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Song[] getSingles() {
        return singles;
    }
    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSingles(Song[] singles) {
        this.singles = singles;
    }
}
