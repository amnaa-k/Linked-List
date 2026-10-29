class Node {
    int data;
    Node Next, Prev;
}
class DLL {
    private Node Head, Tail;
    public DLL() {
        Head = null;
        Tail = null;
    }
    public boolean isEmpty() {
        return Head == null;
    }
    public void createNodeStart(int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (isEmpty()) {
            Head = newNode;
            Tail = newNode;
            newNode.Prev = null;
            newNode.Next = null;
        }
        else {
        newNode.Next = Head;
        Head.Prev = newNode;
        Head = newNode;
    }}
    public void createNodeEnd(int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (isEmpty()) {
            Head = newNode;
            Tail = newNode;
            newNode.Next = null;
            newNode.Prev = null;
        }
        else {
            newNode.Prev = Tail;
            Tail.Next = newNode;
            Tail = newNode;
        }
    } 
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        else {
            Node Current = Head;
            while (Current.Prev != null) {
                Current = Current.Next;
            }
            Head = Head.Next;
            Head.Prev = null;
        }
    }
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        else {
            Node Current = Tail;
            while (Current.Next != null) {
                Current = Current.Next;
            }
            Tail = Tail.Prev;
            Tail.Next = null;
        }
    }
    public void displayLTOR() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node Current = Head;
        while (Current != null) {
            System.out.print(" -> " + Current.data);
            Current = Current.Next;
        }
        System.out.println();
    }
    public void displayRTOL() {
        if (isEmpty()) {
            return;
        }
        Node Current = Tail;
        while (Current != null) {
            System.out.print(" -> " + Current.data);
            Current = Current.Prev;
        }
        System.out.println();
    }
    public void createNodeBTW(int found, int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (isEmpty()) {
            Head = newNode;
            Tail = newNode;
            newNode.Prev = null;
            newNode.Next = null;
            return;
        }
        Node Current = Head;
        while (Current.data != found) {
            Current = Current.Next;
        }
        if (Current == null) {
            System.out.println("Node Invalid.");
        }
        else {
        newNode.Prev = Current;
        newNode.Next = Current.Next;
        newNode.Prev.Next = newNode;
        newNode.Next.Prev = newNode;
    }}
    public void replaceNode(int found, int value) {
        Node Current = Head;
        while (Current.data != found) {
            Current = Current.Next;
        }
        Current.data = value;
    }
}
class Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.createNodeStart(1);
        list.createNodeStart(2);
        list.createNodeStart(3);
        list.displayLTOR();
        list.displayRTOL();
        list.deleteFirst();
        list.displayLTOR();
        list.createNodeEnd(22);
        list.createNodeEnd(23);
        list.displayLTOR();
        list.deleteLast();
        list.displayLTOR();
        list.createNodeBTW(1, 33232);
        list.displayLTOR();
        list.replaceNode(2, 19);
        list.displayLTOR();
    }
} 