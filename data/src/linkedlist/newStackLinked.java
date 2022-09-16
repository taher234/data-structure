package datastructure;

public class newStackLinked<T> {

    Node stackTop;
    int length;

    public newStackLinked() {
        stackTop = null;
        length = 0;
    }

    public Boolean isEmpty() {
        return stackTop == null && length == 0;
    }

    public int getLength() {
        return length;
    }

    public void push(Object val) {
        Node newN = new Node(val);
        newN.next = stackTop;
        stackTop = newN;
        length++;
    }

    public T getTop() {
        return (T) stackTop.value;
    }

    public T pop() {
        Node Temp = stackTop;
        if (isEmpty()) {
            return null;
        } else {
            stackTop = stackTop.next;
            length--;
        }
        return (T) Temp.value;
    }

    public void display() {
        Node current = stackTop;
        System.out.print("Element : ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
