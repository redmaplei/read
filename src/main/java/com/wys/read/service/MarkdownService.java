package com.wys.read.service;

import com.wys.read.domain.Category;
import com.wys.read.domain.Markdown;
import com.wys.read.domain.MarkdownCategory;
import com.wys.read.repository.CategoryRepository;
import com.wys.read.repository.MarkdownCateGoryRepository;
import com.wys.read.repository.MarkdownRepository;
import com.wys.read.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 16:32 2018/10/6
 * @Modified By:
 */
@Service
public class MarkdownService {

    @Autowired
    MarkdownRepository markdownRepository;

    @Autowired
    MarkdownCateGoryRepository mCateGoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    /**
     * 获得md全部数量
     * @return
     */
    public int getmdCount() {

        int count = markdownRepository.findAll().size();

        return count;

    }

    /**
     * 根据md分类 获得分类的数量
     * @param category
     * @return
     */
    public int getCategorymdCount(String category) {

        MarkdownCategory markdownCategory = mCateGoryRepository.findMarkdownCategoryByCategory(category);
        int count = markdownCategory.getCount();
        return count;

    }

    /**
     * 获取最新发布的50篇md
     * @return
     */
    public List<Markdown> getNewmd() {

        List<Markdown> list = markdownRepository.findMarkdownsByTimeLimit();

        return list;
    }

    /**
     * 分页查询 一页查10条数据
     * @return
     */
    public List<Markdown> getPagemd(int page) {
        int size = 10;
        List<Markdown> list = markdownRepository.findMarkdownsByPage(page, size);

        return list;
    }

    /**
     * 上传md
     * @param markdown
     * @return
     */
    public String uploadmd(Markdown markdown) {

        //Markdown markdown = new Markdown("sad", "twitch", "twitch", "twitch");

        try {
            markdownRepository.save(markdown);
            return Code.UploadmdSuccess.toString();
        }catch (Exception e) {
            return Code.UploadmdAlready.toString();
        }

    }

    /**
     * 将md 分类
     * 分类成功 mdcategory count加1
     * @param title
     * @param category
     * @return
     */
    public String mdclassify(String title, String category) {

        if (title == null) {
            return Code.MdCategoryDefault.toString();
        }

        Category catego= new Category(title, category);

        try {
            categoryRepository.save(catego);
            int count = categoryRepository.countByCategory(category);

            MarkdownCategory markdownCategory = mCateGoryRepository.findMarkdownCategoryByCategory(category);
            markdownCategory.setCount(count + 1);
            mCateGoryRepository.save(markdownCategory);
            return Code.MdCategorySuccess.toString();
        }catch (Exception e) {
            return Code.MdCategoryAlready.toString();
        }
    }



}
