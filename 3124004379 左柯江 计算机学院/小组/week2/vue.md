```vue


常用指令


v-bind: 给html标签绑定属性值,比如设置href,css
v-model; 创建双向绑定
v-for:  列表的渲染`,遍历容器元素或者属性
v-show;  根据条件展示某元素,展示的元素可能要多次出现
v-if;    也是展示,但是展示的元素一般是次数较少的,如:是否登陆的提醒
v-if  v-else  v-else-if; 条件渲染


小技巧:v-on:click ===@click
      v-bind: === :



```







基础格式:

```html
开发环境版本(可以直接在vue2官网复制,或者下载)

<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>


基础格式:
var app = new vue({
  el: '#app',
  data:{
      message:{}
      methods:{
      方法名:function(){
     this关键字的使用,和java差不多

      }
   }
      mounted(){

}
    }
})



---------------------------------------------

生命周期(钩子)

mounted   挂在完成
mounted(){

}

```

标签



```html

超链接标签:
href:指定访问资源的url(<a>)
target:指定打开方式
       _self:默认值,在当前页面打开
       _blank:在空白页面打开
    
<a href="url" target="_blank">文字</a>
    
    
    
列表标签:
1.有序列表:
    <oi>
        <li>牛奶</li>
        <li>牛奶</li>
        <li>牛奶</li>
    </oi>
2.无序列表:
    <ul>
        <li>牛奶</li>
        <li>牛奶</li>
        <li>牛奶</li>
        
    </ul>
    
    
    
<oi>定义有序列表
<ul>定义无序列表
<li>定义列表项
    
表格标签
    <table width="50%" border="1" cellspaceing="0">
        <tr height="50%">
            <th rowspan></th>
        </tr>
        <tr height="50">
           <td>文本</td>        
           </tr>
        <tr align="center">
            <td>文本</td>
        </tr>          
    </table>
rowspan:指定单元格可以跨越的行数
colspan:指定单元格可以跨越的列数
    
表单标签:
    <!--
action :指定表单数据提交的url
method:指定表单提交方式
     1.get:默认方式,请求的参数会拼接在url后面,url长度限制4KB
     2.post:请求参数会在http请求协议的方法体中,参数无限制,推介
-->
    <form action="#" method="post">
    <label for="username"></label>
     
    <input type="text" name="username" id="username"><br>
        
    <label for="password" name="password" id="password"></label>
     <input type="radio" name="gender" value="1" id="male">
        <label for="male">男</label> 
        <input type="radio" name="gender" value="1" id="female">
        <label for="female">女</label> 
        
    </form>
    
    
    text:默认值,定义单行输入字段
    password:密码字段
    radio:单选按钮
    checkbox:复选框
    file
    hidden
    submit
    reset
    button: 可点击按钮
    
    
    
    
```

```html
Cascading Style Sheet
表现
三种方式:
第一种不写了,不太好
第二种:
<head>
    ...
    <style>
        span{
            
        }  
    </style>
</head>

第三种:
在外面写一个demo.css包,在导进去
<link href="../css/demo.css" rel="stylesheet">
      此处rel用来指定样式,这样子才能正确解析

选择器:
1.元素选择器
div{color:red}
2.id选择器
<div id="name">
    hello css2
</div>
3.类选择器
<div class="cls">
    hello css
</div>
      
<head>
    ...
    <style>
        div{
            color:red;
        }  
        
        #name{
            color:red;
        }
        
        .cls{
            color:red;
        }
        声明:谁指定的范围小谁生效
    </style>
</head>





```





JavaScript

```javascript
<script>
    window.alert("nihao");//写入警告框
    document.write("")//写入html页面
    console.log("")//写入控制台

</script>

弱类型语言:
变量:
和java一样


let关键字和var一样
let可以用在循环,局部变量(在他的代码块有效),不允许重复定义
var是全局变量

const 常量
变量可以重复定义



原始类型:
number:整数,小数,NaN(Not a Number)
string:
boolean:
null:
undefined:声明变量未初始化,默认NaN


//运算符
==和===
    ==:
1.判断类型是否一样,不一样,转换数据类型 
    ===:
1.判断类型,不一样,直接返回false


string:按照字符字面值,转为数字;字面值不是数字,转为NaN;使用parseInt
   var str=+"abc";
   alsert(parseInt(str)+1);




//流程控制是一样样的
//函数:
形式参数不需要数据类型
形参数也不需要完全一样
返回类型也可以不要
return 返回
var add=function(a,b){
    return a+b;

}

//数组
var arr=new Array(1,2,3);
var arr2=[1,2,3]

//string



//自定义对象

var person={
    name:
    age:
    eat:function(){
        alert("");
    }
}
alert(pertson.name+person.age);
person.eat;


//BOM对象(Browse Object Model)浏览器对象模型
javasrcipt将浏览器各个组成部分封装为对象



```

