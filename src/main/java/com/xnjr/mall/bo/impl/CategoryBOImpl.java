package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ICategoryBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.ICategoryDAO;
import com.xnjr.mall.domain.Category;
import com.xnjr.mall.enums.EPrefixCode;
import com.xnjr.mall.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年11月17日 上午8:32:03 
 * @history:
 */
@Component
public class CategoryBOImpl extends PaginableBOImpl<Category> implements
        ICategoryBO {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public boolean isCategoryExist(String code) {
        Category condition = new Category();
        condition.setCode(code);
        if (categoryDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCategory(Category data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EPrefixCode.CATEGORY.getCode());
            data.setCode(code);
            categoryDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCategory(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Category data = new Category();
            data.setCode(code);
            count = categoryDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCategory(Category data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = categoryDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Category> queryCategoryList(Category condition) {
        return categoryDAO.selectList(condition);
    }

    @Override
    public Category getCategory(String code) {
        Category data = null;
        if (StringUtils.isNotBlank(code)) {
            Category condition = new Category();
            condition.setCode(code);
            data = categoryDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该分类编号不存在");
            }
        }
        return data;
    }
}
