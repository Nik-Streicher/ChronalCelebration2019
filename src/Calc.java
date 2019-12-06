import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Calc {


    private String dir = "D:\\Test";
    private File file = new File(dir + "\\" + "One" + ".txt");
    private ArrayList<Double> array = new ArrayList<>();

    private void fill(BufferedReader reader) throws IOException {
        String s;
        while ((s = reader.readLine()) != null) {
            array.add(Double.parseDouble(s));
        }
    }

    void calc() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            fill(reader);
            System.out.println(array.stream().map(value -> value / 3).map(Math::floor).mapToInt(value -> (int) (value - 2)).sum());
        } catch (Exception e) {
            System.err.println("Read ERROR");
        }


    }
}
