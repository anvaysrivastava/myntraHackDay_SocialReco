var FeedModel = Backbone.Model.extend({
    initialize : function(options){
        this.product = new ProductModel();
        this.on("add", _.bind(function(){
            this.fetchProductModel();
        },this));
    },

    fetchProductModel : function(){
        this.product.fetch({
            productId : this.get('productId')
        });
    },

    getFollowerString: function() {
        var like_list = this.get('peopleWhoLikedIt');
        var string = "Liked by " + like_list[0].name 
            + " & " + (like_list.length-1) + " other people";
        return string;
    },

    getProductId: function(){
        return this.get('productId');
    },

    getProductImage: function(){
        console.log(this.product.get('data').styleImages.default.imageURL);
        return this.product.get('data').styleImages.default.imageURL;
    }
});