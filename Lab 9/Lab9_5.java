import java.util.Scanner;

// Main class
public class Lab9_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input size
        System.out.println("Enter input size : ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline left by nextInt()
        
        // Prompt user for input separated by space
        System.out.println("Enter input separated by space : ");
        String input = sc.nextLine();

        // Split input by space into an array of strings
        String[] inputs = input.split(" ");
        
        // Display each element of inputs array
        for(String str : inputs)
            System.out.println(str);
        
        // Create an object of Peacock class
        Peacock p = new Peacock(n);

        // Process each input string
        for(int i = 0 ; i < inputs.length ; i++){
            if(inputs[i].indexOf("buy") > -1){
                // Extract color from input string
                String color = inputs[i].substring(inputs[i].indexOf("_")+1);
                // Call buyCloth method of Peacock class
                p.buyCloth(color);
            }
            else{
                // Call fetch method of Peacock class
                String color = p.fetch();
                System.out.println("---------- "+color+" -----------");
            }
        }
        
        p.display();
        sc.close();  // Close scanner object
    }
}

// Peacock class to manage a queue of clothes
class Peacock {
    String[] arr;   // Array to store clothes colors
    int front;      // Front pointer of the queue
    int rear;       // Rear pointer of the queue
    int size;       // Maximum size of the queue

    // Constructor to initialize the Peacock queue
    public Peacock(int size){
        this.size = size;           // Set maximum size
        this.arr = new String[size];// Create array with given size
        this.front = this.rear = -1; // Initialize pointers
    }

    // Method to add a cloth color to the queue
    public void buyCloth(String color){
        rear++;                    // Move rear pointer to next position
        if(rear >= size){          // Check for queue overflow
            System.out.println("---------- Queue Overflow ----------");
            return;
        }
        arr[rear] = color;         // Add color at rear pointer
        if(front == -1){           // Adjust front pointer if it's the first element
            front = 0;
        }
    }

    // Method to fetch and remove a cloth color from the queue
    public String fetch(){
        if(front == -1){           // Check for queue underflow
            System.out.println("---------- Queue is Empty ----------");
            return "";
        }
        String color = arr[front]; // Get color at front pointer
        int j = front;
        while(j < rear){           // Shift elements to the left to fill gap
            arr[j] = arr[j+1];
            j++;
        }
        arr[j] = color;            // Set last position to the fetched color
        return color;              // Return fetched color
    }

    public void display(){
        for(int i = rear ; i >= front ; i--){
            System.out.println(arr[i] + " ");
        }
    }
}
