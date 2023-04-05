<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 3/16/2023
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <label style="color: red;text-align: center"><h1>Cửa Hàng</h1></label>
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
<form method="POST" action="/BTVN_war_exploded/cua-hang/store">
    <div class="row">
        <div class="col-md-6">
            <div>
                <label for="exampleInputEmail1" class="form-label">Mã</label>
                <input type="text" title="Không để trống và nhập đúng A-Z,0-9"   pattern="[a-zA-Z0-9]*" required class="form-control"  name="ma" id="exampleInputEmail1">
            </div>
            <div>
                <label for="exampleInputEmail12" class="form-label">Tên</label>
                <input type="text" class="form-control" title="Không để trống và nhập đúng chữ" lang="vi"  pattern="[a-zA-Z]*" required name="ten"  id="exampleInputEmail12">
            </div>



        </div>
        <div class="col-md-6">

            <div>
                <label for="exampleInputEmail1456" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" title="Không để trống và nhập đúng chữ" lang="vi"  pattern="[a-zA-Z]*" name="diaChi" id="exampleInputEmail1456">
            </div>
            <div>
                <label for="exampleInputEmail1456" class="form-label">Thành phố</label>
                <select class="form-select" name="thanhPho" aria-label="Default select example">
                    <option selected></option>
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Viêng Chăn">Viêng Chăn</option>
                    <option value="Phnôm Pênh">Phnôm Pênh</option>
                </select>
            </div>
            <div>
                <label for="exampleInputEmail1456" class="form-label">Quốc Gia</label>
                <select class="form-select" name="quocGia" aria-label="Default select example">
                    <option selected></option>
                    <option value="Việt Nam">Việt Nam</option>
                    <option value="Lào">Lào</option>
                    <option value="Campuchia">Campuchia</option>
                </select>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-danger">Thêm</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
