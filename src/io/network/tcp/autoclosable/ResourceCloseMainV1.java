package io.network.tcp.autoclosable;

public class ResourceCloseMainV1 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = new ResourceV1("resource1");
        ResourceV1 resource2 = new ResourceV1("resource2");

        try {
            resource1.call();
            resource1.callEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }
        resource2.closeEx();
        resource1.closeEx();    // 바로 위에서 터지면 여기는 처리하지 않는 문제
    }
}
