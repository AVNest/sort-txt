import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static String mode = "-d";
    public static String datatype = "-i";
    public static String OutName;
    public static String[] inName;

    public static void main(String[] args){

        // проверка нуливого индекса
        if(args.length < 3){
            System.out.println("Wrong input data");
            System.exit(0);
        }
        boolean modeFlag = false;  // begin flag rejim Down
        switch (args[0]){
            case "-d":
                mode = args[0];
                modeFlag = true;   // flag true UP
                break;
            case "-a":
                mode = args[0];
                modeFlag = true;
                break;
            case "-i":
                datatype = args[0];
                break;
            case "-s":
                datatype = args[0];
                break;
            default: System.out.println("Wrong input log");
                System.exit(0);
        }

        if(modeFlag){
            switch (args[1]){
                case "-i":
                    datatype = args[1];
                    break;
                case "-s":
                    datatype = args[1];
                    break;
                default: System.out.println("Wrong input log");
                    System.exit(0);
            }

            OutName = args[2];

            int len = args.length - 3;
            int k = 0;
            inName = new String[len];
            for(int i = 3; i < args.length; i++){
                inName[k] = args[i];
                k++;
            }
        }else{
            OutName = args[1];

            int len = args.length - 2;
            int k = 0;
            inName = new String[len];
            for(int i = 2; i < args.length; i++){
                inName[k] = args[i];
                k++;
            }
        }

        System.out.println("Mode: " + mode);
        System.out.println("Data Type: " + datatype);
        System.out.println("Out file: " + OutName);
        System.out.println("Input files: " + Arrays.toString(inName));

        List<Object> outMas = new ArrayList<Object>();
        for(int i = 0; i < inName.length; i++){

            String[] tmp = ReadFile.readFiles(inName[i]);

            if(mode.equals("-a") && datatype.equals("-i")){
                int[] temp = new int[tmp.length];
                for(int j = 0; j < tmp.length; j++){
                    temp[j] = Integer.parseInt(tmp[j].trim());
                }
                temp = MergeSort.asort(temp);
                for(int j = 0; j < temp.length; j++){
                    outMas.add(temp[j]);
                }

                System.out.println(Arrays.toString(temp));

            } else if(mode.equals("-d") && datatype.equals("-i")){
                int[] temp = new int[tmp.length];
                for(int j = 0; j < tmp.length; j++){
                    temp[j] = Integer.parseInt(tmp[j].trim());
                }
                temp = MergeSort.sort(temp);
                for(int j = 0; j < temp.length; j++){
                    outMas.add(temp[j]);
                }
                System.out.println(Arrays.toString(temp));
            }else if(mode.equals("-a") && datatype.equals("-s")){
                String[] temp = new String[tmp.length];
                temp = MergeSort.string_asort(tmp);
                for(int j = 0; j < temp.length; j++){
                    outMas.add(temp[j]);
                }
                System.out.println(Arrays.toString(temp));

            }else  if(mode.equals("-d") && datatype.equals("-s")){
                String[] temp = new String[tmp.length];
                temp = MergeSort.string_sort(tmp);
                System.out.println(Arrays.toString(temp));
                for(int j = 0; j < temp.length; j++){
                    outMas.add(temp[j]);
                }
                temp = null;
            }
        }
        String[] out = new String[outMas.size()];

        if(mode.equals("-a") && datatype.equals("-i")){
            int [] temp = new int[out.length];
            for(int j = 0; j < outMas.size(); j++){
                temp[j] = Integer.parseInt(outMas.get(j).toString());
            }
            temp = MergeSort.asort(temp);
            for(int i = 0; i < temp.length; i++){
                out[i] = Integer.toString(temp[i]);
            }
        } else if(mode.equals("-d") && datatype.equals("-i")){
            int [] temp = new int[out.length];
            for(int j = 0; j < outMas.size(); j++){
                temp[j] = Integer.parseInt(outMas.get(j).toString());
            }
            temp = MergeSort.sort(temp);
            for(int i = 0; i < temp.length; i++){
                out[i] = Integer.toString(temp[i]);
            }
        }else if(mode.equals("-a") && datatype.equals("-s")){
            String[] temp = new String[out.length];
            for(int j = 0; j < outMas.size(); j++){
                temp[j] = outMas.get(j).toString();
            }
            temp = MergeSort.string_asort(temp);
            for(int i = 0; i < temp.length; i++){
                out[i] = temp[i];
            }
        }else  if(mode.equals("-d") && datatype.equals("-s")){
            String[] temp = new String[out.length];
            for(int j = 0; j < outMas.size(); j++){
                temp[j] = outMas.get(j).toString();
            }
            temp = MergeSort.string_sort(temp);
            for(int i = 0; i < temp.length; i++){
                out[i] = temp[i];
            }
        }
        System.out.println("output mass");
        System.out.println(Arrays.toString(out));
        WriteFile.write(OutName, out);

    }
}
