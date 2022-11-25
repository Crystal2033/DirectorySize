import Exceptions.FileIsNotDirectoryException;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 24/10/2022
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Developer: Kulikov Pavel, M8O-311");
        System.out.println("This program is able to count directory size.");
        System.out.println();

        if (args.length != 1) {
            System.out.println("Your the only one argument should be the directory name.");
            return;
        }
        final String fileName = args[0];
        DirectoryInfo directoryInfo;
        try {
            directoryInfo = new DirectoryInfo(args[0]);
        } catch (FileIsNotDirectoryException | FileNotFoundException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.println("Processing... Wait a bit.");
        long directorySizeBytes = 0L;
        try {
            directorySizeBytes = directoryInfo.getDirectorySize();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        final long directorySizeKB = directorySizeBytes / 1024;
        final long directorySizeMB = directorySizeKB / 1024;
        final long directorySizeGB = directorySizeMB / 1024;

        System.out.println("Size of " + fileName + " is: " + directorySizeBytes + " bytes / " + directorySizeKB
                + " Kb / " + directorySizeMB + "Mb / " + directorySizeGB + " Gb.");

    }
}
