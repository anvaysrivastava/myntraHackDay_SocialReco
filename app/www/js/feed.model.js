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

    getProductId: function(){
        return this.get('productId');
    },

    getProductImage: function(){
        console.log(this.product.get('data').styleImages.default.imageURL);
        return this.product.get('data').styleImages.default.imageURL;
    }
});