package dao.impl;

import configs.DBConnectMySQL;
import dao.ICategoryDao;
import models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends DBConnectMySQL implements ICategoryDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from category";
        List<CategoryModel> list = new ArrayList<CategoryModel>();
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                list.add(category);

            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "select * from category where categoryid = ?";
        CategoryModel category = null;
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            conn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public CategoryModel findByName(String name) {
        String sql = "select * from category where categoryname = ?";
        CategoryModel category = null;
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            conn.close();
            ps.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        String sql = "select * from category where categoryname like ?";
        List<CategoryModel> list = null;
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "insert into category(categoryname, images, status) values(?,?,?)";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
            conn.close();
            ps.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(CategoryModel category) {
        String sql = "update category set categoryname = ?, images = ?, status = ? where categoryid = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryid());
            ps.executeUpdate();
            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(CategoryModel category) {
        String sql = "delete from category where categoryid = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, category.getCategoryid());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStatus(int id, int status) {
        String sql = "update category set status = ? where categoryid = ?";
        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
