package com.wys.read;

import org.apache.shiro.util.ByteSource;
import org.junit.Test;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 9:39 2018/10/8
 * @Modified By:
 */
public class OtherTest {

    @Test
    public void test() {
        ByteSource credentialsSalt = ByteSource.Util.bytes("a");
        System.out.println("credentialsSalt = " + credentialsSalt);
    }

}
