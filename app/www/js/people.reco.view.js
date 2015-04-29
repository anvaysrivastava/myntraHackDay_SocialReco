var RecoPageView = Backbone.View.extend({
    initialize : function(options){
        this.reco = new RecoCollection();
        this.reco.on("sync", _.bind(function(){
            this.render();
        },this));
        var that= this;

        $("#search-submit").click(function(){
            var searchString = $("#search").val();
            that.reco.fetch({
                //TODO
                'accountID' : 'AI1',
                'searchString' : searchString
            });
        });
    },

    events :{
        'click #follow-button' : 'followUser'
    },

    render: function(){
        var source = $("#reco-template").html();
        var template = Handlebars.compile(source);

        this.reco.each(function(recoModel){
            console.log("working");
            $("#reco-page div ul").append(template({
                personName : recoModel.getPersonName(),
                accountId : recoModel.getPersonId(),
                percentDiff : recoModel.getPersonDifference(),
                image: recoModel.getPersonImage()
            }));
        });

        $(".follow-button").click(this.followUser);
    },

    followUser : function(ev) {

        var followedId = $(ev.target.parentNode).data('id');
        console.log('follow' + followedId);

        var query_params = {
            followerId : "AI1",
            followedId : followedId
        }

        $.ajax({
            type : "GET",
            url : 'http://10.0.12.152:8124/report/follower',
            success : function(res){
                console.log('successfully followed');
            },
            dataType: "json",
            data : query_params,
            error: function(xhr, status, err){
                console.log(status);
            }
        });
    }
});
