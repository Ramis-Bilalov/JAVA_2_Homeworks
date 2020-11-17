package Lesson1.homework;

public class Human implements runningTrack, wall{

    private int runDistance = 100;
    private int jumpHeight = 1;

    @Override
    public Object getRunDistance(int value) {
        runDistance -= value;
        if(runDistance <= 0) {
            System.out.println("Человек дальше больше не может");
            return 0;
        }
        else {
            System.out.println("Человеку осталось бежать " + runDistance + " метров");
            return runDistance;
        }
    }

    @Override
    public Object getJumpHeight(int value) {
        jumpHeight -= value;
        if(jumpHeight < 0) {
            System.out.println("Человек не может прыгнуть на высоту " + value);
            return 0;
        }
        else System.out.println("Человек прыгнул на " + value + " метр");
        return jumpHeight;
    }
}
