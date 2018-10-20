package com.wys.read.utils;

import com.xiaoleilu.hutool.dfa.WordTree;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 17:04 2018/10/9
 * @Modified By:
 */
@Component
public class DfaDetection {

    private final Logger log = LoggerFactory.getLogger(DfaDetection.class);

    WordTree tree;

    public DfaDetection() {
//        init();
    }

    public void init() {
        tree = new WordTree();
        tree.addWord("大");
        tree.addWord("大");
        tree.addWord("大土豆");
        tree.addWord("土豆");
        tree.addWord("刚出锅");
        tree.addWord("出锅");

        System.out.println(" init complete " );
        detection();
    }

    public void detection() {
        String text = "我有一颗大土豆，刚出锅的";

        String filePath = "C:\\Users\\12192\\Desktop\\word.txt";

        String all = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
            String line = null;

            while ((line = br.readLine()) != null) {
                all += line;
            }
            br.close();
        }catch (Exception e) {

        }


        //
//        try {
//            File file = new File(filePath);
//            if(file.isFile() && file.exists()) {
//                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
//                BufferedReader br = new BufferedReader(isr);
//                String lineTxt = null;
//                while ((lineTxt = br.readLine()) != null) {
////                    System.out.println(lineTxt);
//                    all += lineTxt;
//                }
//                br.close();
//            } else {
//                System.out.println("文件不存在!");
//            }
//        } catch (Exception e) {
//            System.out.println("文件读取错误!");
//        }

        log.info(" ------------ {}",all);

        List<String> matchAll = tree.matchAll(text, -1, false, false);
        Assert.assertEquals(matchAll.toString(), "[大, 土豆, 刚出锅]");
        for(String s: matchAll) {
            System.out.printf(" " +s);
        }
    }

}
