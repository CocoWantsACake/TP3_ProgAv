<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ALTN72 - Liste des employés </title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>

    <h3> Bonjour ${ utilisateur.loginSaisi } !</h3>

    <div class="container" >
        <div class="row col-md-6 col-md-offset-0 custyle">
            <form method="get" action="${pageContext.request.contextPath}/details">
                <table class="table table-striped custab">
                    <thead>
                    <h1>Liste des employés</h1>
                    <tr class="text-center">
                        <th>Sél</th>
                        <th>NOM</th>
                        <th>PRENOM</th>
                        <th>TEL DOMICILE</th>
                        <th>TEL PORTABLE</th>
                        <th>TEL PRO</th>
                        <th>ADRESSE</th>
                        <th>CODE POSTAL</th>
                        <th>VILLE</th>
                        <th>EMAIL</th>
                    </tr>
                    </thead>
                    </tr>

                    <c:forEach items="${tousLesEmployes}" var="employe">
                        <tr>
                            <td><input type="radio" name="idEmploye" value=${employe.id}></td>
                            <td>${employe.nom}</td>
                            <td>${employe.prenom}</td>
                            <td>${employe.teldom}</td>
                            <td>${employe.telport}</td>
                            <td>${employe.telpro}</td>
                            <td>${employe.adresse}</td>
                            <td>${employe.codepostal}</td>
                            <td>${employe.ville}</td>
                            <td>${employe.email}</td>

                        </tr>
                    </c:forEach>

                </table>
                <input type="submit" name="action" value="Supprimer" class="btn btn-primary"/>
                <input type="submit" name="action" value="Details" class="btn btn-primary"/>
            </form>
        </div>
    </div>
</body>
</html>
