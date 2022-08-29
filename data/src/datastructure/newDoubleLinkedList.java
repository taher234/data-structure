package datastructure;

public class newDoubleLinkedList<T> {

    NodeDouble head;
    NodeDouble last;
    int length = 0;

    public newDoubleLinkedList() {
        head = last = null;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public T getFirst() {
        return (T) head.value;
    }

    public T getLast() {
        return (T) last.value;
    }

    public T get(int pos) {
        NodeDouble current = head;
        if (isEmpty() || pos < 1 || pos > length) {
        } else {
            if (length == 1) {
                return (T) head.value;
            } else if (length == pos) {
                return (T) last.value;
            } else {
                for (int i = 1; i < pos; i++) {
                    current = current.next;
                }
                if (current != null) {
                    return (T) current.value;
                }
            }
        }
        return null;
    }

    public void addFirst(Object val) {
        NodeDouble newNode = new NodeDouble(val);
        if (isEmpty()) {
            head = last = newNode;
            newNode.next = newNode.previous = null;
        } else {
            newNode.next = head;
            newNode.previous = null;
            head.previous = newNode;
            head = newNode;
        }
        length++;
    }

    public void addLast(Object val) {
        NodeDouble newNode = new NodeDouble(val);
        if (isEmpty()) {
            head = last = newNode;
            newNode.next = newNode.previous = null;
        } else {
            newNode.previous = last;
            newNode.next = null;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public boolean add(int pos, Object val) {
        NodeDouble newNode = new NodeDouble(val);
        if (isEmpty()) {
            head = last = newNode;
            newNode.next = newNode.previous = null;
        } else if (length == pos) {
            newNode.previous = last;
            newNode.next = null;
            last.next = newNode;
            last = newNode;
        } else {
            NodeDouble current = head;
            for (int i = 1; i < pos; i++) {
                if (current == null) {
                    return false;
                }
                current = current.next;
            }
            newNode.next = current.next;
            newNode.previous = current;
            current.next = newNode;
            current.next.previous = newNode;
        }
        length++;
        return true;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("linked is empty!");
        } else {
            if (length == 1) {
                head = last = null;
                head.next = head.previous = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            length--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("linked is empty!");
        } else {
            if (length == 1) {
                head = last = null;
                head.next = head.previous = null;
            } else {
                last = last.previous;
                last.next = null;
            }
            length--;
        }
    }

    public void remove(Object val) {
        if (isEmpty()) {
            System.out.println("linked is empty!");
        } else {
            if (length == 1) {
                head = last = null;
                head.next = head.previous = null;
                length--;
            } else {
                NodeDouble current = head.next;
                NodeDouble prev = head;
                while (current != null) {
                    if (current.value == val) {
                        break;
                    }
                    prev = current;
                    current = current.next;
                }
                if (current == null) {
                    System.out.println("value not found!");
                } else if (last == current) {
                    removeLast();
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    length--;
                }
            }
        }
    }

    public Boolean search(Object element) {
        NodeDouble current = head;
        while (current != null) {
            if (current.value == element) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            return false;
        } else {
            return true;
        }
    }

    public void reverse() {
        System.out.print("after reversing ");
        NodeDouble current, previous, nex;
        previous = null;
        current = head;
        nex = current.next;
        while (nex != null) {
            nex = current.next;
            current.next = previous;
            previous = current;
            current = nex;
        }
        head = previous;
    }

    public void display() {
        NodeDouble cur = head;
        System.out.print("Elements : ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("");
    }

}
