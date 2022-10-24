package Exceptions;

/**
 * @project DirectorySize
 * ©Crystal2033
 * @date 24/10/2022
 */
public class FileIsNotDirectoryException extends Exception{
    private final String errorMessage;
    public FileIsNotDirectoryException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage(){
        return errorMessage;
    }

}

