package io.github.orionlibs.orion_file_system.tasks;

import io.github.orionlibs.orion_assert.Assert;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class RenameFileOrDirectoryTask
{
    public static void run(String originalFileOrDirPath, String newFileOrDirName) throws IOException
    {
        Assert.notEmpty(originalFileOrDirPath, "originalFileOrDirPath input cannot be null/empty.");
        Assert.notEmpty(newFileOrDirName, "newFileOrDirName input cannot be null/empty.");
        run(new File(originalFileOrDirPath), newFileOrDirName);
    }


    public static void run(File originalFileOrDir, String newFileOrDirName) throws IOException
    {
        Assert.notNull(originalFileOrDir, "originalFileOrDir input cannot be null.");
        Assert.notEmpty(newFileOrDirName, "newFileOrDirName input cannot be null/empty.");
        if(!originalFileOrDir.exists())
        {
            originalFileOrDir.createNewFile();
        }
        else
        {
            StringBuilder sb = new StringBuilder(originalFileOrDir.getParentFile().getAbsolutePath());
            sb.append(File.separator);
            sb.append(newFileOrDirName);
            String newFileOrDirPathName = sb.toString();
            Path originalFileOrDirPath = originalFileOrDir.toPath();
            Path newFileOrDirPath = new File(newFileOrDirPathName).toPath();
            Files.move(originalFileOrDirPath, newFileOrDirPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}