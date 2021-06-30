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
    <title>添加员工</title>

</head>
<body>
<div class="container">
    <center><h3>添加员工</h3></center>
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <form action="${pageContext.request.contextPath}/emp/save" method="post">
                <div class="form-group">
                    <label for="empName">员工名：</label>
                    <input type="text" class="form-control" id="empName" name="empName" placeholder="请输入员工名">
                </div>


                <%--需要用Ajax--%>
                <div class="form-group">
                    <label for="deptId">部门：</label>
                    <select id="deptId" name="deptId" class="form-control">
                    </select>
                </div>


                <div class="form-group">
                    <label for="jobName">职务：</label>
                    <select id="jobName" name="jobName" class="form-control">
                        <option>客户经理</option>
                        <option>销售经理</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="joinDate">入职时间：</label>
                    <input type="text" class="form-control" id="joinDate" name="joinDate" placeholder="请输入入职时间">
                </div>
                <div class="form-group">
                    <label for="telephone">联系方式：</label>
                    <input type="text" class="form-control" id="telephone" name="telephone" placeholder="请输入联系方式">
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
<!-- 1. 导入CSS的全局样式 -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<!-- 2. jQuery导入，建议使用1.9以上的版本 -->
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
<!-- 3. 导入bootstrap的js文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    // 形成下拉框 类型名称
    $("#deptId").click(function () {
        $.ajax({
            type: 'POST',
            url : '${pageContext.request.contextPath}/dept/findAll',
            contentType: 'application/json;charset=utf-8',
            success : function(data) {
                console.log(data[0].deptId)
                var list=data;
                var select=document.getElementById("deptId");
                if (list!=null || list.size()>0){
                    for (var c in  list){
                        var option=document.createElement("option");
                        option.setAttribute("value",list[c].deptId);
                        option.innerText=list[c].deptName;
                        select.appendChild(option);
                    }
                }
            }
        });
    })

</script>
</html>