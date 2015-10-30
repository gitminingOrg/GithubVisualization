<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>GreenSock: TimelineLite Control</title>
    
	<link href="../static/js/jquery/css/ui-lightness/jquery-ui-1.9.1.custom.css" rel="stylesheet" type="text/css">
<style>
body{
	background-color:#000;
}
#demo {
	width: 692px;
	height: 70px;
	background-color: #333;
	padding: 8px;
}
#demoBackground{
	position:absolute;
	background-color:#000;
	overflow:hidden;
	width:692px;
	height:70px;
	visibility:hidden;
}	
#logo{
	position:absolute;
	background: url(../static/img/logo_black.jpg) no-repeat;
	height: 60px;
	width: 60px;
	top:6px;
}
#timelinelite{
	position:absolute;
	background: url(../static/img/timelinelite.png) no-repeat;
	left:50px;
	top:16px;
	width: 180px;
	height: 33px;
	overflow:hidden;
}	
#tagline{
	position:absolute;	
	left:236px;
	top:24px;
	width:306px;
	height:26px;
}		
#tagline span{
	position:relative;
	display:inline-block;
}	 
#slider{
	width: 692px;
	height:15px;
	margin:15px 0px 8px 6px;	
}
	 
</style>

</head>

<body>
<div id="demo">
    <div id="demoBackground">
		<div id="logo"></div>
		<div id="timelinelite"></div>
		<div id="tagline"><span><img src="../static/img/whos_61x26.png" width="61" height="26"></span><span><img src="../static/img/the_35x26.png" width="35" height="26"></span><span><img src="../static/img/boss_51x26.png" width="51" height="26"></span><span><img src="../static/img/of_27x26.png" width="27" height="26"></span><span><img src="../static/img/your_49x26.png" width="49" height="26"></span><span><img src="../static/img/tweens_83x26.png" width="83" height="26"></span>
        </div>
    </div>
</div>

<div id="slider"></div>
<div>
<input type="button" id="playBtn" value="play()">
<input type="button" id="pauseBtn" value="pause()">
<input type="button" id="resumeBtn" value="resume()">
<input type="button" id="reverseBtn" value="reverse()">
<input type="button" id="playFromBtn" value="play(1)">
<input type="button" id="reverseFromBtn" value="reverse(1)">
<input type="button" id="seekBtn" value="seek(1.5)"><br/>
<input type="button" id="timeScaleSlowBtn" value="timeScale(0.5)">
<input type="button" id="timeScaleNormalBtn" value="timeScale(1)">
<input type="button" id="timeScaleFastBtn" value="timeScale(2)">
<input type="button" id="restartBtn" value="restart()">
</div>


<script type="text/javascript" src="../static/js/greensock/TweenMax.min.js"></script>
<!-- scripts for jQuery UI slider component -->
<script src="../static/js/jquery/jquery-1.8.2.js"></script>
<script src="../static/js/jquery/jquery-ui-1.9.1.custom.min.js"></script>
<!-- script for making jQuery UI components respond to touch input -->
<script src="../static/js/jquery/jquery.ui.touch-punch.js"></script>

<script>
$(window).load(function() {
	var logo = $("#logo"),
		timelineLite = $("#timelinelite"),
		tagline = $("#tagline span"),
		playBtn = $("#playBtn"),
		pauseBtn = $("#pauseBtn"),
		resumeBtn = $("#resumeBtn"),
		reverseBtn = $("#reverseBtn"),
		playFromBtn = $("#playFromBtn"),
		reverseFromBtn = $("#reverseFromBtn"),
		seekBtn = $("#seekBtn"),
		timeScaleSlowBtn = $("#timeScaleSlowBtn"),
		timeScaleNormalBtn = $("#timeScaleNormalBtn"),
		timeScaleFastBtn = $("#timeScaleFastBtn"),
		restartBtn = $("#restartBtn"),
		tl = new TimelineLite({onUpdate:updateSlider});	
	
	tl.from(logo, 0.5, {left:'-=60px', ease:Back.easeOut})
	//next tween gets added 0.2 seconds before previous tween ends
  	  .from(timelinelite, 0.5, {width:"0px", alpha:0}, "-=0.2")
  	  .staggerFrom(tagline, 0.5, {top:"-=30px", rotation:"-40deg", alpha:0, scale:1.8, ease:Back.easeOut}, 0.2);
		  
	$( "#slider" ).slider({
            range: false,
            min: 0,
            max: 100,
			step:.1,
            slide: function ( event, ui ) {
                tl.progress( ui.value/100 ).pause();
            }
     });	
			
	function updateSlider() {
		$("#slider").slider("value", tl.progress() * 100);
	} 				  
		  	
	playBtn.click(function(){
		//Play the tween forward from the current position.
		//If tween is complete, play() will have no effect
		tl.play();
	});
	pauseBtn.click(function(){
		tl.pause();
	});
	resumeBtn.click(function(){
		//Resume playback in current direction.
		tl.resume();
	});
	reverseBtn.click(function(){
		tl.reverse();
	});
	playFromBtn.click(function(){
		//Play from a sepcified time (in seconds).
		tl.play(1);
	});
	reverseFromBtn.click(function(){
		//Reverse from a specified time (in seconds).
		tl.reverse(1);
	});
	seekBtn.click(function(){
		//Jump to specificied time (in seconds) without affecting
		//whether or not the tween is paused or reversed.
		tl.seek(1.5);
	});
	timeScaleSlowBtn.click(function(){
		//timescale of .5 will make the tween play at half-speed (slower).
		//Tween will take 12 seconds to complete (normal duration is 6 seconds).
		tl.timeScale(0.5);
	});
	timeScaleNormalBtn.click(function(){
		//timescale of 1 will make tween play at normal speed.
		tl.timeScale(1);
	});
	timeScaleFastBtn.click(function(){
		//timescale of 1 will make the tween play at double-speed (faster).
		//Tween will take 3 seconds to complete (normal duration is 6 seconds).
		tl.timeScale(2);
	});
	restartBtn.click(function(){
		//Start playing from a progress of 0.
		tl.restart();
	});
	
	//show the demoBackground div after DOM is ready and all images loaded
	TweenLite.set($("#demoBackground"), {visibility:"visible"});
	
});	

</script>

</body>
</html>
