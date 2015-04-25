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
                var element = $(template({
                    productId : feedModel.getProductId(),
                    imageUrl : feedModel.getProductImage()
                }));

                // element
                //     .hammer({ preventDefault: true })
                //     .bind("swipeleft", function(ev){
                //         var e = ev.target;
                //         e.style.transition = 'all 100ms ease';
                //         e.style.transform = 
                //             e.style.webkitTransform = 
                //                 'translate3d( -' + ev.gesture.distance + 'px, 0, 0 )';
                //         console.log("reject");
                //     })
                //     .bind("swiperight", function(ev){
                //         var e = ev.target;
                //         e.style.transition = 'all 100ms ease';
                //         e.style.transform = 
                //             e.style.webkitTransform = 
                //                 'translate3d( ' + ev.gesture.distance + 'px, 0, 0 )';
                //         console.log("like");
                //     });
                $("#feed-page div ul").append(element);
            });
        });
    }
});
