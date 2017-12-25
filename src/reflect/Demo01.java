package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Demo01 {
    public static void main(String args[]) throws Throwable {
        //获取class方式一：
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflect.Student");
        //获取class方式二：
        Class clazz2 = Student.class;
        //获取class方式三：
        Class clazz3 = Class.forName("reflect.Student");
        //获取class方式四：
        Student stu = new Student();
        Class clazz4 = stu.getClass();

        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Student student = (Student)cons.newInstance();

        Method setId = clazz.getMethod("setStudentId",int.class);
        setId.invoke(student,1);

        Method setName = clazz.getMethod("setStudentName",String.class);
        setName.invoke(student,"Lily");

        Method setAge = clazz.getMethod("setStudentAge",int.class);
        setAge.invoke(student,22);

        Method setSex = clazz.getMethod("setStudentSex",String.class);
        setSex.invoke(student,"female");

        System.out.println(student);

        System.out.println("=========student类中的方法==========");
        Method m[] = clazz.getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            System.out.println("修饰符："+Modifier.toString(m[i].getModifiers()));
            System.out.println("返回值类型："+m[i].getReturnType().getSimpleName());
            System.out.println("方法名："+m[i].getName());
            Class<?>[] parameterTypes = m[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println("传入参数类型："+parameterTypes[j].getSimpleName());
            }
            System.out.println("\t");
        }
        System.out.println("=========student类中的构造函数========");
        Constructor[] constructors = clazz.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
        }
        System.out.println("=========student类中的成员变量========");
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("修饰符："+Modifier.toString(fields[i].getModifiers()));
            System.out.println("方法类型："+fields[i].getType().getSimpleName());
            System.out.println("成员变量："+fields[i].getName());
            System.out.println("\t");
        }

    }
}
