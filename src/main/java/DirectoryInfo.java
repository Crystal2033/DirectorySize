import Exceptions.FileIsNotDirectoryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 24/10/2022
 */
public class DirectoryInfo {
    private final File file;
    private final ExecutorService executorService;

    DirectoryInfo(String fileName) throws FileIsNotDirectoryException, FileNotFoundException {
        this.file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(fileName + " directory does not exist.");
        }
        if (!file.isDirectory()) {
            throw new FileIsNotDirectoryException(fileName + " is not directory.");
        }
        executorService = Executors.newCachedThreadPool();
    }

    public long getDirectorySize() throws ExecutionException, InterruptedException {
        long dirSize = getDirectorySize(file);
        executorService.shutdown();
        return dirSize;
    }

    long getDirectorySize(File dir) throws ExecutionException, InterruptedException {
        long length = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else {
                    Future<Long> resultOfGetDirSize = executorService.submit(new DirectoryThread(this, file));
                    length += resultOfGetDirSize.get();
                }
            }
        }
        return length;
    }
}
