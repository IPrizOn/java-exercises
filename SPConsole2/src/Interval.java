public class Interval {
    private double start;
    private double end;
    private boolean includeStart;
    private boolean includeEnd;

    public Interval(double start, double end, boolean includeStart, boolean includeEnd) {
        this.start = start;
        this.end = end;
        this.includeStart = includeStart;
        this.includeEnd = includeEnd;
    }

    public Interval intersection(Interval other) {
        if (this.overlaps(other)) {
            double newStart = Math.max(this.getStart(), other.getStart());
            double newEnd = Math.min(this.getEnd(), other.getEnd());
            boolean newIncludeStart = (newStart == this.getStart() && this.includeStart) || (newStart == other.getStart() && other.includeStart);
            boolean newIncludeEnd = (newEnd == this.getEnd() && this.includeEnd) || (newEnd == other.getEnd() && other.includeEnd);
            return new Interval(newStart, newEnd, newIncludeStart, newIncludeEnd);
        } else {
            return null; 
        }
    }
    
    public Interval union(Interval other) {
        if (this.overlaps(other)) {
            double newStart = Math.min(this.getStart(), other.getStart());
            double newEnd = Math.max(this.getEnd(), other.getEnd());
            boolean newIncludeStart = (newStart == this.getStart() && this.includeStart) || (newStart == other.getStart() && other.includeStart);
            boolean newIncludeEnd = (newEnd == this.getEnd() && this.includeEnd) || (newEnd == other.getEnd() && other.includeEnd);
            return new Interval(newStart, newEnd, newIncludeStart, newIncludeEnd);
        } else {
            return null; 
        }
    }

    public boolean overlaps(Interval other) {
        if (this.includeStart && this.includeEnd && other.includeStart && other.includeEnd) {
            return (this.start <= other.end && other.start <= this.end);
        } else if (this.includeStart && this.includeEnd) {
            return (this.start <= other.end && other.start < this.end) || (this.start < other.end && other.start <= this.end);
        } else if (other.includeStart && other.includeEnd) {
            return (this.start < other.end && other.start <= this.end) || (this.start <= other.end && other.start < this.end);
        } else {
            return (this.start < other.end && other.start < this.end);
        }
    }

    public Interval add(double value) {
        return new Interval(this.start + value, this.end + value, this.includeStart, this.includeEnd);
    }

    public Interval subtract(double value) {
        return new Interval(this.start - value, this.end - value, this.includeStart, this.includeEnd);
    }

    public Interval multiply(double value) {
        if (value >= 0) {
            return new Interval(this.start * value, this.end * value, this.includeStart, this.includeEnd);
        } else {
            return new Interval(this.end * value, this.start * value, this.includeEnd, this.includeStart);
        }
    }

    public Interval divide(double value) {
        if (value != 0) {
            return new Interval(this.start / value, this.end / value, this.includeStart, this.includeEnd);
        } else {
            throw new ArithmeticException("Деление на ноль");
        }
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public boolean isIncludeStart() {
        return includeStart;
    }

    public boolean isIncludeEnd() {
        return includeEnd;
    }
}
