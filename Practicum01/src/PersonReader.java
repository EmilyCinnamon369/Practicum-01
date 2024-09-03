import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonReader {

    public static void main(String[] args)
    {

        File workingDirectory = new File(System.getProperty("user.dir"));
        File jfcFile = new File(workingDirectory.getPath() + "\\src\\PersonTestData.txt");
        JFileChooser jfc = new JFileChooser(jfcFile, FileSystemView.getFileSystemView());

        jfc.showOpenDialog(null);

        System.out.println(jfc.getSelectedFile());

        try {
            String content = new String(Files.readAllBytes(Paths.get(jfc.getSelectedFile().getAbsolutePath())));

            String[] lines = content.split("\n");

            System.out.format("%-10s %-10s %-10s %-10s %-15s%n", "ID", "First Name", "Last Name", "Title", "YOB");
            System.out.println("-------------------------------------");
            System.out.print(content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
