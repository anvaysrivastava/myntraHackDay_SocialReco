var StoreCollection = Backbone.Collection.extend({
    model : StoreModel,

    initialize : function() {
        this.on("error", this.error, this);
    },

    url : function(searchTerm) {
        return "http://developer.myntra.com/search/data/" + searchTerm;
    },

    sync : function(x,y,options){
        var searchTerm = options.searchTerm || "";

        // var query_params = {
        //     accountID : id
        // }

        $.ajax({
            type : "GET",
            url : this.url(searchTerm),
            success : options.success,
            dataType: "json",
            // data : query_params,
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
    },

    parse : function(res){
        return res.data.results.products;
    }
});