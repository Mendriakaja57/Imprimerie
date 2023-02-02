<%@page import='traitement.*'%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/Articles-Badges-images.css">
    <link rel="stylesheet" href="assets/css/Features-Centered-Icons-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.11.1/baguetteBox.min.css">
</head>

<body id="page-top" data-bs-spy="scroll" data-bs-target="#mainNav" data-bs-offset="72" style="height: 0px;border-radius: 0px;box-shadow: 6px 4px rgb(217,217,217);">    
    <%
    Traitement trtmt = new Traitement();
    Object[][] clients = new Object[1][1];
    try{
        clients = trtmt.getAllClient(null);
    }catch(Exception e){}
    %>

    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-secondary text-uppercase" id="mainNav">
        <div class="container"><a class="navbar-brand" href="#page-top"></a><button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" class="navbar-toggler text-white bg-primary navbar-toggler-right text-uppercase rounded" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                
            </div>
        </div>
    </nav>
    <div style="height: 500px;margin-top: -164px;background: rgba(54,131,245,0);">
        <div class="card shadow" style="margin-top: 300px;width: 1200px;margin-left: 90px;">
            <div class="card-header py-3">
                <p style="font-size: 27px;font-weight: bold;color: rgb(44,62,80);">Inserer facture</p>
            </div>
            <div class="card-body">
                <div class="table-responsive table mt-2" id="dataTable-1" role="grid" aria-describedby="dataTable_info">
                    <table class="table my-0" id="dataTable">
                        <thead>
                            <tr></tr>
                        </thead>
                        <tbody>
                            <tr style="height: 193px;">
                                <td style="height: 73px;">
                                    <div class="container py-4 py-xl-5" style="height: 220px;">
                                        <div class="row gy-4 row-cols-1 row-cols-md-2 row-cols-xl-3" style="height: 186px;margin-top: -82px;margin-left: 34px;">
                                            <div class="col">
                                                <div class="table-responsive" style="width: 608.3px;margin-left: 243px;">
                                                    <table class="table">
                                                        <thead>
                                                            <tr></tr>
                                                        </thead>
                                                        <tbody>
                                                            <form id="formProd" action="ListeFacture.jsp" method="get">
                                                            <tr>
                                                                <td style="width: 134.1px;">Client :</td>
                                                                <td><select style="width: 183px;height: 32px;background: rgb(247,247,247);box-shadow: 6px 4px 8px rgb(228,228,228);border-radius: 5px;border-top-width: 0px;border-right-width: 3px;border-bottom-width: 2px;border-bottom-color: rgb(0,0,0);border-left-width: 0px;"name="client">
                                                                        <optgroup label="This is a group">
                                                                            <%for(int i = 0; i < 3; i++){%>
                                                                                <option value="<%out.print(clients[i][0]);%>"><%out.print(clients[i][1]);%></option>
                                                                            <%}%>
                                                                        </optgroup>
                                                                    </select></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Date :</td>
                                                                <td><input type="date" name="date" style="width: 183px;height: 32px;background: rgb(247,247,247);border-radius: 5px;box-shadow: 6px 4px 8px rgb(228,228,228);border-width: 1px;border-top-width: 0px;border-right-width: 2px;border-bottom-width: 2px;border-left-width: 0px;"></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Montant payé :</td>
                                                                <td><input type="number" name="paye"></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><button class="btn btn-primary" type="submit" style="background: rgb(44,62,80);margin-left: 231px;margin-top: 10px;border-color: rgba(255,255,255,0);border-left-color: rgba(24,188,156,0);">Valider</button></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </form>
                       
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.11.1/baguetteBox.min.js"></script>
    <script src="assets/js/freelancer.js"></script>
    <script src="assets/js/Lightbox-Gallery.js"></script>
</body>
</html>