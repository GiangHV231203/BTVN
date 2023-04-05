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
<c:if test="${f:length(danhsachCTSP)==0}">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${f:length(danhsachCTSP)!=0}">
    <table class="table">
        <thead>
        <tr>
                <%--            <th scope="col">ID</th>--%>

            <th scope="col">IdSP</th>
            <th scope="col">idNsx</th>
            <th scope="col">idMauSac</th>
            <th scope="col">idDongSP</th>
            <th scope="col">Năm bao hanh</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Số lượng tồn</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Giá bán</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ danhsachCTSP }" var="ctsp">
            <tr>

                <td>${ ctsp.sanPham.ten }</td>
                <td>${ ctsp.nsx.ten }</td>
                <td>${ ctsp.mauSac.ten }</td>
                <td>${ ctsp.dongSP.ten }</td>
                <td>${ ctsp.namBH }</td>
                <td>${ ctsp.moTa }</td>
                <td>${ ctsp.soLuongTon }</td>
                <td>${ ctsp.giaNhap }</td>
                <td>${ ctsp.giaBan }</td>

                <td>
                    <a href="/BTVN_war_exploded/chitietSP/edit?id=${ctsp.id}" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="/BTVN_war_exploded/chitietSP/delete?id=${ctsp.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
