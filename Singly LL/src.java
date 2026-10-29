class Node
{
    int data;
    Node Next;
}
class LinkedLink
{
    private Node Head;
   
    public LinkedLink(){ Head = null;}
    public boolean isEmpty(){ return Head==null;}
   
    public void createNode(int value)
    {
        Node newNode = new Node();
        newNode.data = value;
       
        if(isEmpty())
        {
            Head = newNode;
            newNode.Next = null;
        }
        else
        {
            newNode.Next = Head;
            Head = newNode;
        }
    }
    public void createNodeLast(int value)
    {
        Node newNode = new Node();
        newNode.data = value;
       
        if(isEmpty())
        {
            Head = newNode;
            newNode.Next = null;
        }
        else
        {
            Node Current = Head;
            while(Current.Next != null)
            {
                Current = Current.Next;
            }
            Current.Next = newNode;
            newNode.Next  = null;
        }
    }
   
    public void Display()
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
        System.out.println("\n");
    }
    public void deletefirst()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return;
        }
        Node Current  = Head;
        Head = Head.Next;
        Current.Next = null;
    }
    public void deletelast()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return;
        }
        Node Current  = Head;
       
        while(Current.Next.Next != null)
        {
            Current = Current.Next;
        }
        Current.Next = null;
    }
    public void update(int found,int replace)
    {
        Node Current = Head;
       
        while(Current !=null && Current.data != found)
        {
            Current = Current.Next;
        }
        if(Current==null)
        {
            System.out.println("List Is Empty");
        }
        else{
            Current.data = replace;
        }
    }
}
class Main
{
    public static void main(String[] args) {
        LinkedLink list = new LinkedLink();
        list.createNode(5);
        list.createNode(7);
        list.createNode(11);
        list.Display();
        list.createNodeLast(15);
        list.createNodeLast(19);
        list.Display();
        list.deletefirst();
        list.Display();
        list.deletelast();
        list.Display();
        list.update(15,50);
        list.Display();
    }
}