import java.util.Scanner;

public class Lab13_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input
        MusicPlayer mp = new MusicPlayer(); // Create a new MusicPlayer object
        int x = 1; // Initialize the control variable for the while loop
        String song; // Variable to hold the song name entered by the user

        while(x < 8){ // Loop until the user chooses to exit by entering 8
            // Display menu options to the user
            System.out.println("Enter 1 for add song");
            System.out.println("      2 for delete song");
            System.out.println("      3 for play song");
            System.out.println("      4 for play prev song");
            System.out.println("      5 for play next song");
            System.out.println("      6 for search song");
            System.out.println("      7 for display all songs");
            System.out.println("      8 for break");

            x = sc.nextInt(); // Read the user's choice

            // Handle the user's choice with a switch statement
            switch (x) {
                case 1:
                    System.out.println("----------- Add Song ----------");
                    System.out.println("Enter song name : ");
                    song = sc.next(); // Read the song name
                    mp.addSong(song); // Add the song to the music player
                    break;

                case 2:
                    System.out.println("----------- Delete Song ----------");
                    System.out.println("Enter song name : ");
                    song = sc.next(); // Read the song name
                    mp.deleteSong(song); // Delete the song from the music player
                    break;

                case 3:
                    mp.playSong(); // Play the current song
                    break;

                case 4:
                    mp.prevSong(); // Play the previous song
                    break;

                case 5:
                    mp.nextSong(); // Play the next song
                    break;

                case 6:
                    System.out.println("---------- Search Song ----------");
                    System.out.println("Enter song name : ");
                    song = sc.next(); // Read the song name
                    mp.searchSong(song); // Search for the song in the music player
                    break;

                case 7:
                    mp.display(); // Display all songs in the music player
                    break;

                default:
                    break; // Exit the loop if the user enters 8 or any other number greater than 7
            }
        }
    }
}

class MusicPlayer {
    MusicNode head; // Reference to the first node in the list
    MusicNode last; // Reference to the last node in the list
    MusicNode curr; // Reference to the current song being played

    public MusicPlayer() {
        head = last = curr = null; // Initialize the music player as empty
    }

    // Method to add a song to the music player
    public void addSong(String name) {
        MusicNode n = new MusicNode(name); // Create a new MusicNode with the song name
        if (head == null) { // If the list is empty, set head, last, and curr to the new node
            head = last = curr = n;
        } else { // Otherwise, add the new node to the end of the list
            last.next = n;
            n.prev = last;
            last = n;
        }
    }

    // Method to delete a song from the music player
    public void deleteSong(String name) {
        if (head == null) { // If the list is empty, print a message and return
            System.out.println("---------- Music Player is Empty ----------");
            return;
        }
        if (head.name.equals(name)) { // If the song to delete is the first node
            if (last == head) { // If there's only one node in the list, empty the list
                head = last = curr = null;
            } else { // Otherwise, remove the first node and update head
                head = head.next;
                head.prev = null;
            }
            return;
        }
        MusicNode prevNode = head; // Start from the first node
        MusicNode temp = prevNode.next;

        // Traverse the list to find the song to delete
        while (temp != null) {
            if (temp.name.equals(name)) {
                prevNode.next = temp.next; // Bypass the node to delete
                if (temp == last) { // If the node to delete is the last node
                    last = prevNode;
                    return;
                }
                prevNode.next.prev = temp.prev;
                return;
            }
            prevNode = temp; // Move to the next node
            temp = temp.next;
        }

        System.out.println("---------- Song Not Found ----------"); // Print a message if the song is not found
    }

    // Method to play the current song
    public void playSong() {
        if (head == null) { // If the list is empty, print a message and return
            System.out.println("---------- Can't play song because music player is empty ----------");
            return;
        }
        System.out.println("---------- Playing " + curr.name + " song ----------");
        // Determine the next and previous songs
        String nextSong = (curr.next == null) ? head.name : curr.next.name;
        String prevSong = (curr.prev == null) ? last.name : curr.prev.name;
        System.out.println("Previous Song : " + prevSong);
        System.out.println("Next Song : " + nextSong);
    }

    // Method to play the next song
    public void nextSong() {
        if (head == null) { // If the list is empty, print a message and return
            System.out.println("---------- Can't play song because music player is empty ----------");
            return;
        }
        if (curr == last) curr = head; // If the current song is the last, loop to the first song
        else curr = curr.next; // Otherwise, move to the next song
        System.out.println("---------- Playing " + curr.name + " song ----------");
        // Determine the next and previous songs
        String nextSong = (curr.next == null) ? head.name : curr.next.name;
        String prevSong = (curr.prev == null) ? last.name : curr.prev.name;
        System.out.println("Previous Song : " + prevSong);
        System.out.println("Next Song : " + nextSong);
    }

    // Method to play the previous song
    public void prevSong() {
        if (head == null) { // If the list is empty, print a message and return
            System.out.println("---------- Can't play song because music player is empty ----------");
            return;
        }
        if (curr == head) curr = last; // If the current song is the first, loop to the last song
        else curr = curr.prev; // Otherwise, move to the previous song
        System.out.println("---------- Playing " + curr.name + " song ----------");
        // Determine the next and previous songs
        String nextSong = (curr.next == null) ? head.name : curr.next.name;
        String prevSong = (curr.prev == null) ? last.name : curr.prev.name;
        System.out.println("Previous Song : " + prevSong);
        System.out.println("Next Song : " + nextSong);
    }

    // Method to search for a song by name
    public void searchSong(String name) {
        if (head == null) { // If the list is empty, print a message and return
            System.out.println("---------- Music player is Empty ----------");
            return;
        }
        MusicNode temp = head; // Start from the first node
        Scanner sc = new Scanner(System.in);
        // Traverse the list to find the song
        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println("---------- Song Found ----------");
                System.out.println("Enter 1 for play");
                int x = sc.nextInt();
                if (x == 1) {
                    curr = temp; // Set the current song to the found song and play it
                    playSong();
                }
                return;
            }
            temp = temp.next; // Move to the next node
        }
        System.out.println("---------- Song Not Found ----------"); // Print a message if the song is not found
    }

    // Method to display all songs in the music player
    public void display() {
        if (head == null) {
            System.out.println("---------- Music player is Empty ----------");
            return;
        }
        MusicNode temp = head; // Start from the first node
        System.out.println("---------- Display all songs ----------");
        // Traverse the list and print each song name
        while (temp != null) {
            System.out.println(temp.name);
            temp = temp.next;
        }
    }
}

class MusicNode {
    String name; // Song name
    MusicNode next; // Reference to the next node in the list
    MusicNode prev; // Reference to the previous node in the list

    public MusicNode() {
        this.name = "";
        this.next = null;
        this.prev = null;
    }

    public MusicNode(String name) {
        this();
        this.name = name;
    }
}
