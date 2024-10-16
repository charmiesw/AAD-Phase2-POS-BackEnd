package lk.ijse.springposbackend.util;

import java.util.Random;

public class AppUtil {
    public static String createOrderId(){
        return "O" + String.format("%05d", new Random().nextInt(10000));
    }
}
