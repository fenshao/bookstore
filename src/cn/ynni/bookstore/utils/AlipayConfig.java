package cn.ynni.bookstore.utils;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {
	



	public static String app_id = "2016093000630913";
	

    public static String merchant_private_key = "这里填私钥";
	

    public static String alipay_public_key = "公钥";


	public static String notify_url = "http://114.116.156.29:8080/bookstore/Home/success"; //仅在公网服务器下能返回消息


	public static String return_url = "http://localhost:8080/bookstore/index.jsp";


	public static String sign_type = "RSA2";
	

	public static String charset = "utf-8";
	

	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	

	public static String log_path = "Z:\\";



    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

