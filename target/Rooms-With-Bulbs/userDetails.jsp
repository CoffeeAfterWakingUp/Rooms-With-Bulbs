<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="row">
    <div class="col-4">
        <div class="accordion" id="accordionExample">
            <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                    <button class="accordion-button text-white" style="background-color: #0D0D0D;" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Details
                    </button>
                </h2>
                <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                    <input type="hidden" id="userCountryName" value="${requestScope.details.countryName}">
                    <div class="accordion-body" style="background-color: #0D0D0D;">
                        <c:choose>

                            <c:when test = "${requestScope.details != null}">
                                <table class="table table-bordered table-hover text-white">
                                    <tbody>
                                        <tr>
                                            <th scope="row">IP</th>
                                            <td>${requestScope.details.ip}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">City</th>
                                            <td>${requestScope.details.city}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Country Code</th>
                                            <td>${requestScope.details.countryCode}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Country Name</th>
                                            <td>${requestScope.details.countryName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Continent</th>
                                            <td>${requestScope.details.continent}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Latitude</th>
                                            <td>${requestScope.details.latitude}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Longitude</th>
                                            <td>${requestScope.details.longitude}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Org</th>
                                            <td>${requestScope.details.org}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Timezone</th>
                                            <td>${requestScope.details.timezone}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Postal Code</th>
                                            <td>${requestScope.details.postalCode}</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </c:when>

                            <c:otherwise>
                                No Details...
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

