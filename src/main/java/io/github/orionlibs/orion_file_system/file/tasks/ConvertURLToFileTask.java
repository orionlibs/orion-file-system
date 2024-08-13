package io.github.orionlibs.orion_file_system.file.tasks;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ConvertURLToFileTask
{
    public static File run(URL file)
    {
        URI uri = null;
        try
        {
            uri = file.toURI();
        }
        catch(URISyntaxException e)
        {
            try
            {
                uri = new URI(file.getProtocol(), file.getUserInfo(), file.getHost(), file.getPort(), file.getPath(), file.getQuery(), file.getRef());
            }
            catch(URISyntaxException e1)
            {
                throw new IllegalArgumentException("Broken URL: " + file);
            }
        }
        return new File(uri);
    }
}