<%@ include file="inc/header.jsp" %>

    <div class="row">

        <div class="col-sm-6">

            <h1 class="page-title">Cadastrar Classe</h1>

        </div>

        <div class="col-sm-6">
        
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Classe">Classe</a></li>
                <li class="active">Cadastrar classe</li>
            </ol>

        </div>

    </div> 

    <div class="row">

        <div class="col-sm-6">

            <form action="Classe" method="POST">
                
                <div class="form-group">
                    <label for="exampleInput">Nome</label>
                    <input type="text" class="form-control" name="nome">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Valor de loca��o</label>
                    <input type="text" class="form-control" name="valor">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">Prazo de devolu��o (dias)</label>
                    <input type="text" class="form-control" name="prazo">
                </div>
                
                <div class="form-group">
                    <label for="exampleInput">T�tulo</label>
                    <select class="form-control">
					  <option>Matrix</option>
					  <option>Os Vingadores</option>
					  <option>Duro de matar</option>
					</select>
                </div>
                
                <input type="hidden" name="acao" value="cad">
                
                <a href="Classe" class="btn btn-default">Voltar</a>
                <button type="submit" class="btn btn-primary fl-right">Cadastrar</button>
                
            </form>

        </div>

    </div>

<%@ include file="inc/footer.jsp" %>