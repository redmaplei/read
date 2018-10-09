package com.wys.read.utils;

import com.xiaoleilu.hutool.dfa.WordTree;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 17:04 2018/10/9
 * @Modified By:
 */
@Component
public class DfaDetection {

    WordTree tree;

    public DfaDetection() {
        init();
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
    }

    public void detection() {
        String text = "我有一颗大土豆，刚出锅的";
        List<String> matchAll = tree.matchAll(text, -1, false, false);
        Assert.assertEquals(matchAll.toString(), "[大, 土豆, 刚出锅]");
        for(String s: matchAll) {
            System.out.printf(" " +s);
        }
    }

}
