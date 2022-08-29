package datastructure;

public class newLinkedQueue<T> {

    Node front;
    Node rear;
    int length;

    public newLinkedQueue() {
        this.front = this.rear = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(Object val) {
        Node nNode = new Node(val);
        if (isEmpty()) {
            this.front=this.rear=nNode;
        } else {
            this.rear.next=nNode;
            this.rear=nNode;
        }
        length++;
    }
    public T dequeue() {
        Node temp =front;
        if (isEmpty()||this.front==null) {
            this.rear=null;
            return null;
        } else {
            this.front=this.front.next;
            length--;
        }
        return (T)temp.value;
    }
    public void clear() {
        this.rear=this.front=null;
    }
    public void display() {
        Node current = front;
        System.out.print("Element : ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
