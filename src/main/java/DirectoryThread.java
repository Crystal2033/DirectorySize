import java.io.File;
import java.util.concurrent.Callable;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 25/11/2022
 */
public record DirectoryThread(DirectoryInfo directoryInfo, File curFile) implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        return directoryInfo.getDirectorySize(curFile);
    }
}
