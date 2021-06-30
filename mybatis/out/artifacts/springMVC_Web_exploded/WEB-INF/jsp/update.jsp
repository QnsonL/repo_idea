<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改员工信息</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>修改员工信息</h3></center>
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <form action="${pageContext.request.contextPath}/emp/update" method="post">
                <input type="hidden" name="id" value="${emp.empId}">
                <div class="form-group">
                    <label for="empName">员工名：</label>
                    <input type="text" class="form-control" id="empName" name="empName" value="${emp.empName}" placeholder="请输入姓名">
                </div>
                <div class="form-group">
                    <label for="deptId">部门：</label>
                    <input type="text" class="form-control" id="deptId" name="deptId" value="${emp.deptId}" placeholder="请输入部门">
                </div>
                <div class="form-group">
                    <label for="jobName">职务：</label>
                    <input type="text" class="form-control" id="jobName" name="jobName" value="${emp.jobName}" placeholder="请输入职务">
                </div>
                <div class="form-group">
                    <label for="joinDate">入职时间：</label>
                    <input type="text" class="form-control" id="joinDate" name="joinDate" value="${emp.joinDate}" placeholder="请输入入职时间">
                </div>
                <div class="form-group">
                    <label for="telephone">联系方式：</label>
                    <input type="text" class="form-control" id="telephone" name="telephone" value="${emp.telephone}" placeholder="请输入联系方式">
                </div>

                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交" />
                    <input class="btn btn-default" type="reset" value="重置" />
                    <input class="btn btn-default" type="button" onclick="history.go(-1)" value="返回" />
                </div>
            </form>
        </div>
        <div class="col-lg-3"></div>
    </div>
</div>
</body>
</html>