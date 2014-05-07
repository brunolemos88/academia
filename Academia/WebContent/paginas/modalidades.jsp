<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="modalidadeBean"
	class="br.edu.ifms.lp4.bean.ModalidadeBean"></jsp:useBean>
<h2>Modalidades</h2>
<a href="?p=cadastraModalidade" class="btn btn-small">Cadastrar
	Modalidade</a>

<hr>

<c:if test="${empty modalidadeBean.modalidades}">
	<span class="alert alert-error">Nenhuma Modalidade Cadastrada</span>
</c:if>

<c:if test="${not empty modalidadeBean.modalidades}">
	<table class="table table-hover table-condensed table-striped">
		<thead>
			<tr class="bg-tabela-paginas">
				<th width="40px">ID</th>
				<th>Descrição</th>
			</tr>
		</thead>

		<c:forEach var="madalidade" items="${modalidadeBean.modalidades}">
			<tr>
				<td>${modalidade.id}</td>
				<td>${modalidade.descricao}</td>
			</tr>
		</c:forEach>

	</table>
</c:if>