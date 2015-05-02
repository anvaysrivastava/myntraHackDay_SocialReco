require.config({
    base: "./",
    paths : {
        'jquery' : "js/vender/",
        'backbone' : "//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min",
        'underscore' : "//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.7.0/underscore-min",
        'handlebars' : "//cdnjs.cloudflare.com/ajax/libs/handlebars.js/2.0.0/handlebars.min",
        'templates' : "templates"
    },
    shim : {
        "backbone" : {
            exports : 'Backbone',
            deps : ['jquery', 'underscore']
        },

        "underscore" : {
            exports: "_"
        },

        "handlebars" : {
            exports : "Handlebars"
        }
    }
});

// Start the main app logic.
requirejs(['jquery', 'views/products/product.page'],
function ($, Page) {
    var page = new Page({
        el: "#product-content"
    });
    page.render();
});