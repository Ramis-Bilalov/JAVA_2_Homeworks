package Lesson1.homework;

public class Test {

    private static int runValue = 50;
    private static int jumpValue = 1;

    public static void main(String[] args) {
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();
        int[] courseArray = {runValue, jumpValue};


        Object h = human.getRunDistance(courseArray[0]);
        if(!h.equals(0)) {
            human.getJumpHeight(courseArray[1]);
        }

        System.out.println();

        Object c = cat.getRunDistance(courseArray[0]);
        if(!c.equals(0)) {
            cat.getJumpHeight(courseArray[1]);
        }

        System.out.println();

        Object r = robot.getRunDistance(courseArray[0]);
        if(!r.equals(0)) {
            robot.getJumpHeight(courseArray[1]);
        }

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
