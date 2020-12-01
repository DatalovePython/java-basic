package standard.stream;

/**
 * @author luzc
 * @date 2020/11/30 10:42
 * @desc
 */
public class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String name;
    private int score;

    public Student(){

    }

    public Student(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }

    //setter和getter省略

    @Override
    public String toString() {
        return "[姓名=" + name + ", 分数=" + score + "]";
    }
}
