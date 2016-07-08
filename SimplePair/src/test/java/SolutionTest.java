import org.junit.Assert;
import org.junit.Test;

/**
 * @author ricardoerikson
 *
 */
public class SolutionTest {

    @Test
    public void testNodeCreation() {
        Node node = new Node(1);
        Assert.assertEquals(1, node.label);
        Assert.assertNull(node.parent);
        Assert.assertTrue(node.children.isEmpty());
    }

    @Test
    public void testAddNode() {
        Node node = new Node(2);
        node.addChild(1);
        Assert.assertEquals(1, node.children.size());
        Assert.assertEquals(node.label, node.children.get(0).parent.label);
    }

    @Test
    public void testAddTwoNodes() {
        Node root = new Node(3);
        root.addChild(1);
        root.addChild(2);
        Assert.assertEquals(2, root.childrenCount());
    }

    public void testChangePrimitiveTypeValue() {
        class Tst {

            public int val;
            public Tst child;

            public Tst(Tst child, int val) {
                this.child = child;
                this.val = val;
            }
        }

        Tst tst3 = new Tst(null, 3);
        Tst tst2 = new Tst(tst3, 2);
        Tst tst1 = new Tst(tst2, 1);

    }

}
