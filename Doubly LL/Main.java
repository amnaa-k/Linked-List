class Node{
    int data;
    Node Next,Prev;
}
class DLL
{
    private Node Head,Tail;
    public DLL(){ Head = null; Tail=null;}
    public boolean isEmpty(){return Head==null;}
   
    public void createNodeStart(int value)
    {
        Node newNode = new Node();
        newNode.data = value;
       
        if(isEmpty())
        {
            Head = newNode;
            Tail = newNode;
            newNode.Prev = null;
            newNode.Next = null;
        }
        else
        {
            newNode.Next = Head;
            Head.Prev = newNode;
            Head  = newNode;
        }
    }
    public void createNodeEnd(int value)
    {
        Node newNode = new Node();
        newNode.data = value;
       
        if(isEmpty())
        {
            Head = newNode;
            Tail = newNode;
            newNode.Prev = null;
            newNode.Next = null;
        }
        else
        {
            newNode.Prev = Tail;
            Tail.Next = newNode;
            Tail = newNode;
        }
    }
    public void createNodeBTW(int found,int value)
    {
        Node newNode = new Node();
        newNode.data = value;
        Node Current = Head;
        if(isEmpty())
        {
            Head = newNode;
            Tail = newNode;
            newNode.Prev = null;
            newNode.Next = null;
            return;
        }
            while(Current.data != found)
            {
                Current = Current.Next;
            }
           
            if(Current==null)
            {
                System.out.println("Node not Found");
            }
            else
            {
                newNode.Prev = Current;
                newNode.Next = Current.Next;
                newNode.Prev.Next = newNode;
                newNode.Next.Prev = newNode;
            }
    }
    public void DisplayLTOR()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return;
        }
        Node Current = Head;
        while(Current!=null)
        {
            System.out.print("->"+Current.data);
            Current = Current.Next;
        }
        System.out.println(" ");
       
    }
    public void DisplayRTOL()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return;
        }
        Node Current = Tail;
        while(Current!=null)
        {
            System.out.print("->"+Current.data);
            Current = Current.Prev;
        }
        System.out.println(" ");
       
    }
}
public class Main
{
    public static void main(String[] args) {
        DLL list = new DLL();
        list.createNodeStart(10);
        list.createNodeStart(40);
        list.createNodeEnd(50);
        list.DisplayLTOR();
        
        list.createNodeBTW(10,20);
        list.DisplayLTOR();
       
    }
}