package Lesson1.homework;

public class Robot implements runningTrack, wall{

    private int runDistance = 300;
    private int jumpHeight = 3;

    @Override
    public Object getRunDistance(int value) {
        runDistance -= value;
        if(runDistance <= 0) {
            System.out.println("Робот дальше больше не может");
            return 0;
        }
        System.out.println("Роботу осталось бежать " + runDistance + " метров");
        return runDistance;
    }

    @Override
    public Object getJumpHeight(int value) {
        jumpHeight -= value;
        if(jumpHeight <= 0) {
            System.out.println("Робот не может прыгнуть на высоту " + value);
            return 0;
        }
        System.out.println("Робот прыгнул на " + value + " метр");
        return jumpHeight;
    }
}
