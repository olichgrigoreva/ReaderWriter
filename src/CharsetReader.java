import java.io.*;
import java.util.Arrays;

public class CharsetReader {
    public static void main(String[] args) {
        try (Writer osw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("text2.txt")))) {
            osw.write("Привет мир!");
            osw.write("Досвидания!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("text2.txt")))) {
            int v = 0;
            char buf[] = new char[100];
            int sz = 0;
            reader.skip(11);
            reader.mark(100);
            while ((sz = reader.read(buf)) != -1) {
                System.out.println(Arrays.copyOf(buf, sz));
            }
            reader.reset();
            while ((sz = reader.read(buf)) != -1) {
                System.out.println(Arrays.copyOf(buf, sz));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
