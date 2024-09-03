import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args)
    {
        ArrayList<String> Products = new ArrayList<>();

        Scanner ln = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        boolean done = false;

        String ProductRec = "";
        String ID = "";
        String Name = "";
        String Description = "";
        Double Cost = 0.0;

        do {
            ID = SafeInput.getNonZeroLenString(ln, "Enter the ID [6 digits]");
            Name = SafeInput.getNonZeroLenString(ln, "Enter the name");
            Description = SafeInput.getNonZeroLenString(ln, "Enter the description");
            Cost = SafeInput.getDouble(ln, "Enter the cost ");

            ProductRec = (ID + ", " + Name + ", " + Description + ", " + Cost);

            Products.add(ProductRec);

            done = SafeInput.getYNConfirm(ln, "Are you done?");
        }while(!done);

        for (String p: Products)
            System.out.println(p);

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String rec : Products)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
