package io.github.orionlibs.orion_file_system.file.tasks;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_file_system.file.FileService;
import io.github.orionlibs.orion_stream.CloseableResource;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadFileTask
{
    public static void run(String URLResourceToDownload, String filePathToDownloadTo) throws IOException
    {
        Assert.notEmpty(URLResourceToDownload, "URLResourceToDownload input cannot be null/empty.");
        Assert.notEmpty(filePathToDownloadTo, "filePathToDownloadTo input cannot be null/empty.");
        BufferedInputStream input = FileService.downloadFileAsStream(URLResourceToDownload);
        ByteArrayOutputStream output = null;
        OutputStream fos = null;
        try
        {
            output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while((n = input.read(buf)) != -1)
            {
                output.write(buf, 0, n);
            }
            fos = Files.newOutputStream(Paths.get(filePathToDownloadTo));
            fos.write(output.toByteArray());
        }
        finally
        {
            CloseableResource.run(input);
            CloseableResource.run(output);
            CloseableResource.run(fos);
        }
    }
}