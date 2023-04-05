<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 3/14/2023
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
</head>
<body>
<div class="col-6">
    <a href="/BTVN_war_exploded/nhan-vien/create" class="btn btn-success">Thêm mới</a>
</div>
<c:if test="${f:length(danhsachNV)==0}">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${f:length(danhsachNV)!=0}">
    <table class="table">
        <thead>
        <tr>
                <%--            <th scope="col">ID</th>--%>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Tên Đệm</th>
                    <th scope="col">Họ</th>
                    <th scope="col">Giới tính</th>
                    <th scope="col">Ngày Sinh</th>
                    <th scope="col">Địa Chỉ</th>
                    <th scope="col">Số Điện Thoại</th>
                    <th scope="col">Mật Khẩu</th>
                    <th scope="col">Cửa Hàng</th>
                    <th scope="col">Chức vụ</th>
                    <th scope="col">IdGuiBC</th>
                    <th scope="col">TrangThai</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ danhsachNV }" var="nv">
            <tr>
                <td>${ nv.ma }</td>
                <td>${ nv.ten }</td>
                <td>${ nv.tenDem }</td>
                <td>${ nv.ho }</td>
                <td>${ nv.gioiTinh }</td>
                <td>${ nv.ngaySinh }</td>
                <td>${ nv.diaChi }</td>
                <td>${ nv.sdt }</td>
                <td>${ nv.matKhau }</td>
                <td>${ nv.cuaHang.ten }</td>
                <td>${ nv.chucVu.ten }</td>
                <td>${ nv.idGuiBC }</td>
                <td>${ nv.trangThai }</td>
                <td>
                    <a href="/BTVN_war_exploded/nhan-vien/edit?id=${ nv.id }" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="/BTVN_war_exploded/nhan-vien/delete?id=${ nv.id }" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
