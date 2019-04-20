package exercise.reflect_0420;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestClassPart1 {
    public static void code1(){
        //获取类的包名
        Class classz = Message.class;
        Package pg = classz.getPackage();
        System.out.println(pg.getName());//exercise.reflect_0420
        System.out.println(pg.toString());//package exercise.reflect_0420

        //获取类的名称
        //包名+类名=类的全限定名
        System.out.println(classz.getName());//exercise.reflect_0420.Message
        //类名
        System.out.println(classz.getSimpleName());//Message
        //extends 直接父类，返回父类的对象，一个，单继承
        Class superClass = classz.getSuperclass();;
        System.out.println("父类名称"+superClass.getName());//父类名称java.lang.Object
        System.out.println("父类包名"+superClass.getPackage().getName());//父类包名java.lang

        //implements
        Class[] interfacesClass = classz.getInterfaces();
        for(Class cls : interfacesClass){
            System.out.println("接口名称"+cls.getName());
        }
    }
    public static void main(String[] args) {
      Class classz =  Message.class;
      //获取Class的所有构造方法
        Constructor[] constructors = classz.getConstructors();
        for(Constructor constructor : constructors){
            //1.遍历数组，通过StringBuffer拼接
            //2.Arrays.toString()
            Class[] parameterTypes = constructor.getParameterTypes();
            String parameters = Arrays.toString(parameterTypes);
            System.out.println(constructor.getName()+"("+parameters+")");
            //exercise.reflect_0420.Message([])
            //exercise.reflect_0420.Message([class java.lang.String, class java.lang.Integer])
            //exercise.reflect_0420.Message([class java.lang.Integer, class java.lang.String])
        }

        //获取指定的构造方法
        try {
            //public exercise.reflect_0420.Message(java.lang.String,java.lang.Integer)
            Constructor constructor = classz.getConstructor(String.class,Integer.class);
            System.out.println(constructor);

            //通过构造方法对象获取实例化对象
            Object object = constructor.newInstance("张三",15);
//            System.out.println(object);
//            System.out.println(object.getClass());
            Message message =(Message)object;
            System.out.println(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

interface IMessage{

}
interface OperatorSystem{

}
class Message implements IMessage,OperatorSystem{
    private String name;
    private Integer age;
    //重载构造方法
    public Message(){

    }
    public Message(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    public Message(Integer age,String name){
        this(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}