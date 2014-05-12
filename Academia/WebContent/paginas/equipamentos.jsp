<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="equipamentoBean"
	class="br.edu.ifms.lp4.bean.EquipamentoBean"></jsp:useBean>
<jsp:useBean id="modalidadeBean"
	class="br.edu.ifms.lp4.bean.ModalidadeBean"></jsp:useBean>

<c:if test="${not empty param['resposta']}">
	<div class="${param['classResposta']}">
		<strong>${param['resposta']}</strong>
	</div>
</c:if>

<h4>Cadastro Equipamento</h4>
<div class="row-fluid">
	<div class="span12">

		<c:if test="${not empty modalidadeBean.modalidades}">
			<form
				action="equipamento?acao=salva&id=${equipamentoBean.recuperaEquipamento(param['id']).id}"
				method="post" enctype="application/x-www-form-urlencoded">
				<fieldset>

					<label>Descrição</label> <input class="input-block-level"
						type="text" name="descricao" autofocus="autofocus" maxlength="200"
						value="${equipamentoBean.recuperaEquipamento(param['id']).descricao}${param['descricao']}">

					<label>Quantidade em Estoque</label> <input
						class="input-block-level" type="text" name="qtdEstoque"
						maxlength="5"
						value="${equipamentoBean.recuperaEquipamento(param['id']).qtdEstoque}${param['qtdEstoque']}">

					<label>Modalidade</label> <select name="idModalidade" required="required">
						<option value=""></option>
						<c:forEach var="modalidade" items="${modalidadeBean.modalidades}">
							<option value="${modalidade.id}">${modalidade.descricao}</option>
						</c:forEach>
					</select>

					<div class="form-actions">
						<button type="submit" name="enviar" class="btn btn-primary">Salvar</button>
						<button type="reset" class="btn">Limpar</button>
					</div>
				</fieldset>
			</form>
		</c:if>

		<c:if test="${empty modalidadeBean.modalidades}">
			<div class="alert alert-error">
				<strong>Impossivel cadastrar um novo equipamento. <br>
					<a href="?pagina=modalidades">Clique aqui</a> e cadastre pelo menos
					uma modalidade.
				</strong>
			</div>
		</c:if>

	</div>
</div>

<h4>Lista de Equipamentos</h4>
<c:if test="${empty equipamentoBean.equipamentos}">
	<div class='alert alert-error'>
		<strong>Nenhum equipamento Cadastrado.</strong>
	</div>
</c:if>

<c:if test="${not empty equipamentoBean.equipamentos}">
	<table class="table table-hover table-condensed table-striped">
		<thead>
			<tr class="bg-tabela-paginas">
				<th width="40px">ID</th>
				<th>Descrição</th>
				<th>Modalidade</th>
				<th>Quantia Estoque</th>
				<th width="90px">Funções</th>
			</tr>
		</thead>

		<c:forEach var="equipamento" items="${equipamentoBean.equipamentos}">
			<tr>
				<td>${equipamento.id}</td>
				<td>${equipamento.descricao}</td>
				<td>${modalidadeBean.recuperaModalidade(equipamento.modalidade.id).descricao}${param['descricao']}</td>
				<td>${equipamento.qtdEstoque}</td>
				<td><a href="index.jsp?pagina=equipamentos&id=${equipamento.id}"
					class="btn btn-warning" title="Editar"><i
						class="icon-edit icon-white"></i></a> <a
					href="equipamento?id=${equipamento.id}&acao=remove" title="Apagar"
					class="btn btn-danger"><i
						class="icon-remove icon-white"></i></a></td>
			</tr>
		</c:forEach>

	</table>
</c:if>