package io.github.orionlibs.orion_file_system.file.tasks;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_file_system.CloseResourceTask;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFirstLineFromFileTask
{
    public static String run(BufferedReader input) throws IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");
        try
        {
            return input.readLine();
        }
        finally
        {
            CloseResourceTask.run(input);
        }
    }
}