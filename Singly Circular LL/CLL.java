class Node {
    int data;
    Node Next;
    //calling of constructor to initialize data for class Node
    public Node(int d) {
        this.data = d;
        this.Next = null;
    }
}
class CLL {
    private Node First;
    public CLL() {
        this.First = null;
    }
    public boolean isEmpty() {
        return First == null;
    }

    public void createFirstNode(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
/* 
Empty Link List -> newNode will be the First Node & the addition of a newNode after will become the First one
 */
            First = newNode;
            newNode.Next = First;
//^newNode.Next = First points to the same Node, thus, maintaining the Circular Linked List Structure
            return;
        }
        Node Current = First;
        while (Current.Next != First) {
            Current = Current.Next;
        }
        //after finding last node of list, create new node
        newNode.Next = First;
        First = newNode;
        Current.Next = First;
    }
    public void createLastNode(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            First = newNode;
            newNode.Next = First;
            return;
        }
        Node Current = First;
        while (Current.Next != First) {
            Current = Current.Next;
        }
        Current.Next = newNode;
        newNode.Next = First;
    }
    public void insertBetween(int found, int insert) {
        if (isEmpty()) {
            return;
        }
        Node Current = First;
        while (Current.data != found) {
            Current = Current.Next;
            if (Current == First) {
                return;
            }
        }
        Node newNode = new Node(insert);
        newNode.Next = Current.Next;
        Current.Next = newNode;
    }
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        Node Current = First;
        while (Current.Next != First) {
            Current = Current.Next;
        }
        First = First.Next;
        Current.Next = First;
    }
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        Node Current = First;
        while (Current.Next.Next != First) {
            Current = Current.Next;
        }
        Current.Next = First;
    }
    public void deleteBTW(int found) {
        Node Current = First;
        while (Current.Next.data != found) {
            Current = Current.Next;
        }
        Current.Next= Current.Next.Next;
    }
    public void updateNode(int found, int replace) {
        if (isEmpty()) {
            return;
        }
        Node Current = First;
        while (Current.data != found) {
            Current = Current.Next;
        }
        Current.data = replace;
    }
    public void displayNode() {
        System.out.println("DISPLAYING LIST:");
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node Current = First;
        System.out.print(" -> " + Current.data);
        Current = Current.Next;
        while (Current != First) {
            System.out.print(" -> " + Current.data);
            Current = Current.Next;
        }
        System.out.println();
    }
}
class Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        CLL list2 = new CLL();
        list.createFirstNode(10);
        //list.displayNode();
        list.createFirstNode(20);
        list.createFirstNode(30);
        //list.displayNode();

        list.insertBetween(30, 15);
        list.displayNode();
        list.insertBetween(333, 34);
        list.displayNode();
        list.deleteFirst();
        list.displayNode();

        list2.createFirstNode(1);
        list2.createFirstNode(2);
        list2.createFirstNode(3);
        list2.createFirstNode(4);
        list2.createFirstNode(5);
        list2.createFirstNode(6);
        list2.displayNode();
        list2.deleteBTW(3);
        list2.displayNode();

        list2.updateNode(6, 7);
        list2.displayNode();
    }
}