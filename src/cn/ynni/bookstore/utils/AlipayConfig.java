package cn.ynni.bookstore.utils;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {
	



	public static String app_id = "2016093000630913";
	

    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChyqnNLmXAfGHwn92QNtJhgffIhCbikw0V0hbYMiHtOQZDB/Ufp5xhcgPIUIsMgC1t/Lyjpx+5Kdih+XzGRFDyFxLzrCFA4f2NYF5mnBnCi5CJGXA8qLKy9ghB2zJphREMMfKCxsZBaCkJtyfV0vHa4+I/TjUJNJcq3MMROODIVie2xU36Dg/HlZOjcajuy38efU//rOw0PzzJsOr3sjueiS2++R/ZTVcrMuTCvaN40T+2E6iz3r7FUVJKKFmyAPu7JnbRoP5rwjzPBrI8LKwPFjTEsWg+JN7dfQCJDQYL6OqF008+XFrNuzXbcU/6toYvySnRcD5JoUN2NiBJ6BtZAgMBAAECggEANvkhkPH+6NRaguQO6H14JmF+y8b7X2kPvSZRVMxT8sK5efUuOL8+x21yE5IqbOjwhrqlbgXPJZ8uWHrpBoUX6+ojKmCGPAGNoYfpC3xm1E+PoMXf+PxpG521WIseKfRowngGKqFXo8m8h+yPwHuYagOcUF5GbwZLhujT7voghnESlxeIZswGnYQvON0Amg7Wg+n+yIXzglYBxCWew4b88UDUkjseLze835YyA1BhPXwrT28vBTfYZxnnlpA/M3IEk1JIvp6pnjGiKTEDEWqb81dG4w8PFFZOsBPrNWMDJYLKv0ivJiVHWjpBR22BIVDB1mevHRZ58xeKxP1brG1LwQKBgQD48FysMhHJaEoecRNqLllNAgtXSpOw4g1lIha5APHnstSEOGz1UzP6Kney2E5RrJnd5GwwNLK0sNNTAnTwJRc3uxSCDJW9b9NtzxrPRRM4W8Vy4Vkl0T2gtuiiWKsyY8EyyWmeioHxZtceL07tRh5yy5ttMDvGiggVe0SF1ClZRQKBgQCmYX4c5yiWpRF2Pgu7D4wUMGWdz8L2hhg6OOw+05kwXw/3zaTyiGwW+Z09fJgxrbY/DwQOisX6u6sIJl0IHHcT/86tzdV+jG1bIVy7QITED27OXoRVsz6sBzAJSQE0oj8q0DFsGyGUZ2DbLrNTIUgSNJEAZzMB3sJca1SOWGU5BQKBgBKjlJzEBvbomxwaZVS+8arFa2n2yIYm9s/KtJ7XhkVN64GW4/meaDbj9SBr97k/zimCD+OwHm1PDBOcDHtqm4lttYRjQtbzR4ZiSmSYjG7c2DTY0J73QsEE0PhO4Uqdk3qlAAaB4mbbx2GYMzWq2V7JBfMv+FnOPfq1xxSqJQptAoGABlQ9FOJiM+DRmjrf/VypCneQ1gD6PKB7OXPC4NzxvdpP5DBJbwRrgDA8oAMmUvV1sk5i7B6xS0lqRyQWc+GJUhRwC0KCNY8n9ch+G41nv4GKyITl6dCouKiJVkEVr6fgWUOULbWWgGuyToQnRClG8ZJYVbiXQyHzKMrYa5XHO/UCgYEAhldnwUzegpJVX/4WZQM1lzqTzqtnePO6x3DkolskPFpQKjne+OSNc7EHaEdHA/IyNHHricu2Qt0G3LZ0xhp1YUOEUDOAS6Jxa8cGnlg74JbHW859uQx7SoPHbvXxxgQsSfVG6ihhIkJrgnnM60zG4BQBSMnQ8Dm01ub1rWSRdUc=";
	

    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnMZXj/VGS5kzQYvLvJKRRoiqlDBSF00aavSmA0xitkTGwEedOAdj9oMJxUoiL9GE54iK4ghBKM/5s5PMNdi7M4tKXeI3NdCSOurBT2Uf/vLRqA6EOkGuWzYaKBYnMrW+t1SAMqIRDLbNZt3jmLpXRLgY6q1OCo/vzMEsKZcY7nqwoA1T50Xvs8196VNcoUGqVU9ETPXB+5Ol1OhBRtEvcSzNSUv2FsN357kG3ftgMbNoz036AvvbGxqksY8M68j9iF16fLkMfKxv/SRX/JoTtvDNm8MjhEM4JJRDYm/KOMhFmD84HyYGl0LRygRyHOQwhcjeOESEZL4D3E8EUP+dBwIDAQAB";


	public static String notify_url = "http://114.116.156.29:8080/bookstore/Home/success";


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

