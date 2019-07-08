package com.swust.fund.utils.ip;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author pang
 * @version V1.0
 * @ClassName: IpUtil
 * @Package com.swust.fund.utils.ip
 * @description: ip工具
 * @date 2019/7/8 20:42
 */
public class IpUtil {
    /**
     * 获取用户的IP
     *
     * @param request 用户请求
     * @return java.lang.String
     * @author pang
     * @date 2019/7/8
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    /**
     * 将数字转成ip地址
     *
     * @param IpNum 数字
     * @return 转换后的ip地址
     */
    public static String getNumConvertIp(long ipLong) {
        long mask[] = {0x000000FF, 0x0000FF00, 0x00FF0000, 0xFF000000};
        long num = 0;
        StringBuffer ipInfo = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            num = (ipLong & mask[i]) >> (i * 8);
            if (i > 0)
                ipInfo.insert(0, ".");
            ipInfo.insert(0, Long.toString(num, 10));
        }
        return ipInfo.toString();
    }

    /**
     * 将ip 地址转换成数字
     *
     * @param ipAddress 传入的ip地址
     * @return 转换成数字类型的ip地址
     */
    public static long getIpConvertNum(String ipAddress) {
        String[] ip = ipAddress.split("\\.");
        long a = Integer.parseInt(ip[0]);
        long b = Integer.parseInt(ip[1]);
        long c = Integer.parseInt(ip[2]);
        long d = Integer.parseInt(ip[3]);

        long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
        return ipNum;
    }
}
