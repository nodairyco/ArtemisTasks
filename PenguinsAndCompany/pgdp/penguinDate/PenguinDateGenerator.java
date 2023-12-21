package pgdp.penguinDate;

import pgdp.tree.Node;
import pgdp.tree.Tree;

public class PenguinDateGenerator {

    private Tree<Penguin> tree;

    public PenguinDateGenerator(Tree<Penguin> tree) {
        this.tree = tree;
    }

    public boolean canGoOnADate(Penguin p1, Penguin p2) {
       // TODO
        Penguin LCA = tree.LCA(p1,p2);
        return p1.getAllowance() < tree.distanceBetweenNodes(LCA, p1);
    }

    public Tree<Penguin> getTree() {
        return this.tree;
    }
}
