<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Receptionists</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column; /* Change to column direction */
            align-items: center; /* Align items to the center horizontally */
            justify-content: center;
            height: 100vh;
        }

        h1 {
            color: #333333;
            margin-bottom: 20px; /* Add margin for spacing between h1 and buttons */
        }

        button {
            background-color: #3498db;
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin: 10px;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h1>Manage Receptionists</h1>

    <!-- Buttons for managing customers -->
    <button onclick="location.href='ApproveReceptionists.jsp'">Approve Receptionists</button>
    <button onclick="location.href='DeleteReceptionists.jsp'">Delete Receptionists</button>
    <button onclick="location.href='SearchReceptionists.jsp'">Search Receptionists</button>
    <button onclick="location.href='UpdateReceptionists.jsp'">Update Receptionists</button>
</body>
</html>
