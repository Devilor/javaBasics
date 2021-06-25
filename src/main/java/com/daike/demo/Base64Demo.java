package com.daike.demo;

import com.daike.utils.EncodeUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author Ernesto
 * @date 2019/12/30
 */
public class Base64Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //String msg = "Hello Java";
        //String result = Base64Utils.encodeToString(msg, "UTF-8");
        //System.out.println("加密：" + result);
        //String msg1 =
        //    "eyJhcGlfaWQiOiJZRjAwMDAwMiIsImluZm9fY29udGVudCI6Ikhhc05TUG5SL2VzRXdXVjBjRmZqRWZTYkR0UXJKZEF6aWNiNEozK1JwS2F1bURMQkRISG16K3gzWUxHTnk2ZmdSbkpIVnhIamZKZGFcclxuOVNOenNUSSt6Zz09XHJcbiIsIm9iaiI6eyJyZXNwb25zZUNvZGUiOiIwMDAwMDAiLCJyZXNwb25zZU1lc3NhZ2UiOiLor7fmsYLmiJDlip/vvIEifSwicmVxX2NoYW5uZWxfbm8iOiJ5dGIiLCJyZXFfdGltZSI6IjIwMTkwODIxMDYyNTE2IiwicmV0X2NvZGUiOiIwMDAwMDAiLCJyZXRfbXNnIjoi5aSE55CG5oiQ5Yqf77yBIiwicnNwX2NoYW5uZWxfbm8iOiJzbWIiLCJzaWduIjoiNTJkYzk2ZTAyYmU0YjM1MTI5M2EyMzhiODVkZjY2OWEiLCJ0cmFuc19ubyI6IjIwMTkwODIxMDYyNTE2MjIwOTI5MmZlMzMifQ==";
        //System.out.println("解密：" + Base64Utils.decodeBase64(msg1));
        String msg = "Hello Java";
        String result = EncodeUtils.encode(msg);
        System.out.println("加密：" + result);
        String msg1 =
            "eyJpbmZvX2NvbnRlbnQiOiJIYXNOU1BuUi9ldXVtRExCREhIbXoxUEpWQ0U1Wm5saEladWFnS21LTkVvaE85a01VejVJT3JYeGlPOVNGVkE3K08rNGNwcFU3VWdjXHJcbjc2T3hJd1BOa0E9PVxyXG4iLCJzaWduIjoiNDlhZmE4ZGU3YTg1YTdjYTM4MmVjZjg5OTRiNjMwYWYiLCJyc3BfY2hhbm5lbF9ubyI6InNtYiIsImFwaV9pZCI6IllGMDAwMDAyIiwicmV0X2NvZGUiOiI5OTk5OTkiLCJ0cmFuc19ubyI6IjIwMTkwODIxMDYyNTE2MjIwOTI5MmZlMzMiLCJyZXFfdGltZSI6IjIwMTkwODIxMDYyNTE2IiwicmV0X21zZyI6IuWtl+autee8uuWkse+8gSIsInJlcV9jaGFubmVsX25vIjoieXRiIn0=/vvIEifSwicmVxX2NoYW5uZWxfbm8iOiJ5dGIiLCJyZXFfdGltZSI6IjIwMTkwODIxMDYyNTE2IiwicmV0X2NvZGUiOiIwMDAwMDAiLCJyZXRfbXNnIjoi5aSE55CG5oiQ5Yqf77yBIiwicnNwX2NoYW5uZWxfbm8iOiJzbWIiLCJzaWduIjoiNTJkYzk2ZTAyYmU0YjM1MTI5M2EyMzhiODVkZjY2OWEiLCJ0cmFuc19ubyI6IjIwMTkwODIxMDYyNTE2MjIwOTI5MmZlMzMifQ==";
        System.out.println("解密：" + EncodeUtils.decode(msg1));

    }
}
