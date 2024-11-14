import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5, true, true)); 
        intervals.add(new Interval(3, 7, false, true)); 
        intervals.add(new Interval(8, 10, true, false));
        intervals.add(new Interval(12, 15, true, true)); 

        double maxDistance = 0;
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                double distance = Math.abs(intervals.get(i).getEnd() - intervals.get(j).getStart());
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }

        System.out.println("Расстояние между самыми удаленными концами: " + maxDistance);
    }
}
