var FollowerPageView = Backbone.View.extend({
    initialize : function(options){
        this.follow = new FollowerCollection();
        this.follow.on("sync", _.bind(function(){
            this.render();
        },this));

        this.follow.fetch({
            'accountID' : 'Test'
        });
    },

    render: function(){
        var source = $("#follow-template").html();
        var template = Handlebars.compile(source);

        this.follow.each(function(followModel){
            console.log("working");
            $("#follow-page div ul").append(template({
                personName : followModel.getPersonName(),
                personAccId : followModel.getPersonId(),
                percentDiff : followModel.getPersonDifference()
            }));
        });
    }
});
