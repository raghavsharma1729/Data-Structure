public class LinkedList {
    Node head;
    private int size;
    Node tail;

    LinkedList(int value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.size = 1;
    }

    public int length() {
        return size;
    }

    public void add(int value) {
        Node node = new Node(value);
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public boolean addAt(int position, int value) {
        if (position == 1) {
            insertNodeAtHead(value);
            return true;
        }
        Node currentHead = head;
        int currentPos = 1;
        while(currentHead != null) {
            if(currentPos == position - 1) {
                break;
            }
            currentPos++;
            currentHead = currentHead.next;
        }
        if(currentHead == null) {
            return false;
        }
        Node newNode = new Node(value);
        Node temp = currentHead.next != null ? currentHead.next.next : null;
        currentHead.next = newNode;
        newNode.next = temp;
        return true;

        //else if (position > this.size) {
        //    this.add(value);
        //    return true;
        //}
        //Node node = findNodeBy(position - 1);
        //if (node == null) {
        //    return false;
        //}
        //insertNode(value, node);
        //return true;
        //
        //if (position == 1) {
        //    insertNodeAtHead(value);
        //    return true;
        //} else if (position > this.size) {
        //    this.add(value);
        //    return true;
        //}
        //Node node = findNodeBy(position - 1);
        //if (node == null) {
        //    return false;
        //}
        //insertNode(value, node);
        //return true;
    }

    public boolean replaceAt(int position, int value) {
        Node currentNode = findNodeBy(position);
        if (currentNode == null) {
            return false;
        }
        currentNode.value = value;
        return true;
    }

    private Node findNodeBy(int position) {
        if (position <= 0 && position > this.size) {
            return null;
        }
        Node currentNode = this.head;
        int i = 1;
        while (currentNode != null) {
            if (position == i) {
                break;
            }
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }

    private void insertNode(int value, Node prevNode) {
        Node temp = prevNode.next;
        Node newNode = new Node(value);
        prevNode.next = newNode;
        newNode.next = temp;
        if (newNode.next == null) {
            this.tail = newNode;
        }
        this.size++;
    }

    private void insertNodeAtHead(int value) {
        Node newHead = new Node(value);
        newHead.next = this.head;
        this.head = newHead;
        this.size++;
    }

    public boolean addAfterNode(int key, int value) {
        Node currentNode = findNodeByValue(key);
        if (currentNode == null) {
            return false;
        }
        insertNode(value, currentNode);
        return true;
    }

    private Node findNodeByValue(int key) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == key) {
                break;
            }
            //if (currentNode.next == null) {
            //    return null;
            //} not needed
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public boolean replaceByValue(int key, int value) {
        Node currentNode = findNodeByValue(key);
        if (currentNode == null) {
            return false;
        }
        currentNode.value = value;
        return false;
    }

    public boolean deleteAt(int position){
        if(position==1){
            this.head=head.next;
            this.size--;
            return true;
        }
        Node prevNode= findNodeBy(position-1);
        if(prevNode==null || prevNode.next==null){
            return  false;
        }
        prevNode.next= prevNode.next.next;
        if(prevNode.next==null){
            this.tail=prevNode;
        }
        this.size--;
        return true;
    }

    public boolean deleteValue(int value){
        //extra Node added behind head
        Node temp = new Node(-1);
        temp.next = head;
        while(temp.next != null) {
            if(temp.next.value == value) {
                break;
            }
            temp=temp.next;
        }
        if(temp == null) {
            return false;
        }
        if(temp.next == head) {
            head = head.next;
            return true;
        }
        temp.next = temp.next.next;
        return true;
        //if(this.head.value==value){
        //    this.head=this.head.next;
        //    this.size--;
        //    return true;
        //}
        //Node prevNode = findPreviousNodeOf(value);
        //if(prevNode==null){
        //    return false;
        //}
        //prevNode.next= prevNode.next.next;
        //this.size--;
        //if(prevNode.next==null){
        //    this.tail=prevNode;
        //}
        //return false;
    }

    private Node findPreviousNodeOf(int key){

        Node currentNode = this.head;
        while(currentNode != null && currentNode.next != null) {//second condition is for when head is pointing to null already
            if(currentNode.next.value == key)
                break;
            currentNode = currentNode.next;
        }
        return currentNode;
        //Node currentNode = this.head;
        //while (currentNode != null) {
        //    if (currentNode.next.value == key) {
        //        break;
        //    }
        //    if (currentNode.next == null) {
        //        return null;
        //    }
        //    currentNode = currentNode.next;
        //}
        //return currentNode;
    }

    public void print() {
        Node temp;
        temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.addAt(6, 7);
        list.addAt(1, 11);
        list.addAt(2, 12);
        //list.addAfterNode(12, 21);
        //list.addAfterNode(11, 111);
        //list.addAfterNode(23, 1212);
        //list.replaceByValue(10,101);
        //list.addAfterNode(7,49);
        //list.replaceAt(5,0);
        //list.deleteAt(1);
        //list.deleteAt(10);
        //list.deleteAt(8);
        list.deleteValue(11);
        //list.deleteValue(12);
        list.deleteValue(7);

        list.print();
        System.out.println("Size = " + list.length());
        System.out.println("Head = " + list.head.value);
        System.out.println("Tail = " + list.tail.value);
    }

}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        next = null;
    }
}