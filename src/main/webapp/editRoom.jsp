<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card px-3 py-3" style="display: none;margin-top: 56px;background-color: #0D0D0D;border-color: white"
     id="editCard">
    <div class="mb-3">
        <h5>Edit a room</h5>
        <hr>
    </div>
    <div>
        <form action="">
            <input type="hidden" id="id">
            <div class="mb-3">
                <label for="editRoomName" class="form-label">Room name</label>
                <input type="text" class="form-control text-white" name="roomName" id="editRoomName"
                       style="background-color: transparent" placeholder="Room Name...." required/>
            </div>
            <div class="mb-3">
                <label for="editCountry" class="form-label">Choose your country</label>
                <select name="country" id="editCountry" class="form-select text-white"
                        style="background-color: transparent">
                    <c:forEach var="c" items="${requestScope.countryList}">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="user" id="user" value="${requestScope.localAddress}">
            <div class="mb-3 row">
                <div class="col-6">
                    <div class="form-check form-switch">
                        <input class="form-check-input" type="checkbox" id="editBulb" name="bulb" checked>
                        <label class="form-check-label" for="editBulb"><i class="fa fa-lightbulb-o"
                                                                          id="editLightbulbIcon"
                                                                          style="font-size:25px;color: yellow;"></i></label>
                    </div>
                </div>

                <div class="col text-end">
                    <a href="JavaScript:void(0)" onclick="goToCreateMode()">Create a room</a>
                </div>

            </div>
            <br>
            <div class="d-grid gap-2">
                <button class="btn btn-block text-white" type="button" style="background-color: #067302;"
                        onclick="updateRoom()">Update
                </button>
            </div>

        </form>
    </div>
</div>

<script type="text/javascript">
    $('#editBulb').click(function () {
        if ($(this).is(':checked')) {
            $("#editLightbulbIcon").css("color", "yellow");
        } else {
            $("#editLightbulbIcon").css("color", "grey");
        }
    });
</script>

