import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BinaryTools {

    public static String constructString(byte[] b) {
        return new String(b);
    }

    public static int constructInt32(byte[] b) {
        ByteBuffer wrapped = ByteBuffer.wrap(b);
        wrapped.order(ByteOrder.LITTLE_ENDIAN);
        return wrapped.getInt();
    }
}
