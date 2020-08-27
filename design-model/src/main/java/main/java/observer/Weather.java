package main.java.observer;

/**
 * @author luzc
 * @date 2020/7/28 13:45
 * @desc 其实java中提供了Observable类和Observer接口供我们快速的实现该模式，但是为了加深印象，我们不使用这两个类。
 */
public class Weather {
    private String description;

    public Weather(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                '}';
    }
}
