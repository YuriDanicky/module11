package module11;

public class Task5Object {
    int valueInt;
    String valueString;

    public Task5Object(int valueInt, String valueString) {
        this.valueInt = valueInt;
        this.valueString = valueString;
    }

    @Override
    public String toString() {
        return "Task5Object{" +
                "valueInt=" + valueInt +
                ", valueString='" + valueString + '\'' +
                '}';
    }
}
