import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadWriteFile {
    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("text3.txt"));
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("text4.txt"))) {
            int v = 0;
            while ((v = isr.read()) != -1) {
                osw.write(v);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
