<%@ include file="header.jsp" %>

<h2>Liste des Utilisateurs</h2>
<hr>

<div class="mb-3">
    <a href="<%= request.getContextPath() %>/user-form" class="btn btn-success">Ajouter un Utilisateur</a>
</div>

<table class="table table-bordered table-striped">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Date de création</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- JSTL forEach : boucle sur la liste des utilisateurs -->
        <c:forEach var="user" items="${users}">
            <tr>
                <!-- c:out : affiche la valeur de la propriété (échappe les caractères HTML) -->
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.firstName}" /></td>
                <td><c:out value="${user.lastName}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.createdAt}" /></td>
                <td>
                    <a href="<%= request.getContextPath() %>/user-form?action=edit&id=<c:out value='${user.id}' />"
                       class="btn btn-primary btn-sm">Modifier</a>
                    &nbsp;
                    <a href="<%= request.getContextPath() %>/delete-user?id=<c:out value='${user.id}' />"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        <!-- Si la liste est vide, affiche un message -->
        <c:if test="${empty users}">
            <tr>
                <td colspan="6" class="text-center">Aucun utilisateur trouvé</td>
            </tr>
        </c:if>
    </tbody>
</table>

<%@ include file="footer.jsp" %>