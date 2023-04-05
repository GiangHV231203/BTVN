<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="khach-hang/create">KhachHang</a> <br>--%>
<%--<a href="chuc-vu/create">Chucvu</a> <br>--%>
<%--<a href="san-pham/create">SanPham</a> <br>--%>
<%--<a href="nsx/create">NhaSanXuat</a> <br>--%>
<%--<a href="mau-sac/create">MauSac</a> <br>--%>
<%--<a href="cua-hang/create">CuaHang</a> <br>--%>
<%--<a href="nhan-vien/create">NhanVien</a> <br>--%>
<%--<a href="dongSP/create">DongSP</a> <br>--%>
<%--<div><marquee> <h3>--Hoàng Vĩnh Giang PH23041--</h3> </marquee></div>--%>

<%--<nav class="navbar navbar-expand-lg bg-body-tertiary">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="#" style="color: red">Assignment</a>--%>
<%--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarNav">--%>
<%--            <ul class="navbar-nav">--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link active" style="color: blue" aria-current="page" href="khach-hang/create">KhachHang</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" style="color: blueviolet" href="chuc-vu/create">Chucvu</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" style="color: brown" href="san-pham/create">SanPham</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link " style="color: deeppink" href="nsx/create" >NhaSanXuat</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link " style="color: burlywood" href="mau-sac/create">MauSac</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link " style="color: orange" href="cua-hang/create">CuaHang</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link " style="color: darkgreen" href="nhan-vien/create">NhanVien</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link " style="color: purple" href="dongSP/create">DongSP</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link " style="color: deeppink" href="chitietSP/create" >ChiTietSP</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="login" class="nav-link px-2 text-white">Đăng nhập</a></li>
                <li><a href="khach-hang/index" class="nav-link px-2 text-white">Khách Hàng</a></li>
                <li><a href="chuc-vu/index" class="nav-link px-2 text-white">Chức Vụ</a></li>
                <li><a href="san-pham/index" class="nav-link px-2 text-white">Sản Phẩm</a></li>
                <li><a href="nsx/index" class="nav-link px-2 text-white">Nhà Sản Xuất</a></li>
                <li><a href="mau-sac/index" class="nav-link px-2 text-white">Màu Sắc</a></li>
                <li><a href="cua-hang/index" class="nav-link px-2 text-white">Cửa Hàng</a></li>
                <li><a href="nhan-vien/index" class="nav-link px-2 text-white">Nhân Viên</a></li>
                <li><a href="dongSP/index" class="nav-link px-2 text-white">Dòng Sản Phẩm</a></li>
                <li><a href="chitietSP/index" class="nav-link px-2 text-white">Chi Tiết Sản Phẩm</a></li>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
            </form>

        </div>
    </div>
</header>

<!-- Remove the container if you want to extend the Footer to full width. -->
<div class=" my-5">
    <!-- Footer -->
    <footer
            class="text-center text-lg-start text-white"
            style="background-color: #3e4551;"

    >
        <!-- Grid container -->
        <div class="container p-4 pb-0">
            <!-- Section: Links -->
            <section class="">
                <!--Grid row-->
                <div class="row">
                    <!--Grid column-->
                    <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">HOÀNG VĨNH GIANG</h5>

                        <p>
                            ASSIGNMENT
                        </p>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-2 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Products</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">MDBootstrap</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">MDWordPress</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">BrandFlow</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Bootstrap Angular</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-2 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Useful links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Your Account</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Become an Affiliate</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Shipping Rates</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Help</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-2 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Contact</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Vĩnh Tường,Vĩnh Phúc</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">gianghvph23041@fpt.edu.vn</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">0348079278</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">0348888888</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </section>
            <!-- Section: Links -->

            <hr class="mb-4" />

            <!-- Section: CTA -->
            <section class="">
                <p class="d-flex justify-content-center align-items-center">
<%--                    <span class="me-3">Register for free</span>--%>

                </p>
            </section>
            <!-- Section: CTA -->

            <hr class="mb-4" />

            <!-- Section: Social media -->
            <section class="mb-4 text-center">
                <!-- Facebook -->
                <a
                        class="btn btn-outline-light btn-floating m-1"
                        href="https://www.facebook.com/"
                        role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Twitter -->
                <a
                        class="btn btn-outline-light btn-floating m-1"
                        href="#!"
                        role="button"
                ><i class="fab fa-twitter"></i
                ></a>

                <!-- Google -->
                <a
                        class="btn btn-outline-light btn-floating m-1"
                        href="https://myaccount.google.com/?hl=vi&utm_source=OGB&utm_medium=act"
                        role="button"
                ><i class="fab fa-google"></i
                ></a>

                <!-- Instagram -->
                <a
                        class="btn btn-outline-light btn-floating m-1"
                        href="https://www.instagram.com/"
                        role="button"
                ><i class="fab fa-instagram"></i
                ></a>

                <!-- Linkedin -->
                <a
                        class="btn btn-outline-light btn-floating m-1"
                        href="#!"
                        role="button"
                ><i class="fab fa-linkedin-in"></i
                ></a>

                <!-- Github -->
                <a
                        class="btn btn-outline-light btn-floating m-1"
                        href="https://github.com/"
                        role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>
            <!-- Section: Social media -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div
                class="text-center p-3"
                style="background-color: rgba(0, 0, 0, 0.2)"
        >
            © 2023 HVG:
            <a class="text-white" href="https://github.com/"
            >giang031223.com</a
            >
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</div>
<!-- End of .container -->
<script src="https://kit.fontawesome.com/acab08070e.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>