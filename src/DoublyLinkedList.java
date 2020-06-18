public class DoublyLinkedList {
    Node head;
    Node tail;

    public static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean add(int value) {
        Node node = new Node(value);
        if (head == null) {
            this.head = node;
            this.tail = head;
            return true;
        }
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
        return true;
    }

    public boolean addAtHead(int value) {
        Node newNode = new Node(value); // new node with value 21
        if (this.head == null) {
            this.head = newNode;
        }
        newNode.next = this.head; // node.next = current head
        this.head.prev = newNode; // head.prev = new node
        this.head = newNode; //update head to new node
        return true;
    }

    public boolean addAfter(int value, int newNodeValue) {
        Node newNode = new Node(newNodeValue);
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                break;
            }
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            return false;
        } else if (currentNode.next == null) {
            currentNode.next = newNode;
            newNode.prev = currentNode;
            return true;
        }
        Node nextNode = currentNode.next;
        currentNode.next = newNode;
        nextNode.prev = newNode;
        newNode.next = nextNode;
        newNode.prev = currentNode;
        return true;
    }

    public boolean addBefore(int value, int newNodeValue) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                break;
            }
            currentNode = currentNode.next;
        }
        Node newNode = new Node(newNodeValue);
        if (currentNode == null) {
            return false;
        } else if (currentNode.prev == null) {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            return true;
        }
        Node prevNode = currentNode.prev;
        prevNode.next = newNode;
        currentNode.prev = newNode;
        newNode.next = currentNode;
        newNode.prev = prevNode;
        return true;
    }

    public boolean remove(int value) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                break;
            }
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            return false;
        } else if (currentNode.prev == null) {
            this.head = currentNode.next;
            if(this.head==null){
                return true;
            }
            this.head.prev = null;
            return true;
        } else if (currentNode.next == null) {
            Node prevNode = currentNode.prev;
            prevNode.next = null;
            return true;
        }
        Node prevNode = currentNode.prev;
        Node nextNode = currentNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        return true;
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean clear(){
        if(this.head==null){
            return false;
        }
        this.head = null;
        return  true;
    }

    public int length() {
        Node currentNode = this.head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(1729);
        list.addAtHead(19);
        list.addAfter(19, 12);
        list.addBefore(1729, 10);
        System.gc();
        //list.remove(1);
        //list.remove(19);
        //list.remove(12);
        //list.remove(10);
        //list.remove(1729);
        list.clear();
        int size = list.length();
        list.print();
        System.out.println("Size: " + size );
        Runtime.getRuntime().gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }
}
