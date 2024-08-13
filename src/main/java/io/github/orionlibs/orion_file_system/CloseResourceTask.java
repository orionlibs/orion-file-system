package io.github.orionlibs.orion_file_system;

import java.io.Closeable;
import java.io.IOException;

public class CloseResourceTask
{
    public static boolean run(Closeable closeable)
    {
        if(closeable != null)
        {
            return closeResource(closeable);
        }
        return false;
    }


    private static boolean closeResource(Closeable closeable)
    {
        try
        {
            closeable.close();
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}