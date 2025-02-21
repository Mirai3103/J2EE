<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product List</title>

    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body class="bg-gray-100 text-gray-900">

    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>

    <div class="container mx-auto p-6">
        <h3 class="text-2xl font-semibold mb-4">Product List</h3>

        <p class="text-red-500">${errorString}</p>

        <!-- Hiển thị bảng với DisplayTag -->
        <div class="overflow-x-auto">
            <display:table name="productList" pagesize="5" class="min-w-full border border-gray-300 bg-white rounded-lg shadow-md"
                           requestURI="productList" export="true" defaultsort="1" defaultorder="ascending">
                
                <!-- Các cột -->
                <display:column property="code" title="Code" sortable="true" class="px-4 py-2 border"/>
                <display:column property="name" title="Name" sortable="true" class="px-4 py-2 border"/>
                <display:column property="price" title="Price" sortable="true" format="{0,number,#,##0.00}" total="true" class="px-4 py-2 border"/>

                <!-- Cột chỉnh sửa -->
                <display:column title="Edit" class="px-4 py-2 border">
                    <a href="editProduct?code=${product.code}" class="text-blue-500 hover:underline">Edit</a>
                </display:column>

                <!-- Cột xóa -->
                <display:column title="Delete" class="px-4 py-2 border">
                    <a href="deleteProduct?code=${product.code}" class="text-red-500 hover:underline">Delete</a>
                </display:column>

                <!-- Cấu hình export (Excel, CSV, XML, PDF) -->
                <display:setProperty name="export.excel" value="true"/>
                <display:setProperty name="export.csv" value="true"/>
                <display:setProperty name="export.xml" value="true"/>
                <display:setProperty name="export.pdf" value="true"/>

            </display:table>
        </div>

        <a href="createProduct" class="mt-4 inline-block bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">
            Create Product
        </a>
    </div>

    <jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
