import Exceptions.FileIsNotDirectoryException;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 24/10/2022
 */
public class Application {
    public static void main(String[] args) {
        final String fileName = "D:\\Paul\\Programming\\Java\\asd";
        DirectoryInfo directoryInfo;
        try {
            directoryInfo = new DirectoryInfo(fileName);
        } catch (FileIsNotDirectoryException | FileNotFoundException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.println("Processing... Wait a bit.");
        final long directorySizeBytes = directoryInfo.getDirectorySize();
        final long directorySizeKB = directorySizeBytes / 1024;
        final long directorySizeMB = directorySizeKB / 1024;
        final long directorySizeGB = directorySizeMB / 1024;

        System.out.println("Size of " + fileName + " is: " + directorySizeBytes + " bytes / " + directorySizeKB
                + " Kb / " + + directorySizeMB + "Mb / " + directorySizeGB + " Gb.");
    }
}
