package io.github.orionlibs.orion_file_system.file.tasks;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_file_system.CloseResourceTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertFileToStringListTask
{
    public static List<String> run(BufferedReader input) throws IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");
        List<String> fileLines = new ArrayList<>();
        String currentLine = null;
        try
        {
            while((currentLine = input.readLine()) != null)
            {
                fileLines.add(currentLine);
            }
        }
        finally
        {
            CloseResourceTask.run(input);
        }
        return fileLines;
    }
}