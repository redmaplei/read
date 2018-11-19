package com.wys.read.web.rest.MarkdownController;

import com.wys.read.domain.Markdown;
import com.wys.read.exception.ReadErrorCodeEnum;
import com.wys.read.repository.MarkdownRepository;
import com.wys.read.service.MarkdownService;
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

    @Autowired
    MarkdownRepository markdownRepository;

    /**
     * 测试用
     * @return
     */
    @GetMapping(value = "/do")
    public ResponseEntity<Map<String, Object>> d() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("message", "Hello world");
        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
    }

    /**
     * 测试用
     */
    @GetMapping(value = "/test", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test() {
        System.out.println(" test --- \n 11/18" );
        return " test --- \n 11/18";
    }

    /**
     * 获得md 数量
     * @return
     */
    @GetMapping(value = "/getmdcount")
    @ResponseBody
    public ResponseEntity getmdcount() {
        log.info("getmdcount ");

        int count = markdownService.getmdCount();

        return ResponseEntity.ok()
                .body(count);
    }

    /**
     * 获得分类的数量
     * @param category
     * @return
     */
    @GetMapping(value = "/getCategorymdCount")
    public ResponseEntity getCategorymdCount(String category) {

        System.out.println("category = " + category);

        int count = markdownService.getCategorymdCount(category);

        return ResponseEntity.ok()
                .body(count);
    }

    /**
     * 获得最新的5篇md
     * @return
     */
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

    /**
     * 通过blogtitle获得一篇md
     * @param blogtitle
     * @return
     */
    @GetMapping(value = "/getmd")
    public ResponseEntity<Markdown> getmd(String blogtitle) {

        log.info("{}", blogtitle);

        Markdown markdown = markdownRepository.findMarkdownByBlogtitle(blogtitle);

        log.info("getmd  {}", markdown);

        return ResponseEntity.ok()
                .body(markdown);
    }

    /**
     * 分页获得md
     * @param page 获取的页数
     * @return
     */
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
     * 上传一篇md
     * @param markdown
     * @return
     */
    @GetMapping(value = "/uploadmd")
    public ResponseEntity uploadmd(String markdown) {

        if (markdown == null) {
            ReadErrorCodeEnum.SUCCESS.setMsg("md参数错误");
            return ResponseEntity.ok()
                    .body(ReadErrorCodeEnum.SUCCESS.getCode()+ReadErrorCodeEnum.SUCCESS.getMsg());
        }

        log.info("uploadmd {}", markdown);
//        @RequestBody Markdown markdown
//        String result = markdownService.uploadmd(markdown);

        return ResponseEntity.ok()
                .body("result");

    }

    /**
     * 将md进行分类
     * @param title
     * @param category
     * @return
     */
    @PostMapping(value = "/mdclassify")
    public ResponseEntity mdclassify(String title, String category) {
        log.info("mdclassify ");

        String result = markdownService.mdclassify(title, category);

        return ResponseEntity.ok()
                .body(result);

    }

}
