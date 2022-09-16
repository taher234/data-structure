package datastructure;

public class bst {

    treeNode root;

    public bst() {
        this.root = null;
    }

    boolean treeEmpty() {
        return root == null;
    }

    void Inorder(treeNode pt) {
        if (pt != null) {
            Inorder(pt.left);
            System.out.print(pt.value + " ");
            Inorder(pt.right);
        }
    }

    void preorder(treeNode pt) {
        if (pt != null) {
            System.out.print(pt.value + " ");
            preorder(pt.left);
            preorder(pt.right);
        }
    }

    void postorder(treeNode pt) {
        if (pt != null) {
            postorder(pt.left);
            postorder(pt.right);
            System.out.print(pt.value + " ");
        }
    }

    void clearTree() {
        if (root != null) {
            root = null;
        }
    }

    void insertTree(treeNode neNode, treeNode pt) {
        if (treeEmpty()) {
            root = neNode;
            root.value = neNode.value;
            root.left = root.right = null;
        } else if (neNode.value > pt.value) {
            if (pt.right == null) {
                pt.right = neNode;
            } else {
                insertTree(neNode, pt.right);
            }
        } else {
            if (pt.left == null) {
                pt.left = neNode;
            } else {
                insertTree(neNode, pt.left);
            }
        }
    }

    int treeSize(treeNode pt) {
        if (pt != null) {
            return (1 + treeSize(pt.left) + treeSize(pt.right));
        }
        return 0;
    }

    int treeDepth(treeNode pt) {
        if (pt != null) {
            int a = treeDepth(pt.left);
            int b = treeDepth(pt.right);
            return a > b ? a + 1 : b + 1;
        }
        return 0;
    }

    int searchItem(int key, treeNode pt) {
        if (root == null || pt == null) {
            return 0;
        } else if (key == pt.value) {
            return key;
        } else if (key > pt.value) {
            return searchItem(key, pt.right);
        } else {
            return searchItem(key, pt.left);
        }
    }

    int DeleteItem(int key, treeNode pt) {
        treeNode prev = pt, curr = pt;
        boolean isLeft = false;
        while (curr.value != key || curr == null) {
            prev = curr;
            if (key < curr.value) {
                curr = curr.left;
                isLeft = true;
            } else {
                curr = curr.right;
                isLeft = false;
            }
        }
        if (curr == null || pt == null) {
            return 0;
        }
        if (curr.left == null && curr.right == null) {//first case(current haven't children)
            if (isLeft) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        } else if (curr.left == null) {//second case (current have child)
            if (isLeft) {
                prev.left = curr.right;
            } else {
                prev.right = curr.right;
            }
        } else if (curr.right == null) {//second case (current have child)
            if (isLeft) {
                prev.left = curr.left;
            } else {
                prev.right = curr.left;
            }
        } else {//first case(current have two children)
            treeNode q = curr, r;
            q = curr.left;
            if (q.right == null) {
                curr.value = q.value;
                curr.left = q.left;
            } else {
                do {
                    r = q;
                    q = q.right;
                } while (q.right != null);
                curr.value=q.value;
                r.right=q.left;
            }
        }
        return 0;
    }

    public int getMin(treeNode pt) {
        int minv = pt.value;
        while (pt.left != null) {
            minv = pt.left.value;
            pt = pt.left;
        }
        return minv;
    }

    public int getMax(treeNode pt) {
        if (pt != null) {
            return Math.max(pt.value, getMax(pt.right));
        }
        return 0;
    }

}
