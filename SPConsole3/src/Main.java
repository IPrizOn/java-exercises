public class Main {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        Branch branch1 = new Branch();
        Branch branch2 = new Branch();
        branch1.addLeaf(new Leaf("зеленый"));
        branch1.addLeaf(new Leaf("зеленый"));
        branch2.addLeaf(new Leaf("зеленый"));
        tree.addBranch(branch1);
        tree.addBranch(branch2);
        tree.bloom();
        tree.shedLeaves();
        tree.frost();
        tree.turnYellow();
    }
}
