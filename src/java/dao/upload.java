/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Part;

/**
 *
 * @author ASUS
 */
public class upload {
    
    public boolean uploadFile(String fileName, Part file, String uploadRootPath) {
        try {
            InputStream is = file.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            FileOutputStream fos = new FileOutputStream(new File(uploadRootPath + "\\" + fileName));
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getFileName(Part file) {
        String filename;
        String header = file.getHeader("Content-Disposition");
        int beginIndex = header.lastIndexOf("=");
        filename = header.substring(beginIndex + 1);
        // remove "" quotes 
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(filename);
        while (m.find()) {
            filename = m.group(1);
        }
        // for IE 
        beginIndex = filename.lastIndexOf("\\");
        filename = filename.substring(beginIndex + 1);
        return filename;
    }
}
