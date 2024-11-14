public class Main {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        Branch branch1 = new Branch();
        Branch branch2 = new Branch();

        try {
            branch1.addLeaf(new Leaf("зеленый"));
            branch1.addLeaf(new Leaf("жёлтый"));
            branch2.addLeaf(new Leaf(""));

            tree.addBranch(branch1);
            tree.addBranch(branch2);
            tree.bloom();
            tree.shedLeaves();
            tree.frost();
            tree.turnYellow();
        }
        catch (InvalidFieldValueException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println(tree);
    }
}
