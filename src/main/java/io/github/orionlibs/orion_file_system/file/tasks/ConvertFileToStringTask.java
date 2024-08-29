package io.github.orionlibs.orion_file_system.file.tasks;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_object.ResourceCloser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConvertFileToStringTask
{
    public static String run(BufferedReader input) throws FileNotFoundException, IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");
        String currentLine = null;
        StringBuilder fileStringBuilder = new StringBuilder();
        try
        {
            while((currentLine = input.readLine()) != null)
            {
                fileStringBuilder.append(currentLine);
                fileStringBuilder.append(System.lineSeparator());
            }
            //fileStringBuilder = StringsService.deleteLineSeparatorFromTheEnd(fileStringBuilder);
        }
        finally
        {
            ResourceCloser.closeResource(input);
        }
        return fileStringBuilder.toString();
    }
}