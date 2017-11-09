Vue.use(VueMaterial)

var App = new Vue({
  el: '#app'
});

function toggleCheckbox(){
  if(document.getElementById("gerente").checked)
{         document.getElementById("gerente").checked=false;
 
}
  else{ document.getElementById("gerente").checked=true;
  }
};