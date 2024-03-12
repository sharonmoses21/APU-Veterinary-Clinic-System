<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Vets</title>
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
            display: inline-block;
            margin: 10px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: white;
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
    <h1>Update Vets</h1>
    
    <form action="ProcessUpdateSalesmenServlet" method="post">
        <!-- Input field for Old User Name -->
        <label for="oldUsername">Old User Name:</label>
        <input type="text" name="oldUsername" required>

        <!-- Input field for New User Name -->
        <label for="newUsername">New User Name:</label>
        <input type="text" name="newUsername" required>

        <!-- Input field for New Name -->
        <label for="newName">New Name:</label>
        <input type="text" name="newName" required>

        <!-- Input field for New Password -->
        <label for="newPassword">New Password:</label>
        <input type="password" name="newPassword" required>

        <!-- Update button -->
        <button type="submit">Update Vets</button>
    </form>
</body>
</html>
