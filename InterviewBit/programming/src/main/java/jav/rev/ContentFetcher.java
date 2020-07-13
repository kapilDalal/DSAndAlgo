package jav.rev;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ContentFetcher
{
    static final int FILE_READ_BUFFER_SIZE_DEFAULT = 32768; //TODO: read this from property config
    
    byte[] getFileContent(File contentFile) throws IOException
    {
        InputStream contentFileInputStream = getInputStream(contentFile);
        try
        {
            int fileLength = (int)contentFile.length();
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream((int)contentFile.length());
    
            byte[] buffer = new byte[FILE_READ_BUFFER_SIZE_DEFAULT];
            while (byteOutputStream.size() < fileLength)
            {
                int bytesToRead = getBytesToRead(fileLength, byteOutputStream);
    
                int bytesRead = contentFileInputStream.read(buffer, 0, bytesToRead);
                
                if (bytesRead == -1)
                {
                    break;
                }
    
                byteOutputStream.write(buffer, 0, bytesRead);
            }
    
            return byteOutputStream.toByteArray();
            
        }
        finally
        {
            contentFileInputStream.close();
        }
    }
    
    private InputStream getInputStream(File contentFile) throws FileNotFoundException
    {
        InputStream contentFileInputStream = new FileInputStream(contentFile);
        return contentFileInputStream;
    }
    
    private int getBytesToRead(int maxLength, ByteArrayOutputStream byteOutputStream)
    {
        if (maxLength - byteOutputStream.size() < FILE_READ_BUFFER_SIZE_DEFAULT)
        {
            return maxLength - byteOutputStream.size();
        }
        else
        {
            return FILE_READ_BUFFER_SIZE_DEFAULT;
        }
    }
    public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\kd734047\\Desktop\\da.pdf");
		ContentFetcher cf = new ContentFetcher();
		byte[] fileContent = cf.getFileContent(f);
		
	}
}

