<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="modalidadeBean"
	class="br.edu.ifms.lp4.bean.ModalidadeBean"></jsp:useBean>

<c:if test="${not empty param['resposta']}">
	<div class="${param['classResposta']}">
		<strong>${param['resposta']}</strong>
	</div>
</c:if>

<h4>Cadastro Modalidade</h4>
<div class="row-fluid">
	<div class="span12">

		<form name="cadastra_modalidade" action="modalidade" method="get">
			<fieldset>

				<label>Descrição</label> <input class="input-block-level"
					type="text" name="descricao" autofocus="autofocus" maxlength="50"
					required="required" value="">

				<div class="form-actions">
					<button type="submit" name="enviar" class="btn btn-primary">Cadastrar</button>
					<button type="reset" class="btn">Limpar</button>
				</div>

			</fieldset>
		</form>

	</div>
</div>

<h4>Lista Modalidades</h4>
<c:if test="${empty modalidadeBean.modalidades}">
	<div class='alert alert-error'>
		<strong>Nenhuma Modalidade Cadastrada</strong>
	</div>
</c:if>

<c:if test="${not empty modalidadeBean.modalidades}">
	<table class="table table-hover table-condensed table-striped">
		<thead>
			<tr class="bg-tabela-paginas">
				<th width="40px">ID</th>
				<th>Descrição</th>
				<th width="90px">Funções</th>
			</tr>
		</thead>

		<c:forEach var="modalidade" items="${modalidadeBean.modalidades}">
			<tr>
				<td>${modalidade.id}</td>
				<td>${modalidade.descricao}</td>
				<td><a href="modalidade?id=${modalidade.id}" title="Apagar"
					class="btn btn-mini btn-danger"><i
						class="icon-remove icon-white"></i></a></td>
			</tr>
		</c:forEach>

	</table>
</c:if>