package aod.lab2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void testAddOneItem() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(5);

        assertEquals(1, t.size());
        assertTrue(t.searchFor(5));
    }

    @Test
    public void testAddDuplicate() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(5);
        t.add(5);

        assertEquals(1, t.size());
    }

    @Test
    public void testSearchFound() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(10);
        t.add(5);
        t.add(15);

        assertTrue(t.searchFor(15));
    }

    @Test
    public void testSearchNotFound() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(10);

        assertFalse(t.searchFor(99));
    }

    @Test
    public void testSizeEmpty() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();

        assertEquals(0, t.size());
    }

    @Test
    public void testSizeAfterAdd() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(1);
        t.add(2);
        t.add(3);

        assertEquals(3, t.size());
    }

    @Test
    public void testClearEmpty() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.clear();

        assertEquals(0, t.size());
    }

    @Test
    public void testClear() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(1);
        t.add(2);
        t.clear();

        assertEquals(0, t.size());
        assertFalse(t.searchFor(1));
    }

    @Test
    public void testRemoveExisting() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(10);
        t.add(5);

        assertTrue(t.remove(5));
        assertEquals(1, t.size());
    }

    @Test
    public void testRemoveMissing() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(10);

        assertFalse(t.remove(99));
        assertEquals(1, t.size());
    }

    @Test
    public void testToStringSorted() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.add(10);
        t.add(5);
        t.add(15);

        assertEquals("5 10 15", t.toString());
    }

    @Test
    public void testToStringEmpty() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();

        assertEquals("", t.toString());
    }
}