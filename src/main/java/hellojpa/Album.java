package hellojpa;

import javax.persistence.Entity;

@Entity
public class Album extends ItemTemp {

    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
