package pub2504.grade;

public class PFGradePolicy implements GradePolicy {
    @Override
    public String getGrade(int score) {
        return score >= 70 ? "P" : "F";
    }
}