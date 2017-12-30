//显示更新与添加表单
var add=document.getElementById("add");
var div1=document.getElementsByClassName("form")[0];
add.onclick=function(e){
		div1.style.top="50%";
}

var update=document.getElementById("update")
var div2=document.getElementsByClassName("form")[1];
update.onclick=function(){
	div2.style.top="50%";
}





var topcontent=document.getElementsByClassName("topcontent")[0];

//异步删除并刷新数据
var delFun=function(){
	var xhreq=new XMLHttpRequest();
	xhreq.open("get","delete?id="+this.id,true);
	xhreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhreq.send();
	xhreq.onreadystatechange=function(){
		if(xhreq.readyState==4&&xhreq.status==200){
			alert("删除成功");
			getFun();
		}
	}

}

//异步获取数据
var get=document.getElementById("get");
function getFun(){
	topcontent.innerHTML="";
	var xhreq=new XMLHttpRequest();
	xhreq.open("get","get",true);
	xhreq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhreq.send();
	xhreq.onreadystatechange=function(){
		if(xhreq.readyState==4&&xhreq.status==200){
			var users=xhreq.responseText;
			var uo=JSON.parse(users);
			for(var i=0;i<uo.length;i++){
				var text=document.createTextNode(uo[i].id+"---"+uo[i].name+"---"+uo[i].no+"----------->");
				var a=document.createElement("a");
				var del=document.createTextNode("删除");
				a.appendChild(del);
				a.id=uo[i].id;
				a.onclick=delFun;
				var p=document.createElement("p");
				p.appendChild(text);
				p.appendChild(a);
				topcontent.appendChild(p);
				
			}
		}
	}
}
get.onclick=getFun;

//异步添加和更新数据，并验证表单是否为空，否则禁止提交
var input=document.getElementsByTagName("input");
var mes=document.getElementsByClassName("mes");
var btn=document.getElementsByClassName("sub");
btn[0].onclick=function(e){
	if(input[0].value==""||input[1].value==""||input[2].value==""){
		e.preventDefault();
		mes[0].style.transform="scale(1)";
	}else{
		addFun();
		div1.style.top="999px";
		div1.reset();
	}
}
btn[1].onclick=function(e){
	if(input[4].value==""||input[5].value==""||input[6].value==""){
		e.preventDefault();
		mes[1].style.transform="scale(1)";
	}else{
		updateFun();
		div2.style.top="999px";
	}
}


function addFun(){
	var xhreq=new XMLHttpRequest();
	xhreq.open("post","add",true);
	xhreq.setRequestHeader("Content-Type","application/json");
	var user={};
	user[input[0]["name"]]=input[0].value;
	user[input[1]["name"]]=input[1].value;
	user[input[2]["name"]]=input[2].value;
	xhreq.send(JSON.stringify(user));
	xhreq.onreadystatechange=function(){
		if(xhreq.readyState==4&&xhreq.status==200){
			alert("添加成功");
			getFun();
		}
	}
}
 function updateFun(){
		var xhreq=new XMLHttpRequest();
		xhreq.open("post","update",true);
		xhreq.setRequestHeader("Content-Type","application/json");
		var user={};
		user[input[4]["name"]]=input[4].value;
		user[input[5]["name"]]=input[5].value;
		user[input[6]["name"]]=input[6].value;
		xhreq.send(JSON.stringify(user));

 }












