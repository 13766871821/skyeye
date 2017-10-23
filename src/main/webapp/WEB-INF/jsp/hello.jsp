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
    /**
     * 下面是进行插件初始化
     * 你只需传入相应的键值对
     * */
    $('#form1').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {/*验证*/
            	custname: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '客戶姓名不能为空'
                        }
                    }
                },
                custTel: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '手机号不能为空'
                        }
                    }
                },
                custIdNo: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '身份证号不能为空'
                        }
                    }
                },
                custCardno: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '银行卡号不能为空'
                        }
                    }
                }
            }
        });
    
    $('#form2').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {/*输入框不同状态，显示图片的样式*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {/*验证*/
        	smsCode: {/*键名username和input name值对应*/
                message: 'The username is not valid',
                validators: {
                    notEmpty: {/*非空提示*/
                        message: '手机验证码不能为空'
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
	<div class="panel-body">1.发送手机验证码</div>
	<form id="form1" action="/submit_1" method="post" target="result" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label">客戶姓名</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="custname" name="custname" placeholder="请输入客戶姓名">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label">手机号</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="custTel" name="custTel" placeholder="请输入手机号">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label">身份证号</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="custIdNo" name="custIdNo" placeholder="请输入身份证号">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label">银行卡号</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="custCardno" name="custCardno" placeholder="请输入银行卡号">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label"> </label>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-primary">发送验证码</button>
<!-- 				<button type="button" class="btn btn-primary" id="b1Id">重置</button> -->
			</div>
		</div>
	</form>
	<div class="panel-body">2.输入手机验证码</div>
	<form id="form2" action="/submit_2" method="post" target="result" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label">验证码</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="smsCode" name="smsCode" placeholder="请输入验证码">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-1 control-label"> </label>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-primary">确认绑卡</button>
<!-- 				<button type="button" class="btn btn-primary" id="b2Id">重置</button> -->
			</div>
		</div>
	</form>
	<br />
	<div class="panel-body">返回信息</div>
	<div class="form-group">
		<div class="col-sm-2">
			<div class="form-group">
				<iframe name="result" style="width: 700px; height: 100px"></iframe>
				<div></div>
			</div>
		</div>
	</div>
</body>
</html>
