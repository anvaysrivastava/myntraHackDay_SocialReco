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
        var that = this;

        this.feed.each(function(feedModel){
            feedModel.product.on("sync",function(){
                console.log("working");
                var element = $(template({
                    productId : feedModel.getProductId(),
                    imageUrl : feedModel.getProductImage(),
                    likeString : feedModel.getFollowerString()
                }));
                $("#feed-page div ul").append(element);
                $(".reg-button").unbind("click").bind("click", that.followUser);

            });
        });
    
    },

    followUser : function(ev) {
        // http://localhost:8124/register/product/swipe?&swipeResponse=true

        var productId = $(ev.target.parentNode).data('id');
        var regType = $(ev.target.parentNode).data('type');

        var listElement = $(ev.target.parentNode.parentNode.parentNode);

        var swipeResponse = regType === "like" ? true : false;
        console.log('register ' + regType + " for " + productId);


        var query_params = {
            //TODO
            accountID : "AI1",
            productID : productId,
            swipeResponse : swipeResponse
        }

        $.ajax({
            type : "GET",
            url : 'http://10.0.12.152:8124/register/product/swipe',
            success : function(res){
                console.log('successfully registered');
                if(swipeResponse === true){
                    listElement.html("<div class='like-message'>Liked</div>");
                }else {
                    listElement.html("<div class='pass-message'>Disliked</div>");
                }
            },
            dataType: "json",
            data : query_params,
            error: function(xhr, status, err){
                console.log(status);
            }
        });
    }
});
