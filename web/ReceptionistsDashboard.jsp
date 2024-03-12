<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Receptionists Dashboard</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            color: #333333;
            margin-bottom: 20px;
        }

        form {
            margin: 10px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-bottom: 10px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to Your Dashboard!</h1>
    <form action="ReceptionistsEditProfile.jsp">
        <input type="submit" value="Edit Individual Profile">
    </form>
    <form action="ManageAppointments.jsp">
        <input type="submit" value="Manage Appointments">
    </form>
    <form action="CreateCustomer.jsp">
        <input type="submit" value="Create Customer Profile">
    </form>
        <form action="Pet.jsp">
        <input type="submit" value="Create Pet Profile">
    </form>
     </form>
        <form action="AssignAppointment.jsp">
        <input type="submit" value="Assign a Vet To Appointment">
    </form>
</body>
</html>
