<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manager Dashboard</title>
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

        button {
            background-color: #4caf50;
            color: white;
            margin: 10px;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to Manager Dashboard</h1>
    
    <!-- Buttons for managing staff -->
    <button onclick="location.href='ManageStaff.jsp'">Manage Staff</button>

    <!-- Buttons for salesmen -->
    <button onclick="location.href='ManageVets.jsp'">Manage Vets</button>

    <!-- Buttons for customers -->
    <button onclick="location.href='ManageReceptionists.jsp'">Manage Receptionists</button>

    <!-- Buttons for cars -->
    <button onclick="location.href='ManageCars.jsp'">Week's Working Rota</button>

    <!-- Buttons for payment & feedback analysis -->
    <button onclick="location.href='ViewReports.jsp'">View Reports</button>

</body>
</html>
