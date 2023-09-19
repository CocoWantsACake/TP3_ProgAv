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
            <!--<form method="get" action="hello-servlet">-->
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

                    <tr>
                        <td><input type="radio" id="idEmploye" name="idEmploye" checked value="${employe.id}"></td>
                        <td><label for="nom">Nom:</label><input type="text" id="nom" name="nom" value="${employe.nom}"></td>
                        <td><label for="prenom">Prénom:</label><input type="text" id="prenom" name="prenom" value="${employe.prenom}"></td>
                        <td><label for="teldom">Tel Domicile:</label><input type="text" id="teldom" name="teldom" value="${employe.teldom}"></td>
                        <td><label for="telport">Tel Portable:</label><input type="text" id="telport" name="telport" value="${employe.telport}"></td>
                        <td><label for="telpro">Tel Pro:</label><input type="text" id="telpro" name="telpro" value="${employe.telpro}"></td>
                        <td><label for="adresse">Adresse:</label><input type="text" id="adresse" name="adresse" value="${employe.adresse}"></td>
                        <td><label for="codepostal">Code Postal:</label><input type="text" id="codepostal" name="codepostal" value="${employe.codepostal}"></td>
                        <td><label for="ville">Ville:</label><input type="text" id="ville" name="ville" value="${employe.ville}"></td>
                        <td><label for="email">Email:</label><input type="email" id="email" name="email" value="${employe.email}"></td>
                    </tr>


                </table>
                <input type="submit" name="action" value="Supprimer" class="btn btn-primary"/>
                <input type="submit" name="action" value="Retour" class="btn btn-primary"/>
                <input type="submit" name="action" value="Update" class="btn btn-secondary"/>
            </form>
        </div>
    </div>
</body>
</html>
