import java.util.*;

class Song {
    String name;
    String artist;

    Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String toString() {
        return name + " - " + artist;
    }
}

public class ques2 {
    static LinkedList<Song> playlist = new LinkedList<>();
    static LinkedList<Song> history = new LinkedList<>();

    static void addSong(Song s) {
        playlist.add(s);
    }

    static void addFirst(Song s) {
        playlist.addFirst(s);
    }

    static void addAt(int pos, Song s) {
        if (pos < 0 || pos > playlist.size()) {
            System.out.println("Invalid position");
            return;
        }
        playlist.add(pos, s);
    }

    static void removeDuplicates() {
        HashSet<String> seen = new HashSet<>();
        ListIterator<Song> it = playlist.listIterator();

        while (it.hasNext()) {
            Song s = it.next();
            String key = s.name + "|" + s.artist;

            if (!seen.add(key)) {
                it.remove();
            }
        }
    }

    static void playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        }

        Song s = playlist.removeFirst();
        history.addFirst(s);
        System.out.println("Now playing: " + s);
    }

    static void showForward() {
        ListIterator<Song> it = playlist.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    static void showBackward() {
        ListIterator<Song> it = playlist.listIterator(playlist.size());

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    static void showHistory() {
        for (Song s : history) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        addSong(new Song("Song A", "Artist A"));
        addSong(new Song("Song B", "Artist B"));
        addSong(new Song("Song A", "Artist A"));
        addFirst(new Song("Song C", "Artist C"));
        addAt(1, new Song("Song D", "Artist D"));

        removeDuplicates();

        System.out.println("Playlist Forward:");
        showForward();

        System.out.println("Playlist Backward:");
        showBackward();

        System.out.println("Playback:");
        playNext();

        System.out.println("Recent History:");
        showHistory();
    }
}