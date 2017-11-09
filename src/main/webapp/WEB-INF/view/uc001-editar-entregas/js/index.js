Vue.use(VueMaterial)


var App = new Vue({
  el: '#app'
})

var makeRadiosDeselectableByName = function(name){
    $("input[name=" + name + "]").click(function() {
        if($(this).attr("previousValue") == "true"){
            $(this).attr("checked", false)
        } else {
            $("input[name=" + name + "]").attr("previousValue", false);
        }
        
        $(this).attr("previousValue", $(this).attr("checked"));
    });
};


makeRadiosDeselectableByName("radioopt");