package com.wys.read.web.rest.MarkdownController;

import com.google.gson.Gson;
import com.wys.read.domain.Markdown;
import com.wys.read.service.MarkdownService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:21 2018/10/6
 * @Modified By:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/md")
public class MarkdownController {

    private final Logger log = LoggerFactory.getLogger(MarkdownController.class);

    @Autowired
    MarkdownService markdownService;

    @GetMapping(value = "/do")
    public ResponseEntity<Map<String, Object>> d() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("message", "Hello world");
        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
    }

    @GetMapping(value = "/test", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void test() {
        System.out.println(" test --- " );
    }

    @GetMapping(value = "/getmdcount")
    @ResponseBody
    public String getmdcount() {
        log.info("getmdcount ");

        int count = markdownService.getmdCount();

//        return ResponseEntity.ok()
//                .body(count);

//        return count;

        String s = "coutn x";
        Gson gson = new Gson();
        s = gson.toJson(s);

        return s;

    }

    @GetMapping(value = "/getCategorymdCount")
    public ResponseEntity getCategorymdCount(String category) {

        System.out.println("category = " + category);

        int count = markdownService.getCategorymdCount(category);

        return ResponseEntity.ok()
                .body(count);

    }

    @GetMapping(value = "/getnewmd")
    public ResponseEntity<List<Markdown>> getNewmd() {
        log.info("getnewmd ");

        List<Markdown> list = markdownService.getNewmd();

        if (list.isEmpty()) {
            return ResponseEntity.status(400)
                    .body(null);
        }
        return ResponseEntity.ok()
                .body(list);
    }



    @GetMapping(value = "/getPagemd")
    public ResponseEntity<List<Markdown>> getPagemd(int page) {

        List<Markdown> list = markdownService.getPagemd(page);

        if (list.isEmpty()) {
            return ResponseEntity.status(400)
                    .body(null);
        }
        return ResponseEntity.ok()
                .body(list);

    }

    /**
     * 待 前端 接入
     * @param markdown
     * @return
     */
    @PostMapping(value = "uploadmd")
    public ResponseEntity uploadmd(@RequestBody Markdown markdown) {

        String result = markdownService.uploadmd(markdown);

        return ResponseEntity.ok()
                .body(result);

    }

    @PostMapping(value = "/mdclassify")
    public ResponseEntity mdclassify(String title, String category) {
        log.info("mdclassify ");

        String result = markdownService.mdclassify(title, category);

        return ResponseEntity.ok()
                .body(result);

    }

}
