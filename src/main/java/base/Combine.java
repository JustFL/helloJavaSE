package base;

/**
 * 描述局部和整体的关系
 * 将局部作为整体的成员变量
 * @author summerKiss
 *
 */

class Engine{
    public void start() {
        System.out.println("engine start");
    }
    public void stop() {
        System.out.println("engine stop");
    }
}
class Wheel{
    public void inflate(int volume) {
        System.out.println("volume:"+volume);
    }
}
class Window{
    public void roolup() {
        System.out.println("roolup");
    }
    public void rooldown() {
        System.out.println("rooldown");
    }
}
class Door{
    public Window w = new Window();
    public void open() {
        System.out.println("open");
    }
    public void close() {
        System.out.println("close");
    }
}
class Car {
    Engine engine = null;
    Wheel[] wheels = new Wheel[4];
    Door[] doors = new Door[2];
    Car(){
        engine = new Engine();
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel();
        }
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door();
        }
    }
}

public class Combine {
    public static void main(String[] args) {
        Car car = new Car();
        for (int i = 0; i < car.wheels.length; i++) {
            car.wheels[i].inflate(i+100);
        }
        car.doors[0].w.roolup();
        car.doors[1].w.rooldown();
        car.doors[0].open();
        car.doors[1].close();
        car.engine.start();
    }
}
