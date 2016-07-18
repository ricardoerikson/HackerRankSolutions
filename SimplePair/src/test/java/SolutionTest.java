import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author ricardoerikson
 *
 */
public class SolutionTest {

    @Test
    public void testNodeCreation() {
	Node node = new Node(1);
	assertThat(node.label, is(1));
	assertThat(node.parent, is(nullValue()));
	assertThat(node.children, is(empty()));
    }

    @Test
    public void testAddNode() {
	Node node = new Node(2);
	node.addChild(1);
	assertThat(node.children, hasSize(1));
	assertThat(node.children.get(0).parent.label, is(node.label));
    }

    @Test
    public void testAddTwoNodes() {
	Node root = new Node(3);
	root.addChild(1);
	root.addChild(2);
	assertThat(root.childrenCount(), is(2));
    }

}
