<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pb-4">
    <h5>All rooms</h5>
</div>
<table class="table table-bordered table-hover text-center text-white" id="allRoomTable">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Country</th>
        <th scope="col">Is Bulb On</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody id="result">

    </tbody>
</table>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<script type="text/javascript">
    $(document).ready(function () {
        getAllRoom();
        setInterval(function () {
            getAllRoom();
        }, 1000)
    });

    function getAllRoom() {
        $.ajax({
            url: "http://localhost:8080/rooms",
            type: "GET",
            dataType: "JSON",

            success: function (data) {
                let tableContent = "";
                console.log(data);
                for (let i = 0; i < data.length; i++) {
                    tableContent += "<tr>";
                    tableContent += "<th>" + data[i].id + "</th>";
                    tableContent += "<td>" + data[i].name + "</td>";
                    tableContent += "<td>" + data[i].country.name + "</td>";
                    if (data[i].bulb === true) {
                        tableContent += "<td>" + '<i class="fa fa-lightbulb-o" id="lightbulbIcon" style="font-size:25px;color: yellow"></i>' + "</td>";
                    } else {
                        tableContent += "<td>" + '<i class="fa fa-lightbulb-o" id="lightbulbIcon" style="font-size:25px;color: grey"></i>' + "</td>";
                    }
                    tableContent += "<td>" + "<a href='JavaScript:void(0)' onclick='edit(" + data[i].id + ")'><i class='fa fa-sign-in' style='font-size:20px'></i></a>" + "</td>";
                    tableContent += "</tr>";
                }
                console.log(tableContent);

                $("#result").html(tableContent);
            }
        })
    }

    function edit(id) {
        $.ajax({
            url: "http://localhost:8080/room",
            type: "GET",
            dataType: "JSON",
            data: {id},

            success: function (data) {
                if (checkUserCountry(data.country.name)) {
                    $("#createCard").css("display", "none");
                    $("#editCard").css("display", "block");
                    $("#id").val(data.id);
                    $("#editRoomName").val(data.name);
                    $("#editCountry").val(data.country.id);
                    if (data.bulb === true) {
                        $("#editBulb").prop("checked", true);
                        $("#editLightbulbIcon").css("color", "yellow");
                    } else {
                        $("#editBulb").prop("checked", false);
                        $("#editLightbulbIcon").css("color", "grey");
                    }
                } else {
                    alert("You have not access to this room");
                    $("#editCard").css("display", "none");
                    $("#createCard").css("display", "block");
                }
            }
        })
    }

    function updateRoom() {
        const id = $("#id").val();
        const roomName = $("#editRoomName").val();
        const country = $("#editCountry").val();
        let bulb;

        if ($("#editBulb").is(':checked')) {
            bulb = "on";
        } else {
            bulb = "off";
        }

        if (roomName.length !== 0) {
            $.ajax({
                url: "http://localhost:8080/update",
                type: "POST",
                data: {id: id, name: roomName, country: country, bulb: bulb},

                success: function () {
                    $("#editCard").css("display", "none");
                    $("#createCard").css("display", "block");
                    getAllRoom();
                    $("#update").css('display', 'block');

                }
            })
        } else {
            $("#error").css('display', 'block');
        }
    }

    function goToCreateMode() {
        $("#editCard").css("display", "none");
        $("#createCard").css("display", "block");
    }

    function checkUserCountry(roomCountry) {
        const userCountryName = $("#userCountryName").val();
        return userCountryName === roomCountry;

    }


</script>