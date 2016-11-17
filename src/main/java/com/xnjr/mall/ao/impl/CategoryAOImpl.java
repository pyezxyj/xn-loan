package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ICategoryAO;
import com.xnjr.mall.bo.ICategoryBO;
import com.xnjr.mall.bo.IProductBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Category;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年11月17日 上午8:35:16 
 * @history:
 */
@Service
public class CategoryAOImpl implements ICategoryAO {

    @Autowired
    private ICategoryBO categoryBO;

    @Autowired
    private IProductBO productBO;

    @Override
    public String addCategory(Category data) {
        if (!EBoolean.NO.getCode().equals(data.getParentCode())) {
            checkParentCode(data.getParentCode());
        }
        return categoryBO.saveCategory(data);
    }

    @Override
    public void editCategory(Category data) {
        if (!categoryBO.isCategoryExist(data.getCode())) {
            throw new BizException("xn0000", "该分类编号不存在");
        }
        if (!EBoolean.NO.getCode().equals(data.getParentCode())) {
            checkParentCode(data.getParentCode());
        }
        categoryBO.refreshCategory(data);
    }

    private void checkParentCode(String parentCode) {
        if (!categoryBO.isCategoryExist(parentCode)) {
            throw new BizException("xn0000", "父节点编号不存在");
        }
    }

    @Override
    @Transactional
    public void dropCategory(String code) {
        Category data = categoryBO.getCategory(code);
        // 判断是否一级分类
        if (EBoolean.NO.getCode().equals(data.getParentCode())) {
            isUseCategoryProduct(code);
            Category condition = new Category();
            condition.setParentCode(code);
            List<Category> categoryList = categoryBO
                .queryCategoryList(condition);
            for (Category category : categoryList) {
                categoryBO.removeCategory(category.getCode());
            }
        } else {
            isUseTypeProduct(code);
        }
        categoryBO.removeCategory(code);
    }

    private void isUseCategoryProduct(String code) {
        Product condition = new Product();
        condition.setCategory(code);
        long totalCount = productBO.getTotalCount(condition);
        if (totalCount > 0) {
            throw new BizException("xn0000", "该大类已使用，无法删除");
        }
    }

    private void isUseTypeProduct(String code) {
        Product condition = new Product();
        condition.setType(code);
        long totalCount = productBO.getTotalCount(condition);
        if (totalCount > 0) {
            throw new BizException("xn0000", "该小类已使用，无法删除");
        }
    }

    @Override
    public Paginable<Category> queryCategoryPage(int start, int limit,
            Category condition) {
        return categoryBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Category> queryCategoryList(Category condition) {
        return categoryBO.queryCategoryList(condition);
    }

    @Override
    public Category getCategory(String code) {
        return categoryBO.getCategory(code);
    }
}
