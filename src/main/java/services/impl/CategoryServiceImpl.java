package services.impl;

import dao.ICategoryDao;
import dao.impl.CategoryDaoImpl;
import models.CategoryModel;
import services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public CategoryModel findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        return categoryDao.searchByName(keyword);
    }

    @Override
    public void insert(CategoryModel category) {
        CategoryModel categoryModel = this.findById(category.getCategoryid());
        if (categoryModel != null) {
            categoryDao.insert(categoryModel);
        }
    }

    @Override
    public void update(CategoryModel category) {
        CategoryModel categoryModel = this.findById(category.getCategoryid());
        if (categoryModel != null) {
            categoryDao.update(categoryModel);
        }

    }

    @Override
    public void delete(CategoryModel category) {
        categoryDao.delete(category);
    }

    @Override
    public void updateStatus(int id, int status) {
        categoryDao.updateStatus(id, status);
    }
}
