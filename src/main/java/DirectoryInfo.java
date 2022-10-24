import Exceptions.FileIsNotDirectoryException;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 24/10/2022
 */
public class DirectoryInfo {
    private final File file;

    DirectoryInfo(String fileName) throws FileIsNotDirectoryException, FileNotFoundException {
        this.file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(fileName + " directory does not exist.");
        }
        if (!file.isDirectory()) {
            throw new FileIsNotDirectoryException(fileName + " is not directory.");
        }
    }

    public long getDirectorySize() {
        return getDirectorySize(file);
    }

    private long getDirectorySize(File dir) {
        long length = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else if (file.isDirectory()) {
                    length += getDirectorySize(file);
                } else {
                    System.out.println("Something is wrong.");
                }
            }
        }
        return length;
    }
}
