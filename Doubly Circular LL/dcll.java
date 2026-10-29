class Node {
    int data;
    Node Next, Prev;
}
class DCLL {
    private Node Head, Tail;
    public DCLL() {
        this.Head = null;
        this.Tail = null;
    }
    public boolean isEmpty() {
        return Head == null;
    }
    public void createFirstNode(int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (isEmpty()) {
            Head = newNode;
            Tail = newNode;
            Head.Prev = newNode;
            Tail.Next = newNode;
        }
        else {
            newNode.Next = Head;
            Head.Prev = newNode;
            Head = newNode;
            Head.Prev = Tail;
            Tail.Next = Head;
        }}
        public void createNodeEnd(int value) {
            Node newNode = new Node();
            newNode.data = value;
            if (isEmpty()) {
                Head = newNode;
                Tail = newNode;
                Head.Prev = newNode;
                Tail.Next = newNode;
            }
            else {
                newNode.Prev = Tail;
                Tail.Next = newNode;
                Tail = newNode;
                Tail.Next = Head;
                Head.Prev = Tail;
        }}
        public void insertBTW(int found, int value) {
            Node newNode = new Node();
            newNode.data = value;
            if (isEmpty()) {
                createFirstNode(value);
                return;
            }
            if (Head == Tail) {
                createNodeEnd(value);
                return;
            }
            Node Current = Head;
            while (Current.data != found) {
                Current = Current.Next;
            }
            newNode.Prev = Current;
            newNode.Next = Current.Next;
            newNode.Prev.Next = newNode;
            newNode.Next.Prev = newNode;
        }
        public void DisplayLTOR() {
            Node Current = Head;
            System.out.print(" -> [ "+ Current.data + " ] ");
            Current = Current.Next;
            while (Current != Head) {
                System.out.print(" -> [ "+ Current.data + " ] ");
                Current = Current.Next;
            }
            System.out.println();
        }
        public void displayRTOL() {
            Node Current = Tail;
            System.out.print(" -> [ " + Current.data + " ] ");
            Current = Current.Prev;
            while (Current != Tail) {
                System.out.print(" -> [ " + Current.data + " ] ");
                Current = Current.Prev;
            }
            System.out.println();
        }
        public void deletefirst() {
            if (isEmpty()) {
                return;
            }
            if (Head == Tail) {
                Head = null;
                Tail = null;
            }
            else {
                Head = Head.Next;
                Tail.Prev = Head;
                Tail.Next = Head;
            }
        }
        public void deletelastt() {
            if (isEmpty()) {
                return;
            }
            if (Head.Next == Tail.Next) {
                Head = null; Tail = null;
            }
            else {
                Tail = Tail.Prev;
                Tail.Next = Head;
                Head.Prev = Tail;
            }
        }
    }
class Main { 
    public static void main(String[] args) {
        DCLL list = new DCLL();
        list.createFirstNode(1);
        list.createFirstNode(2);
        list.createFirstNode(3);
        list.createNodeEnd(0);
        list.DisplayLTOR();
        list.insertBTW(2, 22);
        list.DisplayLTOR();
        list.displayRTOL();
        list.deletefirst();
        list.DisplayLTOR();
        list.deletelastt();
        list.DisplayLTOR();
    }
}
