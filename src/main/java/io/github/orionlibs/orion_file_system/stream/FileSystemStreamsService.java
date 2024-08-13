package io.github.orionlibs.orion_file_system.stream;

import io.github.orionlibs.orion_assert.Assert;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class FileSystemStreamsService
{
    public static InputStream getFileStream(String filePath)
    {
        Assert.notEmpty(filePath, "filePath input cannot be null/empty.");
        return FileSystemStreamsService.class.getResourceAsStream(filePath);
    }


    public static Reader getReaderForFile(File file) throws FileNotFoundException
    {
        Assert.notNull(file, "file input cannot be null/empty.");
        return new BufferedReader(new FileReader(file));
    }


    public static Reader getReaderForFile(String filePath) throws FileNotFoundException
    {
        Assert.notEmpty(filePath, "filePath input cannot be null/empty.");
        return new BufferedReader(new FileReader(filePath));
    }


    public static Writer getWriterForFile(String filePath) throws IOException
    {
        Assert.notEmpty(filePath, "filePath input cannot be null/empty.");
        return new BufferedWriter(new FileWriter(filePath));
    }


    public static Writer getWriterForFile(File file) throws IOException
    {
        Assert.notNull(file, "file input cannot be null/empty.");
        return new BufferedWriter(new FileWriter(file, Charset.forName("UTF-8")));
    }


    public static void copy(InputStream is, OutputStream os) throws IOException
    {
        if(!(os instanceof BufferedOutputStream))
        {
            os = new BufferedOutputStream(os);
        }
        if(!(is instanceof BufferedInputStream))
        {
            is = new BufferedInputStream(is);
        }
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while((bytesRead = is.read(buffer)) > 0)
        {
            os.write(buffer, 0, bytesRead);
        }
        os.flush();
    }


    public static byte[] readBytes(InputStream is) throws IOException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
        copy(is, bos);
        return bos.toByteArray();
    }
}