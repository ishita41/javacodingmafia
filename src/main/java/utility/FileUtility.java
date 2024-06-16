package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtility {
    public static boolean createFile(String fileNameWithPath) {
        File file = new File(fileNameWithPath);
        boolean fileCreated = false;

        try {
            fileCreated = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileCreated;
    }

    public static void readAndPrintFile(String fileName) {
        Scanner sc = null;
        File file = new File(fileName);

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public static boolean writeToFile(String fileNameWithPath, String content) {
        try (FileWriter fileWriter = new FileWriter(fileNameWithPath)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean appendToFile(String fileNameWithPath, String content) {
        try (FileWriter fileWriter = new FileWriter(fileNameWithPath, true)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String nameOfNewFile = "C:\\Users\\ishit\\IdeaProjects\\Project1\\practice\\file\\create-file.txt";
        if (createFile(nameOfNewFile)) {
            System.out.println("File created successfully.");
        } else {
            System.out.println("File already exists or could not be created.");
        }

        readAndPrintFile(nameOfNewFile);

        String nameOfWriteFile = "C:\\Users\\ishit\\IdeaProjects\\Project1\\practice\\file\\write-file.txt";
        boolean wroteToFile = writeToFile(nameOfWriteFile, "Hii ishita here");
        if (wroteToFile) {
            System.out.println("Content written to file successfully.");
        } else {
            System.out.println("Failed to write content to file.");
        }

        // Read and print the newly written file content to verify
        readAndPrintFile(nameOfWriteFile);

        // Append content to the file
        boolean appendedToFile = appendToFile(nameOfWriteFile, "\nmy surname is mahajan.");
        if (appendedToFile) {
            System.out.println("Content appended to file successfully.");
        } else {
            System.out.println("Failed to append content to file.");
        }

        // Read and print the file content again to verify append operation
        readAndPrintFile(nameOfWriteFile);
    }
}
