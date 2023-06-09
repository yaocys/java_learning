package to_object;

/**
 * @author yao 2022/12/22
 */
class B{
    public B(){
        System.out.println("B对象被初始化！");
    }
}

class C extends B{
    public C(){
        System.out.println("C对象被初始化！");
    }
}
public class Test {
    public static void main(String[] args) {
        B b = new C();
        System.out.println("===============");
        C c = new C();
    }
}
