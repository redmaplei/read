package com.wys.read.util;

import com.wys.read.ReadApplication;
import com.wys.read.utils.DfaDetection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 17:16 2018/10/9
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReadApplication.class)
public class DfaDetectionTest {

    @Autowired
    DfaDetection dfaDetection;

    @Test
    public void test() {
//        DfaDetection dfaDetection = new DfaDetection();
        dfaDetection.detection();
    }

}
