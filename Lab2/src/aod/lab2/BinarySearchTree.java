package aod.lab2;

/**
 * Ett binärt sökträd som lagrar värden av typen T
 * 
 * Själva sökträdet
 * 
 * @author Liam Bendiksen
 * @version 2026-04-20
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements Tree<T> {

    /**
     * Klassen för noden
     */
    private class BSTNode {
        private T item;
        private BSTNode left;
        private BSTNode right;

        /**
         * Skapar en ny nod med ett värde
         * 
         * @param item värdet som ska sparas
         */
        public BSTNode(T item) {
            this.item = item;
            left = null;
            right = null;
        }
    }

    private BSTNode root;
    private int size;

    /**
     * Skapar ett tomt binärt sökträd
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Lägger till ett värde i trädet
     * Ser till att dubbletter ignoreras
     * 
     * @param item värdet som ska läggas till
     */
    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item kan inte vara null.");
        }

        root = add(root, item);
    }

    private BSTNode add(BSTNode n, T item) {
        if (n == null) {
            size++;
            return new BSTNode(item);
        }

        int cmp = item.compareTo(n.item);

        if (cmp < 0) {
            n.left = add(n.left, item);
        } else if (cmp > 0) {
            n.right = add(n.right, item);
        }

        return n;
    }

    /**
     * Söker efter ett värde i trädet
     * 
     * @param item värdet som söks efter
     * @return true om värdet finns, annars returneras false
     */
    @Override
    public boolean searchFor(T item) {
        if (item == null) {
            return false;
        }

        return searchFor(root, item);
    }

    private boolean searchFor(BSTNode n, T item) {
        if (n == null) {
            return false;
        }

        int cmp = item.compareTo(n.item);

        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return searchFor(n.left, item);
        } else {
            return searchFor(n.right, item);
        }
    }

    /**
     * Returnerar antal element i trädet
     * 
     * @return trädets storlek
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Tömmer trädet på alla element
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Tar bort ett värde ur trädet
     * 
     * @param item värdet som ska tas bort
     * @return true om värdet togs bort, annars returneras false
     */
    @Override
    public boolean remove(T item) {
        if (item == null) {
            return false;
        }

        if (!searchFor(item)) {
            return false;
        }

        root = remove(root, item);
        size--;
        return true;
    }

    private BSTNode remove(BSTNode n, T item) {
        if (n == null) {
            return null;
        }

        int cmp = item.compareTo(n.item);

        if (cmp < 0) {
            n.left = remove(n.left, item);
        } else if (cmp > 0) {
            n.right = remove(n.right, item);
        } else {
            if (n.left == null && n.right == null) {
                return null;
            }

            if (n.left == null) {
                return n.right;
            }

            if (n.right == null) {
                return n.left;
            }

            BSTNode s = n.right;
            while (s.left != null) {
                s = s.left;
            }

            n.item = s.item;
            n.right = remove(n.right, s.item);
        }

        return n;
    }

    /**
     * Returnerar trädet i en sorterad ordning
     * 
     * @return trädet som text
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString().trim();
    }

    private void toString(BSTNode n, StringBuilder sb) {
        if (n != null) {
            toString(n.left, sb);
            sb.append(n.item).append(" ");
            toString(n.right, sb);
        }
    }
}