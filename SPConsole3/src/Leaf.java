public class Leaf {
    String color;

    Leaf(String color) {
        this.color = color;
    }

    void turnYellow() {
        this.color = "желтый";
        System.out.println("Лист стал желтым.");
    }

    void frost() {
        System.out.println("Лист покрылся инеем.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return color.equals(leaf.color);
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

    @Override
    public String toString() {
        return "Лист{" +
                "цвет='" + color + '\'' +
                '}';
    }
}
