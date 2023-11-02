package org.example.Reflection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static class Person {
        private String name;
        private int age;
        private String city;

        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        Class<?> personClass = Person.class;

        try {
            String className = personClass.getName();
            System.out.println("Class Name: " + className);

            Field[] fields = personClass.getDeclaredFields();
            System.out.println("Fields in the Person class:");
            for (Field field : fields) {
                String fieldName = field.getName();
                String fieldType = field.getType().getName();
                System.out.println("Field Name: " + fieldName + ", Field Type: " + fieldType);
            }

            Method[] methods = personClass.getDeclaredMethods();
            System.out.println("Methods in the Person class:");
            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());
            }
            Person person = new Person("John", 30, "New York");

            Method getNameMethod = personClass.getMethod("getName");

            String personName = (String) getNameMethod.invoke(person);
            System.out.println("Person's Name: " + personName);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
