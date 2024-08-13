package io.github.orionlibs.orion_file_system.file.tasks;

public class GetFileExtensionTask
{
    public static String run(String fileName)
    {
        if(fileName != null && !fileName.isEmpty() && fileName.lastIndexOf(".") >= 0)
        {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        else
        {
            return "";
        }
    }
}