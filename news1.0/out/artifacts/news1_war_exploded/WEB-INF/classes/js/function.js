/**
 * Created by weiyihu on 2017-06-07.
 */
function fun(form)
{
            if(form.username.value == ""){
                alert("name cannot be empty");
                return false;
            }
            if(form.password.value == ""){
                alert("password cannot be empty");
                return false;
            }
            if(form.email.value == ""){
                alert("email cannot be empty");
                return false;
            }
}