<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet" />
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>

	<script type="text/javascript">
$(document).ready(function() {
       
    $('#form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {/*输入框不同状态，显示图片的样式*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {/*验证*/
        	pInfo: {/*键名username和input name值对应*/
                message: 'The pInfo is not valid',
                validators: {
                    notEmpty: {/*非空提示*/
                        message: '传入报文不能为空'
                    }
                }
            }
        }
    });
});
</script>
</head>
<title>测试页面</title>
<body>
	<div class="panel-body"></div>
	<form id="form" action="/pMonitor" method="post" target="result" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label">报文123</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="pInfo" name="pInfo" placeholder="请输入模拟报文">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label"> </label>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-primary">确认</button>
			</div>
		</div>
	</form>
	<br />
	<div class="panel-body">返回信息</div>
	<div class="form-group">
		<div class="col-sm-2">
			<div class="form-group">
				<iframe name="result" style="width: 700px; height: 50px"></iframe>
				<div></div>
			</div>
		</div>
	</div>
</body>
</html>
