<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
    background-color:#000;
}
#demo {
    width: 692px;
    height: 60px;
    background-color: #333;
    padding: 8px;
}
#logo {
    position: relative;
    width: 60px;
    height: 60px;
    background: url(static/img/logo_black.jpg) no-repeat;
}
</style>
</head>
 
<body>
<div id="demo">
    <div id="logo"></div>
</div>
 
<!--- The following scripts are necessary to do TweenLite tweens on CSS properties -->
<script type="text/javascript" src="static/js/greensock/plugins/CSSPlugin.min.js"></script>
<script type="text/javascript" src="static/js/greensock/TweenLite.min.js"></script>
 
 
<script>
//we'll use a window.onload for simplicity, but typically it is best to use either jQuery's $(document).ready() or $(window).load() or cross-browser event listeners so that you're not limited to one.
window.onload = function(){
    var logo = document.getElementById("logo");
    TweenLite.to(logo, 1, {left:"632px"});
}
</script>
 
</body>
</html>