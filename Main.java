class Node{
    int val;
    Node next;
    
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
class Main {
    Node head;
    //===========================================================
    // Insertion Operations
    //===========================================================
    //insert at head
    public void insertAtHead(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    //insert at end
    public void insertAtTail(int val){
        Node newNode = new Node(val);
        
        // if head is tail
        if(head == null){
            head = newNode;
            return;
        }
        
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    //===========================================================
    // Deletion Operations
    //===========================================================
    // Delete at head
    public void deleteAtHead(){
        if(head == null){
            return;
        }
        head = head.next;
    }
    // Delete at tail
    public void deleteAtTail(){
        if(head == null){
            return;
        }
        
        if(head.next == null){
            head = null;
            return;
        }
        
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    //===========================================================
    // Searching in linkedlist
    //===========================================================
    public boolean search(int tar){
        Node temp = head;
        while(temp != null){
            if(temp.val == tar){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    //===========================================================
    // Length of linkedlist
    //===========================================================
    public int lengthOfLL(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    //===========================================================
    // Insert At Position
    //===========================================================
    public void insertAtPosition(int val, int pos){
        if(pos <= 0){
            return head;
        }
        if(pos == 1){
            insertAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for(int i=1;i<pos-1 && temp != null ;i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Pos out of  bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    //===========================================================
    
    //===========================================================
    // Delete by value
    //===========================================================
    public void deleteByValue(int key){
        if(head == null){
            return;
        }
        if(head.val == key){
            head = head.next;
            return;
        }
        Node temp = head;
        while(temp.next != null && temp.next.val != key){
            temp = temp.next;
        }
        if(temp.next != null){
            temp.next = temp.next.next;
        }else{
            System.out.println("Value not found");
        }
    }
    //===========================================================
    // Printing linkedlist
    //===========================================================
    // print LL
    public void display(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.print("Tail");
    }
    //===========================================================
    // Main method
    //===========================================================
    public static void main(String[] args) {
        Main list = new Main();
        list.insertAtHead(5); // end
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1); // head
        list.display();
        System.out.println();
        System.out.println();
        
        list.deleteAtHead();
        list.display();
        System.out.println();
        System.out.println();
        
        list.deleteAtTail();
        list.display();
        System.out.println();
        System.out.println();
        
        System.out.println("Searching for 3 "+ list.search(3));
        System.out.println();
        System.out.println("Length of LL "+list.lengthOfLL());
        System.out.println();
        
        list.insertAtPosition(1,1);
        list.display();
        System.out.println();
        System.out.println();
        
        list.deleteByValue(3);
        list.display();
        System.out.println();
        System.out.println();
    }
}
