package io.github.orionlibs.orion_file_system;

import io.github.orionlibs.orion_file_system.tasks.DeleteFileOrDirTask;
import io.github.orionlibs.orion_file_system.tasks.PrintFileSystemTask;
import io.github.orionlibs.orion_file_system.tasks.PrintFilesAndDirectoriesTask;
import io.github.orionlibs.orion_file_system.tasks.RenameFileOrDirectoryTask;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileSystemService
{
    public static void delete(File fileToDelete) throws IOException
    {
        DeleteFileOrDirTask.run(fileToDelete);
    }


    public static void delete(String filepath) throws IOException
    {
        DeleteFileOrDirTask.run(new File(filepath));
    }


    public static void deleteFile(String directoryInWhichFileToDeleteExists, boolean checkIfFileStartsWithPattern, String fileStartsWithPattern) throws IOException
    {
        DeleteFileOrDirTask.run(directoryInWhichFileToDeleteExists, checkIfFileStartsWithPattern, fileStartsWithPattern);
    }


    public static BufferedWriter printFileSystem(String directoryPathToTraverse, String filePathToSaveIn) throws IOException
    {
        return PrintFileSystemTask.run(directoryPathToTraverse, filePathToSaveIn);
    }


    public static void printFilesAndDirectories(File directoryToTraverse, BufferedWriter output) throws IOException
    {
        PrintFilesAndDirectoriesTask.run(directoryToTraverse, output);
    }


    public static void renameFileOrDirectory(String originalFileOrDirPath, String newFileOrDirName) throws IOException
    {
        RenameFileOrDirectoryTask.run(originalFileOrDirPath, newFileOrDirName);
    }


    public static void renameFileOrDirectory(File originalFileOrDir, String newFileOrDirName) throws IOException
    {
        RenameFileOrDirectoryTask.run(originalFileOrDir, newFileOrDirName);
    }
}