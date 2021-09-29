<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
  <div class="card px-3 pt-3" id="createCard" style="margin-top: 56px;background-color: #0D0D0D;border-color: white;">
    <div class="mb-3">
      <h5>Create a room</h5>
      <hr>
    </div>
    <div>
      <form action="">
        <div class="mb-3">
          <label for="roomName" class="form-label">Room name</label>
          <input type="text" class="form-control text-white" name="roomName" id="roomName" style="background-color: transparent" placeholder="Room Name...." required />
        </div>
        <div class="mb-3">
          <label for="country" class="form-label">Choose your country</label>
          <select name="country" id="country" class="form-select text-white" style="background-color: transparent">
            <c:forEach var = "c" items="${requestScope.countryList}"><option style="background-color: transparent" value="${c.id}">${c.name}</option></c:forEach>
          </select>
        </div>
        <input type="hidden" name="user" id="user" value="${requestScope.localAddress}">
        <div class="form-check form-switch mb-3">
          <input class="form-check-input" type="checkbox" id="createBulb" name="bulb" checked>
          <label class="form-check-label" for="createBulb"><i class="fa fa-lightbulb-o" id="createLightbulbIcon" style="font-size:25px;color: yellow"></i></label>
        </div>
        <br>
        <div class="d-grid gap-2">
          <button class="btn btn-block text-white" type="button" style="background-color: #067302;" onclick="addRoom()">Create</button>
        </div>

      </form>
    </div>
  </div>
  <%@ include file="editRoom.jsp" %>
  <%@ include file="alerts.jsp" %>

</div>



<script type="text/javascript">
  $('#createBulb').click(function() {
    if($(this).is(':checked')) {
      $("#createLightbulbIcon").css("color","yellow");
    }else{
      $("#createLightbulbIcon").css("color","grey");
    }
  });

  function addRoom(){
    const roomName = $("#roomName").val();
    const country = $("#country").val();
    let bulb;
    const user = $("#user").val();

    if($("#createBulb").is(':checked')) {
      bulb = "on";
    }else{
      bulb = "off";
    }

    if(roomName.length !== 0 ) {
      $.ajax({
        url: "http://localhost:8080/create",
        type: "POST",
        data: {name: roomName, country: country, bulb: bulb, user: user},

        success: function () {
          $("#roomName").val("");
          getAllRoom();
          $("#success").css('display','block');

        }
      })
    }else{
      $("#error").css('display','block');
    }
  }

</script>

