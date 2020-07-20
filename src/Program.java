import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Program {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String hw = "hello!";
        print(hw.getBytes("koi8-r"));
        print(hw.getBytes("windows-1251"));

        Charset charset = Charset.forName("koi8-r"); //указание кодировки через объект
        print(hw.getBytes(charset));


        //доступные кодировки в системе
        for(Charset cs: Charset.availableCharsets().values()){
            System.out.println(cs);
        }
    }

    private static void print(byte[] bytes) {
        for(int i = 0; i < bytes.length; i++) {
            System.out.print(asBinary(bytes[i]) + " ");
        }
        System.out.println();
    }

    static String asBinary(int v) {
        return String.format("%8s",Integer.toBinaryString(v & 0xFF)).replace(' ', '0');
    }
}
