package com.bkap.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.bkap.dao.FlowerDao;
import com.bkap.dao.FlowerImpl;
import com.bkap.entities.Flower;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FlowerServlet")
public class FlowerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Các hằng số cấu hình
    private static final String UPLOAD_DIRECTORY = "images";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        FlowerDao flowerDao = new FlowerImpl();
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("flowers", flowerDao.getAll());
            request.getRequestDispatcher("index.jsp?page=flowertables").forward(request, response);
        } else if (action.equals("flowers")) {
            request.setAttribute("flowers", flowerDao.getAll());
            request.getRequestDispatcher("index.jsp?page=flowercells").forward(request, response);
        } else if (action.equals("detail") || action.equals("edit")) {
            String flowerid = request.getParameter("flowerid");
            request.setAttribute("flower", flowerDao.getById(flowerid));
            if (action.equals("detail"))
                request.getRequestDispatcher("index.jsp?page=flowerdetails").forward(request, response);
            else
                request.getRequestDispatcher("index.jsp?page=edit").forward(request, response);
        } else if (action.equals("delete")) {
            String flowerid = request.getParameter("flowerid");
            if (flowerDao.delete(flowerid))
                request.setAttribute("msg", "Xóa thành công");
            else
                request.setAttribute("msg", "Xóa không thành công");
            request.setAttribute("flowers", flowerDao.getAll());
            request.getRequestDispatcher("index.jsp?page=flowertables").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) {
            if (!JakartaServletFileUpload.isMultipartContent(request)) {
                PrintWriter writer = response.getWriter();
                writer.println("Request does not contain upload data");
                writer.flush();
                return;
            }

            DiskFileItemFactory  factory = DiskFileItemFactory.builder()
			
			.get();
            // factory.setSizeThreshold(THRESHOLD_SIZE);
            // factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);

            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            Flower f = new Flower();
            String pictureOld = null;

            try {
                List<FileItem> formItems = upload.parseRequest(request);
                Iterator<FileItem> iter = formItems.iterator();

                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (!item.isFormField()) {
                        f.setPicture(null);
                        if (item.getSize() > 0) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            item.write(Path.of(filePath));
                            f.setPicture(fileName);
                        }
                    } else {
                        String data = item.getString(Charset.forName("UTF-8"));
                        f.setActive(false);
                        if (item.getFieldName().equals("flowerid")) {
                            f.setFlowerId(data);
                        } else if (item.getFieldName().equals("flowername")) {
                            f.setFlowerName(data);
                        } else if (item.getFieldName().equals("unit")) {
                            f.setUnit(data);
                        } else if (item.getFieldName().equals("price")) {
                            f.setPrice(Float.parseFloat(data));
                        } else if (item.getFieldName().equals("priceold")) {
                            f.setPriceOld(Float.parseFloat(data));
                        } else if (item.getFieldName().equals("brief")) {
                            f.setBrief(data);
                        } else if (item.getFieldName().equals("description")) {
                            f.setDescription(data);
                        } else if (item.getFieldName().equals("active")) {
                            f.setActive(true);
                        } else if (item.getFieldName().equals("pictureOld")) {
                            pictureOld = data;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Date createdate = Date.valueOf(LocalDate.now());
            f.setCreateDate(createdate);
            if (f.getPicture() == null)
                f.setPicture(pictureOld);

            if (action.equals("insert")) {
                if (flowerDao.insert(f))
                    request.setAttribute("msg", "Thêm thành công");
                else
                    request.setAttribute("msg", "Thêm không thành công");
            } else {
                if (flowerDao.update(f))
                    request.setAttribute("msg", "Sửa thành công");
                else
                    request.setAttribute("msg", "Sửa không thành công");
            }

            request.setAttribute("flowers", flowerDao.getAll());
            request.getRequestDispatcher("index.jsp?page=flowertables").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}