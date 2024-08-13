package io.github.orionlibs.orion_file_system.file.tasks;

import io.github.orionlibs.orion_assert.Assert;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class DeleteFileTask
{
    public static void run(File filePathToDelete) throws IOException
    {
        Assert.notNull(filePathToDelete, "filePathToDelete input cannot be null.");
        try
        {
            FileUtils.forceDelete(filePathToDelete);
        }
        catch(Exception e)
        {
        }
    }


    public static void run(String filePathToDelete) throws IOException
    {
        Assert.notEmpty(filePathToDelete, "filePathToDelete input cannot be null/empty.");
        run(new File(filePathToDelete));
    }
}