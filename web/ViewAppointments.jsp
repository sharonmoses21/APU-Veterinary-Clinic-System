<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Appointments</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin: 10px 0;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
        }

        button {
            background-color: #3498db;
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }

        button:hover {
            background-color: #2980b9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: white;
        }
    </style>
<script>
        function viewAppointments() {
            var vetUsername = document.getElementById("vetUsername").value;
            var xmlhttp = new XMLHttpRequest();

            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("appointmentsContainer").innerHTML = this.responseText;
                }
            };

            xmlhttp.open("POST", "ViewAppointmentsServlet", true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("vetUsername=" + vetUsername);
        }
    </script>
</head>
<body>
    <form>
        <label for="vetUsername">Vet Username:</label>
        <input type="text" id="vetUsername" name="vetUsername" required>
        <button type="button" onclick="viewAppointments()">View Appointments</button>
    </form>

    <div id="appointmentsContainer">
        <!-- Appointments will be displayed here -->
    </div>
</body>
</html>
