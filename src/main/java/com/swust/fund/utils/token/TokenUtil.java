package com.swust.fund.utils.token;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Token工具
 * @author pang
 * @version 1.0
 */
public class TokenUtil {
    /** 加密秘钥，保存在内存中 **/
    private static final String KEY="chuangXinJJijin";
    /** 签发人 **/
    private static final String ISSUER="localhost";

    /** 
     * 功能描述 
     * @author pang
     * @date 19-3-6 下午1:02
     * @parm [ttlMillis, userName, subject]
     * @return java.lang.String
    */
    public static String createJWT(long ttlMillis,String userName,String subject){
        //使用HS256加密算法
        SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;
        //生成当前时间戳
        long nowMill=System.currentTimeMillis();
        //生成token时间
        Date now=new Date(nowMill);
        //payload私有声明，注意这里可以添加任意信息，根据业务进行实际修改
        Map<String ,Object> calims=new HashMap<>();
        //添加用户名
        calims.put("username",userName);
        //...

        JwtBuilder builder= Jwts.builder()
                //如果有私有声明，要先设置私有声明，然后再设置其他的，不然会覆盖掉
                .setClaims(calims)
                //设置token的唯一主键，方便识别，这里使用UUID
                .setId(UUID.randomUUID().toString())
                //设置签发时间
                .setIssuedAt(now)
                //设置签发人
                .setIssuer(ISSUER)
                //设置主题
                .setSubject(subject)
                //设置受众
                .setAudience(userName)
                //设置签名算法和秘钥
                .signWith(signatureAlgorithm,KEY);
        if (ttlMillis>0){
            //如果过期时间大于0，则设置过期时间
            //生成过期时间
            Date exp=new Date(nowMill+ttlMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }
        //返回token，这里内置了Base64算法,同时会根据你的签名算法和秘钥进行签名加密
        return builder.compact();
    }

    /**
     * 功能描述 解密token
     * @author pang
     * @date 19-3-6 下午8:46
     * @parm [token, username]
     * @return io.jsonwebtoken.Claims
    */
    public static Claims parseJWT(String token){
        Claims claims=Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
