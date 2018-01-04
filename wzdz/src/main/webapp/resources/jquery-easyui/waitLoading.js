		
function loadingBegin(loadMsg){
	if(loadMsg == undefined)
		loadMsg = '加载中...';
	var msgDiv;
	msgDiv = document.createElement("DIV");
	msgDiv.id="msgDiv";
	msgDiv.style.position="absolute";
	msgDiv.style.zIndex=10000;
    msgDiv.style.display="";
    msgDiv.style.left=0;
    msgDiv.style.top=0;
    msgDiv.style.border="1px solid gray"
    msgDiv.style.background="#ffffff"
    msgDiv.style.padding="5";
    
	var scrollTop=document.body.scrollHeight/2;
	var scrollWid = document.body.scrollWidth/2-50;
	
	msgDiv.style.left = scrollWid+"px";
	msgDiv.style.top  = (scrollTop - 5)+"px" ;
	
	msgDiv.innerHTML = "<h>"+loadMsg+"</h>"; 
	
	var sWidth,sHeight;
	sWidth=document.body.scrollWidth;
	sHeight=document.body.scrollHeight;
	var bgDiv=document.createElement("div");
	bgDiv.setAttribute('id','bgDiv');
	bgDiv.style.position="absolute";
	bgDiv.style.top="0";
	bgDiv.style.background="#gray";
	bgDiv.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
	bgDiv.style.opacity="0.6";
	bgDiv.style.left="0";
	bgDiv.style.width=sWidth + "px";
	bgDiv.style.height=sHeight + "px";
	bgDiv.style.zIndex="10000";
	document.body.appendChild(bgDiv);
	document.body.appendChild(msgDiv);

}


function loadingEnd(){
	document.body.removeChild(document.getElementById("msgDiv"));
	document.body.removeChild(document.getElementById("bgDiv"));			
}