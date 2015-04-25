var RecoPageView = Backbone.View.extend({
    initialize : function(options){
        this.reco = new RecoCollection();
        this.reco.on("sync", _.bind(function(){
            this.render();
        },this));

        this.reco.fetch({
            'accountID' : 'Test'
        });
    },

    render: function(){
        var source = $("#reco-template").html();
        var template = Handlebars.compile(source);

        this.reco.each(function(recoModel){
            console.log("working");
            $("#reco-page div ul").append(template({
                personName : followModel.getPersonName(),
                personAccId : followModel.getPersonId(),
                percentDiff : followModel.getPersonDifference()
            }));
        });
    }
});
