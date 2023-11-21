import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SpotiJy {
    private Artist[] artists;
    public SpotiJy(Artist[] artists) {
        this.artists = artists;
    }
    public Artist[] getArtists() {
        return artists;
    }
    public void addArtists(Artist[] newArtists) {
        List<Artist> first = new ArrayList<>(Arrays.stream(newArtists).toList());
        List<Artist> second = new ArrayList<>( Arrays.stream(this.artists).toList());

        for (Artist artist : newArtists) {
            for (Artist artist1 : artists) {
                if (artist.equals(artist1)) {
                    first.remove(artist1);
                }
            }
        }
        second.addAll(first);
        ArrayList<Artist> thirdList = new ArrayList<>(second);
        this.artists = thirdList.toArray(new Artist[0]);
    }
    public String [] getTopTrendingArtist() {
        Artist[] tempArr = Arrays.copyOf(artists, artists.length);
        Arrays.sort(tempArr, Comparator.comparing(Artist :: totalLikes));
        return new String[]{tempArr[tempArr.length-1].getFirstName(), tempArr[tempArr.length-1].getLastName()};
    }
    public String getTopTrendingAlbum() {
        Album maxValue = artists[0].getAlbums()[0];
        for (int i = 0; i < artists.length; i ++) {
            if(artists[i].getAlbums()[i].returnAllLikes() > maxValue.returnAllLikes()) {
                maxValue = artists[i].getAlbums()[i];
            }
        }
        return maxValue.getTitle();
    }
    public String getTopTrendingSong() {
        Song bestSong = artists[0].getAlbums()[0].getSongs()[0];
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                for (Song song : album.getSongs()) {
                    if (bestSong == null || song.getLikes() > bestSong.getLikes()) {
                        bestSong = song;
                    }
                }
            }
        }
        return bestSong.getTitle();

    }

    @Override
    public String toString() {
        return "SpotiJy{" +
                "artists=" + Arrays.toString(artists) +
                '}';
    }
}
