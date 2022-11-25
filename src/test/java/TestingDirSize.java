import Exceptions.FileIsNotDirectoryException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 25/10/2022
 */
public class TestingDirSize {
    private final String PATH = "D:\\Paul\\Programming\\Java\\";

    @Nested
    @DisplayName("Exceptions testing")
    class DirSizeExceptionsTest {
        @Test
        @DisplayName("Existence of file")
        void existenceOfFile() {
            Assertions.assertThrowsExactly(FileNotFoundException.class, () -> new DirectoryInfo(PATH + "ASD"));
            Assertions.assertThrowsExactly(FileNotFoundException.class, () -> new DirectoryInfo(PATH + "RPKS123"));
            Assertions.assertThrowsExactly(FileNotFoundException.class, () -> new DirectoryInfo(PATH + "ASD"));
        }

        @Test
        @DisplayName("Check file is not directory exception")
        void checkFileIsNotDirectoryException() {
            Assertions.assertThrowsExactly(FileIsNotDirectoryException.class, () -> new DirectoryInfo(PATH + "auction_test.iml"));
        }
    }

    @Nested
    class CorrectnessOfDirSizeValue {
        @Test
        @DisplayName("checkCorrectnessOfDirSize")
        void checkCorrectnessOfDirSize() throws FileIsNotDirectoryException, FileNotFoundException, ExecutionException, InterruptedException {
            DirectoryInfo directoryInfo = new DirectoryInfo(PATH);
            Assertions.assertEquals(FileUtils.sizeOfDirectory(new File(PATH)), directoryInfo.getDirectorySize());

            DirectoryInfo directoryInfo2 = new DirectoryInfo("D:\\Paul\\Programming\\Books");
            Assertions.assertEquals(FileUtils.sizeOfDirectory(new File("D:\\Paul\\Programming\\Books")),
                    directoryInfo2.getDirectorySize());

            DirectoryInfo directoryInfo3 = new DirectoryInfo("D:\\JDK");
            Assertions.assertEquals(FileUtils.sizeOfDirectory(new File("D:\\JDK")),
                    directoryInfo3.getDirectorySize());
        }

        @Test
        @DisplayName("wrongSizeChecking")
        void wrongSizeChecking() throws FileIsNotDirectoryException, FileNotFoundException, ExecutionException, InterruptedException {
            DirectoryInfo directoryInfo = new DirectoryInfo(PATH);
            Assertions.assertNotEquals(FileUtils.sizeOfDirectory(new File("D:\\Paul\\Programming\\Books")), directoryInfo.getDirectorySize());
        }
    }

}
