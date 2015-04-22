<%@ include file="inc/header.jsp" %>

<div class="row">

    <div class="col-sm-6">

        <h1 class="page-title">Cadastrar Cliente</h1>

    </div>

    <div class="col-sm-6">

        <ol class="breadcrumb">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Cliente">Cliente</a></li>
            <li class="active">Cadastrar Cliente</li>
        </ol>

    </div>

</div> 

<div class="row">

    <div class="col-sm-6">

        <form method="POST" action="Cliente">

            <div class="form-group">
                <label for="exampleInput">Nome</label>
                <input type="text" class="form-control" name="nome">
            </div>

            <div class="form-group">
                <label for="exampleInput">Data de nascimento</label>
                <input type="text" class="form-control" name="data_nascimento">
            </div>

            <div class="form-group">
                <label for="exampleInput">Endereço</label>
                <input type="text" class="form-control" name="endereco">
            </div>

            <div class="form-group">
                <label for="exampleInput">Telefone</label>
                <input type="text" class="form-control" name="telefone">
            </div>

            <div class="form-group">
                <label for="exampleInput">CPF</label>
                <input type="text" class="form-control" name="cpf">
            </div>

            <div class="form-group">
                <label for="exampleInput">Sexo</label>
                <select class="form-control" name="sexo">
                    <option value="F">Feminino</option>
                    <option value="M">Masculino</option>
                </select>
            </div>

            <div class="form-group">
                <label for="exampleInput">Estado</label>
                <select class="form-control" name="estado">
                    <option value="ativado">Ativado</option>
                    <option value="desativado">Desativado</option>
                </select>
            </div>
            
            <input type="hidden" name="acao" value="cad">
            <input type="hidden" name="tipo" value="socio">
            
            <a href="Cliente" class="btn btn-default">Voltar</a>
            <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
            
        </form>

    </div>

</div>

<%@ include file="inc/footer.jsp" %>