class Employee {
    int ID, Age;
    String Name, Email;
}
class Department {
    int ID;
    String Name;
}
class Company {
    Employee emp;
    Department dpt;
}
class Node {
    Company cmp;
    Node Next;
}
class CLL {
    private Node First;
    public CLL() {
        this.First = null;
    }
    public boolean isEmpty() {
        return First == null;
    }
    public void createFirstNode(Company c) {
        Node newNode = new Node();
        newNode.cmp = c;
        if (isEmpty()) {
            First = newNode;
            newNode.Next = First;
            return;
        }
        Node Current = First;
        while (Current.Next != First) {
            Current = Current.Next;
        }
        newNode.Next = First;
        First = newNode;
        Current.Next = First;
    }
    public void createLastNode(Company c) {
        Node newNode = new Node();
        newNode.cmp = c;
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
    public void createNodeBetween(Company f, Company v) {
        if (isEmpty()) {
            return;
        }
        Node Current = First;
        while (Current.cmp != f) {
            Current = Current.Next;
        }
        Node newNode = new Node();
        newNode.cmp = v;
        newNode.Next = Current.Next;
        Current.Next = newNode;
    }
    public void displayEmployeeDetails() {
        System.out.println("Displaying Linked List:");
        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }
        System.out.println("Employee Details: ");
        Node Current = First;
        System.out.print(" -> [ " + Current.cmp.emp.Name + ", " + Current.cmp.emp.Email + ", " + Current.cmp.emp.Age + ", " + Current.cmp.emp.ID + " ]");
        Current = Current.Next;
        while (Current != First) {
            System.out.print("-> [ " + Current.cmp.emp.Name + ", " + Current.cmp.emp.Email + ", " + Current.cmp.emp.Age + ", " + Current.cmp.emp.ID + " ]");
            Current = Current.Next;
        }
        System.out.println(); }
    public void displayDPT() {
        System.out.println("Department Details: ");
        Node Current = First;
        System.out.print(" -> [ " + Current.cmp.dpt.Name + ", " + Current.cmp.dpt.ID + " ]");
        Current = Current.Next;
        while (Current != First) {
            System.out.print(" -> [ " + Current.cmp.dpt.Name + ", " + Current.cmp.dpt.ID + " ]");
            Current = Current.Next;
        }
        System.out.println();
    }
}
class Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        Employee e1 = new Employee();
        e1.ID = 1;
        e1.Name = "Amna";
        e1.Age = 19;
        e1.Email = "amnakhan@gmail.com";
        Department d1 = new Department();
        d1.ID = 101;
        d1.Name = "BSCS";
        Company c1 = new Company();
        c1.dpt = d1;
        c1.emp = e1;
        Employee e2 = new Employee();
        e2.ID = 2;
        e2.Name = "Maryam Kazi";
        e2.Age = 22;
        e2.Email = "maryamkazi@gmail.com";
        Department d2 = new Department();
        d2.ID = 201;
        d2.Name = "IT";
        Company c2 = new Company();
        c2.dpt = d2;
        c2.emp = e2;
        Employee e3 = new Employee();
        e3.Age = 20;
        e3.Name = "Humna Arshad";
        e3.ID = 3;
        e3.Email = "humnaarshad@gmail.com";
        Department d3 = new Department();
        d3.ID = 102;
        d3.Name = "BEME";
        Company c3 = new Company();
        c3.dpt = d3;
        c3.emp = e3;
        list.createFirstNode(c1);
        list.createFirstNode(c2);
        list.createFirstNode(c3);

        list.displayEmployeeDetails();
        list.displayDPT();
        list.createNodeBetween(c2, c3);
        list.displayEmployeeDetails();
        list.displayDPT();
    }
}