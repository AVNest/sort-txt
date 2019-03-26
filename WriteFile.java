import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {


    public static void write(String file_name, String[] out){
        try(FileWriter writer = new FileWriter(file_name, false))
        {
            String lineSeparator = System.getProperty("line.separator");
            for(int i = 0; i < out.length; i++){
                writer.append(out[i]);

                writer.append(lineSeparator);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
