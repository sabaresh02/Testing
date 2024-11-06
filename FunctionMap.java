public class FunctionMap {


    public static Integer a = FunctionMap.setA();
    public static Integer b =FunctionMap.setB();

    public static int setA(){
        System.out.println(b);
        return 3;
    }
    public static int setB(){
        System.out.println(a);
        FunctionMap.setA();
        return 9;
    }


    public void sayHello() {
        System.out.println("Hello!");
    }

    public void sayGoodbye() {
        System.out.println("Goodbye!");
    }

    public void greetPerson(String name) {
        System.out.println("Hello, " + name);
    }
}
