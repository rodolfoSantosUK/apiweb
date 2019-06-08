Foi criado um Crud basico usando dados fakes, e fazendo os testes no postman 

GET    http://localhost:4141/clientes
DELETE http://localhost:4141/clientes/5
PUT    http://localhost:4141/clientes
{
	  "id": 1,
    "nome": "Denis Omar Alaya"
}

Script usado para fazer uma requisição via ajax

<!--script>  
 	//<![CDATA[	
// 	function carregarDados() {
// 		  var xhttp = new XMLHttpRequest();
// 		  xhttp.onreadystatechange = function() {
// 		    if (this.readyState == 4 && this.status == 200) {
// 		     document.getElementById("display").innerHTML = this.responseText;
// 		    }
// 		  };
// 		  xhttp.open("GET", "http://localhost:4141/clientes", true);
// 		  xhttp.send();
// 	}
// 	]]>
 </script-->  