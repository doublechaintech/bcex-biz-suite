<style>
#login_tool_container {
	float: right;
}
#login_tool_container button {
	font-size: 1em;
	padding: 2px 5px;
	border-radius: 5px;
	border: none;
	display: inline-block;
	background-color: initial;
}
</style>
<div style="display: block;margin-bottom: 10px;padding-bottom: 5px;box-shadow: 0px 10px 10px lightgray;">
	<div class="menu">
		[<a href="viewHomepage/">首页</a>]
		[<a href="customerViewDashboard/">我的</a>]
		<span style="padding: 0px 20px">|</span>
		[<a href="openWxappLoginPage/">登录</a>]
		[<a href="wxappLogOut/">登出</a>]
		[<a href="devTools/" target="_blank">工具</a>]
		
		<div id="login_tool_container">
			<form action="wxappService/clientLogin/" method="put">
			<label>Code|ID</label><input id="code" />
			<button onClick="javascript:clientLogin()" type="button">企业微信Code登录</button>
			<button onClick="javascript:debugLogin()" type="button">直接ID登录</button>
			</form>
		</div>

	</div>
	
</div>

<script type="text/javascript">
function clientLogin() {
	/* $.ajax({
		url: "clientLogin/",
		type: 'PUT',
		data: JSON.stringify({ 
        	loginMethod:"wechat_work_app",
        	code:$('#code').val()
			}),
		success: function(data,message,xhr) {
		    // alert(JSON.stringify(data));
		    // alert(JSON.stringify(message));
		    // alert(JSON.stringify(xhr.getResponseHeader('Authorization')));
		    
		    var d = new Date();
		    d.setTime(d.getTime() + (7*24*60*60*1000));
		    var expires = "expires="+d.toUTCString();
		    alert(xhr.getResponseHeader('Authorization'));
		    // document.cookie="Authorization="+xhr.getResponseHeader('Authorization') + "; " + expires;
		    // alert(document.cookie);
		  }
	}); */
	
}
function clientLogin() {
	var url = "loginForTest/formData/";
	var formData = { 
        	loginMethod:"wechat_work_app",
        	code:$('#code').val()
			};
	$("#input4submitFormData").val(JSON.stringify(formData));
	$("#form4submit")[0].action = url;
	$("#form4submit")[0].submit();
}
function debugLogin() {
	var url = "loginForTest/formData/";
	var formData = { 
        	loginMethod:"debug",
        	id:$('#code').val()
			};
	$("#input4submitFormData").val(JSON.stringify(formData));
	$("#form4submit")[0].action = url;
	$("#form4submit")[0].submit();
}
</script>
