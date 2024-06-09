import java.util.Scanner;

public class Lab13_5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MusicPlayer mp = new MusicPlayer();
        int x = 1;

        String song;

        while(x < 8){
            System.out.println("Enter 1 for add song");
            System.out.println("      2 for deleter song");
            System.out.println("      3 for play song");
            System.out.println("      4 for play prev song");
            System.out.println("      5 for play next song");
            System.out.println("      6 for search song");
            System.out.println("      7 for display all song");
            System.out.println("      8 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("----------- Add Song ----------");
                    System.out.println("Enter song name : ");
                    song = sc.next();
                    mp.addSong(song);
                    break;

                case 2:
                    System.out.println("----------- Delete Song ----------");
                    System.out.println("Enter song name : ");
                    song = sc.next();
                    mp.deleteSong(song);
                    break;

                case 3:
                    mp.playSong();
                    break;
                
                case 4:
                    mp.prevSong();
                    break;

                case 5:
                    mp.nextSong();
                    break;

                case 6:
                    System.out.println("---------- Search Song ----------");
                    System.out.println("Enter song name : ");
                    song = sc.next();
                    mp.searchSong(song);
                    break;
                
                case 7:
                    mp.display();
                    break;
                
                default:
                    break;
            }
        }
    }
}

class MusicPlayer{
    MusicNode head;
    MusicNode last;
    MusicNode curr;

    public MusicPlayer(){
        head = last = curr = null;
    }

    public void addSong(String name){
        MusicNode n = new MusicNode(name);
        if(head == null){
            head = last = curr = n;
        }
        else{
            last.next = n;
            n.prev = last;
            last = n;
        }
    }

    public void deleteSong(String name){
        if(head == null){
            System.out.println("---------- Music Player is Empty ----------");
            return;
        }
        if(head.name.equals(name)){
            if(last == head){
                head = last = curr = null;
            }
            else{
                head = head.next;
                head.prev = null;
            }
            return;
        }
        MusicNode prevNode = head;
        MusicNode temp = prevNode.next;

        while(temp != null){
            if(temp.name.equals(name)){
                prevNode.next = temp.next;
                if(temp == last){
                    last = prevNode;
                    return;
                }
                prevNode.next.prev = temp.prev;
                return;
            }
            prevNode = temp;
            temp = temp.next;
        }

        System.out.println("---------- Song Not Found ----------");
    }

    public void playSong(){
        if(head == null){
            System.out.println("---------- Can't play song because music player is empty ----------");
            return;
        }
        System.out.println("---------- Playing "+curr.name+" song ----------");
        String nextSong = (curr.next == null) ? head.name : curr.next.name;
        String prevSong = (curr.prev == null) ? last.name : curr.prev.name;
        System.out.println("Previous Song : "+prevSong);
        System.out.println("Next Song : "+nextSong);
    }

    public void nextSong(){
        if(head == null){
            System.out.println("---------- Can't play song because music player is empty ----------");
            return;
        }
        if(curr == last) curr = head;
        else curr = curr.next;
        System.out.println("---------- Playing "+curr.name+" song ----------");
        String nextSong = (curr.next == null) ? head.name : curr.next.name;
        String prevSong = (curr.prev == null) ? last.name : curr.prev.name;
        System.out.println("Previous Song : "+prevSong);
        System.out.println("Next Song : "+nextSong);
    }

    public void prevSong(){
        if(head == null){
            System.out.println("---------- Can't play song because music player is empty ----------");
            return;
        }
        if(curr == head) curr = last;
        else curr = curr.prev;
        System.out.println("---------- Playing "+curr.name+" song ----------");
        String nextSong = (curr.next == null) ? head.name : curr.next.name;
        String prevSong = (curr.prev == null) ? last.name : curr.prev.name;
        System.out.println("Previous Song : "+prevSong);
        System.out.println("Next Song : "+nextSong);
    }

    public void searchSong(String name){
        if(head == null){
            System.out.println("---------- Music player is Empty ----------");
            return;
        }
        MusicNode temp = head;
        Scanner sc = new Scanner(System.in);
        while(temp != null){
            if(temp.name.equals(name)){
                System.out.println("---------- Song Found ----------");
                System.out.println("Enter 1 for play");
                int x = sc.nextInt();
                if(x == 1){
                    curr = temp;
                    playSong();
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("---------- Song Not Found ----------");
    }

    public void display(){
        if(head == null) {
            System.out.println("---------- Music player is Empty ----------");
            return;
        }
        MusicNode temp = head;
        System.out.println("---------- Display all songs ----------");
        while(temp != null){
            System.out.println(temp.name);
            temp = temp.next;
        }
    }
}

class MusicNode{
    String name;
    MusicNode next;
    MusicNode prev;

    public MusicNode(){
        this.name = "";
        this.next = null;
        this.prev = null;
    }

    public MusicNode(String name){
        this();
        this.name = name;
    }
}