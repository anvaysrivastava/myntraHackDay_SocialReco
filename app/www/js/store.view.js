var StorePageView = Backbone.View.extend({
    initialize : function(options){
        this.storeItems = new StoreCollection();
        this.storeItems.on("sync", _.bind(function(){
            this.render();
        },this));

        this.storeItems.fetch({
            'searchTerm' : 'shoes'
        });
    },

    render: function(){
        var source = $("#store-template").html();
        var template = Handlebars.compile(source);

        this.storeItems.each(function(storeItem){
            var element = $(template({
                productId : storeItem.getProductId(),
                imageUrl : storeItem.getProductImage(),
                title: storeItem.getTitle(),
                price: storeItem.getPrice(),
                brand: storeItem.getBrand()
            }));
            $("#store-page div ul").append(element);
        });
    }
});
