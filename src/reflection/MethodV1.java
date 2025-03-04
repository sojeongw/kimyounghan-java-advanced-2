package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        // public인 나와 부모의 메서드
        System.out.println("====== methods() =====");
        Method[] methods = helloClass.getMethods();

        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        // 내가 선언한 모든 메서드
        System.out.println("====== declaredMethods() =====");
        Method[] declaredMethods = helloClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            System.out.println("declaredMethod = " + method);
        }
    }
}
