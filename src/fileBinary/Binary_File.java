package fileBinary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Binary_File {
    private static void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

            while ((length= is.read(buffer)) > 0) {
                os.write(buffer, 0 , length);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter source file: ");
        String sourcePath= sc.nextLine();

        System.out.println("Enter destination file: ");
        String destPath = sc.nextLine();

        File source = new File(sourcePath);
        File destFile = new File(destPath);

        try{
            copyFile(sourcePath, destPath);
            System.out.println("Copy completed");
        } catch (IOException e) {
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }
}
