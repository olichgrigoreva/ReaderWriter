import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream("text3.txt"))) {
            pw.print("Последовательность от 1 до 100:\r\n"); // 13
            for(int i = 1; i <= 100; i++) {
                pw.print(i);
                if (i < 100) {
                    pw.print(',');
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
