package com.ernesto.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;

import com.pingan.iobs.sdk.common.Config;
import com.pingan.iobs.sdk.model.Response;
import com.pingan.iobs.sdk.service.IobsService;

/**
 * @author Ernesto
 * @date 2019/12/30
 */
public class IobsFileSupport {

    private String HOST = "http://test1-iobs.pingan.com.cn";

    //互联网IOBS，上传和下载的目录是分离的，具体配置如下
    private String bucket_upload = "p2pp-bank-dmz-dev-pri";
    private String ACCESS_KEY_UPLOAD = "2dV0dYDdID8J8M8CK9J0DIVKJKFYJF2D";
    private String SECRET_KEY_UPLOAD = "2K0YdJVI9JVI9VI0KJIW066dWJJF02CY";

    private String bucket_download = "p2pp_bank-sf-dev-pri";
    private String ACCESS_KEY_DOWNLOAD = "KMIdWWFYFJK6CJ92d2KMddCW628V8IY9";
    private String SECRET_KEY_DOWNLOAD = "86DCW0JFVIWM6M9FV0CCVdW20KII6JWD";

    //专线IOBS，不需要分离，配置如下
    //http://iobs-test.paic.com.cn
    //p2pp-web-sf-dev-pri
    //KVJM9I88KK9Fd9F69D0dDJFC80W008Fd
    //J6MIIFVI8MDJ866d8M86YWYFD08I8VI0

    private String fileDownloadPath = "D:\\tmp";

    public static void main(String[] args) {
        IobsFileSupport iobsFileSupport = new IobsFileSupport();

        String fileName = "Koala.zip";

        //上传
        boolean result = iobsFileSupport.upLoadFile(new File("D:\\" + fileName), fileName);
        System.out.println("upload result: " + result);

        //下载
        File file = iobsFileSupport.downFile(fileName);
        System.out.println(file.getAbsolutePath());
    }

    public IobsFileSupport() {
        // 初始化访问域名
        Config.HOST = HOST;
    }

    /**
     * @param file
     * @param key  FileName
     *
     * @return
     */
    public boolean upLoadFile(File file, String key) {
        // 初始化AK、sk
        Config.ACCESS_KEY = ACCESS_KEY_UPLOAD;
        Config.SECRET_KEY = SECRET_KEY_UPLOAD;

        IobsService iobs = new IobsService();
        Response response = iobs.upload(bucket_upload, key, file);
        System.out.println(String
            .format("IobsFileSupport.upLoadFile-response:[code:%s,error:%s,ok:%s]", response.code(), response.error(),
                response.isOK()));

        return response.isOK();
    }

    public boolean uploadStream(InputStream ins, String key) {
        // 初始化AK、sk
        Config.ACCESS_KEY = ACCESS_KEY_UPLOAD;
        Config.SECRET_KEY = SECRET_KEY_UPLOAD;

        IobsService iobs = new IobsService();
        Response response = iobs.uploadStream(bucket_upload, key, ins, key, -1L);//-1L或ins.available()

        System.out.println(String
            .format("IobsFileSupport.uploadStream-response:[code:%s,error:%s,ok:%s]", response.code(), response.error(),
                response.isOK()));

        return response.isOK();
    }

    public boolean upload(byte[] bytes, String key) {
        return uploadStream(new ByteArrayInputStream(bytes), key);
    }

    public File downFile(String fileName) {
        System.out.println("------IobsFileSupport.downFile------");
        System.out.println(fileName);
        InputStream in = downFileInputStream(fileName);
        if (in != null) {
            System.out.println("------IobsFileSupport.downFile.createFile------");
            System.out.println(fileDownloadPath);
            return createFile(in, fileName, fileDownloadPath);
        } else {
            return null;
        }
    }

    public InputStream downFileInputStream(String key) {
        // 初始化AK、sk
        Config.ACCESS_KEY = ACCESS_KEY_DOWNLOAD;
        Config.SECRET_KEY = SECRET_KEY_DOWNLOAD;

        InputStream is = null;
        try {
            IobsService iobs = new IobsService();
            String url = iobs.downloadAuthedUrl(bucket_download, key);
            Response response = iobs.download(url);

            System.out.println(String
                .format("IobsFileSupport.downFileInputStream-response:[code:%s,error:%s,ok:%s]", response.code(),
                    response.error(), response.isOK()));

            if (response.isOK())
                is = response.downloadFileStream();
        } catch (Exception e) {
            System.err.println(
                "[" + this.getClass().getName() + ".downFileInputStream] [interface call error] - download " + key
                    + " from iobs error ");
        }

        return is;
    }

    public File createFile(InputStream is, String fileName, String path) {
        File fFile = new File(path);
        if (!fFile.exists()) {
            boolean b = fFile.mkdirs();
            System.out.println("建立目录[" + fFile + "]" + b);
        }
        File file = new File(path + File.separator + fileName);
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            is.close();
        } catch (Exception e) {
            System.err.println("在目录" + path + "下创建文件" + fileName + "失败 ！" + e.getStackTrace());
        }
        return file;
    }
}
