<%@ include file="inc/header.jsp" %>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Loca��o</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Locacao">Loca��o</a></li>
                <li class="active">Cadastrar Loca��o</li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form method="POST" action="Locacao">
                
                <div class="form-group">
                    <label for="exampleInput">N�mero do Cliente</label>
                    <input type="text" class="form-control" name="id_cliente">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">N�mero do item</label>
                    <input type="text" class="form-control" name="id_item">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Data da loca��o</label>
                    <input type="text" class="form-control" name="data_locacao">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Data da devolu��o</label>
                    <input type="text" class="form-control" name="data_devolucao">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Valor</label>
                    <input type="text" class="form-control" name="valor">
                </div>
                
                <input type="hidden" name="acao" value="cad">
                
                <a href="Locacao" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar Loca��o</button>
                
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>