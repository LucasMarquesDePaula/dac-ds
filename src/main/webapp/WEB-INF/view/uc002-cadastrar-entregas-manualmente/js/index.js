Vue.use(VueMaterial)

var App = new Vue({
  el: '#app'
});

function toggleCheckbox(){
  if(document.getElementById("concluido").checked)
{         document.getElementById("concluido").checked=false;
 
}
  else{ document.getElementById("concluido").checked=true;
  }
  toggleConcluidosVisibility();
};
function toggleConcluidosVisibility() {

if (document.getElementById("concluido").checked == true) {

    document.getElementById("concluidos").style.visibility = "visible";

    } 
else {

    document.getElementById("concluidos").style.visibility = "hidden";

    }
};