import java.util.ArrayList;
import java.util.List;

public class Tree {
     List<Branch> branches;

    Tree() {
        branches = new ArrayList<>();
    }

    void addBranch(Branch branch) {
        branches.add(branch);
    }

    void bloom() {
        System.out.println("Дерево зацвело.");
    }

    void shedLeaves() {
        branches.forEach(Branch::shedLeaves);
        System.out.println("Дерево сбросило листья.");
    }

    void frost() {
        branches.forEach(Branch::frost);
        System.out.println("Дерево покрылось инеем.");
    }

    void turnYellow() {
        branches.forEach(Branch::turnYellow);
        System.out.println("Листья дерева пожелтели.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return branches.equals(tree.branches);
    }

    @Override
    public int hashCode() {
        return branches.hashCode();
    }

    @Override
    public String toString() {
        return "Дерево{" +
                "ветки=" + branches +
                '}';
    }
}
