<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Vets Dashboard</title>
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
    <h1>Vets Dashboard</h1>

    <!-- Buttons for different functionalities -->
    <button onclick="location.href='VetsEditProfile.jsp'">Edit Individual Profile</button>
    <button onclick="location.href='DiagonisAndPrognosis.jsp'">Diagnosis And Prognosis Of Pets</button>
    <button onclick="location.href='ViewAppointments.jsp'">View Appointments</button>
</body>
</html>
