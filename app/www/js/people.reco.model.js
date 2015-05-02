var PeopleRecoModel = Backbone.Model.extend({
    initialize : function(options){
        // this.person = new PersonModel();
        // this.on("add", _.bind(function(){
        //     this.fetchPersonModel();
        // },this));
    },

    getPersonName: function(){
        return this.get('person').name;
    },

    getPersonId: function(){
        return this.get('person').accountId;
    },

    getPersonImage: function(){
        return this.get('person').image;
    },

    getPersonDifference: function(){
        return this.get('personDifference').percentageDifference;
    }

});