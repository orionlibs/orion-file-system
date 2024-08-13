package io.github.orionlibs.orion_file_system.file.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

public class AppendToFileTask
{
    public static boolean run(File file, String contentsToAppend)
    {
        try
        {
            OpenOption[] openOptions = new OpenOption[]
                            {StandardOpenOption.APPEND};
            Files.write(file.toPath(), contentsToAppend.getBytes(), openOptions);
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean run(String file, String contentsToAppend)
    {
        return run(new File(file), contentsToAppend);
    }
}