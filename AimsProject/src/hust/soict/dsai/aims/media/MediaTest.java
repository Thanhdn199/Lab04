package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<Media>();

        mediaList.add(new CompactDisc(1, "CD Title", "Music", 15.99f, 60, "Director", "Artist"));
        mediaList.add(new DigitalVideoDisc("DVD Title", "Movies", 20.99f, 120, "Director"));
        mediaList.add(new Book(3, "Book Title", "Math", 10.99f, "Author"));

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
