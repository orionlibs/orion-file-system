package io.github.orionlibs.orion_file_system;

import java.io.File;
import java.net.URI;

public class OrionFile extends File
{
    private String fileName;
    private String fileExtension;


    public OrionFile(File parent, String child)
    {
        super(parent, child);
        initialise();
    }


    public OrionFile(String path)
    {
        super(path);
        initialise();
    }


    public OrionFile(URI path)
    {
        super(path);
        initialise();
    }


    public OrionFile(String parent, String child)
    {
        super(parent, child);
        initialise();
    }


    private void initialise()
    {
        this.fileName = getName();
        if(getFileName().lastIndexOf(".") >= 0)
        {
            this.fileExtension = getFileName().substring(getFileName().lastIndexOf(".") + 1);
        }
    }


    public String getFileName()
    {
        return this.fileName;
    }


    public String getFileExtension()
    {
        return this.fileExtension;
    }
}