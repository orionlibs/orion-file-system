package io.github.orionlibs.orion_file_system.file.tasks;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_file_system.stream.FileSystemStreamsService;
import io.github.orionlibs.orion_object.ResourceCloser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class SaveStringToFileTask
{
    private boolean addEmptyLineAtTheEndOfTheFile;
    private String lineSeparator = System.lineSeparator();
    private BufferedWriter output;
    private int numberOfLines;
    private int lineCounter;


    public void run(String filePath, String fileString, boolean addEmptyLineAtTheEndOfTheFile) throws IOException
    {
        this.addEmptyLineAtTheEndOfTheFile = addEmptyLineAtTheEndOfTheFile;
        run(filePath, fileString);
    }


    public void run(File file, String fileString, boolean addEmptyLineAtTheEndOfTheFile) throws IOException
    {
        this.addEmptyLineAtTheEndOfTheFile = addEmptyLineAtTheEndOfTheFile;
        run(file, fileString);
    }


    public void run(String filePath, String fileContent) throws IOException
    {
        Assert.notEmpty(filePath, "filePath input cannot be null/empty.");
        Assert.notEmpty(fileContent, "fileContent input cannot be null/empty.");
        output = (BufferedWriter)FileSystemStreamsService.getWriterForFile(filePath);
        String[] lines = fileContent.split(lineSeparator);
        numberOfLines = lines.length;
        lineCounter = 1;
        try
        {
            for(String line : lines)
            {
                writeLineToFile(line);
            }
        }
        finally
        {
            ResourceCloser.closeResource(output);
        }
    }


    public void run(File file, String fileContent) throws IOException
    {
        Assert.notNull(file, "file input cannot be null/empty.");
        Assert.notEmpty(fileContent, "fileContent input cannot be null/empty.");
        output = (BufferedWriter)FileSystemStreamsService.getWriterForFile(file);
        String[] lines = fileContent.split(lineSeparator);
        numberOfLines = lines.length;
        lineCounter = 1;
        try
        {
            for(String line : lines)
            {
                writeLineToFile(line);
            }
        }
        finally
        {
            ResourceCloser.closeResource(output);
        }
    }


    private void writeLineToFile(String lineToWrite) throws IOException
    {
        output.write(lineToWrite);
        if(lineCounter != numberOfLines || addEmptyLineAtTheEndOfTheFile)
        {
            output.write(lineSeparator);
        }
    }
}