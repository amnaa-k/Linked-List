class Node {
    int data;
    Node Next;
}
class SLL {
    private Node Head;
    public SLL() {
        Head = null;
    }
    public boolean isEmpty() {
        return Head == null;
    }
    public void createNodeStart(int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (isEmpty()) {
            Head = newNode;
            newNode.Next = null;
        }
        else {
        newNode.Next = Head;
        Head = newNode;
    }}
    public void createNodeEnd(int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (isEmpty()) {
            Head = newNode;
            newNode.Next = null;
        }
        Node Current = Head;
        while (Current.Next != null) {
            Current = Current.Next;
        }
        Current.Next = newNode;
        newNode.Next = null;
    }
    public void createNodeBTW(int found, int value) {
        if (isEmpty()) {
            return;
        }
        Node newNode = new Node();
        newNode.data = value;
        Node Current = Head;
        while (Current.data != found) {
            Current = Current.Next;
        }
        newNode.Next = Current.Next;
        Current.Next = newNode;
    }
    public void display() {
        Node Current = Head;
        while (Current != null) {
            System.out.print(" -> " + Current.data);
            Current = Current.Next;
        }
        System.out.println();
    }
    public void deletefirst() {
        if (isEmpty()) {
            return;
        }
        Node Current = Head;
        Head = Head.Next;
        Current.Next = null;
    }
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        Node Current = Head;
        while (Current.Next.Next != null) {
            Current = Current.Next;
        }
        Current.Next = null;
    }
    public void deleteBTW(int found) {
        if (isEmpty()) {
            return;
        }
        Node Current = Head;
        while (Current.Next.data != found) { //20
            Current = Current.Next;
        }
        Current.Next = Current.Next.Next;
    }
    public void replaceNode(int found, int value) {
        if (isEmpty()) {
            return;
        }
        Node Current = Head;
        while (Current.data != found) {
            Current = Current.Next;
        }
        Current.data = value;
    }
}
class Main {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.createNodeStart(10);
        list.createNodeStart(20);
        list.createNodeStart(30);
        list.display();
        list.createNodeEnd(0);
        list.display();
        list.createNodeBTW(20, 25);
        list.display();
        list.deletefirst();
        list.display();
        list.deleteLast();
        list.display();
        list.createNodeStart(22);
        list.createNodeStart(23);
        list.display();
        list.deleteBTW(20);
        list.display();
        list.replaceNode(22, 500);
        list.display(); 
    }
}