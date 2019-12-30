package com.ernesto.demo;

import com.ernesto.utils.Base64Utils;
import com.ernesto.utils.EncodeUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

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
            "eyJhcGlfaWQiOiJZRjAwMDAwMiIsImluZm9fY29udGVudCI6Ikhhc05TUG5SL2VzRXdXVjBjRmZqRWZTYkR0UXJKZEF6aWNiNEozK1JwS2F1bURMQkRISG16K3gzWUxHTnk2ZmdSbkpIVnhIamZKZGFcclxuOVNOenNUSSt6Zz09XHJcbiIsIm9iaiI6eyJyZXNwb25zZUNvZGUiOiIwMDAwMDAiLCJyZXNwb25zZU1lc3NhZ2UiOiLor7fmsYLmiJDlip/vvIEifSwicmVxX2NoYW5uZWxfbm8iOiJ5dGIiLCJyZXFfdGltZSI6IjIwMTkwODIxMDYyNTE2IiwicmV0X2NvZGUiOiIwMDAwMDAiLCJyZXRfbXNnIjoi5aSE55CG5oiQ5Yqf77yBIiwicnNwX2NoYW5uZWxfbm8iOiJzbWIiLCJzaWduIjoiNTJkYzk2ZTAyYmU0YjM1MTI5M2EyMzhiODVkZjY2OWEiLCJ0cmFuc19ubyI6IjIwMTkwODIxMDYyNTE2MjIwOTI5MmZlMzMifQ==";
        System.out.println("解密：" + EncodeUtils.decode(msg1));

    }
}
