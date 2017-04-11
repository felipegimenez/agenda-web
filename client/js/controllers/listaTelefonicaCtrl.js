	angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function ($scope){ 
			$scope.app = "Lista Telefonica";
			$scope.contatos = [
				{nome: "Pedro", telefone: "999999999"},
				{nome: "Ana", telefone: "888888888"},
				{nome: "Maria", telefone: "999998888"}
			];
			
			$scope.operadoras = [
				{nome: "OI", codigo: 14, categoria: "Celular"}, 
				{nome: "Claro", codigo: 15, categoria: "Celular"},
				{nome: "TIM", codigo: 31, categoria: "Celular"},
				{nome: "GVT", codigo: 20, categoria: "Fixo"},
				{nome: "Embratel", codigo: 21, categoria: "Fixo"}
			];
			
			$scope.adicionarContato = function (contato) {
				$scope.contatos.push(contato);
				delete $scope.contato;
			};
			
			$scope.deletarContato = function (contatos) {
				$scope.contatos = contatos.filter(function (contato){
					return !contato.selecionado;
				});
			}
			
			$scope.isContatoSelecionado = function (contatos){
				return contatos.some(function (contato){
					return contato.selecionado;
				});
			}
			

		});