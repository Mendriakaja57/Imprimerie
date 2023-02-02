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
        Object[][] detailFact = new Object[1][1];
        Object[][] montantTot = new Object[1][1];
        Object[][] facture = new Object[1][1];
        Object[][] fact = new Object[1][1];
        String idFacture = request.getParameter("idFacture");
        double reste = 0;
        try{
            detailFact = trtmt.getServForFact(idFacture,null);
            montantTot = trtmt.getMont_Reste(idFacture,null);
            fact = trtmt.getServForFact(idFacture,null);
            facture = trtmt.getAllFacture(null);
            //reste = Double.valueOf(montantTot[i][3]) - Double.valueOf(fact[i][3]) ;
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
                <p style="font-size: 27px;font-weight: bold;color: rgb(44,62,80);">Facture N°1</p>
            </div>
            <div class="card-body">
                <div class="table-responsive table mt-2" id="dataTable-1" role="grid" aria-describedby="dataTable_info" style="width: 541px;margin-left: 275px;">
                    <table class="table my-0" id="dataTable">
                        <thead>
                            <tr>
                                <th style="width: 351.7px;">Services</th>
                                <th style="width: 399.7px;">Prix unitaire</th>
                                <th style="width: 399.7px;">Quantité</th>
                                <th style="width: 399.7px;">Montant total</th>
                                <th style="width: 399.7px;">Faire une remise</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(int i = 0; i < detailFact.length; i++){%>
                            <tr>
                                <td style="width: 351.7px;"><%out.print(detailFact[i][4]);%></td>
                                <td style="width: 351.7px;"><%out.print(detailFact[i][5]);%></td>
                                <td style="width: 351.7px;"><%out.print(detailFact[i][6]);%></td>
                                <td style="width: 351.7px;"><%out.print(detailFact[i][7]);%></td>
                                <td style="width: 351.7px;"><a href="remise.jsp?id=<%out.print(facture[i][2]);%>&&idFacture=<%out.print(facture[i][0]);%>&&idFacture=<%out.print(idFacture);%>&&idServ=<%out.print(detailFact[i][1]);%>&&tot=<%out.print(detailFact[i][7]);%>">Faire une remise</a></td>
                            </tr>
                           <%}%>
                        </tbody>
                       
                        <tfoot>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            <%for(int i = 0; i < montantTot.length; i++){%>
                                <td style="width: 351.7px;"><%out.print(montantTot[i][3]);%></td>
                           <%}%>

                            </tr>
                        </tfoot>
                    </table>
                    <div>
                        <table class="table my-0" id="dataTable">
                            <thead>
                                <tr>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td style="width: 351.7px;">Payé</td>
                            <%for(int i = 0; i < fact.length; i++){%>
                                    <td style="width: 351.7px;"><%out.print(fact[i][3]);%></td>
                           <%}%>

                                </tr>
                                <tr>
                                    <td style="width: 351.7px;">Reste</td>
                                    <td style="width: 351.7px;"><%out.print(reste);%></td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
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