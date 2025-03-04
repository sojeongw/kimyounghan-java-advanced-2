package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BasicData helloInstance = new BasicData();
        helloInstance.call();   // 정적 메서드 호출

        // 동적 메서드 호출
        Class<? extends BasicData> helloClass = helloInstance.getClass();
        String methodName = "hello";
        // 껍데기만 불러왔을 뿐 어떤 인스턴스에 있는진 알 수 없다.
        Method method1 = helloClass.getDeclaredMethod(methodName, String.class);
        // 호출할 인스턴스와 파라미터를 넘긴다.
        Object returnValue = method1.invoke(helloInstance, "hi");
        System.out.println("returnValue = " + returnValue);
    }
}
