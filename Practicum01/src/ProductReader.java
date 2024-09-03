import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProductReader {

    public static void main(String[] args)
    {

        File workingDirectory = new File(System.getProperty("user.dir"));
        File jfcFile = new File(workingDirectory.getPath() + "\\src\\ProductTestData.txt");
        JFileChooser jfc = new JFileChooser(jfcFile, FileSystemView.getFileSystemView());

        jfc.showOpenDialog(null);

        System.out.println(jfc.getSelectedFile());

        try {
            String content = new String(Files.readAllBytes(Paths.get(jfc.getSelectedFile().getAbsolutePath())));
            System.out.format("%-10s %-10s %-10s %-15s%n", "ID", "Name", "Description", "Cost");
            System.out.println("-------------------------------------");
            System.out.print(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
