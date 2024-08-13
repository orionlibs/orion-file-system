package io.github.orionlibs.orion_file_system.tasks;

import io.github.orionlibs.orion_assert.Assert;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class DeleteFileOrDirTask
{
    public static void run(File fileToDelete) throws IOException
    {
        Assert.notNull(fileToDelete, "fileToDelete input cannot be null.");
        if(fileToDelete.exists())
        {
            FileUtils.forceDelete(fileToDelete);
        }
    }


    public static void run(String filepath) throws IOException
    {
        Assert.notEmpty(filepath, "filepath input cannot be null/empty.");
        run(new File(filepath));
    }


    public static void run(String directoryInWhichFileToDeleteExists, boolean checkIfFileStartsWithPattern, String fileStartsWithPattern) throws IOException
    {
        Assert.notEmpty(directoryInWhichFileToDeleteExists, "directoryInWhichFileToDeleteExists input cannot be null/empty.");
        Assert.notEmpty(fileStartsWithPattern, "fileStartsWithPattern input cannot be null/empty.");
        File directoryName = new File(directoryInWhichFileToDeleteExists);
        if(directoryName.exists())
        {
            File[] files = directoryName.listFiles();
            if(files != null && files.length > 0)
            {
                for(File file : files)
                {
                    if(checkIfFileStartsWithPattern)
                    {
                        if(file.getName().startsWith(fileStartsWithPattern))
                        {
                            run(file);
                        }
                    }
                    else
                    {
                        run(file);
                    }
                }
            }
        }
    }
}