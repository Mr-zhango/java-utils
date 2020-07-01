//当用户点击提交按钮的时候,执行表单校验函数
//表单校验的规则是
//1.用户名,密码,确认密码不能为空
//2.用户名,密码,确认密长度不能小于6位
//3.密码,确认必须一致
//4.校验通过返回true,校验失败,返回false

/*检测思路:获取页面中的标记对象,然后判断页面中标记的value值,*/
function checkForm() {
    //检测用户名是否有效
    var userName = document.getElementById("userName");
    //检验两次输入的密码是否一致
    var pwd = document.getElementById("pwd");
    //重复密码
    var repwd = document.getElementById("repwd");
    if (userName.value == "" || userName.value == "请输入用户名") {
        window.alert("用户名不能为空");
        //弹出信息提示框之后再次把光标再次放在这个位置,获取焦点,便于用户重新输入
        userName.focus();
        //校验失败,返回false
        return false;
    }
    //用户在输入框中输入的数据,是一个类似java中String类型的数据,该数据上有个length属性,就是数据的长度
    else if (userName.value.length < 6) {
        //window其实是可以忽略不写的
        alert("用户名不能小于6位");
        userName.focus();
        return false;
    }
    if (pwd.value == "") {
        alert("密码不能为空");
        pwd.focus();
        return false;
    } else if (pwd.value.length < 6) {
        alert("密码长度不能小于6位");
        pwd.focus();
        return false;
    }
    else if (pwd.value != repwd.value) {
        alert("两次输入的密码不一致,请重新输入!!");
        pwd.focus();
        return false;
    }
    //校验成功,返回true
    return true;
}


//点击输入的时候,清空输入框提示信息函数
function clearValue() {
    var userName = document.getElementById("userName");
    if (userName.value == "请输入用户名") {
        //设置输入框的值为空
        userName.value = "";
    }
//            alert("现在点我干啥?")
}