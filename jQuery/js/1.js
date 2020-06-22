/**
 * 使用不同的方式来获取DOM对象
 *
 * 1.根据标记的id属性来获取DOM对象，若获取的是单个的DOm对象，参数的格式：#id值
 *
 * 2.根据标记的class属性来获取DOm对象，获取到的是一个数组，参数的格式是.class值
 *
 * 3.根据标记对象的名称来获取DOM对象，获取到的是一个数组 参数的格式：标记名称，例如input
 */

function $(param) {

    var obj = new Object(); //创建一个管理对象来管理多个DOM对象,最终把管理对象返回给调用者

    var arr = new Array();

    //根据标记的id属性来获取DOM对象,获取的是单个对的DOM对象,参数的格式是:#id值
    if(param.indexOf("#") == 0){
        var id = param.substr(1);   //切分出id属性
        var domObj = document.getElementById(id);   //根据id属性获取单个的DOM对象

        arr.push(domObj);//把单个的数组对象保存到数组中去
    }

    //2.根据标记的class属性来获取DOM对象,获取到的是一个数组,参数的格式是:.calss值,例如:.aihao
    else if(param.indexOf('.') ==0){
        var classValue = param.substr(1);
        var domArr = document.getElementsByClassName(classValue);//获取到一个数组对象

        arr = domArr;//把多个DOM对象保存到数组中
    }

    //3.根据标记对象的名称来获取DOM对象，获取到的是一个数组 参数的格式：标记名称，例如input

    else{
        var domArr = document.getElementsByTagName(param);
        arr = domArr;//把多个DOM对象保存到数组中
    }

    //把管理对象和数组联系起来
    obj = arr;

    //给管理对象上面扩展属性和方法,来管理DOM对象

    obj.length = arr.length;//给obj对象动态扩展了length属性

    //给obj对象动态的扩展了val()方法
    //val方法,获取DOM对象的value属性,也就是把多个DOM对象的value值组织到一个字符串中并且返回

    obj.val = function(){
        var str = "";
        for (var i = 0;i<arr.length ;i++) {
            str+=arr[i].value +",";
        }
        //去掉,
        str = str.substring(0,str.length-1)
        return str;
    }

    //把管理对象返回给调用者
    return obj;
}