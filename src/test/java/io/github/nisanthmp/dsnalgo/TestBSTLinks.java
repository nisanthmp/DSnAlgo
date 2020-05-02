package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBSTLinks {
    BSTLinks bstNoDup;
    BSTLinks bstYesDup;

    @BeforeEach
    void setup () {
        bstNoDup = new BSTLinks(false);
        bstNoDup.addElement(50);
        bstNoDup.addElement(25);
        bstNoDup.addElement(75);
        bstNoDup.addElement(12);
        bstNoDup.addElement(37);
        bstNoDup.addElement(62);
        bstNoDup.addElement(87);

        bstYesDup = new BSTLinks(true);
        bstYesDup.addElement(50);
        bstYesDup.addElement(25);
        bstYesDup.addElement(75);
        bstYesDup.addElement(12);
        bstYesDup.addElement(37);
        bstYesDup.addElement(62);
        bstYesDup.addElement(87);
    }

    @Test
    void testAddElement() {
        assertTrue(bstNoDup.addElement(0));
        assertTrue(bstNoDup.addElement(100));
        assertFalse(bstNoDup.addElement(50));
        assertFalse(bstNoDup.addElement(87));

        assertTrue(bstYesDup.addElement(0));
        assertTrue(bstYesDup.addElement(100));
        assertTrue(bstYesDup.addElement(50));
        assertTrue(bstYesDup.addElement(87));
        //bstNoDup.inOrderTraversal();
    }

    @Test
    void testFindElement() {
        assertEquals(((Integer)bstNoDup.findElement(50)).intValue(), 50);
        assertEquals(((Integer)bstNoDup.findElement(87)).intValue(), 87);

        assertEquals(bstNoDup.findElement(24), null);

        assertTrue(bstYesDup.addElement(50));
        assertTrue(bstYesDup.addElement(87));
        assertEquals(((Integer)bstYesDup.findElement(50)).intValue(), 50);
        assertEquals(((Integer)bstYesDup.findElement(87)).intValue(), 87);
        assertEquals(((Integer)bstYesDup.findElement(25)).intValue(), 25);

        assertEquals(bstYesDup.findElement(24), null);

    }

    @Test
    void testRemoveElement() {
        assertTrue(bstNoDup.removeElement(25));
        assertFalse(bstNoDup.removeElement(24));
        assertEquals(bstNoDup.findElement(25), null);
        assertTrue(bstNoDup.removeElement(50));
        assertEquals(bstNoDup.findElement(50), null);
        System.out.println("bstNoDup in order traversal: ");
        bstNoDup.inOrderTraversal();

        assertTrue(bstYesDup.addElement(50));
        assertTrue(bstYesDup.addElement(87));
        assertTrue(bstYesDup.removeElement(50));
        assertTrue(bstYesDup.removeElement(87));
        assertEquals(((Integer)bstYesDup.findElement(50)).intValue(), 50);
        assertEquals(((Integer)bstYesDup.findElement(87)).intValue(), 87);
        assertTrue(bstYesDup.removeElement(50));
        assertEquals(bstYesDup.findElement(50), null);
        System.out.println("bstYesDup in order traversal: ");
        bstYesDup.inOrderTraversal();

    }

    @Test
    void testInOrderTraversal() {
        System.out.println("bstNoDup in order traversal:" );
        bstNoDup.inOrderTraversal();

        bstYesDup.addElement(50);
        bstYesDup.addElement(87);
        System.out.println("bstYesDup in order traversal: ");
        bstYesDup.inOrderTraversal();

    }

    @Test
    void preOrderTraversal() {
    }

    @Test
    void postOrderTraversal() {
    }
}