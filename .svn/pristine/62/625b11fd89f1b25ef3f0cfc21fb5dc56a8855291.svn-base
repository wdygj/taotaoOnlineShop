package utils;

import java.util.Random;

public class IDUtils
{
    //Create a image name
    public static String getImageName()
    {
        long mills = System.currentTimeMillis();
        Random random = new Random();
        int end3 = random.nextInt(999);
        String src = mills+ String.format("%03d",end3);
        return src;
    }
    //Create a cargo name
    public static long getItemId()
    {
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end2 = random.nextInt(99);
        String imageName = millis+ String.format("%02d",end2);
        long id = new Long(imageName);
        return id;
    }

}
