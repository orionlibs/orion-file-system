package io.github.orionlibs.orion_file_system.directory;

import io.github.orionlibs.orion_file_system.FileSystemService;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class DirectoryService
{
    public static boolean emptyDirectory(File directory) throws IOException
    {
        FileUtils.cleanDirectory(directory);
        return true;
    }


    public static boolean emptyDirectory(String directory) throws IOException
    {
        return emptyDirectory(new File(directory));
    }


    public static void renameDirectory(String originalDirectoryPath, String newDirectoryName) throws IOException
    {
        FileSystemService.renameFileOrDirectory(originalDirectoryPath, newDirectoryName);
    }


    public static void renameDirectory(File originalDirectoryPath, String newDirectoryName) throws IOException
    {
        FileSystemService.renameFileOrDirectory(originalDirectoryPath, newDirectoryName);
    }


    public static boolean createDirectory(String newDirectoryName)
    {
        return createDirectory(new File(newDirectoryName));
    }


    public static boolean createDirectory(File newDirectoryName)
    {
        return newDirectoryName.mkdirs();
    }


    public static boolean doesDirectoryExist(String directoryName)
    {
        return new File(directoryName).exists();
    }


    public static boolean doesDirectoryNotExist(String directoryName)
    {
        return !doesDirectoryExist(directoryName);
    }
}