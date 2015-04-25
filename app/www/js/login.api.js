var loginAPI = {
    FBLogin : function(){
        facebookConnectPlugin.login( ["email"], function (response) { 
            alert(JSON.stringify(response));
        }, function (response) { 
            alert(JSON.stringify(response));
            window.location.reload();
        });
    },
    signupAPI : function(){
        // /people/signup
    }
}