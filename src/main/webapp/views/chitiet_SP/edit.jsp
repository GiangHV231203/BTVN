<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 3/9/2023
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <label style="color: red;text-align: center"><h1>Chi tiết sản phẩm</h1></label>
    </div>
    <div class="col-md-4"></div>
</div>
<div class="row">
    <div class="col-md-4"><label>ID</label>
        <label>...</label></div>
    <div class="col-md-4"></div>

    <div class="col-md-4"></div>
</div>
<br>
<form method="POST" action="/BTVN_war_exploded/chitietSP/update?id=${ctsp.id}">
    <div class="row">
        <div class="col-md-6">
            <div>
                <label  class="form-label">ID Sản Phẩm</label>
                <select class="form-select" name="sanPham" aria-label="Default select example">
                    <c:forEach items="${listSanPham}" var="sp">
                        <option value="${sp.id}" ${ctsp.sanPham.ma == sp.ma ? "selected":""} >${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label class="form-label">ID Nhà Sản Xuất</label>
                <select class="form-select" name="nsx" aria-label="Default select example">
                    <c:forEach items="${listNsx}" var="nsx">
                        <option value="${nsx.id}" ${ctsp.nsx.ma == nsx.ma ? "selected":""} >${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label  class="form-label">ID Màu Sắc</label>
                <select class="form-select" name="mauSac" aria-label="Default select example">
                    <c:forEach items="${listMauSac}" var="ms">
                        <option value="${ms.id}" ${ctsp.mauSac.ma == ms.ma ? "selected":""} >${ms.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label  class="form-label">ID Dòng Sản Phẩm</label>
                <select class="form-select" name="dongSP" aria-label="Default select example">
                    <c:forEach items="${listDongSanPham}" var="dongSp">
                        <option value="${dongSp.id}" ${ctsp.dongSP.ma == dongSp.ma ? "selected":""} >${dongSp.ten}</option>
                    </c:forEach>
                </select>
            </div>




        </div>
        <div class="col-md-6">
            <div>
                <label for="exampleInputEmail1" class="form-label">Năm bán hàng</label>
                <input type="text" class="form-control" name="namBH" value="${ ctsp.namBH }"  id="exampleInputEmail1">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Mô tả</label>
                <input type="text" class="form-control" name="moTa" value="${ ctsp.moTa }"  id="exampleInputEmail12">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Số lượng tồn</label>
                <input type="text" class="form-control" name="soLuongTon" value="${ ctsp.soLuongTon }"  id="exampleInputEmail13">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Giá nhập</label>
                <input type="text" class="form-control" name="gianhap" value="${ ctsp.giaNhap }"  id="exampleInputEmail124">
            </div>
            <div>
                <label for="exampleInputEmail1" class="form-label">Giá bán</label>
                <input type="text" class="form-control" name="giaban" value="${ ctsp.giaBan }"  id="exampleInputEmail134">
            </div>

        </div>
    </div>
    <button type="submit" class="btn btn-danger">Thêm</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
