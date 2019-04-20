package exercise.reflect_0420.factory;

public interface Fruit {
    void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃桔子");
    }
}
//工厂
class FruitFactory{
    private FruitFactory(){

    }
    public static Fruit getFruit(String classname){
        try {
            Class classz = Class.forName(classname);
            return (Fruit)classz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
