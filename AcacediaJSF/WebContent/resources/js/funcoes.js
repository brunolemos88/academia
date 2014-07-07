function deletarPedidoMusica(id) {
  if (confirm('Deseja realmente deletar?')) {
    window.location='/mvc/painel/PedidoMusica/excluiPedido/'+id; 
  }
  return false;
}

function deletarCliente(id) {
  if (confirm('Deseja realmente deletar?')) {
    window.location='/mvc/painel/Cliente/excluiCliente/'+id; 
  }
  return false;
}
