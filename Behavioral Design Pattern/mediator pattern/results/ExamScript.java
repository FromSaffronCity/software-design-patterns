package results;

public class ExamScript {
    private int examinerID;
    private int examineeID;
    private int scriptMarks;
    private int reexaminationStatus;  // status = 1(not done), 2(done, marks unchanged), 3(marks increased), 4(marks decreased)

    public ExamScript(int examinerID, int examineeID, int scriptMarks) {
        this.examinerID = examinerID;
        this.examineeID = examineeID;
        this.scriptMarks = scriptMarks;

        reexaminationStatus = 1;  // NOTICE
    }

    public int getExaminerID() {
        return examinerID;
    }

    public int getExamineeID() {
        return examineeID;
    }

    public void setScirptMarks(int scriptMarks) {
        this.scriptMarks = scriptMarks;
        return ;
    }

    public int getScriptMarks() {
        return scriptMarks;
    }

    public void setReexaminationStatus(int reexaminationStatus) {
        this.reexaminationStatus = reexaminationStatus;
        return ;
    }

    public int getReexaminationStatus() {
        return reexaminationStatus;
    }

    /* additional */
    public String toString() {
        return "examinee with id "+examineeID+" got "+scriptMarks;
    }
}
