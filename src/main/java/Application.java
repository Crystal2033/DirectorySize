import Exceptions.FileIsNotDirectoryException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 24/10/2022
 */
public class Application {
    public static void main(String[] args) {
        final String fileName = "D:\\Paul\\Programming\\Java\\";
        if (args.length != 1) {
            System.out.println("Your the only one argument should be the directory name.");
            return;
        }
        DirectoryInfo directoryInfo;
        try {
            directoryInfo = new DirectoryInfo(args[0]);
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
                + " Kb / " + directorySizeMB + "Mb / " + directorySizeGB + " Gb.");

    }
}
