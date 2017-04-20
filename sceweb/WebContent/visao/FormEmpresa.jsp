<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
            label {
                font: normal 12px courier !important;
            }
</style>
<title>Manter Empresa</title>
<link rel="stylesheet" type="text/css" href="/sceweb/CSS/Formato.css">
<script type="text/javascript" language="javascript">
	
	function incluir() {
		document.formEmpresaIncluir.acao.value = "IncluirEmpresa";
		document.formEmpresaIncluir.submit();
	}
	function consultar() {
		document.formEmpresaIncluir.acao.value = "ConsultarEmpresa";
		document.formEmpresaIncluir.submit();
	}
	function excluir() {
		history.go(-1)
	}
</script>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<div id="principal">
		<div id="titulo">
			<h3>Mantem Empresas</h3>
		</div>
		<hr>
		<div id="formulario2">

			<form name="formEmpresaIncluir" action="/sceweb/ServletControle" method="post">
				<table id="tabcampos">
					<tr>
						<td><label> Nome:</label></td>
						<td><input id="campo" size="70" type="text" name="txtNomeDaEmpresa"
							value=""></td>
					</tr>
					<tr>
						<td><label> CNPJ:</label></td>
						<td><input id="campo" size="15" type="text" name="txtCNPJ"
							value=""></td>
					</tr>
					<tr>
						<td><label> Nome Fantasia:</label></td>
						<td><input id="campo" size="70" type="text" name="txtNomeFantasia"
							value=""></td>
					</tr>
					<tr>
						<td><label> Endere�o:</label></td>
						<td><input id="campo" size="50" type="text" name="txtEndereco"
							value=""></td>
					</tr>
					<tr>
						<td><label> Telefone:</label></td>
						<td><input id="campo" size="10" type="text" name="txtTelefone"
							value=""></td>
					</tr>
					<tr>
						<td><label> Respons�vel pelo Est�gio:</label></td>
						<td><input id="campo" size="50" type="text" name="txtResponsavel"
							value=""></td>
					</tr>
					<tr>
						<td><label> Telefone do Respons�vel pelo Est�gio:</label></td>
						<td><input id="campo" size="10" type="text" name="txtTelefoneResponsavel"
							value=""></td>
					</tr>
					<tr>
						<td><label> Setor:</label></td>
						<td><input id="campo" size="50" type="text" name="txtSetor"
							value=""></td>
					</tr>
					<tr>
						<td><label> e-mail:</label></td>
						<td><input id="campo" size="30" type="text" name="txtEmail"
							value=""></td>
					</tr>
					
					<tr>
						<td colspan=2 id="botoes" align="center">
						<input id="botao" type=button name=btnIncluir onclick=incluir() value=Incluir>
						<input id="botao" type=reset name=btnConsultar onclick=consultar() value=Consultar>
					    <input id="botao" type=button name=btnExcluir onclick=excluir() value=Excluir>
					    </td>
					</tr>
				</table>
				<input type="hidden" name="acao" value="">
				<input type="hidden" name="menu" value="principal">
				<%	String msg = (String) request.getAttribute("msg"); 
					if(msg == null)
						msg="";
				%>
				<label id = "mensagem"><%=msg%></label>
			</form>
		</div>
	</div>
	<jsp:include page="Rodape.jsp" />
</body>
</html>