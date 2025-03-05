package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "userA", 20);
        System.out.println("user.getName() = " + user.getName());

        Class<? extends User> userClass = user.getClass();
        Field nameField = userClass.getDeclaredField("name");

        // IllegalAccessException을 피하기 위해 private 필드에 접근 허용
        nameField.setAccessible(true);
        nameField.set(user, "userB");
        System.out.println("user.getName() = " + user.getName());
    }
}
