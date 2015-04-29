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

        $(".reg-button").click(this.followUser);
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
