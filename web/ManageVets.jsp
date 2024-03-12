<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Vets</title>
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
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: 10px 0;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Manage Vets</h1>
    
    <!-- Buttons for approving, deleting, searching, and updating salesmen details -->
    <button onclick="location.href='ApproveVets.jsp'">Approve Vets</button>

    <button onclick="location.href='DeleteVets.jsp'">Delete Vets</button>

    <button onclick="location.href='SearchVets.jsp'">Search Vets</button>

    <button onclick="location.href='UpdateVets.jsp'">Update Vets</button>

</body>
</html>
