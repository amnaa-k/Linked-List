class Node
{
    int data;
    Node Next;
   
    public Node(int d)
    {
        this.data = d;
        this.Next = null;
    }
}
class CLL{
    private Node First;
    public CLL(){First = null;}
    public boolean isEmpty(){return First == null;}
   
    public void createNodeFirst(int value)
    {
        Node newNode = new Node(value);
        if(isEmpty())
        {
            First = newNode;
            newNode.Next = First;
            return;
        }
        Node Current = First;
        while(Current.Next != First)
        {
            Current = Current.Next;
        }
        newNode.Next = First;
        First = newNode;
        Current.Next = First;
       
    }
      public void createNodeLast(int value)
    {
        Node newNode = new Node(value);
        if(isEmpty())
        {
            First = newNode;
            newNode.Next = First;
            return;
        }
        Node Current = First;
        while(Current.Next != First)
        {
            Current = Current.Next;
        }
       Current.Next = newNode;
       newNode.Next = First;
       
    }
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return;
        }
        Node Current = First;
        System.out.print("->"+Current.data);
        Current = Current.Next;
        while(Current != First)
        {
            System.out.print("->"+Current.data);
            Current = Current.Next;
        }
        System.out.println("\n");
    }
}
class Main
{
    public static void main(String[] args) {
        CLL list = new CLL();
        list.createNodeFirst(14);
        list.createNodeFirst(12);
        list.createNodeFirst(15);
        list.createNodeFirst(17);
        list.display();
       
       
       
    }
}