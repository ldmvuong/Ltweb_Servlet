package dao;

import models.CategoryModel;

import java.util.List;

public interface ICategoryDao {
    List<CategoryModel> findAll();

    CategoryModel findById(int id);

    CategoryModel findByName(String name);

    List<CategoryModel> searchByName(String keyword);

    void insert(CategoryModel category);

    void update(CategoryModel category);

    void delete(CategoryModel category);

    void updateStatus(int id, int status);


}
