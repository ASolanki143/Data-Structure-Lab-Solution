public class CreateLL{
    public static void main(String[] args) {
        
    }
}

class LinkedList{
    Node head;

    public LinkedList(){
        head = null;
    }

    public void insert(int element){
        Node n = new Node(element);
        if(head == null){
            head = n;
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = n;
    }

    public void display(){
        if(head == null){
            System.out.println("---------- Empty LinkedList ----------");
            return;
        }

        Node temp = head;

        while(temp.next != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println(temp.data);
        System.out.println();
    }

    public int countNode(){
        if(head == null) return 0;
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class Node{
    int data;
    Node next;

    public Node(){
        next = null;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node(int data , Node next){
        this.data = data;
        this.next = next;
    }
}