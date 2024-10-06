package controllers.admin;

import Constant.Path;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import models.CategoryModel;
import services.ICategoryService;
import services.impl.CategoryServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig()
@WebServlet(urlPatterns = {"/admin/categories","/admin/category/add","/admin/category/insert", "/admin/category/edit", "admin/category/update"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/admin/categories")){
            List<CategoryModel> list = categoryService.findAll();
            req.setAttribute("listcate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/category/add")){
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/category/edit")){
            int id = Integer.parseInt(req.getParameter("id"));
            CategoryModel category = categoryService.findById(id);
            req.setAttribute("cate", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/admin/category/insert")){

            //Lay du lieu tu form
            String categoryName = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String images = req.getParameter("images");

            // dua du lieu vao model
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setStatus(status);

//            String fname ="";
//            String uploadPath = Path.DIR;
//            File uploadDir = new File(uploadPath);
//            if(!uploadDir.exists()){
//                uploadDir.mkdir();
//            }
//
//            try{
//                Part part =req.getPart("images1");
//                if(part.getSize() > 0){
//                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//                    int index = fileName.lastIndexOf(".");
//                    String ext = fileName.substring(index +1);
//                    fname = System.currentTimeMillis() + "." +ext;
//
//                    part.write(uploadPath + "/" + fname);
//                    categoryModel.setImages(fname);
//                }
//
//            }
//            catch (FileNotFoundException d){
//
//            }
            categoryModel.setImages(images);

            categoryModel.setCategoryname(categoryName);
            // dua model vao pt insert
            categoryService.insert(categoryModel);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
            if(url.contains("/admin/category/edit")){

            }
        }
    }
}
