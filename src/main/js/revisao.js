function exibeNome() {
	var elNome = document.getElementById("txtNome");
	var strNome = elNome.value;
	var elDisplay = document.getElementById("display");
	elDisplay.innerText = strNome;

}

function novoContato() {

	// div de contatos
	var eListaContato = document.getElementById("listaContatos");

	// elementos
	var inputContato = document.createElement("input");
	inputContato.setAttribute('name', 'txtContato');

	var labelContato = document.createElement("label");
	labelContato.innerText = "Contato: ";
	var br = document.createElement("br");
	var btnExc = document.createElement("input");
	btnExc.setAttribute("type", "button");
	btnExc.setAttribute("value", "-");
	btnExc.onclick = function excluir() {
		eListaContato.removeChild(divLinha);
	}
	// div
	var divLinha = document.createElement("div");
	divLinha.appendChild(labelContato);
	divLinha.appendChild(inputContato);
	divLinha.appendChild(btnExc);
	divLinha.appendChild(br);

	eListaContato.appendChild(divLinha);
}

function imprimeContatos() {

    var saida = "";
	
    var arrInputContatos = document.frmContatos.txtContato;
    for(i=0; i < arrInputContatos.length; i++ ) {
    	saida += arrInputContatos[i].value + "</br>"  ;
    }
    
    var saidaContatos = document.getElementById("saidaContatos");
    saidaContatos.innerHTML = saida ;
    
}








