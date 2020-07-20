import java.io.*;
import java.util.Arrays;

public class ReaderWriter {
    public static void main(String[] args) {
        //запись в файл
        try (Writer fw = new FileWriter(new File("text.txt"), false)) { //не дописывать в конец файла; в конструктор добавили дескриптор
            fw.write("Привет!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //чтение файла и вывод в консоль его содержимого
        try (Reader fr = new FileReader(new File("text.txt"))) {

            int v = 0;
            char buf[] = new char[100];
            int sz = 0;

            //чтение посимвольно
//            while ((v = fr.read()) != -1) {
//                System.out.print((char) v);
//            }

            //чтение в буффер
            while ((sz = fr.read(buf)) != -1) {
                System.out.println(buf);
                System.out.println(Arrays.copyOf(buf, sz)); //обрезает размер буффера до размера считанных символов (100 до 7)
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //на вход принимаем массив символов - считывание, вывод в консоль
        try (CharArrayReader charArrayReader = new CharArrayReader("Hello World".toCharArray())) {
            int v = 0;
            while ((v = charArrayReader.read()) != -1) {
                System.out.print((char) v);
            }
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //вывод
        try(CharArrayWriter writer = new CharArrayWriter()){
            writer.write("Hello");
            char[] chars = writer.toCharArray();
            System.out.println(new String(chars));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
