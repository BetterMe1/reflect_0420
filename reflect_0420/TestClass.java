package exercise.reflect_0420;

import java.util.Date;
import java.lang.Class;
public class TestClass {
    //Class对象的获取
    public static void code1() {
        Date date = new Date();
        Class classz1 = date.getClass();
        Class classz2 = Date.class;
        try {
            Class classz3 = Class.forName("java.util.Date");//受查异常
            System.out.println("1."+classz1);
            System.out.println("2."+classz2);
            System.out.println("3."+classz3);
            System.out.println(classz1==classz2);//true
            System.out.println(classz1==classz3);//true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Class calssz = Date.class;
        //获取到Class对象可以访问Class类中定义的成员属性和方法
        //不获取Class对象，可以通过Class类获取静态属性和方法
        try {
            //通过类的Class对象的newInstance()方法可以实例化对象
            //局限：不能实例化没有无参构造方法的类的对象，如Integer,会出现NoSucMethodException
            Object object = calssz.newInstance();
            System.out.println(object);
            //Date date = (Date)object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
