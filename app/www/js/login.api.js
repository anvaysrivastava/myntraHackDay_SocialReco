var loginAPI = {
    userId : "",
    FBLogin : function(){
        var that = this;
        facebookConnectPlugin.login( ["public_profile","email"], function (response) { 
            that.fetchFBProfile(response);
        }, function (response) { 
            alert(JSON.stringify(response));
            window.location.reload();
        });
    },
    fetchFBProfile: function(res){
        this.userId = res.authResponse.userID;
        var that = this;
        facebookConnectPlugin.api("/v2.3/me?fields=id,name,picture", ["public_profile","email"]
        , function(response){
            that.signupAPI(response);
        }, function(response){
            console.log(response);
        });
    },
    signupAPI : function(res){

        var query_params = {
            accountID: res.id,
            name: res.name,
            image : res.picture.data.url
        }

        $.ajax({
            type: 'GET',
            url: "http://10.0.12.152:8124/people/signup",
            dataType: "json",
            data : query_params,
            success: function(response){
                console.log("signed up successfully");
                window.location.href = "home.html"
            },
            error: function(xhr, status, error){

            }
        });
    }
}