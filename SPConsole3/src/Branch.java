import java.util.ArrayList;
import java.util.List;

public class Branch {
    List<Leaf> leaves;

    Branch() {
        leaves = new ArrayList<>();
    }

    void addLeaf(Leaf leaf) {
        leaves.add(leaf);
    }

    void shedLeaves() {
        leaves.clear();
        System.out.println("Ветка сбросила листья.");
    }

    void frost() {
        leaves.forEach(Leaf::frost);
        System.out.println("Ветка покрылась инеем.");
    }

    void turnYellow() {
        leaves.forEach(Leaf::turnYellow);
        System.out.println("Листья ветки пожелтели.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return leaves.equals(branch.leaves);
    }

    @Override
    public int hashCode() {
        return leaves.hashCode();
    }

    @Override
    public String toString() {
        return "Ветка{" +
                "листья=" + leaves +
                '}';
    }
}
