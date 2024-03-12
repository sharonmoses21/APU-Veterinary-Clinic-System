<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Receptionists</title>
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

        h1 {
            color: #333333;
        }

        form {
            margin-top: 20px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
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
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h1>Update Receptionists</h1>
    
    <form action="ProcessUpdateReceptionistsServlet" method="post">
        <!-- Input field for Old User Name -->
        <label for="oldUsername">Old User Name:</label>
        <input type="text" name="oldUsername" required><br>

        <!-- Input field for New User Name -->
        <label for="newUsername">New User Name:</label>
        <input type="text" name="newUsername" required><br>

        <!-- Input field for New Name -->
        <label for="newName">New Name:</label>
        <input type="text" name="newName" required><br>

        <!-- Input field for New Password -->
        <label for="newPassword">New Password:</label>
        <input type="password" name="newPassword" required><br>

        <!-- Update button -->
        <button type="submit">Update Receptionists</button>
    </form>
</body>
</html>
