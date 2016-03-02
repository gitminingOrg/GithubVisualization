<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Not Found</title>
<style>

#demo {
    width: 692px;
    height: 60px;
    padding: 8px;
}
#logo {
    position: relative;
    width: 400px;
    height: 400px;
    background: url(static/img/error.jpg) no-repeat;
}
</style>
</head>
 
<body>
<center>
<div>
<h2 style="color:red">Page Not Found</h2>
</div>
<div id="demo">
    <div id="logo"></div>
</div>
</center>
 
<!--- The following scripts are necessary to do TweenLite tweens on CSS properties -->
<script type="text/javascript" src="static/js/greensock/plugins/CSSPlugin.min.js"></script>
<script type="text/javascript" src="static/js/greensock/TweenLite.min.js"></script>
 
 
<script>
//we'll use a window.onload for simplicity, but typically it is best to use either jQuery's $(document).ready() or $(window).load() or cross-browser event listeners so that you're not limited to one.
window.onload = function(){
    var logo = document.getElementById("logo");
    TweenLite.to(logo, 3, {left:"300px"});
}
</script>
 
</body>
</html>