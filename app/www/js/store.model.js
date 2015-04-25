var StoreModel = Backbone.Model.extend({
    initialize : function(options){
        // this = new ProductModel();
        // this.on("add", _.bind(function(){
            // this.fetchProductModel();
        // },this));
    },

    // fetchProductModel : function(){
    //     this.fetch({
    //         productId : this.get('productId')
    //     });
    // },

    getProductId: function(){
        return this.get('styleid');
    },

    getProductImage: function(){
        return this.get('search_image');
    },

    getTitle: function(){
        return this.get('product');
    },

    getBrand: function(){
        return this.get('brands_filter_facet');
    },

    getPrice: function(){
        return this.get('discounted_price');
    }
});