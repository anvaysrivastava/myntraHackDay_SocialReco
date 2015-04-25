var ProductModel = Backbone.Model.extend({
    initialize : function() {
    },

    url : function(id) {
        return "http://developer.myntra.com/style/" + id;
    },

    sync : function(x,y,options){
        var pid = options.productId || "";

        $.ajax({
            type : "GET",
            url : this.url(pid),
            success : options.success,
            dataType: "json",
            error: function(xhr, status, err){
                console.log(status);
            }
        });
    }
});