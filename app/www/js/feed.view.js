var FeedPageView = Backbone.View.extend({
    initialize : function(options){
        this.feed = new FeedCollection();
        this.feed.on("sync", _.bind(function(){
            this.render();
        },this));

        this.feed.fetch({
            'accountID' : 'Test'
        });
    },

    render: function(){
        var source = $("#feed-template").html();
        var template = Handlebars.compile(source);

        this.feed.each(function(feedModel){
            feedModel.product.on("sync",function(){
                console.log("working");
                $("#feed-page div ul").append(template({
                    productId : feedModel.getProductId(),
                    imageUrl : feedModel.getProductImage()
                }));
            });
        });
    }
});
