var FeedCollection = Backbone.Collection.extend({
    model : FeedModel,

    initialize : function() {
        this.on("error", this.error, this);
    },

    url : function() {
        return "http://10.0.12.152:8124/fetch/feed";
    },

    sync : function(x,y,options){
        var id = options.accountID || "";

        var query_params = {
            accountID : id
        }

        $.ajax({
            type : "GET",
            url : this.url(),
            success : options.success,
            dataType: "json",
            data : query_params,
            error: function(xhr, status, err){
                console.log(status);
            }
        });
    },

    error: function (model, response, options) {
        console.log("ERROR");
        console.log(model);
        console.log(response);
        console.log(options);
    }
});