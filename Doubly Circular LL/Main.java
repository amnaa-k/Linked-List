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
            newNode.Next = Head;
            newNode.Prev = Tail;
        }
        else
        {
            newNode.Next = Head;
            Head.Prev = newNode;
            Head  = newNode;
            Head.Prev = Tail;
            Tail.Next = Head;
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
            Head.Prev = newNode;
            Tail.Next = newNode;
        }
        else
        {
            newNode.Prev = Tail;
            Tail.Next = newNode;
            Tail = newNode;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
    }
    public void createNodeBTW(int found,int value)
    {
        Node newNode = new Node();
        newNode.data = value;
        Node Current = Head;
        if(isEmpty())
        {
           createNodeStart(value);
            return;
        }
        if( Head==Tail)
        {
            createNodeEnd(value);
            return;
        }
        while(Current.data != found)
        {
                Current = Current.Next;
        }
        if(Current.Next == Head)
        {
            createNodeEnd(value);
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
        System.out.print("->"+Current.data);
        Current = Current.Next;
        while(Current!=Head)
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
        System.out.print("->"+Current.data);
        Current = Current.Prev;
        while(Current!=Tail)
        {
            System.out.print("->"+Current.data);
            Current = Current.Prev;
        }
        System.out.println(" ");
       
    }
    public void deletefirst()
    {
        if(isEmpty())
        {
            System.out.println("list is emplty");
            return;
        }
        if(Head==Tail)
        {
            Head = null;
            Tail = null;
            System.out.println("List is Now Empty");
        }
        else if(Head.Next==Head.Prev)
        {
            Head = Head.Next;
            Tail.Prev = Head;
            Tail.Next = Head;
        }
        else
        {
            Head = Head.Next;
            Head.Prev = Tail;
            Tail.Next = Head;
        }
    }
}
public class Main
{
    public static void main(String[] args) {
        DLL list = new DLL();
        list.createNodeStart(1);
        list.createNodeStart(2);
        list.createNodeStart(3);
        list.DisplayLTOR();
    }
}