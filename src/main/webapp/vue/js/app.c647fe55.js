(function(t){function e(e){for(var n,r,o=e[0],c=e[1],l=e[2],m=0,d=[];m<o.length;m++)r=o[m],Object.prototype.hasOwnProperty.call(s,r)&&s[r]&&d.push(s[r][0]),s[r]=0;for(n in c)Object.prototype.hasOwnProperty.call(c,n)&&(t[n]=c[n]);u&&u(e);while(d.length)d.shift()();return i.push.apply(i,l||[]),a()}function a(){for(var t,e=0;e<i.length;e++){for(var a=i[e],n=!0,o=1;o<a.length;o++){var c=a[o];0!==s[c]&&(n=!1)}n&&(i.splice(e--,1),t=r(r.s=a[0]))}return t}var n={},s={app:0},i=[];function r(e){if(n[e])return n[e].exports;var a=n[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,r),a.l=!0,a.exports}r.m=t,r.c=n,r.d=function(t,e,a){r.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},r.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},r.t=function(t,e){if(1&e&&(t=r(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(r.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var n in t)r.d(a,n,function(e){return t[e]}.bind(null,n));return a},r.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return r.d(e,"a",e),e},r.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},r.p="";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],c=o.push.bind(o);o.push=e,o=o.slice();for(var l=0;l<o.length;l++)e(o[l]);var u=c;i.push([0,"chunk-vendors"]),a()})({0:function(t,e,a){t.exports=a("56d7")},"026d":function(t,e,a){},"034f":function(t,e,a){"use strict";a("85ec")},"03a5":function(t,e,a){},"0b26":function(t,e,a){"use strict";a("7d1f")},"33e2":function(t,e,a){},"4ba1":function(t,e){},"56d7":function(t,e,a){"use strict";a.r(e);a("e260"),a("e6cf"),a("cca6"),a("a79d");var n=a("2b0e"),s=a("2f62"),i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("router-view")],1)},r=[],o={name:"App",components:{}},c=o,l=(a("034f"),a("2877")),u=Object(l["a"])(c,i,r,!1,null,null,null),m=u.exports,d=a("8c4f"),p=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"index"},[a("mainav"),a("div",{staticClass:"search-area-wrapper"},[a("div",{staticClass:"search-area container"},[a("h3",{staticClass:"search-header"},[t._v("Questions & Answers")]),a("router-link",{attrs:{to:"/index"}},[a("a",{staticClass:"logo-img"})]),a("p",{staticClass:"search-tag-line",staticStyle:{"margin-top":"50px"}},[t._v(" 信息共享与交流平台，你问我答，让信息传递更简单！ ")]),a("form",{staticClass:"search-form clearfix",on:{submit:function(e){return e.preventDefault(),t.onSubmit(e)}}},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.search,expression:"search"}],staticClass:"search-term required",attrs:{type:"text",placeholder:"Type your search terms here"},domProps:{value:t.search},on:{input:function(e){e.target.composing||(t.search=e.target.value)}}}),a("input",{staticClass:"search-btn",attrs:{type:"submit",value:"搜索"},on:{click:t.searchbtn}}),a("div",{attrs:{id:"search-error-container"}})])],1)]),a("answer"),a("el-input",{attrs:{type:"text",placeholder:"请输入内容",maxlength:"40","show-word-limit":""},model:{value:t.text,callback:function(e){t.text=e},expression:"text"}}),a("div",{staticStyle:{margin:"20px 0"}}),a("el-input",{attrs:{type:"textarea",placeholder:"请输入内容",maxlength:"2000","show-word-limit":""},model:{value:t.textarea,callback:function(e){t.textarea=e},expression:"textarea"}}),a("foot")],1)},f=[],v=a("1da1"),h=a("5530"),g=(a("96cf"),a("a15b"),a("841c"),a("ac1f"),function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"foot"},[a("footer",{attrs:{id:"footer-wrapper"}},[a("div",{staticClass:"container",attrs:{id:"footer"}},[a("div",{staticClass:"row"},[t._m(0),t._m(1),t._m(2),a("div",{staticClass:"span3"},[a("section",{staticClass:"widget"},[a("h3",{staticClass:"title"},[t._v("客服中心")]),a("ul",[a("li",[a("router-link",{attrs:{to:"/fankui",title:"Lorem ipsum dolor sit amet,"}},[t._v("意见反馈")])],1),a("li",[a("router-link",{attrs:{to:"/shensu",title:"Lorem ipsum dolor sit amet,"}},[t._v("账号解封")])],1),a("li",[a("router-link",{attrs:{to:"/jubao",title:"Lorem ipsum dolor sit amet,"}},[t._v("不良行为举报")])],1)])])])])]),t._m(3)])])}),_=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"span3"},[a("section",{staticClass:"widget"},[a("h3",{staticClass:"title"},[t._v("网站主要功能")]),a("div",{staticClass:"textwidget"},[a("p",[t._v("“OOO”是OOOO大学信息发布与交流平台，用户通过注册账号后就可以发布信息和评论，你可以在这里进行求助和帮助他人")])]),a("h3",{staticClass:"title"},[t._v("公告")]),a("div",{staticClass:"textwidget"},[a("p",[t._v("禁止在本平台上发表不当言论 禁止出现辱骂他人的语言，一经发现进行封号处理")])])])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"span3"},[a("section",{staticClass:"widget"},[a("h3",{staticClass:"title"},[t._v("友情链接")]),a("ul",[a("li",[a("a",{attrs:{href:"#",title:"Lorem ipsum dolor sit amet,"}},[t._v("ooooo大学官网")])]),a("li",[a("a",{attrs:{href:"#",title:"Lorem ipsum dolor sit amet,"}},[t._v("OOOOO大学教务处")])]),a("li",[a("a",{attrs:{href:"http://www.guoang.xyz/",target:"“_blank”",title:"Lorem ipsum dolor sit amet,"}},[t._v("郭昂个人博客")])])])])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"span3"},[a("section",{staticClass:"widget"},[a("h3",{staticClass:"title"},[t._v("广告信息")]),a("div",{attrs:{id:"twitter_update_list"}},[a("ul",[a("li",[t._v("No ")])])])])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"footer-bottom-wrapper"}},[a("div",{staticClass:"container",attrs:{id:"footer-bottom"}},[a("div",{staticClass:"row"},[a("div",{staticClass:"span6"},[a("p",{staticClass:"copyright"},[t._v(" Copyright © 2019 - 哈哈哈 - "),a("a",{staticStyle:{color:"#858585"},attrs:{href:"http://www.miit.gov.cn/",target:"“_blank”"}},[t._v("陕 ICP 备 19016483 号-1")]),t._v(" - "),a("a",{staticStyle:{color:"#858585"},attrs:{href:"http://www.guoang.xyz/",target:"“_blank”"}},[t._v("www.guoang.xyz")])])])])])])}],w={name:"foot",props:{msg:String}},b=w,C=Object(l["a"])(b,g,_,!1,null,"c0025f24",null),x=C.exports,O=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"header-wrapper"},[a("header",[a("div",{staticClass:"container"},[t._m(0),a("nav",{staticClass:"main-nav"},[a("div",{staticClass:"menu-top-menu-container"},[a("ul",{staticClass:"clearfix",attrs:{id:"menu-top-menu"}},[a("router-link",{attrs:{to:"/",tag:"li","exact-active-class":"current-menu-item"}},[a("a",[t._v("首页")])]),a("router-link",{attrs:{to:"/help",tag:"li","exact-active-class":"current-menu-item"}},[a("a",[t._v("在线提问")])]),a("router-link",{attrs:{to:"/activity",tag:"li","exact-active-class":"current-menu-item"}},[a("a",[t._v("关注")])]),a("router-link",{attrs:{to:"/job",tag:"li","exact-active-class":"current-menu-item"}},[a("a",[t._v("个人中心")])]),a("router-link",{attrs:{to:"/oldstuff",tag:"li","exact-active-class":"current-menu-item"}},[a("a",[t._v("关于我们")])]),a("li",[a("router-link",{attrs:{to:"/login"}},[t._v("登录/注册")])],1)],1)]),a("select",{directives:[{name:"model",rawName:"v-model",value:t.selected,expression:"selected"}],staticClass:"responsive-nav",on:{change:[function(e){var a=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){var e="_value"in t?t._value:t.value;return e}));t.selected=e.target.multiple?a:a[0]},function(e){t.changeHref(parseInt(t.selected))}]}},[a("option",{attrs:{value:"1"}},[t._v("首页")]),a("option",{attrs:{value:"2"}},[t._v("在线提问")]),a("option",{attrs:{value:"3"}},[t._v("关注")]),a("option",{attrs:{value:"4"}},[t._v("个人中心")]),a("option",{attrs:{value:"5"}},[t._v("登录/注册")])])])])])])},y=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"logo-container"},[a("span",{staticStyle:{"font-size":"35px",color:"white"}},[t._v("Q & A 问答")]),a("span",{staticClass:"tag-line"},[t._v("网络交流平台")])])}],E={name:"mainav",data:function(){return{selected:1}},methods:{changeHref:function(t){switch(t){}}}},T=E,S=Object(l["a"])(T,O,y,!1,null,"0275ecb4",null),k=S.exports,j=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"page-bar"},[a("ul",[1==t.cur?a("li",[a("a",{staticClass:"banclick"},[t._v("上一页")])]):t._e(),t.cur>1?a("li",[a("a",{on:{click:function(e){t.pageClick,t.cur--}}},[t._v("上一页")])]):t._e(),t._l(t.indexs,(function(e){return a("li",{key:e,class:{active:t.cur==e}},[a("a",{on:{click:function(a){return t.btnClick(e)}}},[t._v(t._s(e))])])})),t.cur!=t.all?a("li",[a("a",{on:{click:function(e){t.pageClick,t.cur++}}},[t._v("下一页")])]):t._e(),t.cur==t.all?a("li",[a("a",{staticClass:"banclick"},[t._v("下一页")])]):t._e(),a("li",[a("a",[t._v("共"),a("i",[t._v(t._s(t.all))]),t._v("页")])])],2)])},N=[],$=(a("d3b7"),a("25f0"),{name:"pagebar",data:function(){return{index:1,all:2,cur:1,tolalPage:0}},methods:{dataListFn:function(t){var e=this,a={current:t,limit:10,qName:"标题",sortType:1,type:1};this.$axios({url:"/question/query",method:"DELETE",headers:{"Content-Type":"application/json;charset=UTF-8"},data:JSON.stringify(a)}).then((function(t){var a=t.data.data;if(200==t.data.state){e.dataList=[];for(var n=0;n<a.length;n++)e.dataList.push(a[n]);console.log(e.dataList)}}))},btnClick:function(t){t!=this.cur&&(this.cur=t),this.dataListFn(this.cur.toString())},pageClick:function(){this.dataListFn(this.cur.toString())}},computed:{indexs:function(){var t=1,e=this.all,a=[];this.all>=5&&(this.cur>3&&this.cur<this.all-2?(t=this.cur-2,e=this.cur+2):this.cur<=3?(t=1,e=5):(e=this.all,t=this.all-4));while(t<=e)a.push(t),t++;return a}}}),I=$,L=(a("a98d"),Object(l["a"])(I,j,N,!1,null,null,null)),P=L.exports,U={name:"index",components:{foot:x,mainav:k,answer:P},data:function(){return{password:"",password1:"",username:"",hover:!1,search:"",text:"",textarea:""}},computed:Object(h["a"])({},Object(s["c"])({isclose:function(t){return t.user.isclose},islogin:function(t){return t.user.islogin},avatar:function(t){return t.user.userinfo.avatar}})),methods:Object(h["a"])(Object(h["a"])({},Object(s["b"])("user",["setUserInfo","changeislog","setToken","join","close","setunread","deleteuserinfo"])),{},{logout:function(){this.deleteuserinfo(),this.$message.success("退出成功")},joinin:function(){this.join()},closein:function(){this.close()},onSubmit:function(){return!1},searchbtn:function(){""!=this.search?this.$router.push({path:"/search",query:{search:this.search}}):this.$message.error("关键字不能为空")},getnocitenmu:function(){var t=this;return Object(v["a"])(regeneratorRuntime.mark((function e(){var a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,t.$axios.post("/web/getnotice",t.qs.stringify({num:1}));case 2:a=e.sent,console.log(a.data),t.setunread(a.data.data.count);case 5:case"end":return e.stop()}}),e)})))()}}),created:function(){localStorage.luffy_jwt_token&&this.getnocitenmu()}},F=U,A=(a("0b26"),Object(l["a"])(F,p,f,!1,null,"0418e5c8",null)),M=A.exports,R=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"login"},[a("div",{staticClass:"sign-in-box clearfix"},[a("span",[t._v("账 号 登 录")]),a("router-link",{staticClass:"regi",attrs:{to:"/register"}},[t._v("没有账号？去注册")]),a("div",{staticClass:"in"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.username,expression:"username"}],attrs:{type:"text",name:"username",placeholder:"用户名",maxlength:"11"},domProps:{value:t.username},on:{input:function(e){e.target.composing||(t.username=e.target.value)}}}),a("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password",name:"password",maxlength:"10",minlength:"6",placeholder:"密码：6-10位数字、字母组合"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}})]),a("button",{staticClass:"loginbtn",on:{click:t.login}},[t._v("登录")])],1)])},D=[],J={name:"Login",data:function(){return{password:"",username:""}},computed:Object(h["a"])({},Object(s["c"])({isclose:function(t){return t.user.isclose},islogin:function(t){return t.user.islogin}})),methods:Object(h["a"])(Object(h["a"])({},Object(s["b"])("user",["setUserInfo","changeislog","setToken","join","close","setunread","deleteuserinfo"])),{},{login:function(){var t=this;if(""!=this.password&&""!=this.password){var e={password:this.password,username:this.username};this.$axios({url:"/user/login",method:"POST",headers:{"Content-Type":"application/json;charset=UTF-8"},data:JSON.stringify(e)}).then((function(e){e.data.data;if(console.log(e.data.data.user),200==e.data.state){t.$message.success("登录成功");var a=document.cookie;console.log(a),t.$axios({url:"/user/getCurrentUser",method:"GET",headers:{"Content-Type":"application/json;charset=UTF-8"}}).then((function(t){console.log(t)}))}403==e.data.state&&t.$message.error("该用户不存在，请前往注册"),400!=e.data.state&&402!=e.data.state||t.$message.error("请求异常，登陆失败")})).catch((function(e){t.$message(e)}))}else this.$message.error("账号或者密码为空")}})},z=J,q=(a("b4c0"),Object(l["a"])(z,R,D,!1,null,"5e288a4c",null)),G=q.exports,H=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"register"},[a("div",{staticClass:"sign-in-box clearfix"},[a("span",{staticClass:"regiline"},[t._v("欢 迎 注 册")]),a("router-link",{staticClass:"login",attrs:{to:"/login"}},[t._v("已有账号？去登录")]),a("div",{staticClass:"in-regi"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.username,expression:"username"}],attrs:{type:"text",name:"username",placeholder:"用户名",maxlength:"11"},domProps:{value:t.username},on:{input:function(e){e.target.composing||(t.username=e.target.value)}}}),a("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password",name:"password",maxlength:"10",minlength:"6",placeholder:"密码：6-10位数字、字母组合"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}}),a("input",{directives:[{name:"model",rawName:"v-model",value:t.pet_name,expression:"pet_name"}],attrs:{type:"text",name:"pet_name",placeholder:"昵称",maxlength:"11"},domProps:{value:t.pet_name},on:{input:function(e){e.target.composing||(t.pet_name=e.target.value)}}}),a("div",{staticClass:"get"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.e_mail,expression:"e_mail"}],attrs:{type:"e-mail",name:"e-mail",placeholder:"邮箱",maxlength:"20"},domProps:{value:t.e_mail},on:{input:function(e){e.target.composing||(t.e_mail=e.target.value)}}}),a("button",{staticClass:"sendver",on:{click:t.sendVerify}},[t._v(t._s(t.timecount))])]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.verification,expression:"verification"}],attrs:{type:"text",name:"verification",placeholder:"验证码"},domProps:{value:t.verification},on:{input:function(e){e.target.composing||(t.verification=e.target.value)}}})]),t._m(0),a("button",{staticClass:"regist",attrs:{type:"submit"},on:{click:t.registered}},[t._v("注册")])],1)])},Q=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"agree findpass"},[a("input",{attrs:{type:"radio"}}),a("label",{attrs:{for:""}},[t._v("阅读并接受《网络问答平台网络协议》")])])}],Z={name:"Register",data:function(){return{password:"",username:"",pet_name:"",e_mail:"",verification:"",time:60,timecount:"发送验证码"}},methods:{countDown:function(){var t=60,e=this;function a(){var a=setInterval((function(){t--,e.timecount=t+"秒后重新发送",0==t&&(clearTimeout(a),e.timecount="发送验证码",t=60)}),1e3)}a(e)},sendVerify:function(){var t=this;console.log(this.e_mail),this.$axios({url:"/email/sendEmail/registerCode",method:"POST",headers:{"Content-Type":"application/json;charset=UTF-8"},data:this.e_mail}).then((function(e){e.data;200==e.data.state&&t.$message.success("发送成功！")})).catch((function(e){t.$message.error(e)}))},registered:function(){var t=this,e=/^[1-9a-zA-Z]{1}[0-9a-zA-Z]{5,9}$/,a=/^[a-zA-Z]\w{5,17}$/;if(e.test(this.username))if(a.test(this.password)){var n={password:this.password,username:this.username,petName:this.pet_name,email:this.e_mail};this.$axios({url:"/user/register/"+this.verification,method:"POST",headers:{"Content-Type":"application/json;charset=UTF-8"},data:JSON.stringify(n)}).then((function(e){var a=e.data.data;alert(a),e.data.state,t.$message.success("注册成功请登录"),t.join()})).catch((function(e){t.$message.error(e)}))}else this.$message.error("密码为6-18位字母数字或下划线 字母开头");else this.$message.error("账号为6-10位字母数字字母")}}},K=Z,V=(a("80b1"),Object(l["a"])(K,H,Q,!1,null,"70ca5faa",null)),B=V.exports;n["default"].use(d["a"]);var W,X=[{path:"/",component:M,meta:{title:"首页"}},{path:"/register",component:B,meta:{title:"注册"}},{path:"/login",component:G,meta:{title:"登录"}}],Y=new d["a"]({routes:X}),tt=Y,et=a("ade3"),at=(a("1276"),{islogin:!0,isclose:!1,id:"",userinfo:JSON.parse(localStorage.getItem("userinfo"))||{avatar:""}}),nt={},st={SET_USERINFO:function(t,e){console.log(e),t.userinfo=e,localStorage.setItem("userinfo",JSON.stringify(e))},CHANGE_ISLOG:function(t){t.islog=!t.islog},DELETE_USERINFO:function(t){t.userinfo={avatar:""},window.localStorage.removeItem("userinfo"),window.localStorage.removeItem("luffy_jwt_token")},SET_TOKEN:function(t,e){t.token=e,window.localStorage.setItem("luffy_jwt_token",t.token)},JOIN:function(){at.islogin=!at.islogin},CLOSE:function(){at.isclose=!at.isclose},SET_UNREAD:function(t,e){t.unread=e}},it={setUserInfo:function(t,e){t.commit("SET_USERINFO",e)},changeislog:function(t){var e=t.commit;e("CHANGE_ISLOG")},join:function(t){var e=t.commit;e("JOIN")},close:function(t){var e=t.commit;e("CLOSE")},deleteuserinfo:function(t){var e=t.commit;e("DELETE_USERINFO")},setToken:function(t,e){var a=t.commit;a("SET_TOKEN",e)},setunread:function(t,e){var a=t.commit;a("SET_UNREAD",e)}},rt={namespaced:!0,state:at,getters:nt,mutations:st,actions:it},ot=a("4ba1");n["default"].use(s["a"]);var ct={commentnum:"",contentid:"",contentname:"",contentuserid:"",url:window.location.href.split("#")[0],info:""},lt={numCouter:function(t,e){return t.commentnum*t.commentnum},numCompare:function(t){return function(e){return t.commentnum>e}}},ut=(W={},Object(et["a"])(W,ot["SET_CONTENTID"],(function(t,e){t.contentid=e})),Object(et["a"])(W,"SET_COMMENTNUM",(function(t,e){t.commentnum=e})),Object(et["a"])(W,"SET_CONTENTINFO",(function(t,e){t.contentname=e.contentname,t.contentuserid=e.contentuserid})),W),mt={setcontentid:function(t,e){t.commit("SET_CONTENTID",e)},setcommentnum:function(t,e){var a=t.commit;a("SET_COMMENTNUM",e)},setcontentinfo:function(t,e){var a=t.commit;a("SET_CONTENTINFO",e)}},dt=new s["a"].Store({state:ct,actions:mt,mutations:ut,getters:lt,modules:{user:rt}}),pt=(a("b004"),a("b7a2"),a("60b2"),a("5b8c"),a("9c58"),a("03a5"),a("a3a0"),a("5c96")),ft=a.n(pt);a("0fae");n["default"].use(ft.a);a("026d");var vt=a("00e7"),ht=a.n(vt),gt=a("bc3a"),_t=a.n(gt);n["default"].use(s["a"]),n["default"].prototype.$cookie=ht.a,_t.a.defaults.withCredentials=!0,_t.a.defaults.baseURL="http://47.108.190.196/QAPlatform",n["default"].prototype.$axios=_t.a,_t.a.defaults.headers.post["Content-Type"]="application/x-www-form-urlencoded",n["default"].config.productionTip=!1,new n["default"]({el:"#app",router:tt,store:dt,render:function(t){return t(m)}})},"5b8c":function(t,e,a){},"60b2":function(t,e,a){},"7d1f":function(t,e,a){},"7dc8":function(t,e,a){},"80b1":function(t,e,a){"use strict";a("33e2")},"85ec":function(t,e,a){},"9c58":function(t,e,a){},a3a0:function(t,e,a){},a98d:function(t,e,a){"use strict";a("7dc8")},b004:function(t,e,a){},b4c0:function(t,e,a){"use strict";a("c127")},b7a2:function(t,e,a){},c127:function(t,e,a){}});