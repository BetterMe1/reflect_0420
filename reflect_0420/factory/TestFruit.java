package exercise.reflect_0420.factory;

public class TestFruit {
    public static void main(String[] args) {
        /*Fruit fruit = FruitFactory.getFruit("exercise.reflect_0420.factory.Apple");
        if(fruit != null){
            fruit.eat();//吃苹果
        }else {
            System.out.println("FruitFactory 创建Fruit对象失败");
        }*/
        Fruit fruit = FruitFactory.getFruit("exercise.reflect_0420.factory.Orange");
        if(fruit != null){
            fruit.eat();//吃桔子
        }else {
            System.out.println("FruitFactory 创建Fruit对象失败");
        }
    }
}


