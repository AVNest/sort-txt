import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {


    public static String[] readFiles(String file_name) {

        List<String> lines = new ArrayList<String>();

        try(FileReader reader = new FileReader(file_name)){

            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            System.out.println(file_name);
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
