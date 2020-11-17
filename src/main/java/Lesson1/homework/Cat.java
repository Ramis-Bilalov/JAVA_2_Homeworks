package Lesson1.homework;

public class Cat implements runningTrack, wall{

    private int runDistance = 200;
    private int jumpHeight = 2;

    @Override
    public Object getRunDistance(int value) {
        runDistance -= value;
        if(runDistance <= 0) {
            System.out.println("Кошка дальше больше не может");
            return 0;
        }
        else System.out.println("Кошке осталось бежать " + runDistance + " метров");
        return runDistance;
    }

    @Override
    public Object getJumpHeight(int value) {
        jumpHeight -= value;
        if(jumpHeight <= 0) {
            System.out.println("Кошка не может прыгнуть на высоту " + value);
            return 0;
        }
        else System.out.println("Кошка прыгнула на " + value + " метр");
        return jumpHeight;
    }
}
